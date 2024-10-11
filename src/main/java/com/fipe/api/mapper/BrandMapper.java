package com.fipe.api.mapper;

import com.fipe.api.input.BrandInput;
import com.fipe.api.output.BrandOutput;
import org.springframework.stereotype.Component;

@Component
public class BrandMapper {

    public BrandOutput toOutput(BrandInput input) {
        var output = new BrandOutput();
        output.setCode(input.getCode());
        output.setName(input.getName());
        return output;
    }
}
