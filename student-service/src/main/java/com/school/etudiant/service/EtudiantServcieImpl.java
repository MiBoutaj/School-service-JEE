package com.school.etudiant.service;


import com.school.etudiant.dto.EtudiantRequeste;
import com.school.etudiant.dto.EtudiantResponse;
import com.school.etudiant.enums.TypeFormation;
import com.school.etudiant.mappers.EtudiantMapper;
import com.school.etudiant.model.Etudiant;
import com.school.etudiant.repositorir.EturdiantRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtudiantServcieImpl implements EtudiantService{

    @Autowired
    private EturdiantRepositorie repositorie;

    @Autowired
    EtudiantMapper etudiantMapper;


    @Override
    public EtudiantResponse addEtudiant(EtudiantRequeste etudiant) {
        Etudiant etudiant1 = etudiantMapper.fromEtudiantRequest(etudiant);
        etudiant1.setActif(Boolean.TRUE);
        etudiant1.setTypeFormation(TypeFormation.formation_initiale);
        repositorie.save(etudiant1);
        return etudiantMapper.fromEtudiant(etudiant1);

    }

    @Override
    public Etudiant editEtudiant(Long id, Etudiant etudiant) {
        return null;
    }

    @Override
    public void deleteEtudiant(Long id) {

    }

    @Override
    public List<Etudiant> getEtudiant() {
        return repositorie.findAll();
    }

    public Etudiant findById(Long id) {
        return repositorie.findById(id).orElseThrow(()-> new RuntimeException("Etudiant not fount"));
    }

    public List<Etudiant> findAll() {
        return repositorie.findAll();
    }

    public void deleteById(Long id) {
        repositorie.deleteById(id);
    }
}
