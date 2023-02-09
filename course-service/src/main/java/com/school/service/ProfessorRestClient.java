package com.school.service;

import com.school.model.sousModel.Professor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "PROFESSOR")
public interface ProfessorRestClient {

    @GetMapping("/professor/{id}")
     Professor getProfessor(@PathVariable Long id);

    @GetMapping("/professors")
    List<Professor> geAlltProfessor();

}
