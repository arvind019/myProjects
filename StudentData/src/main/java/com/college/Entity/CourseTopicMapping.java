package com.college.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Table(name = "COURSE_TOPIC_MAPPING")
public class CourseTopicMapping implements Serializable {

    @EmbeddedId
    private CourseTopicId courseTopicId;

}
