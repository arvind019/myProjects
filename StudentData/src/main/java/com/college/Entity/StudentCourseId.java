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
public class StudentCourseId implements Serializable {

    @Column(name = "STUDENT_ID")
    private Integer studentId;

    @Column(name = "COURSE_ID", columnDefinition="VARCHAR(20)")
    private String courseId;

}
