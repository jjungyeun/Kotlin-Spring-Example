package com.kongtech.example.service

import com.kongtech.example.exception.ItemNotFoundException
import com.kongtech.example.exception.MemberNotFoundException
import com.kongtech.example.exception.NoDeliveryAddressException
import com.kongtech.example.exception.NoOrderItemException
import com.kongtech.example.model.entity.*
import com.kongtech.example.model.request.OrderCreateRequest
import com.kongtech.example.model.response.OrderResponse
import com.kongtech.example.repository.*
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class OrderServiceImpl(
    private val orderRepository: OrderRepository,
    private val memberRepository: MemberRepository,
    private val itemRepository: ItemRepository,
    private val deliveryRepository: DeliveryRepository,
    private val orderItemRepository: OrderItemRepository
) : OrderService {

    @Transactional
    override fun addOrder(orderCreateRequest: OrderCreateRequest) {
        val member: Member = memberRepository.findByIdOrNull(orderCreateRequest.memberId)
            ?: throw MemberNotFoundException()
        val item = itemRepository.findByIdOrNull(orderCreateRequest.itemId)
            ?: throw ItemNotFoundException()

        var deliveryAddress = Address.of(
            orderCreateRequest.deliveryCity,
            orderCreateRequest.deliveryStreet,
            orderCreateRequest.deliveryZipcode
        )

        if (deliveryAddress.notFilled()) {
            deliveryAddress = member.address ?: throw NoDeliveryAddressException()
            if (deliveryAddress.notFilled()) throw NoDeliveryAddressException()
        }

        val delivery = deliveryRepository.save(Delivery.of(deliveryAddress))
        val order = orderRepository.save(Order.of(member, delivery))

        orderItemRepository.save(OrderItem.of(order, item, item.price, orderCreateRequest.itemCount))
        item.reduceStockQuantity(orderCreateRequest.itemCount)
    }

    override fun getOrders(): MutableList<OrderResponse> {
        val orders = orderRepository.findAll()
        val responses: MutableList<OrderResponse> = mutableListOf()
        for (order in orders) {
            val orderItem = orderItemRepository.findByOrderId(order.id!!)
                ?: throw NoOrderItemException()

            val delivery = order.delivery
            val deliveryAddress = delivery.address.fullAddress()

            responses.add(
                OrderResponse.of(
                    order.member.name, deliveryAddress, delivery.status,
                    orderItem.item.name, orderItem.count, orderItem.orderPrice, order.status
                )
            )
        }
        return responses
    }
}