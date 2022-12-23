package com.kongtech.example.exception

open class CustomException(
    val errorCode: ErrorCode
) : RuntimeException(errorCode.message) {
}

class MemberNotFoundException : CustomException(ErrorCode.MEMBER_NOT_FOUND)
class ItemNotFoundException : CustomException(ErrorCode.ITEM_NOT_FOUND)
class NoDeliveryAddressException : CustomException(ErrorCode.NO_DELIVERY_ADDRESS)
class NotEnoughItemStockException : CustomException(ErrorCode.NOT_ENOUGH_ITEM_STOCK)