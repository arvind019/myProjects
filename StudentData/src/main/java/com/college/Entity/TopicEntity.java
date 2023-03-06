package com.college.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TOPIC_DTL")
@Builder
public class TopicEntity implements Serializable {

    @Id
    @Column(name = "TOPIC_ID", columnDefinition="VARCHAR(20)")
    private String topicId;

    @Column(name = "TOPIC_NAME", columnDefinition="VARCHAR(20)")
    private String topicName;

    @Column(name = "DESCRIPTION", columnDefinition="VARCHAR(256)")
    private String description;

    @Column(name = "INSTRUCTOR", columnDefinition="VARCHAR(20)")
    private String instructor;

}
