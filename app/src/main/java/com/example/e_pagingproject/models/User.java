package com.example.e_pagingproject.models;

public class User {
    String guestName;
    String flightNumber;
    String arrivalTime;

    public User() {
    }

    public User(String guestName, String flightNumber, String arrivalTime) {
        this.guestName = guestName;
        this.flightNumber = flightNumber;
        this.arrivalTime = arrivalTime;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
}
