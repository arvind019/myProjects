package com.microservices.movieratingservice.service;

import com.microservices.movieratingservice.entity.MovieRatingEntity;
import com.microservices.movieratingservice.model.MovieRatingRequestDto;
import com.microservices.movieratingservice.model.MovieRatingResponseDto;
import com.microservices.movieratingservice.repository.MovieRatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieRatingServiceImpl implements IMovieRatingService {

    @Autowired
    private MovieRatingRepository movieRatingRepository;

    @Override
    public void saveMovieRatingInfo(final List<MovieRatingRequestDto> request) {
        request.forEach(this::saveMovieInfoEntity);
    }

    private void saveMovieInfoEntity(final MovieRatingRequestDto request) {
        final MovieRatingEntity entity = movieRatingRepository.findByUserIdAndMovieId(request.getUserId(), request.getMovieId());
        if (entity != null) {
            return;
        }
        final MovieRatingEntity movieRatingEntity = new MovieRatingEntity();
        movieRatingEntity.setMovieId(request.getMovieId());
        movieRatingEntity.setUserId(request.getUserId());
        movieRatingEntity.setRating(request.getRating());
        movieRatingEntity.setCreatedBy(request.getCreatedBy());
        movieRatingEntity.setCreatedDate(request.getCreatedDate());
        movieRatingRepository.save(movieRatingEntity);
    }

    private MovieRatingResponseDto getMovieResponseDto(MovieRatingEntity entity) {
        return MovieRatingResponseDto.builder()
                                     .ratingId(entity.getRatingId())
                                     .userId(entity.getUserId())
                                     .movieId(entity.getMovieId())
                                     .rating(entity.getRating())
                                     .createdBy(entity.getCreatedBy())
                                     .createdDate(entity.getCreatedDate())
                                     .build();
    }

    @Override
    public List<MovieRatingResponseDto> getMovieRatings(final Integer userId) {
        final List<MovieRatingEntity> entities = movieRatingRepository.findByUserId(userId);
        final List<MovieRatingResponseDto> response = new ArrayList<>();
        entities.forEach(entity -> response.add(getMovieResponseDto(entity)));
        return response;
    }
}