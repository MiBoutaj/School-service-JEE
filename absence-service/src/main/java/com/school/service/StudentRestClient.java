package com.school.service;

import com.school.model.sousModel.Etudiant;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name = "ETUDIANT")
public interface StudentRestClient {

    @GetMapping("/etudiants/{id}")
    Etudiant getEtudiantById(@PathVariable("id") Long id);
    @GetMapping("/etudiants")
    PagedModel<Etudiant> pageEtudiant(@RequestParam(value = "page") int page,
                                      @RequestParam(value = "taille") int taille);

}
