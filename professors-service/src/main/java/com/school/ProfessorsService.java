package com.school;


import com.school.enums.Metier;
import com.school.model.Professor;
import com.school.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Date;

@SpringBootApplication
@EnableEurekaClient
public class ProfessorsService {

    public static void main(String[] args) {
        SpringApplication.run(ProfessorsService.class,args);
    }


}
