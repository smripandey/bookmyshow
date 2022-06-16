package com.bms.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bms.exceptions.SeatUnavailableException;
import com.bms.model.Booking;
import com.bms.model.Payment;
import com.bms.model.Seat;
import com.bms.model.Show;
import com.bms.repository.BookingRepository;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingRepository bookingRepository;
	
	@Autowired
	private GenericService genericService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("$(show.microservice.url")
	private String showEndpoint;
	
	@Override
	public Booking createBooking(UUID userId, UUID showId, List<Seat> seats) {
		UUID bookingId = UUID.randomUUID();
		int totalPrice = 0;
		Show show = restTemplate.getForObject(showEndpoint+"/getShowById/"+showId, Show.class);
		
		//Checking if all the seats are available or not
		for(Seat showSeat:show.getSeats()) {
			for(Seat seat:seats) {
				if(seat.getSeatID()==showSeat.getSeatID()) {
					if(showSeat.isStatus()){
						throw new SeatUnavailableException("The seat number : "+seat.getSeatNumber()+" is already booked");
					}
				}
				totalPrice = totalPrice + seat.getPrice();
			}
		}
		
		//Calling updateSeat end point for changing the status of seat to booked
		HttpEntity<List<Seat>> requestEntity = new HttpEntity<List<Seat>>(seats);
		restTemplate.exchange(showEndpoint+"/updateSeatsByShow/"+showId+"/"+true, HttpMethod.PUT, requestEntity, Seat[].class);
	
		Booking booking = new Booking();
		booking.setBookingId(bookingId);
		booking.setNoOfSeats(seats.size());
		booking.setSeats(seats);
		booking.setShowId(showId);
		booking.setStatus("PENDING");
		booking.setTimestamp(LocalDateTime.now());
		booking.setTotalPrice(totalPrice);
		booking.setUserId(userId);
        bookingRepository.save(booking);                   
		//Doing payment and updating it in booking table
		Payment payment = genericService.createPayment(bookingId, totalPrice);
		booking.setPaymentId(payment.getPaymentId());
		booking.setStatus("CONFIRMED");
		return bookingRepository.save(booking);
	}

	@Override
	public List<Booking> getAllBookings(UUID userId) {
		List<Booking> bookings = new ArrayList<>();
		for(Booking booking:this.bookingRepository.findAll()) {
			if(booking.getUserId().equals(userId)) {
				bookings.add(booking);
			}
		}
		return bookings;
	}

	@Override
	public Booking getBooking(UUID bookingId) {
		Booking booking = this.bookingRepository.findById(bookingId).get();
		return booking;
	}

	@Override
	public Booking cancelBooking(UUID bookingId) {
		Booking bookingFromDB = bookingRepository.findById(bookingId).get();
		List<Seat> seats = bookingFromDB.getSeats();
		HttpEntity<List<Seat>> requestEntity = new HttpEntity<List<Seat>>(seats);
		
		//releasing seat of specific show and updating it in database
		restTemplate.exchange(showEndpoint+"/updateSeatsByShow/"+bookingFromDB.getShowId()+"/"+false, HttpMethod.PUT, requestEntity, Seat[].class);
		
		genericService.cancelPayment(bookingFromDB.getPaymentId());
		bookingFromDB.setStatus("CANCELLED");
		bookingRepository.delete(bookingFromDB);
		return bookingFromDB;
	}
	
}
