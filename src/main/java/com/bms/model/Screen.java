package com.bms.model;

import java.util.UUID;

public class Screen {

	private UUID screenId;
	private String name;
	private UUID theatreId;
	private int totalSeats;
	
	public Screen(UUID screenId, String name, UUID theatreId, int totalSeats) {
		super();
		this.screenId = screenId;
		this.name = name;
		this.theatreId = theatreId;
		this.totalSeats = totalSeats;
	}

	public UUID getScreenId() {
		return screenId;
	}

	public void setScreenId(UUID screenId) {
		this.screenId = screenId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UUID getTheatreId() {
		return theatreId;
	}

	public void setTheatreId(UUID theatreId) {
		this.theatreId = theatreId;
	}

	public int getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}

	@Override
	public String toString() {
		return "Screen [screenId=" + screenId + ", name=" + name + ", theatreId=" + theatreId + ", totalSeats="
				+ totalSeats + "]";
	}
}
