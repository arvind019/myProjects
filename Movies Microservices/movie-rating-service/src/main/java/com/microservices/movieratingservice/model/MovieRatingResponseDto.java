package com.microservices.movieratingservice.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MovieRatingResponseDto {
    private Integer ratingId;
    private Integer movieId;
    private Integer userId;
    private String rating;
    private String createdBy;
    private Date createdDate;
}
