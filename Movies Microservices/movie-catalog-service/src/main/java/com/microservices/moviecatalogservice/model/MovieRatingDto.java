package com.microservices.moviecatalogservice.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.sql.Date;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MovieRatingDto {
    private Integer userId;
    private Integer movieId;
    private String movieName;
    private Integer ratingId;
    private String rating;
    private String createdBy;
    private Date createdDate;
}
