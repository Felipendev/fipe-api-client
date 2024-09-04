package com.fipe.api.application.api;

import com.fipe.api.application.api.response.BrandResponse;
import com.fipe.api.application.api.response.ModelResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/vehicles")
@RestController
public interface FipeAPI {

    @GetMapping("/{type}/brands")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Retrieve list of brands for a specific vehicle type (car, motorcycle, or truck)")
    List<BrandResponse> getVehicleBrands(@PathVariable("type") String vehicle);

    @GetMapping("/{vehicleType}/brands/{brandId}/models")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Retrieve list of models for a specific brand and vehicle type")
    ModelResponse getModelsByBrand(@PathVariable("vehicleType") String vehicleType, @PathVariable("brandId") String brandId);

}
