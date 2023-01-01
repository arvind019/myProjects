package com.microservices.movieinfoservice.service;

import com.microservices.movieinfoservice.entity.MovieInfoEntity;
import com.microservices.movieinfoservice.model.MovieInfoRequestDto;
import com.microservices.movieinfoservice.model.MovieInfoResponseDto;
import com.microservices.movieinfoservice.repository.MovieInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieInfoServiceImpl implements IMovieInfoService {

    @Autowired
    private MovieInfoRepository movieInfoRepository;

    @Override
    public List<MovieInfoResponseDto> saveMovieInfo(final List<MovieInfoRequestDto> request) {
        final List<MovieInfoResponseDto> response = new ArrayList<>();
        request.forEach(entity -> {
            final MovieInfoEntity movieInfoEntity = saveMovieInfoEntity(entity);
            response.add(getMovieResponseDto(movieInfoEntity));
        });
        return response;
    }

    private MovieInfoResponseDto getMovieResponseDto(final MovieInfoEntity entity) {
        return MovieInfoResponseDto.builder()
                                   .movieId(entity.getMovieId())
                                   .movieName(entity.getMovieName())
                                   .createdBy(entity.getCreatedBy())
                                   .createdDate(entity.getCreatedDate())
                                   .build();
    }

    private MovieInfoEntity saveMovieInfoEntity(final MovieInfoRequestDto request) {
        final MovieInfoEntity response = movieInfoRepository.findByMovieName(request.getMovieName());
        if (response != null) {
            return response;
        }
        final MovieInfoEntity movieInfoEntity = new MovieInfoEntity();
        movieInfoEntity.setMovieName(request.getMovieName());
        movieInfoEntity.setCreatedBy(request.getCreatedBy());
        movieInfoEntity.setCreatedDate(request.getCreatedDate());
        movieInfoRepository.save(movieInfoEntity);
        return movieInfoEntity;
    }

    @Override
    public List<MovieInfoResponseDto> getMoviesInfo(final List<Integer> movieIds) {
        final List<MovieInfoEntity> entities = movieInfoRepository.findByMovieIdIn(movieIds);
        final List<MovieInfoResponseDto> response = new ArrayList<>();
        entities.forEach(entity -> response.add(getMovieResponseDto(entity)));
        return response;
    }
}