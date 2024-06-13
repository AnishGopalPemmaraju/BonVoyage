package com.gl.bookings_service.client;

import com.gl.bookings_service.payload.PackagesDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "packages-service")
public interface OpenFeignPackage {
    @GetMapping("/api/packages/onePackage/{packageId}")
    PackagesDTO getPackageById(@PathVariable String packageId);
}
