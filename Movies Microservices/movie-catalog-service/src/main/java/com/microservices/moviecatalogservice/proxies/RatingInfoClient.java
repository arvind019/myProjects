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
//@FeignClient(name = Constants.RATING_SERVICE_NAME)
@FeignClient(name = Constants.RATING_SERVICE_NAME, url = "${RATING_SERVICE_BASE_URL}")
public interface RatingInfoClient {

    @PostMapping(value = "rating/save")
    BaseAPIResponseBean<?> saveMovieInfo(@RequestBody final List<MovieRatingDto> request);

    @GetMapping(value = "rating/info/{userId}")
    BaseAPIResponseBean<List<MovieRatingDto>> getRatingInfo(@PathVariable(value = "userId") final Integer userId);

}