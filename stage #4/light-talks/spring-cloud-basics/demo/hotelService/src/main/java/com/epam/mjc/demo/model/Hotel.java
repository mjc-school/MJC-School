package com.epam.mjc.demo.model;

public class Hotel {

    private String name;
    private Integer pricePerNight;

    public String getName() {
        return name;
    }

    public Hotel setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getPricePerNight() {
        return pricePerNight;
    }

    public Hotel setPricePerNight(Integer pricePerNight) {
        this.pricePerNight = pricePerNight;
        return this;
    }
}
