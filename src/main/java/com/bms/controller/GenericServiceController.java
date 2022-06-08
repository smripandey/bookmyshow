package com.bms.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bms.model.Seat;
import com.bms.service.GenericServiceImpl;

@RestController
@RequestMapping("/bms")
public class GenericServiceController {

	@Autowired
	private GenericServiceImpl genericServiceImpl;

	@PostMapping(value = "/addSeats", consumes = "application/json")
	public void addSeats(@RequestBody List<Seat> seats) {
		genericServiceImpl.addSeats(seats);
	}

	@PutMapping(value = "/seat", produces = "application/json")
	public Seat releaseSeat(@RequestParam(required = true) UUID seatId) {
		return genericServiceImpl.releaseSeat(seatId);
	}
	

}
