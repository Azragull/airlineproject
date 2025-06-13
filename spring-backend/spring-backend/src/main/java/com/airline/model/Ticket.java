package com.airline.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id")
    private Long ticketID;
    @Column(name = "booking_id")
    private Long bookingID;
    private String seatNumber;
    
    @Column(name = "class_type")
    private String classType;
    
    private String status;

    // Getter ve Setterlar
    public Long getTicketID() { return ticketID; }
    public void setTicketID(Long ticketID) { this.ticketID = ticketID; }
    public Long getBookingID() { return bookingID; }
    public void setBookingID(Long bookingID) { this.bookingID = bookingID; }
    public String getSeatNumber() { return seatNumber; }
    public void setSeatNumber(String seatNumber) { this.seatNumber = seatNumber; }
    public String getClassType() { return classType; }
    public void setClassType(String classType) { this.classType = classType; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
} 