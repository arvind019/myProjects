package com.microservices.movieinfoservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "MOVIES_DTL")
public class MovieInfoEntity {

    @Id
    @Column(name = "MOVIE_ID")
    @GeneratedValue
    private int movieId;

    @Column(name = "MOVIE_NAME")
    private String movieName;

    @Column(name = "CREATED_BY")
    private String createdBy;

    @Column(name = "CREATED_DATE")
    private Date createdDate;

}