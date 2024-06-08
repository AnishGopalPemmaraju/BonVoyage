package com.app.package_service.controller;

import com.app.package_service.payload.PackageDetailsDto;
import com.app.package_service.service.impl.PackageDetailsServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/packageDetails")
public class PackageDetailsController {
    private final PackageDetailsServiceImpl packageDetailsService;

    @GetMapping
    public ResponseEntity<List<PackageDetailsDto>> getAllPackages() {
        List<PackageDetailsDto> packages = packageDetailsService.getAllPackages();
        return ResponseEntity.ok(packages);
    }
    @GetMapping("/{packageID}")
    public ResponseEntity<PackageDetailsDto> getPackageById(@Valid @PathVariable String packageID) {
        return new ResponseEntity<>(packageDetailsService.findPackageById(packageID), HttpStatus.OK);
    }
    @GetMapping("/city/{packageCity}")
    public ResponseEntity<PackageDetailsDto> getPackageByLocation(@Valid @PathVariable String packageCity){
        return new ResponseEntity<>(packageDetailsService.findPackageByCity(packageCity),HttpStatus.OK);
    }
}

