package com.fipe.api.mapper;

import com.fipe.api.input.YearInput;
import com.fipe.api.output.YearOutput;
import org.springframework.stereotype.Component;

@Component
public class YearMapper {

    public YearOutput toOutput(YearInput input) {
        var response = new YearOutput();
        response.setCode(input.getCode());
        response.setName(input.getName());
        return response;
    }
}
