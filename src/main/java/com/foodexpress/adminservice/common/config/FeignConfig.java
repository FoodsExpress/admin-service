package com.foodexpress.adminservice.common.config;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

@Configuration
public class FeignConfig {

    @Bean
    public RequestInterceptor removeHeadersInterceptor() {
        return template -> {
            template.header("Content-Type", Collections.emptyList()); // 'Content-Type' 헤더 제거
        };
    }

}
