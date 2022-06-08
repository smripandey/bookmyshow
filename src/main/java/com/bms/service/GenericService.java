package com.bms.service;

import java.util.List;
import java.util.UUID;

import com.bms.model.Payment;
import com.bms.model.Seat;

public interface GenericService {

	public void addSeats(List<Seat> seats);
	
	public Seat releaseSeat(UUID seatId);
	
    public Payment createPayment(UUID bookingId, int amount);
	
	public Payment cancelPayment(UUID paymentId);
}
