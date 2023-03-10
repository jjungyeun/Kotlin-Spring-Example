package com.kongtech.example.service

import com.kongtech.example.exception.MemberNotFoundException
import com.kongtech.example.model.entity.Address
import com.kongtech.example.model.entity.Member
import com.kongtech.example.model.request.MemberCreateRequest
import com.kongtech.example.model.response.MemberResponse
import com.kongtech.example.repository.MemberRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
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

    override fun getMemberById(memberId: Long): MemberResponse {
        val member = memberRepository.findByIdOrNull(memberId)
            ?: throw MemberNotFoundException()
        return MemberResponse.of(memberId, member.name, member.address?.fullAddress())
    }

    @Transactional
    override fun addMember(memberCreateRequest: MemberCreateRequest) {
        val member = Member.of(
            memberCreateRequest.name,
            Address.of(memberCreateRequest.city, memberCreateRequest.street, memberCreateRequest.zipcode)
        )
        memberRepository.save(member)
    }


}