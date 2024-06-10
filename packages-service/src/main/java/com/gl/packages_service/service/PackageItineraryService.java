package com.gl.packages_service.service;

import com.gl.packages_service.entity.PackageItineraryKey;
import com.gl.packages_service.payload.PackageItineraryDTO;

import java.util.List;

public interface PackageItineraryService {

    List<PackageItineraryDTO> addPackageItinerary(PackageItineraryDTO packageItineraryDTO);
    List<PackageItineraryDTO> getPackageItinerariesByPackageId(String packageId);

}
