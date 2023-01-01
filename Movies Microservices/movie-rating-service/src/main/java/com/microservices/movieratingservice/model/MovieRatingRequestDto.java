package com.microservices.movieratingservice.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public class MovieRatingRequestDto {
    private Integer movieId;
    private Integer userId;
    private String rating;
    private String createdBy;
    private Date createdDate;
}
