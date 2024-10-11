package com.fipe.api.input;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class ModelInput {

    @JsonProperty("modelos")
    private List<Model> models;

    @JsonProperty("anos")
    private List<Year> years;

    @Getter
    @ToString
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Model {

        @JsonProperty("codigo")
        private String code;

        @JsonProperty("nome")
        private String name;
    }

    @Getter
    @ToString
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Year {

        @JsonProperty("codigo")
        private String code;

        @JsonProperty("nome")
        private String name;
    }
}
