package com.ats.controller;

import com.ats.entity.Booking;
import com.ats.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
        return ResponseEntity.ok(bookingService.createBooking(booking));
    }

    @GetMapping
    public ResponseEntity<List<Booking>> getAllBookings() {
        return ResponseEntity.ok(bookingService.getAllBookings());
    }

    @GetMapping("/id/{bookingId}")
    public ResponseEntity<Booking> getBookingByBookingId(@PathVariable String bookingId) {
        Optional<Booking> booking = bookingService.getBookingByBookingId(bookingId);
        return booking.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @GetMapping("/sno/{seatNumber}")
    public ResponseEntity<Booking> getBookingByseatNumber(@PathVariable String seatNumber){
        Optional<Booking> booking =bookingService.getBookingByseatNumber(seatNumber);
        return booking.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }


//    @GetMapping("/date/{bookingDate}")
//    public ResponseEntity<List<Booking>> getBookingsByBookingDate(@PathVariable LocalDate bookingDate) {
//        List<Booking> bookings = bookingService.getBookingsByBookingDate(bookingDate);
//        return ResponseEntity.ok(bookings);
//    }
@PostMapping("/bookings/date")
public ResponseEntity<List<Booking>> getBookingsByDate(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
    List<Booking> bookings = bookingService.getBookingsByBookingDate(date);
    return ResponseEntity.ok(bookings);
}

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
        return ResponseEntity.ok("Booking Deleted Succesfully");
    }
}
