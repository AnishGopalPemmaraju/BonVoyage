package com.gl.bookings_service.controller;

import com.gl.bookings_service.payload.BookingDTO;
import com.gl.bookings_service.payload.UpdateBookingDTO;
import com.gl.bookings_service.service.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    BookingService bookingService;

    @PostMapping
    public List<BookingDTO> createBooking(@RequestBody BookingDTO bookingDTO){
        return bookingService.createBooking(bookingDTO);
    }

    @GetMapping("/{userId}")
    public List<BookingDTO> getBookingsByUserId(@PathVariable String userId){
        return bookingService.getBookingsByUserId(userId);
    }
    @PutMapping
    public BookingDTO updateBooking(@RequestBody UpdateBookingDTO updateBookingDTO){
        return bookingService.updateBooking(updateBookingDTO);
    }

    @DeleteMapping("/{userId}/{bookingId}")
    public List<BookingDTO> deleteBooking(@PathVariable String userId, @PathVariable String bookingId){
        return bookingService.deleteBooking(userId,bookingId);
    }

    @GetMapping("/bookingsCount")
    public long getBookingsCount(){
        return bookingService.getBookingsCount();
    }
}
