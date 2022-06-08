package com.bms.model;

import java.util.UUID;

public class Movie {

	private UUID movieId;
	private String name;
	private Enum<Genre> genre;
	private String duration;
	private String language;
	private UUID theatreId;
	private int rating;
	
	public Movie(UUID movieId, String name, Enum<Genre> genre, String duration, String language, UUID theatreId,
			int rating) {
		super();
		this.movieId = movieId;
		this.name = name;
		this.genre = genre;
		this.duration = duration;
		this.language = language;
		this.theatreId = theatreId;
		this.rating = rating;
	}

	public UUID getMovieId() {
		return movieId;
	}

	public void setMovieId(UUID movieId) {
		this.movieId = movieId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Enum<Genre> getGenre() {
		return genre;
	}

	public void setGenre(Enum<Genre> genre) {
		this.genre = genre;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public UUID getTheatreId() {
		return theatreId;
	}

	public void setTheatreId(UUID theatreId) {
		this.theatreId = theatreId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", name=" + name + ", genre=" + genre + ", duration=" + duration
				+ ", language=" + language + ", theatreId=" + theatreId + ", rating=" + rating + "]";
	}
}	