package com.example.end_course.service.typeCourse;

import com.example.end_course.model.TypeCourse;

import java.util.List;
import java.util.Optional;

public interface TypeCourseService {
    TypeCourse save(TypeCourse typeCourse);

    Optional<TypeCourse> getTypeCourseById(int id);

    void delete(int id);

    List<TypeCourse> getTypeCourses();
}
