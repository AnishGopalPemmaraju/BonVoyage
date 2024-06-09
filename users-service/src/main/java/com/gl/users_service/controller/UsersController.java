package com.gl.users_service.controller;

import com.gl.users_service.payload.LoginDetailsDTO;
import com.gl.users_service.payload.UsersDTO;
import com.gl.users_service.service.UsersService;
import com.gl.users_service.service.impl.UsersServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UsersController {
    UsersService usersService;
    @PostMapping("/register")
    public UsersDTO addUser(@Valid @RequestBody UsersDTO usersDTO){
        return usersService.addUser(usersDTO);
    }
    @PostMapping("/login")
    public UsersDTO loginUser(@Valid @RequestBody LoginDetailsDTO loginDetailsDTO){
        return usersService.loginUser(loginDetailsDTO);
    }

    @GetMapping("/{userName}")
   public UsersDTO getUserByUserName(@PathVariable String userName){
        return usersService.getUserByUserName(userName);
   }

}
