package com.microservices.moviecatalogservice.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MovieCatalogResponseDto {
    private Integer userId;
    private String userName;
    private String createdBy;
    private Date createdDate;
    private List<MovieRatingDto> movies;
}
