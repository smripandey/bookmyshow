package com.bms.model;

import java.time.LocalDateTime;
import java.util.UUID;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverted;

@DynamoDBTable(tableName = "payment")
public class Payment {

	private UUID paymentId;
	private int amount;
	private LocalDateTime timestamp;
	private UUID transactionId;
	private String paymentMethod;
	private UUID bookingId;
	
	public Payment() {
		super();
	}

	public Payment(UUID paymentId, int amount, LocalDateTime timestamp, UUID transactionId, String paymentMethod,
			UUID bookingId) {
		super();
		this.paymentId = paymentId;
		this.amount = amount;
		this.timestamp = timestamp;
		this.transactionId = transactionId;
		this.paymentMethod = paymentMethod;
		this.bookingId = bookingId;
	}

	@DynamoDBHashKey
	public UUID getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(UUID paymentId) {
		this.paymentId = paymentId;
	}

	@DynamoDBAttribute
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
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
	public UUID getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(UUID transactionId) {
		this.transactionId = transactionId;
	}

	@DynamoDBAttribute
	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	@DynamoDBAttribute
	public UUID getBookingId() {
		return bookingId;
	}

	public void setBookingId(UUID bookingId) {
		this.bookingId = bookingId;
	}
	
}
