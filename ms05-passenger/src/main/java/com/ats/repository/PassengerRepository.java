package com.ats.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ats.entity.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {
}
