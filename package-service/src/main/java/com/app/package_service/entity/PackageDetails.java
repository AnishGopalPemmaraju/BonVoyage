package com.app.package_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "packageDetails")
public class PackageDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String packageID;
    private String packageCountry;
    private String packageCity;
    private String packageName;
    private String packageDesc;
    private double packageRating;
    private int packageReviews;
    private String packagePrice;
    private String packageDuration;
    private String minAge;
    private int maxPeople;
    private String packagePickup;
    private String availableDate;
    private String packageLanguage;
    private String packageImage;
//    @ManyToOne
//    @JoinColumn(name = "packageID")
//    private PackageItenary packageItenary;

    @OneToMany(mappedBy = "PackageDetails")
    private List<PackageItenary> packageItenary;
}
