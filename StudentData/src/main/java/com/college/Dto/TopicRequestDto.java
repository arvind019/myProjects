package com.college.Dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TopicRequestDto {
    private String topicId;
    private String topicName;
    private String description;
    private String instructor;
}
