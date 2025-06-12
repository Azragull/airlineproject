package com.airline.model;

import jakarta.persistence.*;

@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingID;
    private Long userID;
    private Long flightID;
    private String paymentStatus;
    private String bookingDate;
    private String seatNumber;
    private String classType;

    // Getter ve Setterlar
    public Long getBookingID() { return bookingID; }
    public void setBookingID(Long bookingID) { this.bookingID = bookingID; }
    public Long getUserID() { return userID; }
    public void setUserID(Long userID) { this.userID = userID; }
    public Long getFlightID() { return flightID; }
    public void setFlightID(Long flightID) { this.flightID = flightID; }
    public String getPaymentStatus() { return paymentStatus; }
    public void setPaymentStatus(String paymentStatus) { this.paymentStatus = paymentStatus; }
    public String getBookingDate() { return bookingDate; }
    public void setBookingDate(String bookingDate) { this.bookingDate = bookingDate; }
    public String getSeatNumber() { return seatNumber; }
    public void setSeatNumber(String seatNumber) { this.seatNumber = seatNumber; }
    public String getClassType() { return classType; }
    public void setClassType(String classType) { this.classType = classType; }
} 