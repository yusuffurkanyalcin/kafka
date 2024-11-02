package com.example.kafka_producer.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Order {

    private String id;
    private String username;
    private String price;
    private String createdTime;
}