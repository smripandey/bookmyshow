package com.bms.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.exceptions.SeatUnavailableException;
import com.bms.model.Booking;
import com.bms.model.Payment;
import com.bms.model.Seat;
import com.bms.repository.BookingRepository;
import com.bms.repository.SeatRepository;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingRepository bookingRepository;
	
	@Autowired
	private SeatRepository seatRepository;
	
	@Autowired
	private GenericService genericService;
	
	@Override
	public Booking createBooking(UUID userId, UUID showId, List<Seat> seats) {
		UUID bookingId = UUID.randomUUID();
		int totalPrice = 0;
        StringBuilder sb = new StringBuilder();
		for(Seat seat:seats) {
			Optional<Seat>  seatFromDb = seatRepository.findById(seat.getSeatID());
			Seat oseat = seatFromDb.get();
			if(oseat.isStatus()) {
				throw new SeatUnavailableException("The seat number : "+seat.getSeatNumber()+" is already booked");
			}
			totalPrice = totalPrice + seat.getPrice();
			oseat.setStatus(true);
			seatRepository.save(oseat);
			sb.append(oseat.getSeatNumber()+",");
		}
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
		for(Seat seat: seats) {
			Optional<Seat> seatFromDb = seatRepository.findById(seat.getSeatID());
			if(seatFromDb == null) {
				throw new NoSuchElementException("Seat not found");
			}
			seatFromDb.get().setStatus(false);
			seatRepository.save(seatFromDb.get());
		}
		genericService.cancelPayment(bookingFromDB.getPaymentId());
		bookingFromDB.setStatus("CANCELLED");
		bookingRepository.delete(bookingFromDB);
		return bookingFromDB;
	}

	//For testing purpose
	@Override
	public void delBooking(UUID bookingId) {
		// TODO Auto-generated method stub
		 Optional<Booking> booking = bookingRepository.findById(bookingId);
		  bookingRepository.delete(booking.get());
		 
	}
	
}
