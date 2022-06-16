package com.bms.model;

import java.util.List;
import java.util.UUID;

public class Show {
	
	private UUID showId;
	private String date;
	private UUID movieId;
	private UUID theatreId;
	private UUID cityId;
	private UUID screenId;
	private String startTime;
	private String endTime;
	private List<Seat> seats;

	public Show() {
		super();
	}
	
	public Show(UUID showId, String date, UUID movieId, UUID theatreId, UUID cityId, UUID screenId, String startTime,
			String endTime, List<com.bms.model.Seat> seats) {
		super();
		this.showId = showId;
		this.date = date;
		this.movieId = movieId;
		this.theatreId = theatreId;
		this.cityId = cityId;
		this.screenId = screenId;
		this.startTime = startTime;
		this.endTime = endTime;
		this.seats = seats;
	}

	public UUID getShowId() {
		return showId;
	}

	public void setShowId(UUID showId) {
		this.showId = showId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public UUID getMovieId() {
		return movieId;
	}

	public void setMovieId(UUID movieId) {
		this.movieId = movieId;
	}

	public UUID getTheatreId() {
		return theatreId;
	}

	public void setTheatreId(UUID theatreId) {
		this.theatreId = theatreId;
	}

	public UUID getCityId() {
		return cityId;
	}

	public void setCityId(UUID cityId) {
		this.cityId = cityId;
	}

	public UUID getScreenId() {
		return screenId;
	}

	public void setScreenId(UUID screenId) {
		this.screenId = screenId;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public List<Seat> getSeats() {
		return seats;
	}

	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}

	@Override
	public String toString() {
		return "Show [showId=" + showId + ", date=" + date + ", movieId=" + movieId + ", theatreId=" + theatreId
				+ ", cityId=" + cityId + ", screenId=" + screenId + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", seats=" + seats + "]";
	}

}
