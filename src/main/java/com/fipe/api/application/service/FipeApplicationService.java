package com.fipe.api.application.service;

import com.fipe.api.application.api.FipeFeignClient;
import com.fipe.api.application.api.response.BrandResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class FipeApplicationService implements FipeService {
    private final FipeFeignClient vehiclFeignClient;
    @Override
    public List<BrandResponse> getVehicleBrands(String vehicle) {
        log.info("[start] FipeApplicationService - getVehicleBrands");
        List<BrandResponse> vehicleBrands = vehiclFeignClient.getVehicleBrands(vehicle);
        vehicleBrands.sort(Comparator.comparing(BrandResponse::getName));
        log.info("[finish] FipeApplicationService - getVehicleBrands");
        return vehicleBrands;
    }
}
