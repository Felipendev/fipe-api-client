package com.fipe.api.application.api;

import com.fipe.api.application.api.response.BrandResponse;
import com.fipe.api.application.api.response.ModelResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "${api.fipe.name}", url = "${api.fipe.url}")
public interface FipeFeignClient {

    @GetMapping("/{vehicleType}/marcas")
    List<BrandResponse> getVehicleBrands(@PathVariable("vehicleType") String vehicleType);

    @GetMapping("/{vehicleType}/marcas/{brandId}/modelos")
    ModelResponse getModelsByBrand(
            @PathVariable("vehicleType") String vehicleType,
            @PathVariable("brandId") String brandId);
}
