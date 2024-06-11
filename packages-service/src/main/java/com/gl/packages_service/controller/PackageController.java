package com.gl.packages_service.controller;

import com.gl.packages_service.payload.PackagesDTO;
import com.gl.packages_service.service.PackagesService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/packages")
public class PackageController {
    PackagesService packagesService;
    @GetMapping
    public List<PackagesDTO> getPackages(){
        return packagesService.getPackages();
    }
    @GetMapping("/{location}")
    public PackagesDTO getPackageByLocation(@PathVariable String location){
        return packagesService.getPackageByLocation(location);
    }
    @GetMapping("/onePackage/{packageId}")
    public PackagesDTO getPackageById(@PathVariable String packageId){
        return packagesService.getPackageById(packageId);
    }
    @PostMapping
    public ResponseEntity<PackagesDTO> createPackage(@Valid @RequestBody PackagesDTO packagesDTO){
        return new ResponseEntity<>(packagesService.createPackage(packagesDTO), HttpStatus.CREATED);
    }

    @GetMapping("/packagesCount")
    public long getPackagesCount(){
        return packagesService.getPackagesCount();
    }
}
