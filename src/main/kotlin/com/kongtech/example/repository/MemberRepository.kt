package com.kongtech.example.repository

import com.kongtech.example.model.entity.Member
import org.springframework.data.jpa.repository.JpaRepository

interface MemberRepository: JpaRepository<Member, Long> {
}