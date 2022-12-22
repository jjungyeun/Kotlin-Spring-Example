package com.kongtech.example.model.type

enum class OrderStatus(
    val msg: String
) {
    ORDER("주문 완료"), CANCEL("주문 취소");
}
