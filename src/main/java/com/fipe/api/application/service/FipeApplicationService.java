package com.fipe.api.application.service;

import com.fipe.api.application.api.FipeFeignClient;
import com.fipe.api.application.api.response.BrandResponse;
import com.fipe.api.domain.VehicleType;
import com.fipe.api.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class FipeApplicationService implements FipeService {
    private final FipeFeignClient vehiclFeignClient;
    @Override
    public List<BrandResponse> getVehicleBrands(String vehicleType) {
        log.info("[start] FipeApplicationService - getVehicleBrands");
        validateVehicleType(vehicleType);
        List<BrandResponse> vehicleBrands = vehiclFeignClient.getVehicleBrands(vehicleType);
        vehicleBrands.sort(Comparator.comparing(BrandResponse::getName));
        log.info("[finish] FipeApplicationService - getVehicleBrands");
        return vehicleBrands;
    }

    private void validateVehicleType(String vehicleType) {
        if (!VehicleType.isValid(vehicleType)){
            log.error("[erro] Invalid vehicle type: {}", vehicleType);
            throw APIException.build(HttpStatus.BAD_REQUEST,
                    "Invalid vehicle type. Please choose either 'Carros', 'Motos', or 'Caminhoes'.");
        }
    }
}
