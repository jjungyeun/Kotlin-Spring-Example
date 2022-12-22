package com.kongtech.example.model.response

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
class MemberResponse(
    var id: Int,
    var name: String,
    var address: String? = ""
) {

    companion object {
        fun of(memberId: Int?, name: String?, address: String?): MemberResponse {
            return MemberResponse(memberId!!, name!!, address)
        }
    }
}
