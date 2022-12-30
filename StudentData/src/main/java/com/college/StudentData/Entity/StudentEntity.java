package com.college.StudentData.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "STUDENT_DTL")
public class StudentEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Integer id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "COURSE")
    private String course;
    @Column(name = "YEAR")
    private Integer year;
    @Column(name = "BRANCH")
    private String branch;
    @Column(name = "MOBILE")
    private String mobile;
    @Column(name = "GRADUATION_YEAR")
    private Integer graduationYear;
}







