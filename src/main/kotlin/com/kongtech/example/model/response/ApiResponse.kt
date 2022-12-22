package com.kongtech.example.model.response

import com.fasterxml.jackson.annotation.JsonInclude

class ApiResponse<T> {
    @get:JsonInclude(JsonInclude.Include.NON_NULL)
    var data: T? = null
        private set

    constructor() {}

    constructor(data: T) {
        this.data = data
    }

    companion object {

        // @JvmStatic: 컴파일러에게 해당 메소드를 static 메소드로 만들라고 하는 어노테이션
        @JvmStatic
        fun <T: Any> ok(body: T?): ApiResponse<T> {
            val apiResponse: ApiResponse<T> = ApiResponse()
            apiResponse.data = body
            return apiResponse
        }
    }
}
