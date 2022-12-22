package com.kongtech.example.model.type

enum class DeliveryStatus(
    val msg: String
) {
    READY("배송 준비"), COMP("배송 완료");
}
