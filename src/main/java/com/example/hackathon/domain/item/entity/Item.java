package com.example.hackathon.domain.item.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
public class Item {
    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;
    private String itemName;
    private int itemPrice;
    private int itemStock = 999;
    private float itemStar = 0;
    private int itemReviewCount = 0;
    private String itemImg = "img";
    @Enumerated(EnumType.STRING)
    private Type itemType;
}

