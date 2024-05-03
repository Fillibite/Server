package com.example.hackathon.domain.order.entity;

public enum OrderStatus {
    CANCEL, FINISH, CONFIRMED
    // CANCEL = 주문 취소
    // FINISH = 주문 완료
    // CONFIRMED = 주문 확정 (7일 뒤 주문 취소 불가능)
}
