package com.bms.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.model.Payment;
import com.bms.model.Seat;
import com.bms.repository.PaymentRepository;
import com.bms.repository.SeatRepository;

@Service
public class GenericServiceImpl implements GenericService{

	@Autowired
	private SeatRepository seatRepository;
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Override
	public void addSeats(List<Seat> seats) {
		seatRepository.saveAll(seats);
	}
	
	@Override
	public Seat releaseSeat(UUID seatId) {
		Seat seatFromDB = seatRepository.findById(seatId).get();
		seatFromDB.setStatus(false);
		return seatRepository.save(seatFromDB);
	}

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
