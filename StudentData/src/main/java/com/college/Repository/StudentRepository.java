package com.college.Repository;

import com.college.Entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {

    List<StudentEntity> findByName(final String name);

    List<StudentEntity> findByMobile(final String mobile);
}
