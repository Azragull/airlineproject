package com.airline.controller;

import com.airline.repository.BookingRepository;
import com.airline.repository.FlightRepository;
import com.airline.repository.PaymentRepository;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/reports")
public class AdminReportController {
    private final BookingRepository bookingRepository;
    private final FlightRepository flightRepository;
    private final PaymentRepository paymentRepository;

    public AdminReportController(BookingRepository bookingRepository, FlightRepository flightRepository, PaymentRepository paymentRepository) {
        this.bookingRepository = bookingRepository;
        this.flightRepository = flightRepository;
        this.paymentRepository = paymentRepository;
    }

    @GetMapping
    public Map<String, Object> getReports() {
        Map<String, Object> map = new HashMap<>();
        map.put("totalBookings", bookingRepository.count());
        map.put("totalSales", paymentRepository.findAll().stream().filter(p -> "Completed".equalsIgnoreCase(p.getStatus())).mapToDouble(p -> p.getAmount().doubleValue()).sum());
        map.put("avgOccupancy", flightRepository.findAll().stream().mapToInt(f -> f.getSeatsAvailable()).average().orElse(0));
        return map;
    }
} 