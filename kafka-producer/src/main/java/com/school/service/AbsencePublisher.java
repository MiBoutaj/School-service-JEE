package com.school.service;

import com.school.Absence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Sinks;

@Service
public class AbsencePublisher {

    @Autowired
    private KafkaTemplate<String,Absence> kafkaTemplate;

    public void publishAbsenceEvent(Absence absence){
        kafkaTemplate.send("AbsenceTopic",absence);
        System.out.println(absence.getDate());
    }

}
