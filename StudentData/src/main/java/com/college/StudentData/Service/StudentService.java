package com.college.StudentData.Service;

import com.college.StudentData.Dto.StudentRequestDto;
import com.college.StudentData.Dto.StudentResponseDto;
import com.college.StudentData.Entity.StudentEntity;
import com.college.StudentData.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public void saveStudentInfo(final StudentRequestDto request) {
        final StudentEntity student = getStudentEntity(request);
        studentRepository.save(student);
    }

    private StudentEntity getStudentEntity(final StudentRequestDto request) {
        final StudentEntity entity = new StudentEntity();
        entity.setBranch(request.getBranch());
        entity.setName(request.getName());
        entity.setCourse(request.getCourse());
        entity.setMobile(request.getMobile());
        entity.setYear(request.getYear());
        entity.setGraduationYear(request.getGraduationyear());
        return entity;
    }

    public List<StudentResponseDto> getStudentsInfo(final String name,
                                                    final String course,
                                                    final Integer year,
                                                    final String mobile) {
        final List<StudentEntity> entities = getInfoFromDB(name, course, year, mobile);
        final List<StudentResponseDto> response = new ArrayList<>();
        entities.forEach(entity -> response.add(getStudentResponseDto(entity)));
        return response;
    }

    private List<StudentEntity> getInfoFromDB(final String name,
                                              final String course,
                                              final Integer year,
                                              final String mobile) {
        if (StringUtils.hasText(name)) {
            return studentRepository.findByName(name);
        } else if (StringUtils.hasText(course)) {
            return studentRepository.findByCourse(course);
        } else if (StringUtils.hasText(mobile)) {
            return studentRepository.findByMobile(mobile);
        } else if(year != null){
            return studentRepository.findByYear(year);
        }
        return new ArrayList<>();
    }

    private StudentResponseDto getStudentResponseDto(final StudentEntity entity) {
        final StudentResponseDto response = new StudentResponseDto();
        response.setId(entity.getId());
        response.setBranch(entity.getBranch());
        response.setName(entity.getName());
        response.setCourse(entity.getCourse());
        response.setMobile(entity.getMobile());
        response.setYear(entity.getYear());
        response.setGraduationYear(entity.getGraduationYear());
        return response;
    }

    public void updateStudentInfo(final Integer id, final StudentRequestDto request) {
        final Optional<StudentEntity> optional = studentRepository.findById(id);
        if(optional.isPresent()) {
            final StudentEntity student = optional.get();
            student.setBranch(request.getBranch() != null ? request.getBranch() : student.getBranch());
            student.setName(request.getName() != null ? request.getName() : student.getName());
            student.setCourse(request.getCourse()!= null ? request.getCourse() : student.getCourse());
            student.setMobile(request.getMobile()!= null ? request.getMobile() : student.getMobile());
            student.setYear(request.getYear()!= null ? request.getYear() : student.getYear());
            student.setGraduationYear(request.getGraduationyear()!= null ? request.getGraduationyear() : student.getGraduationYear());
            studentRepository.save(student);
        }
    }
}
