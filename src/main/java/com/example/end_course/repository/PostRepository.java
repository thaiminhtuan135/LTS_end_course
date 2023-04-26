package com.example.end_course.repository;

import com.example.end_course.model.Course;
import com.example.end_course.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer>{
}
