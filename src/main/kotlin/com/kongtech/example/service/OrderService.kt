package com.kongtech.example.service

import com.kongtech.example.model.request.OrderCreateRequest

interface OrderService {
    fun addOrder(orderCreateRequest: OrderCreateRequest)

}
