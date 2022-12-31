package com.coronavirus.tracker.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CoronaDataDto {

    private String countryName;
    private String totalCount;
    private String dailyCount;
}
