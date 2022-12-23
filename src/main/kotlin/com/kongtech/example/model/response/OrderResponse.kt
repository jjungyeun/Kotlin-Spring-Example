package com.kongtech.example.model.response

import com.fasterxml.jackson.annotation.JsonInclude
import com.kongtech.example.model.type.DeliveryStatus
import com.kongtech.example.model.type.OrderStatus

@JsonInclude(JsonInclude.Include.NON_NULL)
class OrderResponse private constructor(
    var memberName: String,
    var deliveryAddress: String,
    var deliveryStatus: DeliveryStatus,
    var itemName: String,
    var totalPrice: Int,
    var itemCount: Int,
    var orderStatus: OrderStatus
) {

    companion object {
        fun of(memberName: String, deliveryAddress: String, deliveryStatus: DeliveryStatus,
               itemName: String, itemCount: Int, totalPrice: Int, orderStatus: OrderStatus): OrderResponse {
            return OrderResponse(
                memberName, deliveryAddress, deliveryStatus, itemName, totalPrice, itemCount, orderStatus
            )
        }
    }
}
