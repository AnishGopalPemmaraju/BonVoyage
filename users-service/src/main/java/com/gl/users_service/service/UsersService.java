package com.gl.users_service.service;

import com.gl.users_service.entity.Users;
import com.gl.users_service.payload.*;

public interface UsersService {
//     UsersDTO addUser(UsersDTO usersDTO);
     LoginResponseDTO addUser(UsersDTO usersDTO);
     LoginResponseDTO loginUser(LoginDetailsDTO loginDetailsDTO);
//     UserBookingsAPIDTO loginUser(LoginDetailsDTO loginDetailsDTO);
     UserBookingsAPIDTO getUserByUserName(String userName);
     UserBookingsAPIDTO findByUserId(String userId);
}
