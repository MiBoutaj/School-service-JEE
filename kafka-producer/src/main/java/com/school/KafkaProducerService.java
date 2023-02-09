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

    @Bean
    CommandLineRunner commandLineRunner(AbsencePublisher absencePublisher){
        return args -> {
            Timer timer = new Timer();
            TimerTask task = new TimerTask() {
                public void run() {
                     Absence absence = new Absence();
                    absence.setId_etudiant((int)(Math.random() * 50) + 1);
                    absence.setNbr_heures((int)(Math.random() * 10) + 1);
                    absence.setDate(genererDate());
                    absencePublisher.publishAbsenceEvent(absence);
                }
            };
            timer.scheduleAtFixedRate(task, 0, 1000);
        };
    }


    public Date genererDate(){

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1); // définir le mois précédent
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int dayOfMonth = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
        cal.set(year, month, dayOfMonth);
        Date start = cal.getTime();
        cal.set(Calendar.MONTH, Calendar.getInstance().get(Calendar.MONTH));
        dayOfMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        cal.set(year, month, dayOfMonth);
        Date end = cal.getTime();

        Random rand = new Random();
        long randomTimestamp = rand.nextLong() % (end.getTime() - start.getTime() + 1) + start.getTime();
        return new Date(randomTimestamp);
    }
}
