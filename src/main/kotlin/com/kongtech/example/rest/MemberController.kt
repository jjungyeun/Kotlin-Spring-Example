package com.kongtech.example.rest

import com.kongtech.example.model.request.MemberCreateRequest
import com.kongtech.example.model.response.ApiResponse
import com.kongtech.example.model.response.MemberResponse
import com.kongtech.example.service.MemberService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/kopring-ex/members")
class MemberController(
    private val memberService: MemberService
) {
    @GetMapping
    fun getMembers(): ResponseEntity<ApiResponse<MutableList<MemberResponse>>>{
        val memberResponses: MutableList<MemberResponse> = memberService.getMembers()
        return ResponseEntity.ok(ApiResponse.ok(memberResponses))
    }

    @PostMapping
    fun addMember(@RequestBody createRequest:MemberCreateRequest): ResponseEntity<Void>{
        memberService.addMember(createRequest)
        return ResponseEntity.ok().build()
    }
}