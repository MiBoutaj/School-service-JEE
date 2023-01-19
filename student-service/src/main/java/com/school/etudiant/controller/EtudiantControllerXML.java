package com.school.etudiant.controller;



import com.school.etudiant.model.Etudiant;
import com.school.etudiant.repositorir.EturdiantRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(produces = "application/xml",path = "/api/v2/etudiant/")
public class EtudiantControllerXML {

    @Autowired
    EturdiantRepositorie etudiantRepositorie;

    @PostMapping
    public Etudiant addEtudiant(Etudiant etudiant){
        return etudiantRepositorie.save(etudiant);
    }

    @PutMapping("/update/{id}")
    public Etudiant updateEtudiant(@PathVariable Long id , @RequestBody Etudiant e){
        Etudiant etudiant = etudiantRepositorie.findById(id).get();
        if (etudiant!=null){
            etudiant.setName(e.getName());
            etudiant.setCin(e.getCin());
            etudiant.setDateN(e.getDateN());
            etudiant.setEmail(e.getEmail());
            etudiant.setActif(e.getActif());
            etudiant.setTypeFormation(e.getTypeFormation());
            return etudiantRepositorie.save(etudiant);
        }
        return null;

    }

    @GetMapping("/etudiant/{id}")
    public Etudiant getEtudiant(@PathVariable Long id){
    return etudiantRepositorie.findById(id).orElseThrow(()-> new RuntimeException("Etudiant not found"));
    }
    @GetMapping("/etudiant")
    public List<Etudiant> geAlltEtudiant(){
        return etudiantRepositorie.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEtudiant(@RequestParam Long id){
        etudiantRepositorie.deleteById(id);
    }
}
