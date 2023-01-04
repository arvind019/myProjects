package com.college.Controller;

import com.college.Dto.Constants;
import com.college.Configuration.BaseAPIResponseBean;
import com.college.Dto.StudentRequestDto;
import com.college.Dto.StudentResponseDto;
import com.college.Service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @PostMapping("/save/info")
    public ResponseEntity<BaseAPIResponseBean<?>> saveStudentInfo(@RequestBody final List<StudentRequestDto> request) {

        studentService.saveStudentInfo(request);
        BaseAPIResponseBean<?> response = new BaseAPIResponseBean<>();
        response.setMessage(Constants.SUCCESS_MESSAGE);
        response.setStatus(Constants.SUCCESS_STATUS);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getInfoBy")
    public ResponseEntity<BaseAPIResponseBean<List<StudentResponseDto>>> getStudentInfo(
            @RequestParam(value = "name", required = false) final String name,
            @RequestParam(value = "course", required = false) final String course,
            @RequestParam(value = "year", required = false) final Integer year,
            @RequestParam(value = "mobile", required = false) final String mobile,
            @RequestParam(value = "options", required = false) final String options) {

        List<StudentResponseDto> data = studentService.getStudentsInfo(name, course, year, mobile, options);
        BaseAPIResponseBean<List<StudentResponseDto>> response = new BaseAPIResponseBean<>();
        response.setMessage(Constants.SUCCESS_MESSAGE);
        response.setStatus(Constants.SUCCESS_STATUS);
        response.setData(data);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/update/info/{id}")
    public ResponseEntity<BaseAPIResponseBean<?>> updateAllStudentInfo(@PathVariable final Integer id,
                                                                       @RequestBody final StudentRequestDto request) throws Exception {

        try {
            studentService.updateAllStudentInfo(id, request);
            BaseAPIResponseBean<?> response = new BaseAPIResponseBean<>();
            response.setMessage(Constants.SUCCESS_MESSAGE);
            response.setStatus(Constants.SUCCESS_STATUS);
            return ResponseEntity.ok(response);
        } catch (Exception exception) {
            BaseAPIResponseBean<?> response = new BaseAPIResponseBean<>();
            response.setMessage(exception.getMessage());
            response.setStatus(Constants.FAILED_STATUS);
            return ResponseEntity.ok(response);
        }
    }

    @DeleteMapping("/delete/info/{id}")
    public ResponseEntity<BaseAPIResponseBean<?>> deleteStudentInfo(@PathVariable final Integer id) throws Exception {

        try {
            studentService.deleteStudentInfo(id);
            BaseAPIResponseBean<?> response = new BaseAPIResponseBean<>();
            response.setMessage(Constants.SUCCESS_MESSAGE);
            response.setStatus(Constants.SUCCESS_STATUS);
            return ResponseEntity.ok(response);
        }catch (Exception exception) {
            BaseAPIResponseBean<?> response = new BaseAPIResponseBean<>();
            response.setMessage(exception.getMessage());
            response.setStatus(Constants.FAILED_STATUS);
            return ResponseEntity.ok(response);
        }
    }

    @PatchMapping("/update/info/{id}")
    public ResponseEntity<BaseAPIResponseBean<?>> updateStudentInfo(@PathVariable final Integer id,
                                                                    @RequestBody final StudentRequestDto request) throws Exception {

        try {
            studentService.updateStudentInfo(id, request);
            BaseAPIResponseBean<?> response = new BaseAPIResponseBean<>();
            response.setMessage(Constants.SUCCESS_MESSAGE);
            response.setStatus(Constants.SUCCESS_STATUS);
            return ResponseEntity.ok(response);
        } catch (Exception exception) {
            BaseAPIResponseBean<?> response = new BaseAPIResponseBean<>();
            response.setMessage(exception.getMessage());
            response.setStatus(Constants.FAILED_STATUS);
            return ResponseEntity.ok(response);
        }
    }
}
