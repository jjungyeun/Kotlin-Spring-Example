package com.kongtech.example.rest

import com.kongtech.example.model.request.ItemCreateRequest
import com.kongtech.example.model.response.ApiResponse
import com.kongtech.example.model.response.ItemResponse
import com.kongtech.example.service.ItemService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/kopring-ex/items")
class ItemController(
    private val itemService: ItemService
) {

    @GetMapping
    fun getItems(): ResponseEntity<ApiResponse<MutableList<ItemResponse>>> {
        val itemResponses: MutableList<ItemResponse> = itemService.getItems()
        return ResponseEntity.ok(ApiResponse.ok(itemResponses))
    }

    @PostMapping
    fun addItem(@RequestBody itemCreateRequest: ItemCreateRequest): ResponseEntity<Void> {
        itemService.addItem(itemCreateRequest)
        return ResponseEntity.ok().build()
    }

}