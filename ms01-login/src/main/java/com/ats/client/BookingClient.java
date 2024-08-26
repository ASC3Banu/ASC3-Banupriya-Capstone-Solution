package com.ats.client;
//
//
//
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//
//@FeignClient(name = "booking-service",url="localhost:8087")
//public interface BookingClient {
//
//    @GetMapping("/bookings/id/{bookingId}")
//    String getBookingsForUser(@PathVariable("userId") Long userId);
//}
//

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "booking-service")
public interface BookingClient {

    @GetMapping("/bookings/{bookingId}")
    <Booking>
    Booking getBookingById(@PathVariable("bookingId") String bookingId);

    @GetMapping("/bookings")
    List<Booking> getBookingsByDate(@RequestParam("date") String date);
}
