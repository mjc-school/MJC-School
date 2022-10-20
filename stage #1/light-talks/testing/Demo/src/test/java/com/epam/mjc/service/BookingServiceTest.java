package com.epam.mjc.service;

import com.epam.mjc.exception.CustomerException;
import com.epam.mjc.exception.HotelRoomException;
import com.epam.mjc.exception.ValidationException;
import com.epam.mjc.model.Customer;
import com.epam.mjc.model.HotelRoom;
import com.epam.mjc.repository.BookingRepository;
import com.epam.mjc.repository.CustomerRepository;
import com.epam.mjc.repository.HotelRoomRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookingServiceTest {

    private BookingService bookingService;

    @Mock
    private BookingRepository bookingRepository;
    @Mock
    private BookingValidator bookingValidator;
    @Mock
    private HotelRoomRepository hotelRoomRepository;
    @Mock
    private CustomerRepository customerRepository;

    @BeforeEach
    public void setUp() {
        bookingService = new BookingServiceImpl(bookingRepository, bookingValidator,
                hotelRoomRepository, customerRepository);
    }


    @Test
    void shouldCreateBooking() {
        long hotelRoomId = 11L;
        long customerId = 19L;

        HotelRoom hotelRoom = new HotelRoom();
        hotelRoom.setCost(15.0);
        when(hotelRoomRepository.find(hotelRoomId)).thenReturn(hotelRoom);
        when(customerRepository.find(customerId)).thenReturn(new Customer());
        when(bookingValidator.isValid(any())).thenReturn(true);
        when(bookingRepository.createBooking(any())).thenReturn(true);

        boolean actual = bookingService.book(hotelRoomId, customerId,
                LocalDate.now().minusDays(3), LocalDate.now());

        assertTrue(actual);
        verify(hotelRoomRepository).find(hotelRoomId);
        verify(customerRepository).find(customerId);
        verify(customerRepository).updateCost(customerId, 15.0);
        verify(bookingValidator).isValid(any());
        verify(bookingRepository).createBooking(any());
        verifyNoMoreInteractions(hotelRoomRepository, customerRepository, bookingValidator, bookingRepository);
    }

    @Test
    void shouldThrowHotelRoomException() {
        long hotelRoomId = 11L;
        long customerId = 19L;
        when(hotelRoomRepository.find(hotelRoomId)).thenReturn(null);

        assertThrows(HotelRoomException.class, () -> bookingService.book(hotelRoomId, customerId,
                LocalDate.now().minusDays(3), LocalDate.now()));

        verifyNoInteractions(customerRepository, bookingValidator, bookingRepository);
    }

    @Test
    void shouldThrowCustomerException() {
        long hotelRoomId = 11L;
        long customerId = 19L;

        HotelRoom hotelRoom = new HotelRoom();
        hotelRoom.setCost(15.0);
        when(hotelRoomRepository.find(hotelRoomId)).thenReturn(hotelRoom);
        when(customerRepository.find(customerId)).thenReturn(null);

        assertThrows(CustomerException.class, () -> bookingService.book(hotelRoomId, customerId,
                LocalDate.now().minusDays(3), LocalDate.now()));

        verify(hotelRoomRepository).find(hotelRoomId);
        verifyNoInteractions(bookingValidator, bookingRepository);
    }

    @Test
    void shouldThrowValidationException() {
        long hotelRoomId = 11L;
        long customerId = 19L;

        HotelRoom hotelRoom = new HotelRoom();
        hotelRoom.setCost(15.0);
        when(hotelRoomRepository.find(hotelRoomId)).thenReturn(hotelRoom);
        when(customerRepository.find(customerId)).thenReturn(new Customer());
        when(bookingValidator.isValid(any())).thenReturn(false);

        assertThrows(ValidationException.class, () -> bookingService.book(hotelRoomId, customerId,
                LocalDate.now().minusDays(3), LocalDate.now()));

        verify(hotelRoomRepository).find(hotelRoomId);
        verify(customerRepository).find(customerId);
        verifyNoInteractions(bookingRepository);
        verifyNoMoreInteractions(customerRepository);
    }

    @Test
    void shouldReturnFalseBookingWasNotCreated() {
        long hotelRoomId = 11L;
        long customerId = 19L;

        HotelRoom hotelRoom = new HotelRoom();
        hotelRoom.setCost(15.0);
        when(hotelRoomRepository.find(hotelRoomId)).thenReturn(hotelRoom);
        when(customerRepository.find(customerId)).thenReturn(new Customer());
        when(bookingValidator.isValid(any())).thenReturn(true);
        when(bookingRepository.createBooking(any())).thenReturn(false);

        boolean actual = bookingService.book(hotelRoomId, customerId,
                LocalDate.now().minusDays(3), LocalDate.now());

        assertFalse(actual);
        verify(hotelRoomRepository).find(hotelRoomId);
        verify(customerRepository).find(customerId);
        verify(bookingValidator).isValid(any());
        verify(bookingRepository).createBooking(any());
        verifyNoMoreInteractions(hotelRoomRepository, customerRepository, bookingValidator, bookingRepository);
    }

}
