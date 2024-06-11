package com.gl.users_service.repository;

import com.gl.users_service.entity.Users;
import com.gl.users_service.payload.UsersDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users,String> {
    Users findByUserName(String userName);
    Users findByUserEmail(String userEmail);
    Users findByUserRole(String role);
}
