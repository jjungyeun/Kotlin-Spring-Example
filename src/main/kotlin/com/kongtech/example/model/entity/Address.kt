package com.kongtech.example.model.entity

import javax.persistence.Embeddable

@Embeddable
class Address(
    private val city: String?,
    private val street: String?,
    private val zipcode: String?
) {
    fun fullAddress(): String {
        val sb = StringBuilder(city?:"")

        if (street != null){
            if (sb.isNotBlank()) sb.append(" ")
            sb.append(street)
        }

        if (sb.isBlank()) sb.append("No address Info")
        if (zipcode != null) sb.append(" ($zipcode)")

        return sb.toString()
    }
}