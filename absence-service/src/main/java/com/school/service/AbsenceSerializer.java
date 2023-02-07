package com.school.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Map;

import com.school.Absence;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;

public class AbsenceSerializer implements Serializer<Absence> {

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
    }

    @Override
    public byte[] serialize(String topic, Absence data) {
        try (ByteArrayOutputStream b = new ByteArrayOutputStream()) {
            try (ObjectOutputStream o = new ObjectOutputStream(b)) {
                o.writeObject(data);
            }
            return b.toByteArray();
        } catch (IOException e) {
            throw new SerializationException("Error serializing Absence object", e);
        }
    }

    @Override
    public void close() {
    }
}
