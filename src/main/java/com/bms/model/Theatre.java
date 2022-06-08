package com.bms.model;

import java.util.UUID;

public class Theatre {

	private UUID theatreId;
	private String name;
	private String location;
	private UUID cityId;
	
	public Theatre(UUID theatreId, String name, String location, UUID cityId) {
		super();
		this.theatreId = theatreId;
		this.name = name;
		this.location = location;
		this.cityId = cityId;
	}

	public UUID getTheatreId() {
		return theatreId;
	}

	public void setTheatreId(UUID theatreId) {
		this.theatreId = theatreId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public UUID getCityId() {
		return cityId;
	}

	public void setCityId(UUID cityId) {
		this.cityId = cityId;
	}

	@Override
	public String toString() {
		return "Theatre [theatreId=" + theatreId + ", name=" + name + ", location=" + location + ", cityId=" + cityId
				+ "]";
	}
	
}
