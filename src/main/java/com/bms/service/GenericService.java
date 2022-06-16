package com.bms.service;

import java.util.UUID;

import com.bms.model.Payment;

public interface GenericService {
	
    public Payment createPayment(UUID bookingId, int amount);
	
	public Payment cancelPayment(UUID paymentId);
}
