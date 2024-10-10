package com.fipe.api.application.api;

import com.fipe.api.application.api.response.BrandResponse;
import com.fipe.api.input.ValueInput;
import com.fipe.api.output.ModelResponse;
import com.fipe.api.application.api.response.YearResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "${api.fipe.name}", url = "${api.fipe.url}")
public interface FipeFeignClient {

    @GetMapping("/{tipoVeiculo}/marcas")
    List<BrandResponse> getVehicleBrands(@PathVariable("tipoVeiculo") String tipoVeiculo);

    @GetMapping("/{tipoVeiculo}/marcas/{marcaId}/modelos")
    ModelResponse getModelsByBrand(
            @PathVariable("tipoVeiculo") String tipoVeiculo,
            @PathVariable("marcaId") String marcaId);

    @GetMapping("/{tipoVeiculo}/marcas/{marcaId}/modelos/{modeloId}/anos")
    List<YearResponse> getYearsByModel(
            @PathVariable("tipoVeiculo") String tipoVeiculo,
            @PathVariable("marcaId") String marcaId,
            @PathVariable("modeloId") String modeloId);

    @GetMapping("/{tipoVeiculo}/marcas/{marcaId}/modelos/{modeloId}/anos/{anoId}")
    ValueInput getVehicleDetail(
            @PathVariable("tipoVeiculo") String tipoVeiculo,
            @PathVariable("marcaId") String marcaId,
            @PathVariable("modeloId") String modeloId,
            @PathVariable("anoId") String yearId);
}
