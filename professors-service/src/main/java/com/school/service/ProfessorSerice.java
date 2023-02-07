package com.school.service;

import com.school.dto.ProfessorRequeste;
import com.school.dto.ProfessorResponse;
import com.school.model.Professor;

import java.util.List;

public interface ProfessorSerice {
    ProfessorResponse addProfessor(ProfessorRequeste professor);
    Professor editProfessor(Long id, Professor professor);
    void deleteProfessor(Long id);
    List<Professor> getProfessor();
    Professor findById(Long id);


}
