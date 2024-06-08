package com.app.package_service.payload;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PackageItenaryDto {
    @NotBlank(message = "Package ID is required")
    private String packageID; // Required

    @NotBlank(message = "Day is required")
    private String day; // Required

    @NotBlank(message = "Title is required")
    private String title; // Required

    @NotBlank(message = "Activities are required")
    private String activities;
}
