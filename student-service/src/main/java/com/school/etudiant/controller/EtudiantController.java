package com.school.etudiant.controller;


import com.school.etudiant.dto.EtudiantResponse;
import com.school.etudiant.enums.TypeFormation;
import com.school.etudiant.model.Etudiant;
import com.school.etudiant.repositorir.EturdiantRepositorie;
import com.school.etudiant.service.EtudiantServcieImpl;
import com.school.etudiant.dto.EtudiantRequeste;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@RestController
@RequestMapping(produces = "application/json",path = "api/v1")
public class EtudiantController {

    @Autowired
    EturdiantRepositorie  etudiantR;

    @Autowired
    RepositoryRestConfiguration repositoryRestConfiguration;




    @GetMapping("/etudiant")
    public List<Etudiant> geAlltEtudiant(){
        repositoryRestConfiguration.exposeIdsFor(Etudiant.class);
        etudiantR.deleteAll();
        for (int i = 2; i < 10; i++) {
            etudiantR.save(new Etudiant(null,"Zakaria","Cin_"+i,new Date(), TypeFormation.formation_continue,"zakaria"+i+"@gmail.com",true));
        }
        return etudiantR.findAll();
    }


}
