package com.school;


import com.school.service.AbsencePublisher;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Calendar;
import java.util.Random;
import  com.school.model.Absence;

@SpringBootApplication
@EnableEurekaClient
public class KafkaProducerService {

    public static void main(String[] args) {
        SpringApplication.run(KafkaProducerService.class,args);
    }

}
