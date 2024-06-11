package com.gl.users_service.service;

import com.gl.users_service.entity.Users;
import com.gl.users_service.payload.BookingDTO;
import com.gl.users_service.payload.LoginDetailsDTO;
import com.gl.users_service.payload.UserBookingsAPIDTO;
import com.gl.users_service.payload.UsersDTO;

public interface UsersService {
     UsersDTO addUser(UsersDTO usersDTO);
     UserBookingsAPIDTO loginUser(LoginDetailsDTO loginDetailsDTO);
     UserBookingsAPIDTO getUserByUserName(String userName);
     UserBookingsAPIDTO findByUserId(String userId);
}
