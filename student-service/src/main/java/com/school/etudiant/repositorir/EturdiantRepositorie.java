package com.school.etudiant.repositorir;

import com.school.etudiant.model.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource
public interface EturdiantRepositorie extends JpaRepository<Etudiant,Long> {
}


