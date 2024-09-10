package com.fipe.api.application.api;

import com.fipe.api.application.api.response.BrandResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "${api.fipe.name}", url = "${api.fipe.url}")
public interface FipeFeignClient {

    @GetMapping("/{vehicle}/marcas")
    List<BrandResponse> getVehicleBrands(@PathVariable("vehicle") String vehicle);
}
