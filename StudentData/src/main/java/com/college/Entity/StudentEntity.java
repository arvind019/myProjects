package com.college.Entity;

import com.college.Enum.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "STUDENT_DTL")
public class StudentEntity implements Serializable {

    @Id
    @Column(name = "STUDENT_ID")
    @GeneratedValue
    private Integer id;

    @Column(name = "STUDENT_NAME")
    private String name;

    @Column(name = "COURSE_ID")
    private Integer courseId;

    @Column(name = "YEAR")
    private Integer year;

    @Column(name = "MOBILE")
    private String mobile;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "COURSE_ID", updatable = false, insertable = false, referencedColumnName = "COURSE_ID")
    CourseEntity courseEntity;

}







