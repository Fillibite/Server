package com.example.hackathon.domain.order.repository;

import com.example.hackathon.domain.order.entity.Order;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository {

    List<Order> findByUserId(Long userId);

    @Query("SELECT o FROM Order o JOIN FETCH o.delivery WHERE o.user.id = :userId")
    List<Order> findOrdersWithDeliveriesByUserId(Long userId);
}
