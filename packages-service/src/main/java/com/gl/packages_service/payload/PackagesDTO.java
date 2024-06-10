package com.gl.packages_service.payload;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PackagesDTO {

    private String packageID;

    @NotBlank(message = "Package country is required")
    private String packageCountry;

    @NotBlank(message = "Package city is required")
    private String packageCity;

    @NotBlank(message = "Package name is required")
    private String packageName;

    @NotBlank(message = "Package description is required")
    private String packageDesc;

    @NotNull
    @NotBlank(message = "Package rating is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Package rating must be greater than 0")
    @DecimalMax(value = "5.0", message = "Package rating must be less than or equal to 5")
    private String packageRating; // Required

    @NotNull
    @NotBlank(message = "Package reviews is required")
    @Min(value = 0, message = "Package reviews must be zero or greater")
    private String packageReviews; // Required

    @NotBlank(message = "Package price is required")
    private String packagePrice; // Required

    @NotBlank(message = "Package duration is required")
    private String packageDuration; // Required

    @NotBlank(message = "Minimum age is required")
    private String minAge; // Required

    @NotNull
    @NotBlank(message = "Maximum people is required")
    @Min(value = 1, message = "Maximum people must be at least 1")
    private String maxPeople; // Required

    @NotBlank(message = "Package pickup is required")
    private String packagePickup; // Required

    @NotBlank(message = "Available date is required")
    private String availableDate; // Required

    @NotBlank(message = "Package language is required")
    private String packageLanguage; // Required

    @NotBlank(message = "Package image is required")
    private String packageImage;

    private List<PackageItineraryDTO> packageItineraryDTOS = new ArrayList<>();
}

/*
packageCountry;
packageCity;
packageName;
packageDesc;
packageRating;
packageReviews;
packagePrice;
packageDuration;
minAge;
maxPeople;
packagePickup;
availableDate;
packageLanguage;
packageImage;
*/