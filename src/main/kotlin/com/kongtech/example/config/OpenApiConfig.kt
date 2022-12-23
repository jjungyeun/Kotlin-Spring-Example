package com.kongtech.example.config

import io.swagger.v3.oas.models.Components
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OpenApiConfig {

    @Bean
    fun openApi(): OpenAPI {
        val info = Info()
            .title("OJT 회원-주문 서비스 API Document")
            .version("v0.0.1")
            .description("회원-주문 서비스의 API 명세서입니다.")
        return OpenAPI()
            .components(Components())
            .info(info)
    }
}