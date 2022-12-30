package com.college.StudentData.Service;

import com.college.StudentData.Dto.Constants;
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
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void saveStudentInfo(final List<StudentRequestDto> request) {
        request.forEach(entity -> studentRepository.save(getStudentEntity(entity)));
    }

    private StudentEntity getStudentEntity(final StudentRequestDto request) {
        final StudentEntity entity = new StudentEntity();
        entity.setBranch(request.getBranch());
        entity.setName(request.getName());
        entity.setCourse(request.getCourse());
        entity.setMobile(request.getMobile());
        entity.setYear(request.getYear());
        entity.setGraduationYear(request.getGraduationYear());
        return entity;
    }

    @Override
    public List<StudentResponseDto> getStudentsInfo(final String name,
                                                    final String course,
                                                    final Integer year,
                                                    final String mobile,
                                                    final String options) {
        final List<StudentEntity> entities = getInfoFromDB(name, course, year, mobile, options);
        final List<StudentResponseDto> response = new ArrayList<>();
        entities.forEach(entity -> response.add(getStudentResponseDto(entity)));
        return response;
    }

    private List<StudentEntity> getInfoFromDB(final String name,
                                              final String course,
                                              final Integer year,
                                              final String mobile,
                                              final String options) {
        if (Constants.ALL.equalsIgnoreCase(options)) {
            return studentRepository.findAll();
        } else if (StringUtils.hasText(name)) {
            return studentRepository.findByName(name);
        } else if (StringUtils.hasText(course)) {
            return studentRepository.findByCourse(course);
        } else if (StringUtils.hasText(mobile)) {
            return studentRepository.findByMobile(mobile);
        } else if (year != null) {
            return studentRepository.findByYear(year);
        }
        return new ArrayList<>();
    }

    private StudentResponseDto getStudentResponseDto(final StudentEntity entity) {
        return StudentResponseDto.builder()
                                 .id(entity.getId())
                                 .branch(entity.getBranch())
                                 .name(entity.getName())
                                 .course(entity.getCourse())
                                 .mobile(entity.getMobile())
                                 .year(entity.getYear())
                                 .graduationYear(entity.getGraduationYear())
                                 .build();
    }

    @Override
    public void updateStudentInfo(final Integer id, final StudentRequestDto request) throws Exception {
        final Optional<StudentEntity> optional = studentRepository.findById(id);
        if (!optional.isPresent()) {
            throw new Exception("Student Information for given id Not present");
        }
        final StudentEntity student = optional.get();
        student.setBranch(request.getBranch() != null ? request.getBranch() : student.getBranch());
        student.setName(request.getName() != null ? request.getName() : student.getName());
        student.setCourse(request.getCourse() != null ? request.getCourse() : student.getCourse());
        student.setMobile(request.getMobile() != null ? request.getMobile() : student.getMobile());
        student.setYear(request.getYear() != null ? request.getYear() : student.getYear());
        student.setGraduationYear(request.getGraduationYear() != null ? request.getGraduationYear() : student.getGraduationYear());
        studentRepository.save(student);
    }

    @Override
    public void updateAllStudentInfo(final Integer id, final StudentRequestDto request) throws Exception {
        final Optional<StudentEntity> optional = studentRepository.findById(id);
        if (!optional.isPresent()) {
            throw new Exception("Student Information for given id Not present");
        }
        final StudentEntity student = optional.get();
        student.setBranch(request.getBranch());
        student.setName(request.getName());
        student.setCourse(request.getCourse());
        student.setMobile(request.getMobile());
        student.setYear(request.getYear());
        student.setGraduationYear(request.getGraduationYear());
        studentRepository.save(student);
    }

    @Override
    public void deleteStudentInfo(final Integer id) throws Exception {
        final Optional<StudentEntity> optional = studentRepository.findById(id);
        if (!optional.isPresent()) {
            throw new Exception("Student Information for given id Not present");
        }
        optional.ifPresent(studentEntity -> studentRepository.delete(studentEntity));
    }
}
