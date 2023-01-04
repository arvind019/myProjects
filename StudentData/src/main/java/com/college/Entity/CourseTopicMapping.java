package com.college.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "COURSE_TOPIC_MAPPING_DTL")
public class CourseTopicMapping implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Integer Id;

    @Column(name = "TOPIC_ID")
    private String topicId;

    @Column(name = "COURSE_ID")
    private String courseId;

}
