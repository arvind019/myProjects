package com.microservices.moviecatalogservice.controller;

import com.microservices.moviecatalogservice.configuration.BaseAPIResponseBean;
import com.microservices.moviecatalogservice.model.Constants;
import com.microservices.moviecatalogservice.model.MovieCatalogRequestDto;
import com.microservices.moviecatalogservice.model.MovieCatalogResponseDto;
import com.microservices.moviecatalogservice.service.IMovieCatalogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/user")
public class MovieCatalogController {

    @Autowired
    private IMovieCatalogService movieCatalogService;

    @PostMapping("/save")
    public ResponseEntity<BaseAPIResponseBean<?>> saveUserMovieRatingInfo(@RequestBody final List<MovieCatalogRequestDto> request) {

        movieCatalogService.saveUserMovieRatingInfo(request);
        final BaseAPIResponseBean<?> response = new BaseAPIResponseBean<>();
        response.setMessage(Constants.SUCCESS_MESSAGE);
        response.setStatus(Constants.SUCCESS_STATUS);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/info/{userId}")
    public ResponseEntity<BaseAPIResponseBean<MovieCatalogResponseDto>> getUserInfo(@PathVariable(value = "userId") final Integer userId) throws Exception {

        final MovieCatalogResponseDto data = movieCatalogService.getUserMovieCatalogInfo(userId);
        final BaseAPIResponseBean<MovieCatalogResponseDto> response = new BaseAPIResponseBean<>();
        response.setMessage(Constants.SUCCESS_MESSAGE);
        response.setStatus(Constants.SUCCESS_STATUS);
        response.setData(data);
        return ResponseEntity.ok(response);
    }
}
