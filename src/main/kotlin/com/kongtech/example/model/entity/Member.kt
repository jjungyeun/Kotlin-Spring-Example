package com.kongtech.example.model.entity

import javax.persistence.*

@Entity
@Table(name = "member2")
class Member private constructor(
    var name: String,
    @Embedded
    var address: Address?
) {

    @Id @GeneratedValue
    var id: Long? = null

    companion object {
        fun of(name: String, city: String?, street: String?, zipcode: String?): Member {
            return Member(name = name, address = Address(city, street, zipcode))
        }

        fun of(name: String, address: Address?): Member{
            return Member(name = name, address = address)
        }
    }
}