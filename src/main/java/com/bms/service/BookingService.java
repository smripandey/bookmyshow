package com.bms.service;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import com.bms.model.Booking;
import com.bms.model.Payment;
import com.bms.model.Seat;

public interface BookingService {

	public Booking createBooking(UUID userId, UUID showId, List<Seat> seats);
	
	public List<Booking> getAllBookings(UUID userId);
	
	public Booking getBooking(UUID bookingId);
	
	public Booking cancelBooking(UUID bookingId);
	
	public void delBooking(UUID bookingId); //For testing purpose . del it afterwards
	
}
