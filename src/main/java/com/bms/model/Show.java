package com.bms.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Show {
	
	private UUID showId;
	private LocalDateTime date;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private UUID screenId;
	private UUID movieId;
	private List<Seat> seats;
	
	public Show(UUID showId, LocalDateTime date, LocalDateTime startTime, LocalDateTime endTime, UUID screenId,
			UUID movieId, List<Seat> seats) {
		super();
		this.showId = showId;
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.screenId = screenId;
		this.movieId = movieId;
		this.seats = seats;
	}

	public UUID getShowId() {
		return showId;
	}

	public void setShowId(UUID showId) {
		this.showId = showId;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	public UUID getScreenId() {
		return screenId;
	}

	public void setScreenId(UUID screenId) {
		this.screenId = screenId;
	}

	public UUID getMovieId() {
		return movieId;
	}

	public void setMovieId(UUID movieId) {
		this.movieId = movieId;
	}

	public List<Seat> getSeats() {
		return seats;
	}

	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}

	@Override
	public String toString() {
		return "Show [showId=" + showId + ", date=" + date + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", screenId=" + screenId + ", movieId=" + movieId + ", seats=" + seats + "]";
	}
	
}
