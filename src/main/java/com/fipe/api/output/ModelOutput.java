package com.fipe.api.output;

import lombok.Data;

import java.util.List;

@Data
public class ModelOutput {
    private List<Model> models;
    private List<Year> years;

    @Data
    public static class Model {
        private String code;
        private String name;
    }

    @Data
    public static class Year {
        private String code;
        private String name;
    }
}
