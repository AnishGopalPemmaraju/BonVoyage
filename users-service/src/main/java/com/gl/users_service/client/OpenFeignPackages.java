package com.gl.users_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("packages-service")
public interface OpenFeignPackages {

    @GetMapping("/api/packages/packagesCount")
    long getPackagesCount();
}
