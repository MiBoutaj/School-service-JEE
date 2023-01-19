package com.school.etudiant.dto;

import com.school.etudiant.enums.TypeFormation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EtudiantResponse {

    private String name;
    private String cin;
    private TypeFormation typeFormation;
    private Date dateN;
    private Boolean status;
    private String email;



}
