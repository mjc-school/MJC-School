package com.epam.mjc.demo.server.rest;

import com.epam.mjc.demo.model.Hotel;
import com.epam.mjc.demo.service.HotelService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HotelController {

    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping("/hotels")
    public List<Hotel> getHotels() {
        return hotelService.getHotels();
    }
}
