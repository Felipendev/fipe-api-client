package com.fipe.api.mapper;

import com.fipe.api.input.ModelInput;
import com.fipe.api.output.ModelOutput;
import com.fipe.api.output.YearOutput;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import java.util.stream.Collectors;

@Component
public class ModelMapper {

    public ModelOutput toOutput(ModelInput input) {
        var output = new ModelOutput();
        output.setModels(
                input.getModels().stream().map(inputModel -> {
                    var model = new ModelOutput.Model();
                    model.setCode(inputModel.getCode());
                    model.setName(inputModel.getName());
                    return model;
                }).collect(Collectors.toList())
        );
        output.setYears(
                input.getYears().stream().map(inputYear -> {
                    var yeah = new ModelOutput.Year();
                    yeah.setCode(inputYear.getCode());
                    yeah.setName(inputYear.getName());
                    return yeah;
                }).collect(Collectors.toList())
        );

        return output;
    }
}
