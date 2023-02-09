package com.school.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Absence implements Serializable{
    public int id_etudiant;
    public int nbr_heures;
    public Date date;



}
