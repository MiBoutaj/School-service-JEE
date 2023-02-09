package com.school.model.sousModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Professor {

    private Long id;
    private String name;
    private String cin;
    private Date dateN;
    private Metier metier;
    private String email;
    private Boolean actif;

}
