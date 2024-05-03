package com.example.hackathon.domain.order.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDTO {
    private Long orderId;
    private String orderStatus;
    private String userName;

    // Constructors, Getters, and Setters
    public OrderDTO(Long orderId, String orderStatus, String userName) {
        this.orderId = orderId;
        this.orderStatus = orderStatus;
        this.userName = userName;
    }
}
