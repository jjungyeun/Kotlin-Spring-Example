package com.kongtech.example.repository

import com.kongtech.example.model.entity.Order
import org.springframework.data.jpa.repository.JpaRepository

interface OrderRepository: JpaRepository<Order, Long> {
}