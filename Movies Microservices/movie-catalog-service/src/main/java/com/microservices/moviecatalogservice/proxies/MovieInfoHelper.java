package com.microservices.moviecatalogservice.proxies;

import com.microservices.moviecatalogservice.configuration.BaseAPIResponseBean;
import com.microservices.moviecatalogservice.model.Constants;
import com.microservices.moviecatalogservice.model.MovieRatingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieInfoHelper {

    @Autowired
    private MovieInfoClient movieInfoClient;

    public List<MovieRatingDto> saveMovieInfo(final List<MovieRatingDto> request) throws Exception {
        final List<MovieRatingDto> movieList = new ArrayList<>();
        request.forEach(movie -> {
            final MovieRatingDto data = MovieRatingDto.builder()
                                                      .movieName(movie.getMovieName())
                                                      .createdBy(movie.getCreatedBy())
                                                      .createdDate(movie.getCreatedDate())
                                                      .build();
            movieList.add(data);
        });
        final BaseAPIResponseBean<List<MovieRatingDto>> response = movieInfoClient.saveMovieInfo(movieList);
        if (response != null && Constants.SUCCESS_STATUS.equalsIgnoreCase(response.getStatus())) {
            return response.getData();
        } else {
            throw new Exception(response != null ? response.getMessage() : "Response from Movie Info Service is null");
        }
    }

    public List<MovieRatingDto> getMoviesInfo(final List<Integer> movieIds) throws Exception {
        final BaseAPIResponseBean<List<MovieRatingDto>> response = movieInfoClient.getMoviesInfo(movieIds);
        if (response != null && Constants.SUCCESS_STATUS.equalsIgnoreCase(response.getStatus())) {
            return response.getData();
        } else {
            throw new Exception(response != null ? response.getMessage() : "Response from Movie Info Service is null");
        }
    }
}
