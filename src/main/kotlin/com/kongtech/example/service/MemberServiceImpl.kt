package com.kongtech.example.service

import com.kongtech.example.model.response.MemberResponse
import com.kongtech.example.repository.MemberRepository
import org.springframework.stereotype.Service

@Service
class MemberServiceImpl(
    private val memberRepository: MemberRepository
) : MemberService {
    override fun getMembers(): MutableList<MemberResponse> {
        val members = memberRepository.findAll()
        val responses = mutableListOf<MemberResponse>()
        for (member in members) {
            responses.add(
                MemberResponse.of(member.id, member.name, member.address?.fullAddress())
            )
        }
        return responses
    }
}