package com.kongtech.example.exception

import com.kongtech.example.model.response.ErrorResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ControllerExceptionHandler {

    @ExceptionHandler
    protected fun handleCustomException(ce: CustomException): ResponseEntity<ErrorResponse> {
        return ResponseEntity
            .status(ce.errorCode.statusCode)
            .body(ErrorResponse.of(ce.errorCode))
    }
}