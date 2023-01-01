package com.microservices.movieinfoservice.repository;

import com.microservices.movieinfoservice.entity.MovieInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieInfoRepository extends JpaRepository<MovieInfoEntity, Integer> {

    MovieInfoEntity findByMovieName(final String movieName);

    List<MovieInfoEntity> findByMovieIdIn(final List<Integer> movieIds);
}
