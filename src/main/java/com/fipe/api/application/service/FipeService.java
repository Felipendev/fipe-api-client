package com.fipe.api.application.service;

import com.fipe.api.application.api.response.BrandResponse;
import com.fipe.api.output.ModelResponse;
import com.fipe.api.application.api.response.YearResponse;
import com.fipe.api.output.ValueOutput;

import java.util.List;

public interface FipeService {
    List<BrandResponse> getVehicleBrands(String vehicle);
    ModelResponse getModelsByBrand(String vehicleType, String brandId);
    List<YearResponse> getYearsByModel(String vehicleType, String brandId, String modelId);
    ValueOutput getVehicleDetail(String vehicleType, String brandId, String modelId, String yearId);
}
