package com.kongtech.example.service

import com.kongtech.example.model.request.ItemCreateRequest
import com.kongtech.example.model.response.ItemResponse

interface ItemService {
    fun getItems(): MutableList<ItemResponse>
    fun addItem(itemCreateRequest: ItemCreateRequest)
}