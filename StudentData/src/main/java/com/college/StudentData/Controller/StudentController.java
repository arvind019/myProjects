package com.college.StudentData.Controller;

import com.college.StudentData.Configuration.BaseAPIResponseBean;
import com.college.StudentData.Dto.StudentRequestDto;
import com.college.StudentData.Dto.StudentResponseDto;
import com.college.StudentData.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("student/api/{apiversion}")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/save/info")
    public ResponseEntity<BaseAPIResponseBean<?>> saveStudentInfo(@RequestBody final StudentRequestDto request) {

        studentService.saveStudentInfo(request);
        BaseAPIResponseBean<?> response = new BaseAPIResponseBean<>();
        response.setMessage("success");
        response.setStatus("success");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getInfoBy")
    public ResponseEntity<BaseAPIResponseBean<List<StudentResponseDto>>> getStudentInfo(
            @RequestParam(value = "name", required = false) final String name,
            @RequestParam(value = "course", required = false) final String course,
            @RequestParam(value = "year", required = false) final Integer year,
            @RequestParam(value = "mobile", required = false) final String mobile) {

        List<StudentResponseDto> data = studentService.getStudentsInfo(name, course, year, mobile);
        BaseAPIResponseBean<List<StudentResponseDto>> response = new BaseAPIResponseBean<>();
        response.setMessage("success");
        response.setStatus("success");
        response.setData(data);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/update/info/{id}")
    public ResponseEntity<BaseAPIResponseBean<?>> updateStudentInfo(@PathVariable final Integer id,
                                                                    @RequestBody final StudentRequestDto request) {

        studentService.updateStudentInfo(id, request);
        BaseAPIResponseBean<?> response = new BaseAPIResponseBean<>();
        response.setMessage("success");
        response.setStatus("success");
        return ResponseEntity.ok(response);
    }
}
