package com.gl.users_service.service.impl;

import com.gl.users_service.client.OpenFeignBookings;
import com.gl.users_service.client.OpenFeignPackages;
import com.gl.users_service.entity.Users;
import com.gl.users_service.payload.AdminDTO;
import com.gl.users_service.repository.UsersRepository;
import com.gl.users_service.service.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AdminServiceImpl implements AdminService {
    OpenFeignPackages openFeignPackages;
    OpenFeignBookings openFeignBookings;
    UsersRepository usersRepository;

    @Override
    public AdminDTO getAdminDetails() {
        long packagesCount = openFeignPackages.getPackagesCount();
        long bookingsCount = openFeignBookings.getBookingsCount();

        Users users = usersRepository.findByUserRole("Admin");
        AdminDTO adminDTO = new AdminDTO();
        adminDTO.setAdminName(users.getName());
        adminDTO.setAdminEmail(users.getUserEmail());
        adminDTO.setAdminAddress(users.getUserAddress());
        adminDTO.setTotalBookings(bookingsCount);
        adminDTO.setTotalPackages(packagesCount);

        return adminDTO;
    }

}
