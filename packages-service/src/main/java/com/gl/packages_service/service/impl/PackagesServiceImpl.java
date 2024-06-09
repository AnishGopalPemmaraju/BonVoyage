package com.gl.packages_service.service.impl;

import com.gl.packages_service.PackagesServiceApplication;
import com.gl.packages_service.entity.Packages;
import com.gl.packages_service.exception.PackageNotFoundException;
import com.gl.packages_service.payload.PackagesDTO;
import com.gl.packages_service.repository.PackageRepository;
import com.gl.packages_service.service.PackagesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class PackagesServiceImpl implements PackagesService {
    PackageRepository packageRepository;

    @Override
    public List<PackagesDTO> getPackages() {
        List<Packages> packagesList = packageRepository.findAll();
        return packagesList.stream().map(packages -> mapToDTO(packages)).toList();
    }

    @Override
    public PackagesDTO getPackageByLocation(String packageCity) {
        Packages packages = packageRepository.findByPackageCity(packageCity);
        if (packages==null){
            throw new PackageNotFoundException("Packages","Package City",packageCity);
        }
        return mapToDTO(packages);
    }

    @Override
    public PackagesDTO getPackageById(String packageId) {
        Packages packages = packageRepository.findById(packageId).orElseThrow(()->new PackageNotFoundException("Package","Package Id",packageId));
        return mapToDTO(packages);
    }

    @Override
    public PackagesDTO createPackage(PackagesDTO packagesDTO) {
        String packageId = generatePackageId();
        packagesDTO.setPackageID(packageId);
        return mapToDTO(packageRepository.save(mapToEntity(packagesDTO)));
    }

    public static PackagesDTO mapToDTO(Packages packages){
        return PackagesServiceApplication.modelMapper().map(packages, PackagesDTO.class);
    }

    public static Packages mapToEntity(PackagesDTO packagesDTO){
        return PackagesServiceApplication.modelMapper().map(packagesDTO,Packages.class);
    }

    public String generatePackageId(){
        long id = packageRepository.count()+100;

            long quotient = id / 100;
            long remainder = id % 100;
            long number = (quotient * 100) + (remainder + 1);

            return "P" + number;
        }
    }
