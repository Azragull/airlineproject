package com.airline.model;

import jakarta.persistence.*;

@Entity
@Table(name = "baggage_allowance")
public class BaggageAllowance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long baggageID;
    private Long flightID;
    private Integer allowedWeight;
    private Double extraChargePerKg;

    // Getters and Setters
    public Long getBaggageID() {
        return baggageID;
    }

    public void setBaggageID(Long baggageID) {
        this.baggageID = baggageID;
    }

    public Long getFlightID() {
        return flightID;
    }

    public void setFlightID(Long flightID) {
        this.flightID = flightID;
    }

    public Integer getAllowedWeight() {
        return allowedWeight;
    }

    public void setAllowedWeight(Integer allowedWeight) {
        this.allowedWeight = allowedWeight;
    }

    public Double getExtraChargePerKg() {
        return extraChargePerKg;
    }

    public void setExtraChargePerKg(Double extraChargePerKg) {
        this.extraChargePerKg = extraChargePerKg;
    }
} 