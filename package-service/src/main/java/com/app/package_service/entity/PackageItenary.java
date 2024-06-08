package com.app.package_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "packageItenary")
public class PackageItenary {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(insertable=false, updatable=false)
    private String packageID;
    private String day;
    private String title;
    private String activities;

    //one package many packageItenary
//    @OneToMany(mappedBy = "packageItenary")
//    private List<Package> package1;

    @ManyToOne
    @JoinColumn(name = "packageID")
    private PackageDetails PackageDetails;
}
