package com.fipe.api.application.api;

import com.fipe.api.output.BrandOutput;
import com.fipe.api.output.YearOutput;
import com.fipe.api.application.service.FipeService;
import com.fipe.api.output.ModelOutput;
import com.fipe.api.output.ValueOutput;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RestController
@RequiredArgsConstructor
public class FipeController implements FipeAPI {

    private final FipeService fipeService;
    @Override
    public List<BrandOutput> getVehicleBrands(String vehicle) {
        log.info("[start] FipeController - getVehicleBrands");
        List<BrandOutput> brands = fipeService.getVehicleBrands(vehicle);
        log.info("[finish] FipeController - getVehicleBrands");
        return brands;
    }

    @Override
    public ModelOutput getModelsByBrand(String vehicleType, String brandId) {
        log.info("[start] FipeController - getModelsByBrand");
        ModelOutput modelsByBrand = fipeService.getModelsByBrand(vehicleType, brandId);
        log.info("[finish] FipeController - getModelsByBrand");
        return modelsByBrand;
    }

    @Override
    public List<YearOutput> getYearsByModel(String vehicleType, String brandId, String modelId) {
        log.info("[start] FipeController - getYearsByModel");
        List<YearOutput> yearsByModel = fipeService.getYearsByModel(vehicleType, brandId, modelId);
        log.info("[finish] FipeController - getYearsByModel");
        return yearsByModel;
    }

    @Override
    public ValueOutput getVehicleDetail(String vehicleType, String brandId, String modelId, String yearId) {
        log.info("[start] FipeController - getVehicleDetail");
        ValueOutput vehicleDetail = fipeService.getVehicleDetail(vehicleType, brandId, modelId, yearId);
        log.info("[finish] FipeController - getVehicleDetail");
        return vehicleDetail;
    }
}
