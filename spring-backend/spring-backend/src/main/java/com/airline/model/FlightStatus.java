package com.airline.model;

import jakarta.persistence.*;

@Entity
@Table(name = "flight_status")
public class FlightStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long statusID;
    private Long flightID;
    private String departureTime;
    private String arrivalTime;
    private String status;

    // Getters and Setters
    public Long getStatusID() {
        return statusID;
    }

    public void setStatusID(Long statusID) {
        this.statusID = statusID;
    }

    public Long getFlightID() {
        return flightID;
    }

    public void setFlightID(Long flightID) {
        this.flightID = flightID;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
} 