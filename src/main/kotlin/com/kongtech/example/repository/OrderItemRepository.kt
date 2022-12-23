package com.kongtech.example.repository

import com.kongtech.example.model.entity.OrderItem
import org.springframework.data.jpa.repository.JpaRepository

interface OrderItemRepository: JpaRepository<OrderItem, Long> {
    fun findByOrderId(orderId: Long): OrderItem?
}