package com.school.dto;

import com.school.enums.Metier;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorRequeste {

    private String name;
    private String cin;
    private Metier metier;
    private String email;
    private Date dateN;

}
