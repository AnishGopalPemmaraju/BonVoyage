package com.gl.packages_service.service.impl;

import com.gl.packages_service.PackagesServiceApplication;
import com.gl.packages_service.entity.Packages;
import com.gl.packages_service.entity.PackagesItinerary;
import com.gl.packages_service.exception.PackageNotFoundException;
import com.gl.packages_service.payload.PackageItineraryDTO;
import com.gl.packages_service.payload.PackagesDTO;
import com.gl.packages_service.repository.PackageRepository;
import com.gl.packages_service.service.PackagesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class PackagesServiceImpl implements PackagesService {
    PackageRepository packageRepository;

    @Override
    public List<PackagesDTO> getPackages() {
        List<Packages> packagesList = packageRepository.findAll();
        return packagesList.stream().map(packages -> mapToPackageDTO(packages)).toList();
    }

    @Override
    public List<PackagesDTO> getPackageByLocation(String packageCity) {
        List<Packages> packagesList = packageRepository.findByPackageCityIgnoreCase(packageCity);
        if (packagesList.isEmpty()) {
            throw new PackageNotFoundException("Packages", "Package City", packageCity);
        }
        return packagesList.stream().map(this::mapToPackageDTO).collect(Collectors.toList());
    }


    @Override
    public PackagesDTO getPackageById(String packageId) {
        Packages packages = packageRepository.findById(packageId).orElseThrow(()->new PackageNotFoundException("Package","Package Id",packageId));
        return mapToPackageDTO(packages);
    }

    @Override
    public PackagesDTO createPackage(PackagesDTO packagesDTO) {
        String packageId = generatePackageId();
        packagesDTO.setPackageID(packageId);
        return mapToPackageDTO(packageRepository.save(mapToPackage(packagesDTO)));
    }

    @Override
    public long getPackagesCount() {
        return packageRepository.count();
    }

    public PackagesDTO mapToPackageDTO(Packages packages){

        return PackagesServiceApplication.modelMapper().map(packages, PackagesDTO.class);
    }

    public Packages mapToPackage(PackagesDTO packagesDTO){
        return PackagesServiceApplication.modelMapper().map(packagesDTO,Packages.class);
    }

    public String generatePackageId(){
        long id = packageRepository.count()+100;

            long quotient = id / 100;
            long remainder = id % 100;
            long number = (quotient * 100) + (remainder + 1);

            return "P" + number;
        }

    public PackageItineraryDTO mapToDTO(PackagesItinerary packagesItinerary){
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
