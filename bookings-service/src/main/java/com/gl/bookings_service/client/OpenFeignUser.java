package com.gl.bookings_service.client;

import com.gl.bookings_service.payload.UsersDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "users-service")
public interface OpenFeignUser {
    @GetMapping("/api/users/id/{userId}")
    UsersDTO getUserById(@PathVariable String userId);
}
