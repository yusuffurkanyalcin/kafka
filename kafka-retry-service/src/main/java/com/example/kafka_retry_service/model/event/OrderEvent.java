package com.example.kafka_retry_service.model.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class OrderEvent {

    private String id;
    private String username;
    private String price;
    private String createdTime;
}