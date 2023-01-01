package com.microservices.movieinfoservice.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MovieInfoResponseDto {
    private Integer movieId;
    private String movieName;
    private String createdBy;
    private Date createdDate;
}
