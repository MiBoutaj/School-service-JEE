package com.school.etudiant.mappers;


import com.school.etudiant.dto.EtudiantRequeste;
import com.school.etudiant.dto.EtudiantResponse;
import com.school.etudiant.model.Etudiant;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;


@Component
public class EtudiantMapper {
    public Etudiant fromEtudiantRequest(EtudiantRequeste etudiantRequeste){
        Etudiant etudiant = new Etudiant();
        BeanUtils.copyProperties(etudiantRequeste,etudiant);
        return etudiant;
    }

    public Etudiant fromEtudiantResponse(EtudiantResponse etudiantResponse){
        Etudiant etudiant = new Etudiant();
        BeanUtils.copyProperties(etudiantResponse,etudiant);
        return etudiant;
    }

    public EtudiantResponse fromEtudiant(Etudiant etudiant){
      EtudiantResponse etudiantResponse = new EtudiantResponse();
        BeanUtils.copyProperties(etudiant,etudiantResponse);
        return etudiantResponse;
    }
}
