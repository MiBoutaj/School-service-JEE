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
public class CourseService{

    public static void main(String[] args) {
        SpringApplication.run(CourseService.class,args);
    }



}
