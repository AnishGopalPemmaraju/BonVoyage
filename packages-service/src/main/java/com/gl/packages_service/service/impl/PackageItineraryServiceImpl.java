package com.gl.packages_service.service.impl;

import com.gl.packages_service.PackagesServiceApplication;
import com.gl.packages_service.entity.Packages;
import com.gl.packages_service.entity.PackagesItinerary;
import com.gl.packages_service.payload.PackageItineraryDTO;
import com.gl.packages_service.payload.PackagesDTO;
import com.gl.packages_service.service.PackageItineraryService;

public class PackageItineraryServiceImpl implements PackageItineraryService {

    @Override
    public PackageItineraryDTO addPackageItinerary(PackageItineraryDTO packageItineraryDTO) {
        return null;
    }

    private static PackageItineraryDTO mapToDTO(PackagesItinerary packagesItinerary){
        return PackagesServiceApplication.modelMapper().map(packagesItinerary, PackageItineraryDTO.class);
    }

    private static PackagesItinerary mapToEntity(PackageItineraryDTO packageItineraryDTO){
        return PackagesServiceApplication.modelMapper().map(packageItineraryDTO,PackagesItinerary.class);
    }
}


