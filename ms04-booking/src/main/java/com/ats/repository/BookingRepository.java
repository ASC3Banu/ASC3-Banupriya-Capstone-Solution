package com.ats.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ats.entity.Booking;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    Optional<Booking> findByBookingId(String bookingId);
    List<Booking> findByBookingDate(LocalDate bookingDate);
    Optional<Booking> findByseatNumber(String seatNumber);

}
