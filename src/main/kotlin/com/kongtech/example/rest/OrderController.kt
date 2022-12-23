package com.kongtech.example.rest

import com.kongtech.example.model.request.OrderCreateRequest
import com.kongtech.example.service.OrderService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/kopring-ex/orders")
class OrderController(
    private val orderService: OrderService
) {

    @PostMapping
    fun addOrder(@RequestBody orderCreateRequest: OrderCreateRequest): ResponseEntity<Void> {
        orderService.addOrder(orderCreateRequest)
        return ResponseEntity.ok().build()
    }

}