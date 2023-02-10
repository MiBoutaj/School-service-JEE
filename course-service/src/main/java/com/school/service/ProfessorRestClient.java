package com.school.service;

import com.school.model.sousModel.Professor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@FeignClient(name = "PROFESSOR")
public interface ProfessorRestClient {

    @GetMapping("/professors/{id}")
     Professor getProfessorById(@PathVariable("id") Long id);

    @GetMapping("/professors")
    PagedModel<Professor> pageProduit(@RequestParam(value = "page") int page,
                                    @RequestParam(value = "taille") int taille);

}
