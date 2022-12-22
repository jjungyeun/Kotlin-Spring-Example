package com.kongtech.example.model.response

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
class ItemResponse private constructor(
    var id: Long,
    var name: String,
    var price: Int,
    var stock: Int
) {
    companion object {
        fun of(itemId: Long, name: String, price: Int, stock: Int): ItemResponse {
            return ItemResponse(itemId, name, price, stock)
        }
    }
}
