package com.microservices.moviecatalogservice.service;

import com.microservices.moviecatalogservice.entity.UserEntity;
import com.microservices.moviecatalogservice.entity.UserMovieMappingEntity;
import com.microservices.moviecatalogservice.model.MovieCatalogRequestDto;
import com.microservices.moviecatalogservice.model.MovieCatalogResponseDto;
import com.microservices.moviecatalogservice.model.MovieRatingDto;
import com.microservices.moviecatalogservice.proxies.MovieInfoHelper;
import com.microservices.moviecatalogservice.proxies.RatingInfoHelper;
import com.microservices.moviecatalogservice.repository.UserMovieMappingRepository;
import com.microservices.moviecatalogservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class MovieCatalogServiceImpl implements IMovieCatalogService {

    @Autowired
    private UserMovieMappingRepository userMovieMappingRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MovieInfoHelper movieInfoHelper;

    @Autowired
    private RatingInfoHelper ratingInfoHelper;

    @Override
    @Transactional
    public void saveUserMovieRatingInfo(final List<MovieCatalogRequestDto> request) {
        request.forEach(entity -> {
            try {
                saveUserInfo(entity);
                saveMovieInfo(entity);
                saveUserMovieMapping(entity);
                saveRatingInfo(entity);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

    private void saveUserInfo(final MovieCatalogRequestDto entity) {
        final UserEntity user = userRepository.findByUserName(entity.getUserName());
        if (user != null) {
            entity.setUserId(user.getUserId());
            return;
        }
        final UserEntity userEntity = new UserEntity();
        userEntity.setUserName(entity.getUserName());
        userEntity.setCreatedBy(entity.getCreatedBy());
        userEntity.setCreatedDate(entity.getCreatedDate());
        entity.setUserId(userRepository.save(userEntity).getUserId());
        System.out.println(entity);
    }

    private void saveMovieInfo(final MovieCatalogRequestDto entity) throws Exception {
        if (entity.getMovies() == null) {
            return;
        }
        final List<MovieRatingDto> response = movieInfoHelper.saveMovieInfo(entity.getMovies());
        final Map<String, Integer> map = response.stream()
                .collect(Collectors.toMap(MovieRatingDto::getMovieName, MovieRatingDto::getMovieId));
        entity.getMovies().forEach(movie -> movie.setMovieId(map.get(movie.getMovieName())));
    }

    private void saveUserMovieMapping(final MovieCatalogRequestDto entity) {
        if (entity.getMovies() == null) {
            return;
        }
        final Integer userId = entity.getUserId();
        entity.getMovies().forEach(movie -> {
            final UserMovieMappingEntity mapping = userMovieMappingRepository.findByUserIdAndMovieId(userId, movie.getMovieId());
            if (mapping == null) {
                final UserMovieMappingEntity mappingEntity = new UserMovieMappingEntity();
                mappingEntity.setUserId(userId);
                mappingEntity.setMovieId(movie.getMovieId());
                mappingEntity.setCreatedBy(movie.getCreatedBy());
                mappingEntity.setCreatedDate(movie.getCreatedDate());
                userMovieMappingRepository.save(mappingEntity);
            }
        });
    }

    private void saveRatingInfo(final MovieCatalogRequestDto entity) throws Exception {
        if (entity.getMovies() == null) {
            return;
        }
        ratingInfoHelper.saveRatingInfo(entity.getMovies(), entity.getUserId());
    }

    @Override
    public MovieCatalogResponseDto getUserMovieCatalogInfo(final Integer userId) throws Exception {
        final UserEntity userInfo = userRepository.findByUserId(userId);
        if (userInfo == null) {
            throw new Exception("Given User Id does not exist.");
        }
        final List<MovieRatingDto> movies = getMovieInfoAndRating(userId);

        return MovieCatalogResponseDto.builder()
                                      .userId(userInfo.getUserId())
                                      .userName(userInfo.getUserName())
                                      .createdBy(userInfo.getCreatedBy())
                                      .createdDate(userInfo.getCreatedDate())
                                      .movies(movies)
                                      .build();
    }

    private List<MovieRatingDto> getMovieInfoAndRating(final Integer userId) throws Exception {
        final List<UserMovieMappingEntity> userMovieList = userMovieMappingRepository.findByUserId(userId);
        if (userMovieList == null) {
            return new ArrayList<>();
        }

        final List<Integer> movieIds = userMovieList.stream()
                                                    .map(UserMovieMappingEntity::getMovieId)
                                                    .collect(Collectors.toList());

        final List<MovieRatingDto> moviesInfo = movieInfoHelper.getMoviesInfo(movieIds);
        final Map<Integer, String> movieInfoMap = moviesInfo.stream()
                .collect(Collectors.toMap(MovieRatingDto::getMovieId, MovieRatingDto::getMovieName));

        final List<MovieRatingDto> ratingsInfo = ratingInfoHelper.getRatingInfo(userId);
        final Map<Integer, List<MovieRatingDto>> ratingInfoMap = ratingsInfo.stream()
                .collect(Collectors.groupingBy(MovieRatingDto::getMovieId));

        final List<MovieRatingDto> response = new ArrayList<>();
        movieIds.forEach(movieId -> {
            response.add(MovieRatingDto.builder()
                                       .movieId(movieId)
                                       .movieName(movieInfoMap.get(movieId))
                                       .ratingId(ratingInfoMap.get(movieId).get(0).getRatingId())
                                       .rating(ratingInfoMap.get(movieId).get(0).getRating())
                                       .createdBy(ratingInfoMap.get(movieId).get(0).getCreatedBy())
                                       .createdDate(ratingInfoMap.get(movieId).get(0).getCreatedDate())
                                       .build());
        });
        return response;
    }

    @Override
    public List<MovieCatalogResponseDto> getAllUsers() {
        final List<UserEntity> allUsers = userRepository.findAll();
        final List<MovieCatalogResponseDto> response = new ArrayList<>();
        allUsers.forEach(user -> {
            response.add(MovieCatalogResponseDto.builder()
                                                .userId(user.getUserId())
                                                .userName(user.getUserName())
                                                .createdBy(user.getCreatedBy())
                                                .createdDate(user.getCreatedDate())
                                                .build());
        });
        return response;
    }
}