package com.school;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.core.serializer.Deserializer;

import java.io.IOException;
import java.io.InputStream;
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
