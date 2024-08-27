package com.ats.proxy;
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

import com.ats.dto.Booking;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "ms04-booking")
public interface BookingClient {

    @GetMapping("/bookings/{Id}")
    Booking getBookingById(@PathVariable("Id") String bookingId);

    @GetMapping("/bookings")
    List<Booking> getBookingsByDate(@RequestParam("date") String date);
}

