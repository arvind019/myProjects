package com.microservices.movieinfoservice.service;


import com.microservices.movieinfoservice.model.MovieInfoRequestDto;
import com.microservices.movieinfoservice.model.MovieInfoResponseDto;

import java.util.List;

public interface IMovieInfoService {

    List<MovieInfoResponseDto> saveMovieInfo(final List<MovieInfoRequestDto> request);

    List<MovieInfoResponseDto> getMoviesInfo(final List<Integer> movieIds);

}
