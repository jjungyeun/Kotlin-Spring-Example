package com.kongtech.example.rest

import com.kongtech.example.model.request.MemberCreateRequest
import com.kongtech.example.model.response.ApiResponse
import com.kongtech.example.model.response.MemberResponse
import com.kongtech.example.service.MemberService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Tag(name = "회원")
@RestController
@RequestMapping("/kopring-ex/members")
class MemberController(
    private val memberService: MemberService
) {

    @Operation(summary = "회원 리스트 조회")
    @GetMapping
    fun getMembers(): ResponseEntity<ApiResponse<MutableList<MemberResponse>>> {
        val memberResponses: MutableList<MemberResponse> = memberService.getMembers()
        return ResponseEntity.ok(ApiResponse.ok(memberResponses))
    }

    @Operation(summary = "회원 조회")
    @GetMapping("/{memberId}")
    fun getMemberById(@PathVariable memberId: Long): ResponseEntity<ApiResponse<MemberResponse>> {
        val memberResponse: MemberResponse = memberService.getMemberById(memberId)
        return ResponseEntity.ok(ApiResponse.ok(memberResponse))
    }

    @Operation(summary = "회원 등록")
    @PostMapping
    fun addMember(@RequestBody createRequest:MemberCreateRequest): ResponseEntity<Void>{
        memberService.addMember(createRequest)
        return ResponseEntity.ok().build()
    }
}