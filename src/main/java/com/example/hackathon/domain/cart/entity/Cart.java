package com.example.hackathon.domain.cart.entity;

import com.example.hackathon.domain.item.entity.Item;
import com.example.hackathon.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Cart {
    @Id
    @GeneratedValue
    @Column(name = "cart_id")
    private Long id;

    private int count;
    private int totalPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public void setCart(int count, int totalPrice, Item item, User user) {
        this.count = count;
        this.totalPrice = totalPrice;
        this.item = item;
        this.user = user;
    }
    public Cart() {

    }
}
