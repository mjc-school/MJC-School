package com.epam.mjc.repository;

import com.epam.mjc.model.Booking;

import java.time.LocalDate;

public class BookingRepository {

    public boolean createBooking(Booking booking) {
        return true;
    }

    public void deleteBooking(long bookingId) {

    }

    public boolean findBooking(LocalDate startDate, LocalDate endDate) {
        return true;
    }
}
