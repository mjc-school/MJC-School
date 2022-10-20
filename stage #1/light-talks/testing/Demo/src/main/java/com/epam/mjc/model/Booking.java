package com.epam.mjc.model;

import java.time.LocalDate;

public class Booking {

    private long id;
    private HotelRoom hotelRoom;
    private Customer customer;
    private LocalDate startDate;
    private LocalDate endDate;

    public Booking(HotelRoom hotelRoom, Customer customer, LocalDate startDate, LocalDate endDate) {
        this.hotelRoom = hotelRoom;
        this.customer = customer;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Booking(long id, HotelRoom hotelRoom, Customer customer, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.hotelRoom = hotelRoom;
        this.customer = customer;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public HotelRoom getHotelRoom() {
        return hotelRoom;
    }

    public void setHotelRoom(HotelRoom hotelRoom) {
        this.hotelRoom = hotelRoom;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
