package com.college.StudentData.Dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentResponseDto {
    private int id;
    private String name;
    private String course;
    private int year;
    private String branch;
    private String mobile;
    private int graduationYear;
}
