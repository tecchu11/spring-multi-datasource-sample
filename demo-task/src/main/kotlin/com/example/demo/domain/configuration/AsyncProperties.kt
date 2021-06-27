package com.example.demo.domain.configuration

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConfigurationProperties("app.async")
@ConstructorBinding
data class AsyncProperties(
    val corePoolSize: Int,
    val maxPoolSize: Int,
    val queueCapacity: Int,
    val threadNamePrefix: String
)