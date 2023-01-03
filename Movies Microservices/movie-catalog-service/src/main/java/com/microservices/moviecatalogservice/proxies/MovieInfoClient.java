package com.microservices.moviecatalogservice.proxies;

import com.microservices.moviecatalogservice.configuration.BaseAPIResponseBean;
import com.microservices.moviecatalogservice.model.Constants;
import com.microservices.moviecatalogservice.model.MovieRatingDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

// Can Use Only Name if using Eureka Server
// Else use Name and URL both
//@FeignClient(name = Constants.MOVIE_SERVICE_NAME)
@FeignClient(name = Constants.MOVIE_SERVICE_NAME, url = "${MOVIE_INFO_SERVICE_BASE_URL}")
public interface MovieInfoClient {

    @PostMapping(value = "movie/save")
    BaseAPIResponseBean<List<MovieRatingDto>> saveMovieInfo(@RequestBody final List<MovieRatingDto> request);

    @GetMapping(value = "movie/info/{movieIds}")
    BaseAPIResponseBean<List<MovieRatingDto>> getMoviesInfo(@PathVariable(value = "movieIds") final List<Integer> movieIds);

}
