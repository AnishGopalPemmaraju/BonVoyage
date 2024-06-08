package com.app.package_service.service;

import com.app.package_service.payload.PackageDetailsDto;


import java.util.List;

public interface PackageDetailsService {
    List<PackageDetailsDto> getAllPackages();
    public PackageDetailsDto findPackageById(String packageID);
    public PackageDetailsDto findPackageByCity(String packageCity);
}
