package com.epam.mjc.service;

import com.epam.mjc.exception.CustomerException;
import com.epam.mjc.exception.HotelRoomException;
import com.epam.mjc.exception.ValidationException;
import com.epam.mjc.model.Booking;
import com.epam.mjc.model.Customer;
import com.epam.mjc.model.HotelRoom;
import com.epam.mjc.repository.BookingRepository;
import com.epam.mjc.repository.CustomerRepository;
import com.epam.mjc.repository.HotelRoomRepository;

import java.time.LocalDate;

public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final BookingValidator validator;
    private final HotelRoomRepository hotelRoomRepository;
    private final CustomerRepository customerRepository;

    public BookingServiceImpl(BookingRepository bookingRepository,
                              BookingValidator validator,
                              HotelRoomRepository hotelRoomRepository,
                              CustomerRepository customerRepository) {
        this.bookingRepository = bookingRepository;
        this.validator = validator;
        this.hotelRoomRepository = hotelRoomRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public boolean book(long hotelRoomId, long customerId, LocalDate startDate, LocalDate endDate) {

        final HotelRoom hotelRoom = hotelRoomRepository.find(hotelRoomId);
        if (hotelRoom == null) {
            throw new HotelRoomException("Hotel room with provided id does not exist. Booking can not be done.");
        }
        final Customer customer = customerRepository.find(customerId);
        if (customer == null) {
            throw new CustomerException("Customer with provided id does not exist. Booking can not be done.");
        }

        final Booking booking = new Booking(hotelRoom, customer, startDate, endDate);
        if (!validator.isValid(booking)) {
            throw new ValidationException("Booking can not be done due to validation");
        }

        boolean isBookingCreated = bookingRepository.createBooking(booking);
        if (isBookingCreated) {
            customerRepository.updateCost(customerId, hotelRoom.getCost());
        }

        return isBookingCreated;
    }
}
