package com.college.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Table(name = "STUDENT_COURSE_MAPPING")
public class StudentCourseMapping implements Serializable {

    @EmbeddedId
    private StudentCourseId studentCourseId;

}