package com.kongtech.example.model.entity

import javax.persistence.Embedded
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Member(
    var name: String,
    @Embedded
    var address: Address?
) {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null

    companion object {
        fun of(name: String, city: String?, street: String?, zipcode: String?): Member {
            return Member(name = name, address = Address(city, street, zipcode))
        }
    }
}