package com.school.model.sousModel;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Etudiant {

    private Long id;
    private String name;
    private String cin;
    private Date dateN;
    private TypeFormation typeFormation;
    private String email;
    private Boolean actif;

}
