package com.bms.exceptions;

import java.sql.Timestamp;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Advisor {

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<ErrorMessage> handleNoSuchElementException(NoSuchElementException ex) {
		ErrorMessage error = new ErrorMessage(new Timestamp(System.currentTimeMillis()), HttpStatus.NOT_FOUND.value(),
				"Booking not found", ex.getMessage());
		return new ResponseEntity<ErrorMessage>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(SeatUnavailableException.class)
	public ResponseEntity<ErrorMessage> handleSeatUnavailableException(SeatUnavailableException ex) {
		ErrorMessage error = new ErrorMessage(new Timestamp(System.currentTimeMillis()),
				HttpStatus.BAD_REQUEST.value(), "Seat is already booked. Try booking other seat",
				ex.getMessage());
		return new ResponseEntity<ErrorMessage>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorMessage> handleException(Exception ex) {
		ErrorMessage errorMessage = new ErrorMessage(new Timestamp(System.currentTimeMillis()),
				HttpStatus.INTERNAL_SERVER_ERROR.value(), "Internal Server error", ex.getMessage());
		return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
