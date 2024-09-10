package com.fipe.api.domain;

import lombok.Getter;

@Getter
public enum VehicleType {
    CARROS("Carros"),
    MOTOS("Motos"),
    CAMINHOES("Caminhoes");

    private final String type;

    VehicleType(String type) {
        this.type = type;
    }

    public static boolean isValid(String type) {
        for (VehicleType vehicleType : VehicleType.values()) {
            if (vehicleType.getType().equalsIgnoreCase(type)) {
                return true;
            }
        }
        return false;
    }
}

