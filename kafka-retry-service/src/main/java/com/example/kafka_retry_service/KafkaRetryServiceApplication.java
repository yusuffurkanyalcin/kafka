package com.example.kafka_retry_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableConfigurationProperties
@ConfigurationPropertiesScan("kafkaretryservice")
public class KafkaRetryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaRetryServiceApplication.class, args);
	}

}
