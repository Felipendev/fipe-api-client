package com.fipe.api.output;

import lombok.Data;

@Data
public class ValueOutput {
    private int vehicleType;
    private String value;
    private String brand;
    private String model;
    private int modelYear;
    private String fuelType;
    private String fipeCode;
    private String referenceMonth;
    private String fuelAbbreviation;
}
