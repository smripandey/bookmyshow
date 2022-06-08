package com.bms.repository;

import java.util.UUID;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bms.model.Seat;

@EnableScan
@Repository
public interface SeatRepository extends CrudRepository<Seat, UUID>{

}
