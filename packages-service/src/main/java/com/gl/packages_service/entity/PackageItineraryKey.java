package com.gl.packages_service.entity;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Setter
@Getter
@Embeddable
public class PackageItineraryKey implements Serializable{

    private String packageId;
    private String day;

}
