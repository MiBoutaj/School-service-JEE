package com.school.controller;


import com.school.model.Absence;
import com.school.service.AbsencePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Calendar;
import java.util.Random;


@RestController
@RequestMapping("/start")
public class KafkaController {

    @Autowired
    AbsencePublisher absencePublisher;

    @GetMapping
    public void start(){
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
