package com.example.kafka_producer.producer;

import com.example.kafka_producer.model.entity.Outbox;
import com.example.kafka_producer.repository.OutboxRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class KafkaProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final OutboxRepository repository;

    public void produce(String topicName, Object message) {
        try {
            if (topicName.equals(topicName)) {
                throw new RuntimeException();
            }
            kafkaTemplate.send(topicName, message);
        } catch (Exception e) {
            String key = UUID.randomUUID().toString();
            Outbox outbox = new Outbox(topicName, key, topicName, message);
            repository.save(outbox);
        }
    }
}
