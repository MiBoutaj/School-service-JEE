package com.school;

import com.school.model.Course;
import com.school.model.StudentCours;
import com.school.model.sousModel.Etudiant;
import com.school.model.sousModel.Professor;
import com.school.repository.CourseRepository;
import com.school.repository.StudentCourseRepository;
import com.school.service.ProfessorRestClient;
import com.school.service.StudentRestClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.List;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class CourseService implements CommandLineRunner {

 ProfessorRestClient professorRestClient;
 StudentRestClient studentRestClient;
 CourseRepository courseRepository;
 StudentCourseRepository studentCourseRepository;

    public CourseService(ProfessorRestClient professorRestClient, StudentRestClient studentRestClient, CourseRepository courseRepository, StudentCourseRepository studentCourseRepository) {
        this.professorRestClient = professorRestClient;
        this.studentRestClient = studentRestClient;
        this.courseRepository = courseRepository;
        this.studentCourseRepository = studentCourseRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(CourseService.class,args);
    }

    @Override
    public void run(String... args) throws Exception {


        Professor professor = professorRestClient.getProfessor(1L);

        Course course = new Course(null,"COURS 1",professor.getId(),professor,null);

        List<Etudiant> etudiantList = studentRestClient.geAlltEtudiant();

        etudiantList.forEach(etu->{

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



    }
}
