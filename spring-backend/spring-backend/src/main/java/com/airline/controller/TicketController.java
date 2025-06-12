package com.airline.controller;

import com.airline.model.Ticket;
import com.airline.repository.TicketRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {
    private final TicketRepository ticketRepository;

    public TicketController(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @GetMapping("/booking/{bookingId}")
    public List<Ticket> getTicketsByBooking(@PathVariable Long bookingId) {
        return ticketRepository.findByBookingID(bookingId);
    }

    @PutMapping("/checkin/{ticketId}")
    public Ticket checkIn(@PathVariable Long ticketId) {
        Ticket ticket = ticketRepository.findById(ticketId).orElseThrow();
        ticket.setStatus("Checked-in");
        return ticketRepository.save(ticket);
    }
} 