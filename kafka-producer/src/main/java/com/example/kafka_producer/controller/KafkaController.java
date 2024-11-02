package com.example.kafka_producer.controller;

import com.example.kafka_producer.model.request.Order;
import com.example.kafka_producer.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class KafkaController {

    private final KafkaProducer producer;
    private String topicName = "order-create";

    @PostMapping
    public void sendEvent(@RequestBody Order order) {
        producer.produce(topicName, order);
    }
}
