package com.kongtech.example.model.response

import com.kongtech.example.exception.ErrorCode

class ErrorResponse private constructor(
    val detail: String,
) {
    companion object {
        fun of(errorCode: ErrorCode): ErrorResponse {
            return ErrorResponse(errorCode.message)
        }
    }
}