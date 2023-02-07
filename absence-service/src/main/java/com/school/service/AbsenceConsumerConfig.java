package com.school.service;


import com.school.Absence;

import com.school.entities.EtudiantAbsence;
import com.school.repository.AbsenceRepository;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

@Component
public class AbsenceConsumerConfig {

    @Autowired
    AbsenceRepository absenceRepository;

    @KafkaListener(topics = "AbsenceTopic", groupId = "groupID")
    void listener(ConsumerRecord<String,Absence> consumerRecord){
        System.out.println(consumerRecord.value().getDate());

        System.out.println(consumerRecord.serializedValueSize());
        System.out.println(consumerRecord.key());
        System.out.println(consumerRecord.serializedKeySize());
    }
}
