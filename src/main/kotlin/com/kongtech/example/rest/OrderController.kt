package com.kongtech.example.rest

import com.kongtech.example.model.request.OrderCreateRequest
import com.kongtech.example.model.response.ApiResponse
import com.kongtech.example.model.response.OrderResponse
import com.kongtech.example.service.OrderService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@Tag(name = "주문")
@RestController
@RequestMapping("/kopring-ex/orders")
class OrderController(
    private val orderService: OrderService
) {

    @Operation(summary = "주문 등록")
    @PostMapping
    fun addOrder(@RequestBody orderCreateRequest: OrderCreateRequest): ResponseEntity<Void> {
        orderService.addOrder(orderCreateRequest)
        return ResponseEntity.ok().build()
    }

    @Operation(summary = "주문 리스트 조회")
    @GetMapping
    fun getOrders(): ResponseEntity<ApiResponse<MutableList<OrderResponse>>> {
        val orderResponses: MutableList<OrderResponse> = orderService.getOrders()
        return ResponseEntity.ok(ApiResponse.ok(orderResponses))
    }

}