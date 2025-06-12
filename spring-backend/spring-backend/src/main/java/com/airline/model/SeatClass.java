package com.airline.model;

import jakarta.persistence.*;

@Entity
@Table(name = "seat_classes")
public class SeatClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long classID;
    private Long flightID;
    private String classType;
    private Double priceMultiplier;

    // Getters and Setters
    public Long getClassID() {
        return classID;
    }

    public void setClassID(Long classID) {
        this.classID = classID;
    }

    public Long getFlightID() {
        return flightID;
    }

    public void setFlightID(Long flightID) {
        this.flightID = flightID;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public Double getPriceMultiplier() {
        return priceMultiplier;
    }

    public void setPriceMultiplier(Double priceMultiplier) {
        this.priceMultiplier = priceMultiplier;
    }
} 