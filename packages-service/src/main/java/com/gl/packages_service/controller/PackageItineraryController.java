package com.gl.packages_service.controller;

import com.gl.packages_service.entity.PackagesItinerary;
import com.gl.packages_service.payload.PackageItineraryDTO;
import com.gl.packages_service.service.PackageItineraryService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/packages/itinerary")
public class PackageItineraryController {
    PackageItineraryService packageItineraryService;

    @PostMapping
    List<PackageItineraryDTO> addPackageItinerary(@Valid @RequestBody PackageItineraryDTO packageItineraryDTO){
        return packageItineraryService.addPackageItinerary(packageItineraryDTO);
    }

    @GetMapping("/{packageId}")
    List<PackageItineraryDTO> getPackageItinerariesByPackageId(@PathVariable String packageId){
        return packageItineraryService.getPackageItinerariesByPackageId(packageId);
    }


}
