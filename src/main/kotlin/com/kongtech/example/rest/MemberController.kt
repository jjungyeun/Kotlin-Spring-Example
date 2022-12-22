package com.kongtech.example.rest

import com.kongtech.example.model.request.MemberCreateRequest
import com.kongtech.example.model.response.ApiResponse
import com.kongtech.example.model.response.MemberResponse
import com.kongtech.example.service.MemberService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
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
    fun getMembers(): ResponseEntity<ApiResponse<MutableList<MemberResponse>>> {
        val memberResponses: MutableList<MemberResponse> = memberService.getMembers()
        return ResponseEntity.ok(ApiResponse.ok(memberResponses))
    }

    @GetMapping("/{memberId}")
    fun getMemberById(@PathVariable memberId: Long): ResponseEntity<ApiResponse<MemberResponse>> {
        val memberResponse: MemberResponse = memberService.getMemberById(memberId)
        return ResponseEntity.ok(ApiResponse.ok(memberResponse))
    }

    @PostMapping
    fun addMember(@RequestBody createRequest:MemberCreateRequest): ResponseEntity<Void>{
        memberService.addMember(createRequest)
        return ResponseEntity.ok().build()
    }
}