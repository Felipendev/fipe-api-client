package com.fipe.api.application.service;

import com.fipe.api.application.api.response.BrandResponse;
import com.fipe.api.application.api.response.ModelResponse;

import java.util.List;

public interface FipeService {
    List<BrandResponse> getVehicleBrands(String vehicle);
    ModelResponse getModelsByBrand(String vehicleType, String brandId);
}
