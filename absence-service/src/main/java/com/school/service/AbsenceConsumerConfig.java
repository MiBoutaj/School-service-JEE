package com.school.service;
import com.school.entities.EtudiantAbsence;
import com.school.model.Absence;
import com.school.repository.AbsenceRepository;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
@Component
@Transactional
public class AbsenceConsumerConfig {

    @Autowired
    AbsenceRepository absenceRepository;

    @KafkaListener(topics = "AbsenceTopic", groupId = "group_id" , containerFactory = "absenceKafkaListenerContainerFactory")
    void consume(Absence consumerRecord){
        System.out.println(consumerRecord.getDate());
        EtudiantAbsence  etudiantAbsence = new EtudiantAbsence();
        etudiantAbsence.setName(null);
        etudiantAbsence.setDate(consumerRecord.getDate());
        etudiantAbsence.setHr(consumerRecord.getNbr_heures());
        absenceRepository.save(etudiantAbsence);
    }
}
