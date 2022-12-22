package com.kongtech.example.model.entity

import com.kongtech.example.model.type.OrderStatus
import java.time.LocalDate
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToMany
import javax.persistence.OneToOne
import javax.persistence.Table

@Entity
@Table(name = "orders2")
class Order private constructor(
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    val member: Member,
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_id")
    val delivery: Delivery,
    val orderDate: LocalDateTime,
    var status: OrderStatus
) {

    @Id
    @GeneratedValue
    var id: Long? = null

    @OneToMany(mappedBy = "order")
    private var orderItems: List<OrderItem> = ArrayList()

    companion object {
        fun of(member: Member, delivery: Delivery): Order {
            return Order(member, delivery, LocalDateTime.now(), OrderStatus.ORDER)
        }
    }
}