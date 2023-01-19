package com.school.etudiant.service;

import com.school.etudiant.dto.EtudiantRequeste;
import com.school.etudiant.dto.EtudiantResponse;
import com.school.etudiant.model.Etudiant;

import java.util.List;

public interface EtudiantService {

    EtudiantResponse addEtudiant(EtudiantRequeste etudiant);
    Etudiant editEtudiant(Long id, Etudiant etudiant);
    void deleteEtudiant(Long id);
    List<Etudiant> getEtudiant();

    Etudiant findById(Long id);
}
