package com.school.controller;

import com.school.dto.ProfessorRequeste;
import com.school.dto.ProfessorResponse;
import com.school.enums.Metier;
import com.school.model.Professor;
import com.school.repository.ProfessorRepository;
import com.school.service.ProfessorServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.Date;

@RestController
@RequestMapping(produces = "application/json", path = "/api/v1/professor")
public class ProfessorController {
    @Autowired
    ProfessorRepository professorRepository;
    @Autowired
    RepositoryRestConfiguration repositoryRestConfiguration;

    @GetMapping("/professors")
    public java.util.List<Professor> geAlltProfessor() {

        repositoryRestConfiguration.exposeIdsFor(Professor.class);

        professorRepository.deleteAll();
        for (int i = 2; i < 10; i++) {
            professorRepository.save(new Professor(null, "Zakaaria", "Cin_" + i, new Date(), Metier.anglais, "ifuhurh", true));
        }
        System.out.println(professorRepository.findAll());

        return professorRepository.findAll();
    }

}

