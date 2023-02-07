package com.school.controller;

import com.school.dto.ProfessorRequeste;
import com.school.dto.ProfessorResponse;
import com.school.model.Professor;
import com.school.service.ProfessorServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
@RequestMapping(produces = "application/json",path = "/api/v1/professor")
public class ProfessorController {
    @Autowired
    private  ProfessorServiceIMPL professorServiceIMPL;

    @PostMapping("/add")
    public ProfessorResponse addProfessor(@RequestBody ProfessorRequeste professor){
        return professorServiceIMPL.addProfessor(professor);
    }
    @PutMapping("/update/{id}")
    public Professor updateProfessor(@PathVariable Long id , @RequestBody Professor professor){
        return professorServiceIMPL.editProfessor(id,professor);
    }

    @GetMapping("/professor/{id}")
    public Professor getProfessor(@PathVariable Long id){
        return professorServiceIMPL.findById(id);
    }
    @GetMapping("/professors")
    public java.util.List<Professor> geAlltProfessor(){
        return professorServiceIMPL.getProfessor();
    }
    @DeleteMapping("/delete/{id}")
    public void deleteProfessor(@RequestParam Long id){
        professorServiceIMPL.deleteById(id);
    }

}