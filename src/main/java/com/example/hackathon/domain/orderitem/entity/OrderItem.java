package com.example.hackathon.domain.orderitem.entity;

import com.example.hackathon.domain.order.entity.Order;
import com.example.hackathon.domain.item.entity.Item;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@Builder // 빌더 패턴 적용
@NoArgsConstructor // 기본 생성자 생성
@AllArgsConstructor // 모든 필드를 가진 생성자 생성
public class OrderItem {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String orderprice;

    @Column
    private Long count;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orders_id")
    private Order order;

}
