package com.fipe.api.application.api.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ModelResponse {
    @JsonProperty(value = "modelos")
    private List<Model> models;
    @JsonProperty(value = "anos")
    private List<Year> years;

    @Data
    public static class Model {
        @JsonProperty(value = "codigo")
        private String code;
        @JsonProperty(value = "nome")
        private String name;
    }

    @Data
    public static class Year {
        @JsonProperty(value = "codigo")
        private String code;
        @JsonProperty(value = "nome")
        private String name;
    }
}
