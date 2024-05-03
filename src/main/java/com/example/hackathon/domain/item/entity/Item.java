package com.example.hackathon.domain.item.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Item {
    @Id @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;
    private Long price;
    private Long stock;

    public Item(Long id, String name, Long price, Long stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public Item() {

    }
}
