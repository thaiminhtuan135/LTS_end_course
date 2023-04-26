package com.example.end_course.repository;

import com.example.end_course.model.ImageData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StorageRepository extends JpaRepository<ImageData,Long> {

    Optional<ImageData> findByName(String name);
}
