package com.school.repository;

import com.school.entities.EtudiantAbsence;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AbsenceRepository extends MongoRepository<EtudiantAbsence,String> {
}
