package com.airline.controller;

import com.airline.model.Flight;
import com.airline.repository.FlightRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/flights")
public class FlightController {
    private final FlightRepository flightRepository;

    public FlightController(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @GetMapping
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    @PostMapping
    public Flight addFlight(@RequestBody Flight flight) {
        return flightRepository.save(flight);
    }

    @DeleteMapping("/{flightId}")
    public void deleteFlight(@PathVariable Long flightId) {
        flightRepository.deleteById(flightId);
    }

    @PutMapping("/{flightId}")
    public Flight updateFlight(@PathVariable Long flightId, @RequestBody Flight flight) {
        flight.setFlightID(flightId);
        return flightRepository.save(flight);
    }
} 