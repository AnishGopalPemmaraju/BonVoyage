package com.gl.bookings_service.service;

import com.gl.bookings_service.entity.Booking;
import com.gl.bookings_service.payload.BookingDTO;
import com.gl.bookings_service.payload.UpdateBookingDTO;

import java.util.List;

public interface BookingService {
    List<BookingDTO> createBooking(BookingDTO bookingDTO);
    List<BookingDTO> getBookingsByUserId(String userId);
    BookingDTO updateBooking(UpdateBookingDTO updateBookingDTO);
    List<BookingDTO> deleteBooking(String userId, String bookingId);
    long getBookingsCount();
}
