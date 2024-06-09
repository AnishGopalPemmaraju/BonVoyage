package com.gl.packages_service.exception;

import com.gl.packages_service.entity.Packages;

public class PackageNotFoundException extends RuntimeException{
    String resourceName;
    String fieldName;
    String fieldValue;

    public PackageNotFoundException(String resourceName, String fieldName, String fieldValue) {
        super(resourceName+" with "+fieldName+": "+fieldValue+" is not found");
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

}
