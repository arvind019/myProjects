package com.microservices.moviecatalogservice.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "USER_MOVIES_DTL")
public class UserMovieMappingEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue
    private int Id;

    @Column(name = "USER_ID")
    private int userId;

    @Column(name = "MOVIE_ID")
    private int movieId;

    @Column(name = "CREATED_BY")
    private String createdBy;

    @Column(name = "CREATED_DATE")
    private Date createdDate;

}
