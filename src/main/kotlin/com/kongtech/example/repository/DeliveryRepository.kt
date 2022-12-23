package com.kongtech.example.repository

import com.kongtech.example.model.entity.Delivery
import org.springframework.data.jpa.repository.JpaRepository

interface DeliveryRepository: JpaRepository<Delivery, Long> {

}
