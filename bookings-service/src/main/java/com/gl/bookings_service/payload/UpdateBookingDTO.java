package com.gl.bookings_service.payload;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateBookingDTO {

    private String bookingId;
    private String bookingPerson;
    private String bookingRooms;
    private String bookingDate;
}
