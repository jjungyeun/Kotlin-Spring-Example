package com.kongtech.example.service

import com.kongtech.example.model.response.MemberResponse

interface MemberService {
    fun getMembers(): MutableList<MemberResponse>
}
