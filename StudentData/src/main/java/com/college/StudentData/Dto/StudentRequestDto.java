package com.college.StudentData.Dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentRequestDto {
    private String name;
    private String course;
    private Integer year;
    private String branch;
    private String mobile;
    private Integer graduationYear;
}
