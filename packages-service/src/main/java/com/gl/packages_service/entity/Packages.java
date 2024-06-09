package com.gl.packages_service.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "packageDetails")
public class Packages {
    @Id
    private String packageID;
    @Column(nullable = false)
    private String packageCountry;
    @Column(nullable = false)
    private String packageCity;
    @Column(nullable = false,unique = true)
    private String packageName;
    @Column(nullable = false)
    private String packageDesc;
    @Column(nullable = false)
    private String packageRating;
    @Column(nullable = false)
    private String packageReviews;
    @Column(nullable = false)
    private String packagePrice;
    @Column(nullable = false)
    private String packageDuration;
    @Column(nullable = false)
    private String minAge;
    @Column(nullable = false)
    private String maxPeople;
    @Column(nullable = false)
    private String packagePickup;
    @Column(nullable = false)
    private String availableDate;
    @Column(nullable = false)
    private String packageLanguage;
    @Column(nullable = false)
    private String packageImage;


    @OneToMany(mappedBy = "packageDetails")
    private List<PackagesItinerary> packagesItinerary;
}
