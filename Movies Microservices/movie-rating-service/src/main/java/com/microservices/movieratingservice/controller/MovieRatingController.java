package com.microservices.movieratingservice.controller;

import com.microservices.movieratingservice.configuration.BaseAPIResponseBean;
import com.microservices.movieratingservice.model.Constants;
import com.microservices.movieratingservice.model.MovieRatingRequestDto;
import com.microservices.movieratingservice.model.MovieRatingResponseDto;
import com.microservices.movieratingservice.service.IMovieRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/rating")
public class MovieRatingController {

    @Autowired
    private IMovieRatingService movieRatingService;

    @PostMapping("/save")
    public ResponseEntity<BaseAPIResponseBean<?>> saveMovieRatingInfo(@RequestBody final List<MovieRatingRequestDto> request) {

        movieRatingService.saveMovieRatingInfo(request);
        final BaseAPIResponseBean<?> response = new BaseAPIResponseBean<>();
        response.setMessage(Constants.SUCCESS_MESSAGE);
        response.setStatus(Constants.SUCCESS_STATUS);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/info/{userId}")
    public ResponseEntity<BaseAPIResponseBean<List<MovieRatingResponseDto>>> getMoviesInfo(@PathVariable(value = "userId") final Integer userId) {

        final List<MovieRatingResponseDto> data = movieRatingService.getMovieRatings(userId);
        final BaseAPIResponseBean<List<MovieRatingResponseDto>> response = new BaseAPIResponseBean<>();
        response.setMessage(Constants.SUCCESS_MESSAGE);
        response.setStatus(Constants.SUCCESS_STATUS);
        response.setData(data);
        return ResponseEntity.ok(response);
    }
}
