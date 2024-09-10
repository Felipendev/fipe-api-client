package com.fipe.api.application.api;

import com.fipe.api.application.api.response.BrandResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/vehicles")
@RestController
public interface FipeAPI {

    @GetMapping("/{type}/brands")
    List<BrandResponse> getVehicleBrands(@PathVariable("type") String vehicle);

}
