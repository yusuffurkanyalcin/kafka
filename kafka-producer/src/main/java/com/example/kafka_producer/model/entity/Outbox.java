package com.example.kafka_producer.model.entity;

import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import java.util.UUID;

@Entity
@Table(name = "outbox")
@Data
@NoArgsConstructor
public class Outbox {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(columnDefinition = "varchar(255)", name = "aggregatetype")
    private String aggregateType;

    @Column(columnDefinition = "varchar(255)", name = "aggregateid")
    private String aggregateId;

    @Column(columnDefinition = "varchar(255)")
    private String type;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    private Object payload;

    public Outbox(String aggregateType, String aggregateId, String type, Object payload) {
        this.aggregateType = aggregateType;
        this.aggregateId = aggregateId;
        this.type = type;
        this.payload = payload;
    }
}
