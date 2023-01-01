package com.microservices.movieinfoservice.controller;

import com.microservices.movieinfoservice.configuration.BaseAPIResponseBean;
import com.microservices.movieinfoservice.model.Constants;
import com.microservices.movieinfoservice.model.MovieInfoRequestDto;
import com.microservices.movieinfoservice.model.MovieInfoResponseDto;
import com.microservices.movieinfoservice.service.IMovieInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/movie")
public class MovieInfoController {

    @Autowired
    private IMovieInfoService movieInfoService;

    @PostMapping("/save")
    public ResponseEntity<BaseAPIResponseBean<List<MovieInfoResponseDto>>> saveMovieInfo(@RequestBody final List<MovieInfoRequestDto> request) {

        final List<MovieInfoResponseDto> data = movieInfoService.saveMovieInfo(request);
        final BaseAPIResponseBean<List<MovieInfoResponseDto>> response = new BaseAPIResponseBean<>();
        response.setMessage(Constants.SUCCESS_MESSAGE);
        response.setStatus(Constants.SUCCESS_STATUS);
        response.setData(data);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/info/{movieIds}")
    public ResponseEntity<BaseAPIResponseBean<List<MovieInfoResponseDto>>> getMoviesInfo(@PathVariable (value = "movieIds") final List<Integer> movieIds) {

        final List<MovieInfoResponseDto> data = movieInfoService.getMoviesInfo(movieIds);
        final BaseAPIResponseBean<List<MovieInfoResponseDto>> response = new BaseAPIResponseBean<>();
        response.setMessage(Constants.SUCCESS_MESSAGE);
        response.setStatus(Constants.SUCCESS_STATUS);
        response.setData(data);
        return ResponseEntity.ok(response);
    }
}
