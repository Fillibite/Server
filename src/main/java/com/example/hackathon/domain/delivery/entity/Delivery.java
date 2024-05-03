package com.example.hackathon.domain.delivery.entity;

import com.example.hackathon.global.common.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class Delivery extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

}
