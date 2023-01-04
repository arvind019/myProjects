package com.college.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "COURSE_DTL")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CourseEntity implements Serializable {

    @Id
    @Column(name = "COURSE_ID")
    private Integer courseId;

    @Column(name = "COURSE_NAME")
    private String courseName;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "PRICE")
    private Integer price;

    @Column(name = "COURSE_TIME")
    private Integer time;

}
