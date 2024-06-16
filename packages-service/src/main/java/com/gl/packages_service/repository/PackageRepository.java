package com.gl.packages_service.repository;

import com.gl.packages_service.entity.Packages;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PackageRepository extends JpaRepository<Packages,String> {
    Packages findByPackageCity(String packageCity);
    List<Packages> findByPackageCityIgnoreCase(String packageCity);

}
