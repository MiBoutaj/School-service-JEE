package com.school.mappers;

import com.school.dto.ProfessorRequeste;
import com.school.dto.ProfessorResponse;
import com.school.model.Professor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ProfessorMapper {
    public Professor fromProfessorRequest(ProfessorRequeste professorRequest){
        Professor professor = new Professor();
        BeanUtils.copyProperties(professorRequest,professor);
        return professor;
    }

    public Professor fromProfessorResponse(ProfessorResponse professorResponse){
        Professor professor = new Professor();
        BeanUtils.copyProperties(professorResponse,professor);
        return professor;
    }

    public ProfessorResponse fromProfessor(Professor professor){
        ProfessorResponse professorResponse = new ProfessorResponse();
        BeanUtils.copyProperties(professor,professorResponse);
        return professorResponse;
    }

}