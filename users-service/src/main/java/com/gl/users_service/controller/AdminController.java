package com.gl.users_service.controller;

import com.gl.users_service.payload.AdminDTO;
import com.gl.users_service.repository.UsersRepository;
import com.gl.users_service.service.AdminService;
import lombok.AllArgsConstructor;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("api/admin")
public class AdminController {
    AdminService adminService;
    @GetMapping
    public AdminDTO getAdminDetails(){
        return adminService.getAdminDetails();
    }
}
