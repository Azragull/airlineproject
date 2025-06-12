package com.airline.controller;

import com.airline.model.Airport;
import com.airline.repository.AirportRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/airports")
public class AirportController {
    private final AirportRepository airportRepository;

    public AirportController(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    @GetMapping
    public List<Airport> getAllAirports() {
        return airportRepository.findAll();
    }

    @PostMapping
    public Airport addAirport(@RequestBody Airport airport) {
        return airportRepository.save(airport);
    }

    @DeleteMapping("/{airportId}")
    public void deleteAirport(@PathVariable Long airportId) {
        airportRepository.deleteById(airportId);
    }

    @PutMapping("/{airportId}")
    public Airport updateAirport(@PathVariable Long airportId, @RequestBody Airport airport) {
        airport.setAirportID(airportId);
        return airportRepository.save(airport);
    }
} 