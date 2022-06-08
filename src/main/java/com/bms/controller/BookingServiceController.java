package com.bms.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bms.model.Booking;
import com.bms.model.Seat;
import com.bms.service.BookingServiceImpl;

@RestController
@RequestMapping(path = "/bms")
public class BookingServiceController {

	@Autowired
	BookingServiceImpl bookingService;
	
	@RequestMapping(value = "/booking", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Booking> createBooking(@RequestParam(value = "userId") UUID userId, @RequestParam(value = "showId") UUID showId,@RequestBody List<Seat> seats){
			Booking booking = bookingService.createBooking(userId, showId, seats);
			return new ResponseEntity<Booking>(booking, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/bookings/{userId}", produces = "application/json")
	public ResponseEntity<List<Booking>> bookingHistory(@PathVariable UUID userId){
		List<Booking> bookings = bookingService.getAllBookings(userId);
		if(bookings.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return new ResponseEntity<List<Booking>>(bookings, HttpStatus.OK);
	}
	
	@GetMapping(value = "/booking/{bookingId}", produces = "application/json")
	public ResponseEntity<Booking> getBooking(@PathVariable UUID bookingId) {
		Booking booking = bookingService.getBooking(bookingId);
		return new ResponseEntity<Booking>(booking, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/booking/{bookingId}", produces = "application/json")
	public ResponseEntity<Booking> cancelBooking(@PathVariable UUID bookingId) {
			Booking booking = bookingService.cancelBooking(bookingId);
			return new ResponseEntity<Booking>(booking, HttpStatus.OK);
		
	}
	
}
