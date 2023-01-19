package com.school.etudiant.controller;

import com.school.etudiant.dto.EtudiantRequeste;
import com.school.etudiant.dto.EtudiantResponse;
import com.school.etudiant.model.Etudiant;
import com.school.etudiant.service.EtudiantServcieImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class EtudiantGraphQl {

    @Autowired
    EtudiantServcieImpl etudiantServcie;

    @QueryMapping
    public List<Etudiant> getEtudiant() {
        return etudiantServcie.getEtudiant();
    }


    @QueryMapping
    public Etudiant getEtudiantId(@Argument Long id) {
        return etudiantServcie.findById(id);
    }


    @MutationMapping
    public EtudiantResponse addEtudiant(@Argument EtudiantRequeste etudiant) {
        return etudiantServcie.addEtudiant(etudiant);
    }

    @MutationMapping
    public void deleteEtudiant(@Argument Long id) {
        etudiantServcie.deleteById(id);
    }

    @MutationMapping
    public Etudiant updateEtudiant(@Argument Long id, @Argument Etudiant e) {
        return etudiantServcie.editEtudiant(id, e);

    }


}
