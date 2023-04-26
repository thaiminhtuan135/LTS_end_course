package com.example.end_course.service.topic;

import com.example.end_course.model.Post;
import com.example.end_course.model.Topic;

import java.util.List;
import java.util.Optional;

public interface TopicService {
    Topic save(Topic topic);

    Optional<Topic> getTopicById(int id);

    void delete(int id);

    List<Topic> getTopics();
}
