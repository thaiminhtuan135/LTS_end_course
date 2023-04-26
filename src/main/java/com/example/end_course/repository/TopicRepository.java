package com.example.end_course.repository;

import com.example.end_course.model.Post;
import com.example.end_course.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Integer>{
}
