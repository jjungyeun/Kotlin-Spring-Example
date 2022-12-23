package com.kongtech.example.model.entity

import com.kongtech.example.model.type.DeliveryStatus
import javax.persistence.*

@Entity
@Table(name = "delivery2")
class Delivery private constructor(
    var status: DeliveryStatus,
    @Embedded
    var address: Address
) {

    @Id
    @GeneratedValue
    var id: Long? = null


    companion object {
        fun of(city: String?, street: String?, zipcode: String?): Delivery {
            return Delivery(status = DeliveryStatus.READY, address = Address.of(city, street, zipcode))
        }

        fun of(address: Address): Delivery{
            return Delivery(status = DeliveryStatus.READY, address = address)
        }
    }
}