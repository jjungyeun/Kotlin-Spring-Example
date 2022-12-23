package com.kongtech.example.service

import com.kongtech.example.model.request.OrderCreateRequest
import com.kongtech.example.model.response.OrderResponse

interface OrderService {
    fun addOrder(orderCreateRequest: OrderCreateRequest)
    fun getOrders(): MutableList<OrderResponse>
}
