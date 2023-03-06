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
    @Column(name = "COURSE_ID", columnDefinition="VARCHAR(20)")
    private String courseId;

    @Column(name = "COURSE_NAME", columnDefinition="VARCHAR(20)")
    private String courseName;

    @Column(name = "DESCRIPTION", columnDefinition="VARCHAR(256)")
    private String description;

    @Column(name = "PRICE")
    private Integer price;

    @Column(name = "COURSE_TIME")
    private Integer time;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "COURSE_TOPIC_MAPPING", joinColumns = @JoinColumn(name = "COURSE_ID"))
    private List<TopicEntity> topics;

}
