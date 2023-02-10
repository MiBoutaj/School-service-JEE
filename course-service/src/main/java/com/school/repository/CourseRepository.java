package com.school.repository;

import com.school.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

@RestResource
public interface CourseRepository extends JpaRepository<Course, Long> {
}
