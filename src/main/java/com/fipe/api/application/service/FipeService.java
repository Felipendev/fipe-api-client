package com.fipe.api.application.service;

import com.fipe.api.application.api.response.BrandResponse;

import java.util.List;

public interface FipeService {
    List<BrandResponse> getVehicleBrands(String vehicle);
}
