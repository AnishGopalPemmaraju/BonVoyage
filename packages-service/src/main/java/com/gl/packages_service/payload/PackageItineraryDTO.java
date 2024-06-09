package com.gl.packages_service.payload;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PackageItineraryDTO {
        @NotEmpty(message = "Package ID is required")
        private String packageID; // Required

        @NotEmpty(message = "Day is required")
        private String day; // Required

        @NotEmpty(message = "Title is required")
        private String title; // Required

        @NotEmpty(message = "Activities are required")
        private String activities;
}
