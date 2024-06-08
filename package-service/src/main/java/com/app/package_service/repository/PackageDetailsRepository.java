package com.app.package_service.repository;

import com.app.package_service.entity.PackageDetails;
import com.app.package_service.payload.PackageDetailsDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PackageDetailsRepository extends JpaRepository<PackageDetails,String> {
    Optional<PackageDetails> findByPackageCity(String packageCity);
    Optional<PackageDetails> findByPackageID(String packageID);

}
