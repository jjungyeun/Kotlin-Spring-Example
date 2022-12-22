package com.kongtech.example.model.entity

import javax.persistence.*

@Entity
@Table(name = "order_item2")
class OrderItem private constructor(
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    val order: Order,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    val item: Item,
    val orderPrice: Int,
    val count: Int
) {

    @Id
    @GeneratedValue
    var id: Long? = null

    companion object {
        fun of(order: Order, item: Item, orderPrice: Int, count: Int): OrderItem {
            return OrderItem(order, item, orderPrice, count)
        }
    }
}