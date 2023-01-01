package com.microservices.moviecatalogservice.repository;

import com.microservices.moviecatalogservice.entity.UserMovieMappingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMovieMappingRepository extends JpaRepository<UserMovieMappingEntity, Integer> {

    List<UserMovieMappingEntity> findByUserId(final Integer userId);

    UserMovieMappingEntity findByUserIdAndMovieId(final Integer userId, final Integer movieId);
}