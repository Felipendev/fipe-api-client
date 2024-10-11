package com.fipe.api.application.service;

import com.fipe.api.output.BrandOutput;
import com.fipe.api.output.ModelOutput;
import com.fipe.api.output.YearOutput;
import com.fipe.api.output.ValueOutput;

import java.util.List;

public interface FipeService {
    List<BrandOutput> getVehicleBrands(String vehicle);
    ModelOutput getModelsByBrand(String vehicleType, String brandId);
    List<YearOutput> getYearsByModel(String vehicleType, String brandId, String modelId);
    ValueOutput getVehicleDetail(String vehicleType, String brandId, String modelId, String yearId);
}
