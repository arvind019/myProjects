package com.microservices.moviecatalogservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "USER_DTL")
public class UserEntity {

    @Id
    @Column(name = "USER_ID")
    @GeneratedValue
    private int userId;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "CREATED_BY")
    private String createdBy;

    @Column(name = "CREATED_DATE")
    private Date createdDate;

}