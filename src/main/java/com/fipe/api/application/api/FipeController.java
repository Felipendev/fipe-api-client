package com.fipe.api.application.api;

import com.fipe.api.application.api.response.BrandResponse;
import com.fipe.api.application.api.response.ModelResponse;
import com.fipe.api.application.service.FipeService;
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
    public List<BrandResponse> getVehicleBrands(String vehicle) {
        log.info("[start] FipeController - getVehicleBrands");
        List<BrandResponse> brands = fipeService.getVehicleBrands(vehicle);
        log.info("[finish] FipeController - getVehicleBrands");
        return brands;
    }

    @Override
    public ModelResponse getModelsByBrand(String vehicleType, String brandId) {
        log.info("[start] FipeController - getModelsByBrand");
        ModelResponse modelsByBrand = fipeService.getModelsByBrand(vehicleType, brandId);
        log.info("[finish] FipeController - getModelsByBrand");
        return modelsByBrand;
    }
}
