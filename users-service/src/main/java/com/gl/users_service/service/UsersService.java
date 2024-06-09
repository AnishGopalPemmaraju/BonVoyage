package com.gl.users_service.service;

import com.gl.users_service.entity.Users;
import com.gl.users_service.payload.LoginDetailsDTO;
import com.gl.users_service.payload.UsersDTO;

public interface UsersService {
     UsersDTO addUser(UsersDTO usersDTO);
     UsersDTO loginUser(LoginDetailsDTO loginDetailsDTO);
     UsersDTO getUserByUserName(String userName);

}
