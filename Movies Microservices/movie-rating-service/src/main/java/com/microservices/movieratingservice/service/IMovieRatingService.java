package com.microservices.movieratingservice.service;


import com.microservices.movieratingservice.model.MovieRatingRequestDto;
import com.microservices.movieratingservice.model.MovieRatingResponseDto;

import java.util.List;

public interface IMovieRatingService {

    void saveMovieRatingInfo(final List<MovieRatingRequestDto> request);

    List<MovieRatingResponseDto> getMovieRatings(final Integer userId);

}
