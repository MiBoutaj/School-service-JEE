package com.school.etudiant;

import com.school.etudiant.enums.TypeFormation;
import com.school.etudiant.model.Etudiant;
import com.school.etudiant.repositorir.EturdiantRepositorie;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
@EnableEurekaClient
public class EtudiantApplication {

    public static void main(String[] args) {
        SpringApplication.run(EtudiantApplication.class, args);
    }

  /*  @Bean
    CommandLineRunner commandLineRunner(EturdiantRepositorie etudiantR){
        return args -> {
            for (int i = 2; i < 10; i++) {
                etudiantR.save(new Etudiant(null,"Zakaria","Cin_"+i,new Date(), TypeFormation.formation_continue,"zakaria"+i+"@gmail.com",true));
            }
            System.out.println(etudiantR.findAll());

        };
    }

   */



}
