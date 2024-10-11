package com.fipe.api.input;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class ValueInput {

    @JsonProperty("TipoVeiculo")
    private int vehicleType;

    @JsonProperty("Valor")
    private String value;

    @JsonProperty("Marca")
    private String brand;

    @JsonProperty("Modelo")
    private String model;

    @JsonProperty("AnoModelo")
    private int modelYear;

    @JsonProperty("Combustivel")
    private String fuelType;

    @JsonProperty("CodigoFipe")
    private String fipeCode;

    @JsonProperty("MesReferencia")
    private String referenceMonth;

    @JsonProperty("SiglaCombustivel")
    private String fuelAbbreviation;
}
