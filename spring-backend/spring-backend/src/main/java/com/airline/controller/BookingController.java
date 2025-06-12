package com.airline.controller;

import com.airline.model.Booking;
import com.airline.model.Ticket;
import com.airline.repository.BookingRepository;
import com.airline.repository.TicketRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    private final BookingRepository bookingRepository;
    private final TicketRepository ticketRepository;

    public BookingController(BookingRepository bookingRepository, TicketRepository ticketRepository) {
        this.bookingRepository = bookingRepository;
        this.ticketRepository = ticketRepository;
    }

    @GetMapping("/user/{userId}")
    public List<Booking> getBookingsByUser(@PathVariable Long userId) {
        return bookingRepository.findByUserID(userId);
    }

    @PostMapping
    public Booking addBooking(@RequestBody Booking booking) {
        Booking savedBooking = bookingRepository.save(booking);

        // Create and save a new Ticket for this booking
        Ticket ticket = new Ticket();
        ticket.setBookingID(savedBooking.getBookingID());
        ticket.setSeatNumber(booking.getSeatNumber());
        ticket.setClassType(booking.getClassType());
        ticket.setStatus("Confirmed"); // Default status for a new ticket
        ticketRepository.save(ticket);

        return savedBooking;
    }

    @PutMapping("/cancel/{bookingId}")
    public Booking cancelBooking(@PathVariable Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId).orElseThrow();
        booking.setPaymentStatus("Cancelled");
        return bookingRepository.save(booking);
    }
} 