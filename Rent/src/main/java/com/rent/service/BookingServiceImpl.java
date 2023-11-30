package com.rent.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rent.model.Booking;
import com.rent.repository.BookingRepository;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;

    @Autowired
    public BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id).orElse(null);
    }

    @Override
    public Booking saveBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }
    
    @Override
    public ResponseEntity<Booking> updateBooking(Long id, Booking updatedBooking) {
        Booking booking = bookingRepository.findById(id).orElse(null);
        if (booking != null) {
            // Update other properties of the booking
            // ...
            
            // Save the updated booking
            Booking updated = bookingRepository.save(booking);
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
