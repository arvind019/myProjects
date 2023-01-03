package com.microservices.movieratingservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "MOVIES_RATING_DTL")
public class MovieRatingEntity {

    @Id
    @Column(name = "RATING_ID")
    @GeneratedValue
    private int ratingId;

    @Column(name = "MOVIE_ID")
    private int movieId;

    @Column(name = "USER_ID")
    @GeneratedValue
    private int userId;

    @Column(name = "RATING")
    private String rating;

    @Column(name = "CREATED_BY")
    private String createdBy;

    @Column(name = "CREATED_DATE")
    private Date createdDate;

}