package com.school.model;


import com.school.model.sousModel.Professor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long idProf;

    @Transient
    private Professor professor;

    @OneToMany(mappedBy = "course")
    private List<StudentCours> etudiants;

}
