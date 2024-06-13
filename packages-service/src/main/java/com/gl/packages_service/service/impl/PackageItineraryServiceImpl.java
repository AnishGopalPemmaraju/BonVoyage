package com.gl.packages_service.service.impl;

import com.gl.packages_service.PackagesServiceApplication;
import com.gl.packages_service.entity.PackageItineraryKey;
import com.gl.packages_service.entity.Packages;
import com.gl.packages_service.entity.PackagesItinerary;
import com.gl.packages_service.exception.PackageNotFoundException;
import com.gl.packages_service.payload.PackageItineraryDTO;
import com.gl.packages_service.payload.PackagesDTO;
import com.gl.packages_service.repository.PackageItineraryRepository;
import com.gl.packages_service.repository.PackageRepository;
import com.gl.packages_service.service.PackageItineraryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PackageItineraryServiceImpl implements PackageItineraryService {
   PackageItineraryRepository packageItineraryRepository;
   PackageRepository packageRepository;
    @Override
    public List<PackageItineraryDTO> addPackageItinerary(PackageItineraryDTO packageItineraryDTO) {
        PackagesItinerary packagesItinerary = packageItineraryRepository.save(mapToEntity(packageItineraryDTO));
        Packages packages = packageRepository.findById(packageItineraryDTO.getPackageID()).orElseThrow(()->new PackageNotFoundException("Package","Package ID", packageItineraryDTO.getPackageID()));
        packages.getPackagesItinerary().add(packagesItinerary);
        packageRepository.save(packages);

        return packageItineraryRepository.findPackagesItineraryByPackageId(packageItineraryDTO.getPackageID()).stream().map(packagesItinerary1 -> mapToDTO(packagesItinerary1)).collect(Collectors.toList());
    }


    @Override
    public List<PackageItineraryDTO> getPackageItinerariesByPackageId(String packageId) {
        return packageItineraryRepository.findPackagesItineraryByPackageId(packageId).stream().map(packagesItinerary -> mapToDTO(packagesItinerary)).collect(Collectors.toList());
    }

    public  PackageItineraryDTO mapToDTO(PackagesItinerary packagesItinerary){
        PackageItineraryDTO packageItineraryDTO = new PackageItineraryDTO();

        packageItineraryDTO.setPackageID(packagesItinerary.getId().getPackageId());
        packageItineraryDTO.setDay(packagesItinerary.getId().getDay());
        packageItineraryDTO.setTitle(packagesItinerary.getTitle());
        packageItineraryDTO.setActivities(packagesItinerary.getActivities());

        return packageItineraryDTO;
    }

    public PackagesItinerary mapToEntity(PackageItineraryDTO packageItineraryDTO){
        PackagesItinerary packagesItinerary = new PackagesItinerary();

        packagesItinerary.getId().setPackageId(packageItineraryDTO.getPackageID());
        packagesItinerary.getId().setDay(packageItineraryDTO.getDay());
        packagesItinerary.setTitle(packageItineraryDTO.getTitle());
        packagesItinerary.setActivities(packageItineraryDTO.getActivities());

        return packagesItinerary;
    }
}


