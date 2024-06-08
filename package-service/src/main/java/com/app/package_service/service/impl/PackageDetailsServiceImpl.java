package com.app.package_service.service.impl;

import com.app.package_service.entity.PackageDetails;
import com.app.package_service.exception.ApiException;
import com.app.package_service.payload.PackageDetailsDto;
import com.app.package_service.repository.PackageDetailsRepository;
import com.app.package_service.service.PackageDetailsService;
import com.app.package_service.util.Mapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PackageDetailsServiceImpl implements PackageDetailsService {
    private final PackageDetailsRepository packageDetailsRepository;

//    private List<PackageDetails> packageDetails = new ArrayList<>();

    @Override
    public List<PackageDetailsDto> getAllPackages() {
        List<PackageDetails> packageDetails = packageDetailsRepository.findAll();
        return packageDetails.stream().map(Mapper::mapToPackageDetailsDto).collect(Collectors.toList());
    }

    @Override
    public PackageDetailsDto findPackageById(String packageID) {
        PackageDetails packageDetails = packageDetailsRepository.findByPackageID(packageID).orElseThrow(
                () -> new ApiException(HttpStatus.BAD_REQUEST,"No package found with this packageId")
        );
        return Mapper.mapToPackageDetailsDto(packageDetails);
    }

    @Override
    public PackageDetailsDto findPackageByCity(String packageCity) {
        PackageDetails packageDetails=packageDetailsRepository.findByPackageCity(packageCity).orElseThrow(
                ()-> new ApiException(HttpStatus.BAD_REQUEST,"Package can't be found for this city")
        );
        return Mapper.mapToPackageDetailsDto(packageDetails);
    }

}

