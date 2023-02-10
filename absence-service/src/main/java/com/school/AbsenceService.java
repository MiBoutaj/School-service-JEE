package com.school;


import com.school.entities.EtudiantAbsence;
import com.school.repository.AbsenceRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class AbsenceService {

    public static void main(String[] args) {
        SpringApplication.run(AbsenceService.class,args);
    }

}
