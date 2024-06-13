package com.gl.users_service.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class UserBookingsAPIDTO {
    UsersDTO usersDTO;
    List<BookingDTO> bookingDTOList = new ArrayList<>();
}
