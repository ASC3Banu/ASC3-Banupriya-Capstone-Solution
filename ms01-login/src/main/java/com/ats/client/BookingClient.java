//package com.ats.client;
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
