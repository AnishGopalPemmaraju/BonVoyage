package com.gl.users_service.client;

import com.gl.users_service.payload.BookingDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "bookings-service")
public interface OpenFeignBookings {
    @GetMapping("/api/bookings/{userId}")
    List<BookingDTO> getBookingsByUserId(@PathVariable String userId);
}
