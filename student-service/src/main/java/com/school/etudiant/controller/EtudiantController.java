package com.school.etudiant.controller;


import com.school.etudiant.dto.EtudiantResponse;
import com.school.etudiant.model.Etudiant;
import com.school.etudiant.service.EtudiantServcieImpl;
import com.school.etudiant.dto.EtudiantRequeste;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(produces = "application/json",path = "/api/v1/etudiant")
public class EtudiantController {

    @Autowired
    EtudiantServcieImpl etudiantServcie;

    @PostMapping("/add")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public EtudiantResponse addEtudiant(@RequestBody EtudiantRequeste etudiant){
        return etudiantServcie.addEtudiant(etudiant);
    }

    @PutMapping("/update/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public Etudiant updateEtudiant(@PathVariable Long id , @RequestBody Etudiant e){
      return etudiantServcie.editEtudiant(id,e);

    }

    @GetMapping("/etudiant/{id}")
    @PreAuthorize("hasAnyAuthority('USER')")
    public Etudiant getEtudiant(@PathVariable Long id){
    return etudiantServcie.findById(id);
    }
    @GetMapping("/etudiants")
    @PreAuthorize("hasAnyAuthority('USER')")
    public List<Etudiant> geAlltEtudiant(){
        return etudiantServcie.findAll();
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public void deleteEtudiant(@RequestParam Long id){
        etudiantServcie.deleteById(id);
    }
}
