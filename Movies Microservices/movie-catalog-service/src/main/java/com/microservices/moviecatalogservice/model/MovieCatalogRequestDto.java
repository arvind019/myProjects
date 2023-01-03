package com.microservices.moviecatalogservice.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.sql.Date;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MovieCatalogRequestDto {
    private Integer userId;
    private String userName;
    private String createdBy;
    private Date createdDate;
    private List<MovieRatingDto> movies;
}
