package com.gl.packages_service.repository;

import com.gl.packages_service.entity.PackageItineraryKey;
import com.gl.packages_service.entity.PackagesItinerary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PackageItineraryRepository extends JpaRepository<PackagesItinerary, PackageItineraryKey> {

    @Query("SELECT pi FROM PackagesItinerary pi WHERE pi.id.packageId = :packageId")
    List<PackagesItinerary> findPackagesItineraryByPackageId(String packageId);
}
