package com.example.hackathon.domain.order.service;

import com.example.hackathon.domain.delivery.entity.Delivery;
import com.example.hackathon.domain.delivery.entity.DeliveryStatus;
import com.example.hackathon.domain.order.entity.Order;
import com.example.hackathon.domain.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Map<DeliveryStatus, Long> countDeliveriesByStatus(Long userId) {
        List<Order> orders = orderRepository.findOrdersWithDeliveriesByUserId(userId);

        return orders.stream()
                .filter(order -> order.getDelivery() != null) // Ensure delivery is not null
                .map(Order::getDelivery)
                .collect(Collectors.groupingBy(Delivery::getDeliveryStatus, Collectors.counting()));
    }
}
