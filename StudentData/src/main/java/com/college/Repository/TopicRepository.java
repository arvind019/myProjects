package com.college.Repository;

import com.college.Entity.TopicEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepository extends JpaRepository<TopicEntity, String> {

    TopicEntity findByTopicId(final String topicId);

}
