package com.microservices.moviecatalogservice.proxies;

import com.microservices.moviecatalogservice.configuration.BaseAPIResponseBean;
import com.microservices.moviecatalogservice.model.Constants;
import com.microservices.moviecatalogservice.model.MovieRatingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RatingInfoHelper {

    @Autowired
    private RatingInfoClient ratingInfoClient;

    public void saveRatingInfo(final List<MovieRatingDto> request, final Integer userId) throws Exception {
        final List<MovieRatingDto> ratingList = new ArrayList<>();
        request.forEach(rating -> {
            final MovieRatingDto data = MovieRatingDto.builder()
                                                      .rating(rating.getRating())
                                                      .movieId(rating.getMovieId())
                                                      .userId(userId)
                                                      .createdBy(rating.getCreatedBy())
                                                      .createdDate(rating.getCreatedDate())
                                                      .build();
            ratingList.add(data);
        });
        final BaseAPIResponseBean<?> response = ratingInfoClient.saveMovieInfo(ratingList);
        if (response == null || !Constants.SUCCESS_STATUS.equalsIgnoreCase(response.getStatus())) {
            throw new Exception(response != null ? response.getMessage() : "Response from Rating Info Service is null");
        }
    }

    public List<MovieRatingDto> getRatingInfo(final Integer userId) throws Exception {
        final BaseAPIResponseBean<List<MovieRatingDto>> response = ratingInfoClient.getRatingInfo(userId);
        if (response != null && Constants.SUCCESS_STATUS.equalsIgnoreCase(response.getStatus())) {
            return response.getData();
        } else {
            System.out.println("Response = " + response);
            throw new Exception(response != null ? response.getMessage() : "Response from Rating Info Service is null");
        }
    }
}
