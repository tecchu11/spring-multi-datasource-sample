package com.example.demo.domain.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor

@Configuration
class AsyncConfig(
    private val asyncProperties: AsyncProperties
) {

    @Primary
    @Bean
    fun threadPoolTaskExecutor(): ThreadPoolTaskExecutor {
        val threadPoolTaskExecutor = ThreadPoolTaskExecutor()
        threadPoolTaskExecutor.corePoolSize = asyncProperties.corePoolSize
        threadPoolTaskExecutor.maxPoolSize = asyncProperties.maxPoolSize
        threadPoolTaskExecutor.setQueueCapacity(asyncProperties.queueCapacity)
        threadPoolTaskExecutor.setThreadNamePrefix(asyncProperties.threadNamePrefix)
        return threadPoolTaskExecutor
    }
}