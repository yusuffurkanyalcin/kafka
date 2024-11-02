package com.example.kafka_retry_service.publisher;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaPublisher {

    private final KafkaTemplate<String, Object> template;

    public void publish(String topicName, Object message) {
        template.send(topicName, message);
    }
}