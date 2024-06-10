package com.gl.packages_service.payload;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
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
        private String packageID;

        @NotEmpty(message = "Day is required")
        private String day;

        @NotEmpty(message = "Title is required")
        @Size(min = 3,message = "Title should have minimum 3 characters long")
        private String title;

        @NotEmpty(message = "Activities are required")
        @Size(min = 3,message = "Title should have minimum 3 characters long")
        private String activities;
}
