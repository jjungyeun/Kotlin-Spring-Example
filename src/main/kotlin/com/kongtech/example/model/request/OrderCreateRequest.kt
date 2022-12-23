package com.kongtech.example.model.request

class OrderCreateRequest(
    val memberId: Long,
    val itemId: Long,
    val itemCount: Int,
    val deliveryCity: String?,
    val deliveryStreet: String?,
    val deliveryZipcode: String?
)
