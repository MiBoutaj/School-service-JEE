package com.school.repository;

import com.school.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource
public interface ProfessorRepository extends JpaRepository<Professor,Long> {

}
