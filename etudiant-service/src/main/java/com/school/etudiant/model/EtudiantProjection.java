package com.school.etudiant.model;

import com.school.etudiant.enums.TypeFormation;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "mobile",types = Etudiant.class)
public interface EtudiantProjection {
    String getNom();
    TypeFormation getTypeFormation();
    Boolean getStatus();
}
