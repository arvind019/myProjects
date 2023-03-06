package com.college.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseTopicId implements Serializable {

    @Column(name = "TOPIC_ID", columnDefinition="VARCHAR(20)")
    private String topicId;

    @Column(name = "COURSE_ID", columnDefinition="VARCHAR(20)")
    private String courseId;

}
