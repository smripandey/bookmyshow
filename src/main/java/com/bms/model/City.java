package com.bms.model;

import java.util.UUID;

public class City {
	
	private static UUID cityId;
	private static String cityName;
	private static String state;
	private static String zipCode;
	
	public City(UUID cityId, String cityName, String state, String zipCode) {
		super();
		this.cityId = cityId;
		this.cityName = cityName;
		this.state = state;
		this.zipCode = zipCode;
	}

	public UUID getCityId() {
		return cityId;
	}

	public void setCityId(UUID cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public String toString() {
		return "City [getCityId()=" + getCityId() + ", getCityName()=" + getCityName() + ", getState()=" + getState()
				+ ", getZipCode()=" + getZipCode() + "]";
	}	
}
