package com.bms.model;

import java.util.UUID;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "seat")
@DynamoDBDocument
public class Seat {

	private UUID seatID;
	private int seatNumber;
	private UUID screenID;
	private int price;
	private boolean status;
	
	public Seat() {
		super();
	}

	public Seat(UUID seatId, int seatNumber, UUID screenId, int price, boolean booked) {
		super();
		this.seatID = seatId;
		this.seatNumber = seatNumber;
		this.screenID = screenId;
		this.price = price;
		this.status = booked;
	}

	@DynamoDBHashKey
	public UUID getSeatID() {
		return seatID;
	}

	public void setSeatID(UUID seatId) {
		this.seatID = seatId;
	}

	@DynamoDBAttribute
	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

	@DynamoDBAttribute
	public UUID getScreenID() {
		return screenID;
	}

	public void setScreenID(UUID screenId) {
		this.screenID = screenId;
	}

	@DynamoDBAttribute
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@DynamoDBAttribute
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean booked) {
		this.status = booked;
	}
	
}
