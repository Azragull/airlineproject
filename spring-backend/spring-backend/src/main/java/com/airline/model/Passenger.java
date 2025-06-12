package com.airline.model;

import jakarta.persistence.*;

@Entity
@Table(name = "passengers")
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long passengerID;
    private Long bookingID;
    private String name;
    private Integer age;
    private String passportNumber;

    // Getters and Setters
    public Long getPassengerID() {
        return passengerID;
    }

    public void setPassengerID(Long passengerID) {
        this.passengerID = passengerID;
    }

    public Long getBookingID() {
        return bookingID;
    }

    public void setBookingID(Long bookingID) {
        this.bookingID = bookingID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }
} 