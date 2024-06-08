package com.app.package_service.util;

import com.app.package_service.PackageServiceApplication;
import com.app.package_service.entity.PackageDetails;
import com.app.package_service.entity.PackageItenary;
import com.app.package_service.payload.PackageDetailsDto;
import com.app.package_service.payload.PackageItenaryDto;

public class Mapper {
    public static PackageDetailsDto mapToPackageDetailsDto(PackageDetails packageDetails) {
        return PackageServiceApplication.modelMapper().map(packageDetails, PackageDetailsDto.class);
    }
    public static PackageDetails mapToPackageDetails(PackageDetailsDto packageDetailsDto) {
        return PackageServiceApplication.modelMapper().map(packageDetailsDto, PackageDetails.class);
    }
    public static PackageItenaryDto mapToPackageItenaryDto(PackageItenary packageItenary) {
        return PackageServiceApplication.modelMapper().map(packageItenary, PackageItenaryDto.class);
    }
    public static PackageItenary mapToPackageItenary(PackageItenaryDto packageItenaryDto) {
        return PackageServiceApplication.modelMapper().map(packageItenaryDto, PackageItenary.class);
    }

}
