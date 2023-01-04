package com.college.Service;

import com.college.Dto.TopicRequestDto;
import com.college.Dto.TopicResponseDto;

import java.util.List;

public interface ITopicService {

    List<TopicResponseDto> getAllTopics();

    TopicResponseDto getTopicInfo(final String topicId);

    void saveTopicInfo(final TopicRequestDto request);

    void updateTopicInfo(final String topicId, final TopicRequestDto request);

    void deleteTopicInfo(final String topicId);

}
