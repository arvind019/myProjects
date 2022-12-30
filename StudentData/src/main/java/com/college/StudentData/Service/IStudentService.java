package com.college.StudentData.Service;

import com.college.StudentData.Dto.StudentRequestDto;
import com.college.StudentData.Dto.StudentResponseDto;

import java.util.List;

public interface IStudentService {
    void saveStudentInfo(final List<StudentRequestDto> request);

    List<StudentResponseDto> getStudentsInfo(final String name, final String course, final Integer year,
                                             final String mobile, final String options);

    void updateStudentInfo(final Integer id, final StudentRequestDto request) throws Exception;

    void updateAllStudentInfo(final Integer id, final StudentRequestDto request) throws Exception;

    void deleteStudentInfo(final Integer id) throws Exception;
}
