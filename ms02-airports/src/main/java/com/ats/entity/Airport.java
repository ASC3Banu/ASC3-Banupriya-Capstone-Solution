package com.ats.entity;

import javax.persistence.*;

@Entity
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String airportCode; // Format "A0001"

    @Column(nullable = false)
    private String airportName;

    @Column(nullable = false)
    private String countryCode; // Minimum 1 character and maximum 5 characters

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAirportCode() {
        return airportCode;
    }

    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        if (countryCode.length() < 1 || countryCode.length() > 5) {
            throw new IllegalArgumentException("Country code must be between 1 and 5 characters");
        }
        this.countryCode = countryCode;
    }
}
