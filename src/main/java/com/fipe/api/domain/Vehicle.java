package com.fipe.api.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class Vehicle {
    private String brandCode;
    private String brandName;
    private String modelCode;
    private String modelName;
    private String yearCode;
    private int year;
    private String fuelType;
    private String vehicleType;
    private String fipeCode;
    private String referenceMonth;
    private String value;
}
