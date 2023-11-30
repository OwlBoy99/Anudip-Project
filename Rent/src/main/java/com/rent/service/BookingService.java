package com.rent.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.rent.model.Booking;

public interface BookingService {

    List<Booking> getAllBookings();

    Booking getBookingById(Long id);

    Booking saveBooking(Booking booking);

    void deleteBooking(Long id);
    
    ResponseEntity<Booking> updateBooking(Long id, Booking updatedBooking);
}
