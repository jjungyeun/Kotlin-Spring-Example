package com.kongtech.example.repository

import com.kongtech.example.model.entity.Item
import org.springframework.data.jpa.repository.JpaRepository

interface ItemRepository: JpaRepository<Item, Long> {
}