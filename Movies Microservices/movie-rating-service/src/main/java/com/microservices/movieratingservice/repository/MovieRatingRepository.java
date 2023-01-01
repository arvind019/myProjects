package com.microservices.movieratingservice.repository;

import com.microservices.movieratingservice.entity.MovieRatingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRatingRepository extends JpaRepository<MovieRatingEntity, Integer> {

    List<MovieRatingEntity> findByUserId(final Integer userId);

    MovieRatingEntity findByUserIdAndMovieId(final Integer userId, final Integer movieId);
}
