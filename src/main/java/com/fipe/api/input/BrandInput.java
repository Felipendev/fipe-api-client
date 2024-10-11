package com.fipe.api.input;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class BrandInput {
    @JsonProperty("codigo")
    private String code;
    @JsonProperty("nome")
    private String name;
}
