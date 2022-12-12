package org.example.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer {

    @Value("${topic.sql}")
    private String topicSql;

    @Value("${topic.mongo}")
    private String topicMongo;

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    public void sendSql(String message) {
        kafkaTemplate.send(topicSql, message);
    }

    public void sendMongo(String message) {
        kafkaTemplate.send(topicMongo, message);
    }
}
