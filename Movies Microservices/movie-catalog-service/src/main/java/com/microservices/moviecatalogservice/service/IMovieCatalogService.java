package com.microservices.moviecatalogservice.service;

import com.microservices.moviecatalogservice.model.MovieCatalogRequestDto;
import com.microservices.moviecatalogservice.model.MovieCatalogResponseDto;

import java.util.List;

public interface IMovieCatalogService {

    void saveUserMovieRatingInfo(final List<MovieCatalogRequestDto> request);

    MovieCatalogResponseDto getUserMovieCatalogInfo(final Integer userId) throws Exception;

}
