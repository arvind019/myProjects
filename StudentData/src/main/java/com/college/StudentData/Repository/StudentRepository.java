package com.college.StudentData.Repository;

import com.college.StudentData.Entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {

    List<StudentEntity> findByName(final String name);

    List<StudentEntity> findByCourse(final String course);

    List<StudentEntity> findByYear(final Integer year);

    List<StudentEntity> findByMobile(final String mobile);
}
