package com.kongtech.example.rest

import com.kongtech.example.model.request.ItemCreateRequest
import com.kongtech.example.model.response.ApiResponse
import com.kongtech.example.model.response.ItemResponse
import com.kongtech.example.service.ItemService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Tag(name = "아이템")
@RestController
@RequestMapping("/kopring-ex/items")
class ItemController(
    private val itemService: ItemService
) {

    @Operation(summary = "아이템 리스트 조회")
    @GetMapping
    fun getItems(): ResponseEntity<ApiResponse<MutableList<ItemResponse>>> {
        val itemResponses: MutableList<ItemResponse> = itemService.getItems()
        return ResponseEntity.ok(ApiResponse.ok(itemResponses))
    }

    @Operation(summary = "아이템 등록")
    @PostMapping
    fun addItem(@RequestBody itemCreateRequest: ItemCreateRequest): ResponseEntity<Void> {
        itemService.addItem(itemCreateRequest)
        return ResponseEntity.ok().build()
    }

}