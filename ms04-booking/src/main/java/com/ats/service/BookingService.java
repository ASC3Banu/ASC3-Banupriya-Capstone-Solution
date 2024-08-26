package com.ats.service;

import com.ats.entity.Booking;
import com.ats.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public Booking createBooking(Booking booking) {
        booking.setBookingId(generateBookingId());
        return bookingRepository.save(booking);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Optional<Booking> getBookingById(Long id) {
        return bookingRepository.findById(id);
    }

    public Optional<Booking> getBookingByBookingId(String bookingId) {
        return bookingRepository.findByBookingId(bookingId);
    }

    public List<Booking> getBookingsByBookingDate(LocalDate bookingDate) {
        return bookingRepository.findByBookingDate(bookingDate);
    }
    public Optional<Booking> getBookingsByseatNumber(String seatNumber){
        return bookingRepository.findByseatNumber(seatNumber);
    }

    public void deleteBooking(Long id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
        bookingRepository.delete(booking);
    }

    private String generateBookingId() {
        Long count = bookingRepository.count();
        return String.format("B%04d", count + 1);
    }

    public Optional<Booking> getBookingByseatNumber(String seatNumber) {
        return bookingRepository.findByseatNumber(seatNumber);
    }
}
