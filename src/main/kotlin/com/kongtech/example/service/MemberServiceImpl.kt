package com.kongtech.example.service

import com.kongtech.example.model.response.MemberResponse
import org.springframework.stereotype.Service

@Service
class MemberServiceImpl : MemberService {
    override fun getMembers(): MutableList<MemberResponse> {
        return mutableListOf<MemberResponse>(
            MemberResponse(1, "wjy", "용인시 마북로 (16911)"),
            MemberResponse(2, "kyj", "용인시 용구대로 (15432)")
        )
    }
}