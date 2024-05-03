package com.example.hackathon.domain.order.controller;

import com.example.hackathon.domain.delivery.entity.DeliveryStatus;
import com.example.hackathon.domain.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/delivery-status-count/{userId}")
    public Map<DeliveryStatus, Long> getDeliveryStatusCount(@PathVariable Long userId) {
        return orderService.countDeliveriesByStatus(userId);
    }
}
