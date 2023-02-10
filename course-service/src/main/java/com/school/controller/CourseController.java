package com.school.controller;


import com.school.model.Course;
import com.school.model.StudentCours;
import com.school.model.sousModel.Etudiant;
import com.school.model.sousModel.Professor;
import com.school.repository.CourseRepository;
import com.school.repository.StudentCourseRepository;
import com.school.service.ProfessorRestClient;
import com.school.service.StudentRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v3")
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    StudentCourseRepository studentCourseRepository;

    @Autowired
    RepositoryRestConfiguration repositoryRestConfiguration;

    @Autowired
    StudentRestClient studentRestClient;
    @Autowired
    ProfessorRestClient professorRestClient;


    @GetMapping("/courses/{id}")
    public List<Course> getAll(@PathVariable Long id) {

        repositoryRestConfiguration.exposeIdsFor(Course.class);

        studentCourseRepository.deleteAll();
        courseRepository.deleteAll();

        List.of("COURS 1","COURS 2").forEach(cou->{
            Professor professor = professorRestClient.getProfessorById(id);
            System.out.println(professor.toString());

            Course course = new Course(null, cou, professor.getId(), professor, null);
            courseRepository.save(course);
            PagedModel<Etudiant> etudiantList = studentRestClient.pageEtudiant(0,6);
            etudiantList.forEach(etu -> {
                StudentCours studentCours = new StudentCours();
                studentCours.setId(etu.getId());
                studentCours.setName(etu.getName());
                studentCours.setActif(etu.getActif());
                studentCours.setCin(etu.getCin());
                studentCours.setEmail(etu.getEmail());
                studentCours.setDateN(etu.getDateN());
                studentCours.setCourse(course);
                studentCourseRepository.save(studentCours);

            });

           // courseRepository.save(course);

        });

        return courseRepository.findAll();
    }
}
