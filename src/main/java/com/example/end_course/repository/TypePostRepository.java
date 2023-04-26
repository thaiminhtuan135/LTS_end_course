package com.example.end_course.repository;

import com.example.end_course.model.TypePost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypePostRepository extends JpaRepository<TypePost, Integer>{
}
