package com.example.hackathon.domain.order.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserOrderDTO {

    private Long userId;
    private List<OrderDTO> orders;

    // Constructors, Getters, and Setters
    public UserOrderDTO(Long userId, List<OrderDTO> orders) {
        this.userId = userId;
        this.orders = orders;
    }
}
