package org.example.service;

import org.example.message.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MessageProcessImpl implements MessageProcess{

    @Autowired
    KafkaProducer kafkaProducer;

    @Override
    public String process(Map<String, Object> body) {
        String message = body.get("message").toString();
        kafkaProducer.sendSql(message);
        return "OK";
    }
}
