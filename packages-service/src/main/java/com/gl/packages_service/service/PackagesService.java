package com.gl.packages_service.service;

import com.gl.packages_service.entity.Packages;
import com.gl.packages_service.payload.PackagesDTO;

import java.util.List;

public interface PackagesService {

//    List<PackagesDTO> getPackages();
//    PackagesDTO getPackageByLocation(String location);
//    PackagesDTO getPackageById(String packageId);
//    PackagesDTO createPackage(PackagesDTO packagesDTO);
//    long getPackagesCount();

        List<PackagesDTO> getPackages();
        List<PackagesDTO> getPackageByLocation(String packageCity);
        PackagesDTO getPackageById(String packageId);
        PackagesDTO createPackage(PackagesDTO packagesDTO);
        long getPackagesCount();
}

