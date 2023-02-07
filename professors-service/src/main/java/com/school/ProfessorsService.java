package com.school;


import com.school.enums.Metier;
import com.school.model.Professor;
import com.school.repository.ProfessorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class ProfessorsService {

    public static void main(String[] args) {
        SpringApplication.run(ProfessorsService.class,args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ProfessorRepository professorRepository){
        return args -> {
            for (int i = 2; i < 10; i++) {
                professorRepository.save(new Professor(null,"Zakaaria","Cin_"+i,new Date(), Metier.anglais,"ifuhurh",true));
            }
            System.out.println(professorRepository.findAll());

        };
    }
}
