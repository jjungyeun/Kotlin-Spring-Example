package com.kongtech.example.model.entity

import javax.persistence.Embeddable

@Embeddable
class Address private constructor(
    var city: String?,
    var street: String?,
    var zipcode: String?
) {

    companion object {
        fun of(city: String?, street: String?, zipcode: String?): Address {
            return Address(city, street, zipcode)
        }
    }

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

    fun notFilled(): Boolean {
        return city.isNullOrEmpty() || street.isNullOrEmpty() || zipcode.isNullOrEmpty()
    }
}