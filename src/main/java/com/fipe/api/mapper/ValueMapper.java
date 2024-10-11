package com.fipe.api.mapper;

import com.fipe.api.input.ValueInput;
import com.fipe.api.output.ValueOutput;
import org.springframework.stereotype.Component;

@Component
public class ValueMapper {

    public ValueOutput toOutput(ValueInput input) {
        ValueOutput output = new ValueOutput();

        output.setVehicleType(input.getVehicleType());
        output.setValue(input.getValue());
        output.setBrand(input.getBrand());
        output.setModel(input.getModel());
        output.setModelYear(input.getModelYear());
        output.setFuelType(input.getFuelType());
        output.setFipeCode(input.getFipeCode());
        output.setReferenceMonth(input.getReferenceMonth());
        output.setFuelAbbreviation(input.getFuelAbbreviation());

        return output;
    }
}
