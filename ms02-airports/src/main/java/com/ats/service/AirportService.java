package com.ats.service;

import com.ats.entity.Airport;
import com.ats.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class  AirportService {

    @Autowired
    private AirportRepository airportRepository;

    public Airport createAirport(Airport airport) {
        airport.setAirportCode(generateAirportCode());
        return airportRepository.save(airport);
    }

    public List<Airport> getAllAirports() {
        return airportRepository.findAll();
    }

    public Optional<Airport> getAirportById(Long id) {
        return airportRepository.findById(id);
    }

    public Optional<Airport> getAirportByAirportCode(String airportCode) {
        return airportRepository.findByAirportCode(airportCode);
    }

    private String generateAirportCode() {
        Long count = airportRepository.count();
        return String.format("A%04d", count + 1);
    }
}
