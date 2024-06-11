package com.gl.users_service.payload;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AdminDTO {
    private String adminName;
    private String adminEmail;
    private String adminAddress;
    private long totalBookings;
    private long totalPackages;
}
