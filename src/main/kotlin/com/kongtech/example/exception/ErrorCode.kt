package com.kongtech.example.exception

enum class ErrorCode(
    val statusCode: Int,
    val message: String
) {
    // ------ Entity Not Found ------
    MEMBER_NOT_FOUND(400, "해당 회원이 존재하지 않습니다."),
    ITEM_NOT_FOUND(400, "해당 아이템이 존재하지 않습니다."),

    NO_DELIVERY_ADDRESS(400, "배송 주소가 존재하지 않습니다."),
    NOT_ENOUGH_ITEM_STOCK(400, "주문하려는 항목의 재고가 부족합니다.")



    ;
}