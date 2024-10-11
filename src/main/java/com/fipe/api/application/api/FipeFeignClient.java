package com.fipe.api.application.api;

import com.fipe.api.input.BrandInput;
import com.fipe.api.input.ModelInput;
import com.fipe.api.input.YearInput;
import com.fipe.api.output.BrandOutput;
import com.fipe.api.input.ValueInput;
import com.fipe.api.output.ModelOutput;
import com.fipe.api.output.YearOutput;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "${api.fipe.name}", url = "${api.fipe.url}")
public interface FipeFeignClient {

    @GetMapping("/{tipoVeiculo}/marcas")
    List<BrandInput> getVehicleBrands(@PathVariable("tipoVeiculo") String tipoVeiculo);

    @GetMapping("/{tipoVeiculo}/marcas/{marcaId}/modelos")
    ModelInput getModelsByBrand(
            @PathVariable("tipoVeiculo") String tipoVeiculo,
            @PathVariable("marcaId") String marcaId);

    @GetMapping("/{tipoVeiculo}/marcas/{marcaId}/modelos/{modeloId}/anos")
    List<YearInput> getYearsByModel(
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
