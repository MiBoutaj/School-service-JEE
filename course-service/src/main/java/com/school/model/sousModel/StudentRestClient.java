package com.school.model.sousModel;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "STUDENT")
public interface StudentRestClient {

    @GetMapping("/etudiant/{id}")
     Etudiant getEtudiant(@PathVariable Long id)
    @GetMapping("/etudiants")
     List<Etudiant> geAlltEtudiant();

}
