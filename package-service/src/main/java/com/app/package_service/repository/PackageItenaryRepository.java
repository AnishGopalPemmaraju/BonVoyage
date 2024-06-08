package com.app.package_service.repository;

import com.app.package_service.entity.PackageItenary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PackageItenaryRepository extends JpaRepository<PackageItenary,Long> {
}
