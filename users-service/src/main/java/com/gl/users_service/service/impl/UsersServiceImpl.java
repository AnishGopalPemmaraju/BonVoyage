package com.gl.users_service.service.impl;

import com.gl.users_service.entity.Users;
import com.gl.users_service.exception.ResourceNotFoundException;
import com.gl.users_service.payload.LoginDetailsDTO;
import com.gl.users_service.payload.UsersDTO;
import com.gl.users_service.repository.UsersRepository;
import com.gl.users_service.service.UsersService;
import com.gl.users_service.util.MapperLibrary;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UsersServiceImpl implements UsersService {
    UsersRepository usersRepository;

    @Override
    public UsersDTO addUser(UsersDTO usersDTO) {
        usersDTO.setUserID(generateUserId());

        /*Password Encryption using BCrypt*/
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(usersDTO.getUserPassword());
        usersDTO.setUserPassword(hashedPassword);

        return MapperLibrary.mapToUsersDto(usersRepository.save(MapperLibrary.mapToUsers(usersDTO)));
    }

    @Override
    public UsersDTO loginUser(LoginDetailsDTO loginDetailsDTO) {
        Users users = usersRepository.findByUserEmail(loginDetailsDTO.getUserEmail());
        if (users==null || !authenticate(loginDetailsDTO.getUserPassword(), users)){
            throw new ResourceNotFoundException("Invalid Login Details!");
        }
        return MapperLibrary.mapToUsersDto(users);
    }

    @Override
    public UsersDTO getUserByUserName(String userName) {
        Users users = usersRepository.findByUserName(userName);
        if (users==null){
            throw new ResourceNotFoundException("User","username",userName);
        }
        return MapperLibrary.mapToUsersDto(users);
    }

    public String generateUserId(){
        long id = usersRepository.count()+100;
        id = id+1;
        return "U" + id;
    }

    public boolean authenticate(String password,Users users){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(password, users.getUserPassword());
    }
}



