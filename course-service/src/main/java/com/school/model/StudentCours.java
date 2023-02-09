package com.school.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.school.model.sousModel.TypeFormation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentCours {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 60, nullable = false)
    private String name;
    @Column(length = 8, unique = true, nullable = false)
    private String cin;
    @Temporal(TemporalType.DATE)
    private Date dateN;
    @Enumerated(EnumType.STRING)
    private TypeFormation typeFormation;
    @Column(nullable = false)
    private String email;
    private Boolean actif;

    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Course course;
}
