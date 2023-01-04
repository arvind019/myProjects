package com.college.Controller;

import com.college.Dto.TopicRequestDto;
import com.college.Dto.Constants;
import com.college.Configuration.BaseAPIResponseBean;
import com.college.Dto.TopicResponseDto;
import com.college.Service.ITopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topic")
public class TopicContoller {

    @Autowired
    private ITopicService topicService;

    @GetMapping("/all")
    public ResponseEntity<BaseAPIResponseBean<List<TopicResponseDto>>> getAllTopics() {

        try {
            List<TopicResponseDto> data = topicService.getAllTopics();
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
            TopicResponseDto data = topicService.getTopicInfo(topicId);
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
            topicService.saveTopicInfo(request);
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
            topicService.updateTopicInfo(topicId, request);
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
            topicService.deleteTopicInfo(topicId);
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
