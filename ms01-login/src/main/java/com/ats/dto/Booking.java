package com.ats.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Booking {
    private Long id;


    private String bookingId; // Format "B0001"


    private Long passengerId;


    private Long scheduleId; // Assuming this refers to a flight or travel schedule


    private LocalDate bookingDate;


    private String seatNumber;


    private Double ticketCost;


    private Double totalAmount;


    private LocalDateTime departureDateTime;


    private LocalDateTime arrivalDateTime;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public Long getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Long passengerId) {
        this.passengerId = passengerId;
    }

    public Long getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Long scheduleId) {
        this.scheduleId = scheduleId;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Double getTicketCost() {
        return ticketCost;
    }

    public void setTicketCost(Double ticketCost) {
        this.ticketCost = ticketCost;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public LocalDateTime getDepartureDateTime() {
        return departureDateTime;
    }

    public void setDepartureDateTime(LocalDateTime departureDateTime) {
        this.departureDateTime = departureDateTime;
    }

    public LocalDateTime getArrivalDateTime() {
        return arrivalDateTime;
    }

    public void setArrivalDateTime(LocalDateTime arrivalDateTime) {
        this.arrivalDateTime = arrivalDateTime;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", bookingId='" + bookingId + '\'' +
                ", passengerId=" + passengerId +
                ", scheduleId=" + scheduleId +
                ", bookingDate=" + bookingDate +
                ", seatNumber='" + seatNumber + '\'' +
                ", ticketCost=" + ticketCost +
                ", totalAmount=" + totalAmount +
                ", departureDateTime=" + departureDateTime +
                ", arrivalDateTime=" + arrivalDateTime +
                '}';
    }
}

