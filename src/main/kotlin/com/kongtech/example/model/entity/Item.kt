package com.kongtech.example.model.entity

import com.kongtech.example.exception.NotEnoughItemStockException
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "item2")
class Item private constructor(
    var name: String,
    var price: Int,
    var stockQuantity: Int
) {

    @Id
    @GeneratedValue
    var id: Long? = null

    companion object {
        fun of(name: String, price: Int, stockQuantity: Int): Item {
            return Item(name, price, stockQuantity)
        }
    }

    fun reduceStockQuantity(orderCount: Int) {
        if (this.stockQuantity < orderCount) throw NotEnoughItemStockException()
        this.stockQuantity -= orderCount
    }
}