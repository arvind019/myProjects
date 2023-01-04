package com.college.Controller;

import com.college.Configuration.BaseAPIResponseBean;
import com.college.Dto.Constants;
import com.college.Dto.TopicRequestDto;
import com.college.Dto.TopicResponseDto;
import com.college.Service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private ICourseService courseService;

    @GetMapping("/all")
    public ResponseEntity<BaseAPIResponseBean<List<TopicResponseDto>>> getAllTopics() {

        try {
            List<TopicResponseDto> data = courseService.getAllTopics();
            BaseAPIResponseBean<List<TopicResponseDto>> response = new BaseAPIResponseBean<>();
            response.setMessage(Constants.SUCCESS_MESSAGE);
            response.setStatus(Constants.SUCCESS_STATUS);
            response.setData(data);
            return ResponseEntity.ok(response);
        } catch (Exception exception) {
            BaseAPIResponseBean<List<TopicResponseDto>> response = new BaseAPIResponseBean<>();
            response.setMessage(exception.getMessage());
            response.setStatus(Constants.FAILED_STATUS);
            return ResponseEntity.ok(response);
        }
    }

    @GetMapping("/get/{topicId}")
    public ResponseEntity<BaseAPIResponseBean<TopicResponseDto>> getTopicById(@PathVariable(value = "topicId") final String topicId) {

        try {
            TopicResponseDto data = courseService.getTopicInfo(topicId);
            BaseAPIResponseBean<TopicResponseDto> response = new BaseAPIResponseBean<>();
            response.setMessage(Constants.SUCCESS_MESSAGE);
            response.setStatus(Constants.SUCCESS_STATUS);
            response.setData(data);
            return ResponseEntity.ok(response);
        } catch (Exception exception) {
            BaseAPIResponseBean<TopicResponseDto> response = new BaseAPIResponseBean<>();
            response.setMessage(exception.getMessage());
            response.setStatus(Constants.FAILED_STATUS);
            return ResponseEntity.ok(response);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<BaseAPIResponseBean<?>> saveTopicInfo(@RequestBody final TopicRequestDto request) {

        try {
            courseService.saveTopicInfo(request);
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

    @PutMapping("/update/{topicId}")
    public ResponseEntity<BaseAPIResponseBean<?>> updateTopicInfo(@PathVariable(value = "topicId") final String topicId, @RequestBody final TopicRequestDto request) {

        try {
            courseService.updateTopicInfo(topicId, request);
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

    @DeleteMapping("/delete/{topicId}")
    public ResponseEntity<BaseAPIResponseBean<?>> deleteTopicInfo(@PathVariable(value = "topicId") final String topicId) {

        try {
            courseService.deleteTopicInfo(topicId);
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
