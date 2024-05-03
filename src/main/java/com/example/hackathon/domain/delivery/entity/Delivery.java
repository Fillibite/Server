package com.example.hackathon.domain.delivery.entity;

import com.example.hackathon.global.common.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Delivery extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private DeliveryStatus deliveryStatus;
}
