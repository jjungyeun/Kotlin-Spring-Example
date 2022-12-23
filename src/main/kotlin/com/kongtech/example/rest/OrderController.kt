package com.kongtech.example.rest

import com.kongtech.example.model.request.OrderCreateRequest
import com.kongtech.example.model.response.ApiResponse
import com.kongtech.example.model.response.OrderResponse
import com.kongtech.example.service.OrderService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

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

    @GetMapping
    fun getOrders(): ResponseEntity<ApiResponse<MutableList<OrderResponse>>> {
        val orderResponses: MutableList<OrderResponse> = orderService.getOrders()
        return ResponseEntity.ok(ApiResponse.ok(orderResponses))
    }

}