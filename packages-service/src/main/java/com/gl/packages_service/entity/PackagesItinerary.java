package com.gl.packages_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "packagesItineraries")
public class PackagesItinerary {

    @EmbeddedId
    private PackageItineraryKey id = new PackageItineraryKey();
    private String title;
    private String activities;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "packageId", referencedColumnName = "packageId",insertable = false,updatable = false)
    private Packages packageDetails;
}
