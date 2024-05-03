package com.example.hackathon.domain.delivery.entity;

public enum DeliveryStatus {
    RECEIVED,
    PAYMENT_COMPLETED,
    PREPARING_FOR_DELIVERY,
    IN_DELIVERY,
    DELIVERY_COMPLETED,
    WAIT, DELIVERY, ARRIVED
    //RECEIVED = 주문접수
    //PAYMENT_COMPLETED = 결제완료
    //PREPARING_FOR_DELIVERY = 배송준비중
    //IN_DELIVERY = 배송중
    //DELIVERY_COMPLETED = 배송완료
    // WAIT = 대기 중
    // DELIVERY = 배송 중
    // ARRIVED = 도착
}
