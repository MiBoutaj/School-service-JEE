package com.school.service;

import com.school.dto.ProfessorRequeste;
import com.school.dto.ProfessorResponse;
import com.school.mappers.ProfessorMapper;
import com.school.model.Professor;
import com.school.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorServiceIMPL implements ProfessorSerice{
        @Autowired
        private ProfessorRepository repositorie;

        @Autowired
        ProfessorMapper professorMapper;


        @Override
        public ProfessorResponse addProfessor(ProfessorRequeste professor) {
            Professor professor1 = professorMapper.fromProfessorRequest(professor);
            repositorie.save(professor1);
            return professorMapper.fromProfessor(professor1);
        }

        @Override
        public Professor editProfessor(Long id, Professor professor) {
            return null;
        }


        @Override
        public List<Professor> getProfessor() {
            return repositorie.findAll();
        }

        @Override
        public Professor findById(Long id) {
            return repositorie.findById(id).orElseThrow(()-> new RuntimeException("Professor not fount"));
        }
    @Override
        public void deleteById(Long id) {
        repositorie.deleteById(id);
    }
}