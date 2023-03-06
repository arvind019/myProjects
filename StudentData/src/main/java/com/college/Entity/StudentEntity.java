package com.college.Entity;

import com.college.Enum.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "STUDENT_DTL")
public class StudentEntity implements Serializable {

    @Id
    @Column(name = "STUDENT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "STUDENT_NAME", columnDefinition="VARCHAR(20)")
    private String name;

    @Column(name = "YEAR")
    private Integer year;

    @Column(name = "MOBILE", columnDefinition="VARCHAR(10)")
    private String mobile;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "STUDENT_COURSE_MAPPING", joinColumns = @JoinColumn(name = "STUDENT_ID"))
    private List<CourseEntity> courses;

}







