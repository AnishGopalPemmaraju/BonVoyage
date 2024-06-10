package com.gl.bookings_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Bookings")
public class Booking {
    @Id
    private String bookingId;
    private String userId;
    private String packageID;
    private String packageImage;
    private String bookingPerson;
    private String bookingRooms;

}
