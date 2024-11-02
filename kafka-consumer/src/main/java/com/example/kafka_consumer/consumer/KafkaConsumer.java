package com.example.kafka_consumer.consumer;

import com.example.kafka_consumer.consumer.exception.BusinessException;
import com.example.kafka_consumer.consumer.exception.ValidationException;
import com.example.kafka_consumer.model.event.OrderEvent;
import com.example.kafka_consumer.producer.KafkaProducer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.net.ConnectException;

@Component
@RequiredArgsConstructor
public class KafkaConsumer {

    private final KafkaProducer producer;
    private static final String TOPIC_NAME = "order-create";
    private static final String RETRY_TOPIC_NAME = "order-create.kafkaconsumer.retry";
    private static final String ERROR_TOPIC_NAME = "order-create.kafkaconsumer.error";
    private static final String GROUP_ID = "KafkaOrderConsumer-GroupId"; // Hangi consumer group'a ait olduğunu belirledik
    private final ObjectMapper objectMapper;

    @KafkaListener(topics = {TOPIC_NAME}, groupId = GROUP_ID, containerFactory = "kafkaListenerContainerFactory")
    public void listener(@Payload OrderEvent event, ConsumerRecord c) throws Exception {
        try {
            consume(event);
        } catch (BusinessException | ValidationException exception) {
        } catch (ConnectException connectException) {
            String value = (String) c.value();
            JsonNode jsonNode = objectMapper.readTree(value);
            producer.produce(RETRY_TOPIC_NAME, jsonNode);
        }
    }

    @KafkaListener(topics = RETRY_TOPIC_NAME, groupId = GROUP_ID, containerFactory = "kafkaListenerContainerFactory")
    public void listener2(@Payload OrderEvent event, ConsumerRecord c) throws Exception {
        try {
            consume(event);
        } catch (BusinessException | ValidationException exception) {
        } catch (ConnectException connectException) {
            String value = (String) c.value();
            JsonNode jsonNode = objectMapper.readTree(value);
            producer.produce(ERROR_TOPIC_NAME, jsonNode);
        }
    }

    private void consume(OrderEvent event) throws Exception {
        int error = 6;
        if (error < 7) {
            System.out.println("I Consumed");
        } else if (error == 7) {
            throw new BusinessException("BusinessException");
        } else if (error == 8) {
            throw new ValidationException("ValidationException");
        } else {
            throw new ConnectException("Connect to mssql is failed");
        }
    }
}
