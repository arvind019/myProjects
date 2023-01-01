package com.microservices.movieinfoservice.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public class MovieInfoRequestDto {
    private String movieName;
    private String createdBy;
    private Date createdDate;
}
