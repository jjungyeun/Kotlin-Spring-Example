package com.kongtech.example.service

import com.kongtech.example.model.request.MemberCreateRequest
import com.kongtech.example.model.response.MemberResponse

interface MemberService {
    fun getMembers(): MutableList<MemberResponse>
    fun addMember(memberCreateRequest: MemberCreateRequest)
}
