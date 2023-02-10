package com.school.repository;

import com.school.model.StudentCours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

@RestResource
public interface StudentCourseRepository extends JpaRepository<StudentCours, Long> {
}
