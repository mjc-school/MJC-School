package com.epam.mjc.service;

import java.time.LocalDate;

public interface BookingService {

    boolean book(long hotelRoomId, long customerId, LocalDate startDate, LocalDate endDate);
}
