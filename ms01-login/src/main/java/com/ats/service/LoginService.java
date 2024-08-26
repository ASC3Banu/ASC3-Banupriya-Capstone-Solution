package com.ats.service;

import com.ats.client.Booking;
import com.ats.client.BookingClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {
    @Autowired
    private BookingClient bookingClient;

    public Booking getBookingDetails(String bookingId) {
        return bookingClient.getBookingById(bookingId);
    }

    public List<Booking> getBookingsByDate(String date) {
        return bookingClient.getBookingsByDate(date);
    }
}
