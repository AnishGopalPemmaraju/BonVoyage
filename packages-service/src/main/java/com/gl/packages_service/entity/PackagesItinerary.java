package com.gl.packages_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "packagesItineraries")
public class PackagesItinerary {

    private String itineraryId;
    private String day;
    private String title;
    private String activities;

    @ManyToOne
    @JoinColumn(name = "packageID")
    private Packages packageDetails;
}