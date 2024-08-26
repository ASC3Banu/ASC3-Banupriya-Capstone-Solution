package com.ats.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ats.entity.Airport;

import java.util.Optional;

public interface AirportRepository extends JpaRepository<Airport, Long> {
    Optional<Airport> findByAirportCode(String airportCode);
}
