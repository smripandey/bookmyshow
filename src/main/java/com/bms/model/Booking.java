package com.bms.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverted;

@DynamoDBTable(tableName = "booking")
public class Booking {
	
	private UUID bookingId;
	private UUID userId;
	private UUID showId;
	private UUID paymentId;
	private int noOfSeats;
	private LocalDateTime timestamp;
	private String status;
	private List<Seat> seats;
	private int totalPrice;

	public Booking() {
		super();
	}

	public Booking(UUID bookingId, UUID userId, UUID showId, UUID paymentId, int noOfSeats, LocalDateTime timestamp,
			String status, List<Seat> seats, int totalPrice) {
		super();
		this.bookingId = bookingId;
		this.userId = userId;
		this.showId = showId;
		this.paymentId = paymentId;
		this.noOfSeats = noOfSeats;
		this.timestamp = timestamp;
		this.status = status;
		this.seats = seats;
		this.totalPrice = totalPrice;
	}

	@DynamoDBHashKey
	public UUID getBookingId() {
		return bookingId;
	}

	public void setBookingId(UUID bookingId) {
		this.bookingId = bookingId;
	}

	@DynamoDBAttribute
	public UUID getUserId() {
		return userId;
	}

	public void setUserId(UUID userId) {
		this.userId = userId;
	}

	@DynamoDBAttribute
	public UUID getShowId() {
		return showId;
	}

	public void setShowId(UUID showId) {
		this.showId = showId;
	}

	@DynamoDBAttribute
	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	@DynamoDBTypeConverted(converter = LocalDateTimeToStringTypeConverter.class)
	@DynamoDBAttribute
	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	@DynamoDBAttribute
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@DynamoDBTypeConverted(converter = SeatConverter.class)
	@DynamoDBAttribute
	public List<Seat> getSeats() {
		return seats;
	}

	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}

	@DynamoDBAttribute
	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	@DynamoDBAttribute
	public UUID getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(UUID paymentId) {
		this.paymentId = paymentId;
	}
	
}
