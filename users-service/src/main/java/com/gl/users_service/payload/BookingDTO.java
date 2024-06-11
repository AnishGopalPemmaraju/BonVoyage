package com.gl.users_service.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingDTO {
    private String bookingId;
    private String userId;
    private String packageID;
    private String bookingDate;
    private String bookingPerson;
    private String bookingRooms;
}
