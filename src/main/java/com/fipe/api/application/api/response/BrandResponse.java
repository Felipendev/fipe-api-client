package com.fipe.api.application.api.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
public class BrandResponse {
    @JsonProperty(value = "codigo")
    private String code;
    @JsonProperty(value = "nome")
    private String name;
}
