package com.bms.service;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.model.Payment;
import com.bms.repository.PaymentRepository;

@Service
public class GenericServiceImpl implements GenericService{

	
	@Autowired
	private PaymentRepository paymentRepository;

	@Override
	public Payment createPayment(UUID bookingId, int amount) {
		UUID paymentId = UUID.randomUUID();
		Payment payment = new Payment();
		payment.setBookingId(bookingId);
		payment.setAmount(amount);
		payment.setPaymentId(paymentId);
		payment.setPaymentMethod("CREDITCARD");
		payment.setTimestamp(LocalDateTime.now());
		payment.setTransactionId(paymentId);
		Payment paymentFromDB = this.paymentRepository.save(payment);
		return paymentFromDB;
	}

	@Override
	public Payment cancelPayment(UUID paymentId) {
		Optional<Payment> paymentFromDB = paymentRepository.findById(paymentId);
		if(paymentFromDB==null) {
			throw new NoSuchElementException("No payment found");
		}
		Payment opayment = paymentFromDB.get();
		paymentRepository.delete(opayment);
		return opayment;
	}

}
