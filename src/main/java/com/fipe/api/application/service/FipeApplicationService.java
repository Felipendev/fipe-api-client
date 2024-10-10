package com.fipe.api.application.service;

import com.fipe.api.application.api.FipeFeignClient;
import com.fipe.api.application.api.response.BrandResponse;
import com.fipe.api.input.ValueInput;
import com.fipe.api.mapper.ValueMapper;
import com.fipe.api.output.ModelResponse;
import com.fipe.api.application.api.response.YearResponse;
import com.fipe.api.domain.VehicleType;
import com.fipe.api.handler.APIException;
import com.fipe.api.output.ValueOutput;
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
    private final FipeFeignClient fipeFeignClient;
    private final ValueMapper valueMapper;
    @Override
    public List<BrandResponse> getVehicleBrands(String vehicleType) {
        log.info("[start] FipeApplicationService - getVehicleBrands");
        List<BrandResponse> vehicleBrands = fipeFeignClient.getVehicleBrands(vehicleType);
        vehicleBrands.sort(Comparator.comparing(BrandResponse::getName));
        log.info("[finish] FipeApplicationService - getVehicleBrands");
        return vehicleBrands;
    }

    @Override
    public ModelResponse getModelsByBrand(String vehicleType, String brandId) {
        log.info("[start] FipeApplicationService - getModelsByBrand");
        validateVehicleType(vehicleType);
        validateBrandId(vehicleType, brandId);
        ModelResponse modelsByBrand = fipeFeignClient.getModelsByBrand(vehicleType, brandId);
        log.info("[finish] FipeApplicationService - getModelsByBrand");
        return modelsByBrand;
    }

    @Override
    public List<YearResponse> getYearsByModel(String vehicleType, String brandId, String modelId) {
        log.info("[start] FipeApplicationService - getYearsByModel");
        validateVehicleType(vehicleType);
        validateBrandId(vehicleType, brandId);
        validateModelId(vehicleType, brandId, modelId);
        List<YearResponse> yearsByModel = fipeFeignClient.getYearsByModel(vehicleType, brandId, modelId);
        log.info("[finish] FipeApplicationService - getYearsByModel");
        return yearsByModel;
    }

    @Override
    public ValueOutput getVehicleDetail(String vehicleType, String brandId, String modelId, String yearId) {
        log.info("[start] FipeService - getVehicleValue");
        validateVehicleType(vehicleType);
        validateBrandId(vehicleType, brandId);
        validateModelId(vehicleType, brandId, modelId);
        ValueInput valueInput = fipeFeignClient.getVehicleDetail(vehicleType, brandId, modelId, yearId);
        log.info("ValueInput returned from Feign Client: {}", valueInput);
        ValueOutput valueOutput = valueMapper.toOutput(valueInput);

        log.info("[finish] FipeService - getVehicleValue");
        return valueOutput;
    }

    private void validateVehicleType(String vehicleType) {
        if (!VehicleType.isValid(vehicleType)){
            log.error("[erro] Invalid vehicle type: {}", vehicleType);
            throw APIException.build(HttpStatus.BAD_REQUEST,
                    "Invalid vehicle type. Please choose either 'Carros', 'Motos', or 'Caminhoes'.");
        }
    }

    private void validateBrandId(String vehicleType, String brandId) {
        List<BrandResponse> brands = getVehicleBrands(vehicleType);
        boolean brandExists = brands.stream()
                .anyMatch(brandResponse -> brandResponse.getCode().equals(brandId));

        if (!brandExists){
            log.error("[error] Brand ID {} not found for vehicle type {}", brandId, vehicleType);
            throw APIException.build(HttpStatus.NOT_FOUND, "Brand ID not found: " + brandId);
        }
    }

    private void validateModelId(String vehicleType, String brandId, String modelId) {
        ModelResponse models = fipeFeignClient.getModelsByBrand(vehicleType, brandId);
        boolean modelExists = models.getModels().stream()
                .anyMatch(model -> model.getCode().equals(modelId));

        if (!modelExists){
            log.error("[error] Model ID {} not found for brand ID {}", modelId, brandId);
            throw APIException.build(HttpStatus.NOT_FOUND, "Model ID not found: " + modelId);
        }
    }
}
