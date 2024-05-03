package com.example.hackathon.domain.basket.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Basket {
    @Id
    @GeneratedValue
    private Long id;

    private String basketName;

    public Basket(Long id, String basketName) {
        this.id = id;
        this.basketName = basketName;
    }

    public Basket() {

    }
}
