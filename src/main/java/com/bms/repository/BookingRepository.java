package com.bms.repository;

import java.util.Optional;
import java.util.UUID;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bms.model.Booking;

@EnableScan
@Repository
public interface BookingRepository extends CrudRepository<Booking, UUID>{

	Optional<Booking> findById(UUID bookingId);
}
