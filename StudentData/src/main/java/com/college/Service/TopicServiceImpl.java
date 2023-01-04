package com.college.Service;

import com.college.Dto.TopicRequestDto;
import com.college.Entity.TopicEntity;
import com.college.Dto.TopicResponseDto;
import com.college.Repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TopicServiceImpl implements ITopicService {

    @Autowired
    private TopicRepository topicRepository;

    @Override
    public List<TopicResponseDto> getAllTopics() {
        final List<TopicEntity> list = topicRepository.findAll();
        final List<TopicResponseDto> response = new ArrayList<>();
        list.forEach(topic -> response.add(getTopicResponseDto(topic)));
        return response;
    }

    private TopicResponseDto getTopicResponseDto(final TopicEntity topic) {
        return TopicResponseDto.builder()
                               .topicId(topic.getTopicId())
                               .topicName(topic.getTopicName())
                               .description(topic.getDescription())
                               .instructor(topic.getInstructor())
                               .build();
    }

    @Override
    public TopicResponseDto getTopicInfo(final String topicId) {
        return getTopicResponseDto(topicRepository.findByTopicId(topicId));
    }

    @Override
    public void saveTopicInfo(TopicRequestDto request) {
        topicRepository.save(getEntityFromRequest(request));
    }

    private TopicEntity getEntityFromRequest(TopicRequestDto request) {
        return TopicEntity.builder()
                          .topicId(request.getTopicId())
                          .topicName(request.getTopicName())
                          .description(request.getDescription())
                          .instructor(request.getInstructor())
                          .build();
    }

    @Override
    public void updateTopicInfo(final String topicId, final TopicRequestDto request) {
        topicRepository.save(getEntityFromRequest(request));
    }

    @Override
    public void deleteTopicInfo(final String topicId) {
        topicRepository.deleteById(topicId);
    }
}
