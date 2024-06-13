package com.gl.users_service.service.impl;

import com.gl.users_service.client.OpenFeignBookings;
import com.gl.users_service.entity.Users;
import com.gl.users_service.exception.ResourceNotFoundException;
import com.gl.users_service.payload.BookingDTO;
import com.gl.users_service.payload.LoginDetailsDTO;
import com.gl.users_service.payload.UserBookingsAPIDTO;
import com.gl.users_service.payload.UsersDTO;
import com.gl.users_service.repository.UsersRepository;
import com.gl.users_service.service.UsersService;
import com.gl.users_service.util.MapperLibrary;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UsersServiceImpl implements UsersService {
    UsersRepository usersRepository;
    OpenFeignBookings openFeignBookings;
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
    public UserBookingsAPIDTO loginUser(LoginDetailsDTO loginDetailsDTO) {
        Users users = usersRepository.findByUserEmail(loginDetailsDTO.getUserEmail());
        if (users==null || !authenticate(loginDetailsDTO.getUserPassword(), users)){
            throw new ResourceNotFoundException("Invalid Login Details!");
        }
        List<BookingDTO> bookingDTOList = openFeignBookings.getBookingsByUserId(users.getUserID());
        return new UserBookingsAPIDTO(MapperLibrary.mapToUsersDto(users),bookingDTOList);
    }

    @Override
    public UserBookingsAPIDTO getUserByUserName(String userName) {
        Users users = usersRepository.findByUserName(userName);
        if (users==null){
            throw new ResourceNotFoundException("User","username",userName);
        }
        List<BookingDTO> bookingDTOList = openFeignBookings.getBookingsByUserId(users.getUserID());
        return new UserBookingsAPIDTO(MapperLibrary.mapToUsersDto(users),bookingDTOList);
    }
    @Override
    public UserBookingsAPIDTO findByUserId(String userId) {
        Users users = usersRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","User Id",userId));

        List<BookingDTO> bookingDTOList = openFeignBookings.getBookingsByUserId(users.getUserID());
        return new UserBookingsAPIDTO(MapperLibrary.mapToUsersDto(users),bookingDTOList);
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



