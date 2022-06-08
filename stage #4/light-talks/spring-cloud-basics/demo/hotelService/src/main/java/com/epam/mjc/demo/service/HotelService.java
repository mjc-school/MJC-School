package com.epam.mjc.demo.service;

import com.epam.mjc.demo.model.Hotel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RefreshScope
public class HotelService {

    private static final Logger LOGGER = LoggerFactory.getLogger(HotelService.class);

//    private final DiscountClient discountClient;

    private final boolean hotel1Enabled;
    private final boolean hotel2Enabled;

    public HotelService(
            @Value("${hotel.one.enabled}") boolean hotel1Enabled,
            @Value("${hotel.two.enabled}") boolean hotel2Enabled//,
//            DiscountClient discountClient
    ) {
//        this.discountClient = discountClient;
        this.hotel1Enabled = hotel1Enabled;
        this.hotel2Enabled = hotel2Enabled;

        LOGGER.info("Creating service with hotel1Enabled={}, hotel2Enabled={}", hotel1Enabled, hotel2Enabled);
    }

    public List<Hotel> getHotels() {
        List<Hotel> hotels = new ArrayList<>();

        int discount = 10;
//        int discount = discountClient.getDiscount().getAmount();

        if (hotel1Enabled) {
            Hotel hotel = new Hotel().setName("Hotel_1")
                    .setPricePerNight(applyDiscount(discount, 100));
            hotels.add(hotel);
        }
        if (hotel2Enabled) {
            Hotel hotel = new Hotel().setName("Hotel_2")
                    .setPricePerNight(applyDiscount(discount, 200));
            hotels.add(hotel);
        }

        return hotels;
    }

    private int applyDiscount(int discount, int basePrice) {
        return basePrice * (100 - discount) / 100;
    }
}
