package com.example.hackathon.domain.order.service;

import com.example.hackathon.domain.order.repository.OrderRepository;
import com.example.hackathon.global.common.CommonMethod;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final CommonMethod commonMethod;
}
