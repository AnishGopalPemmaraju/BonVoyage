package com.gl.bookings_service.payload;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BookingDTO {
    private String bookingId;
    private String userId;
    private String packageID;
    private String bookingDate;
    private String bookingPerson;
    private String bookingRooms;
}

