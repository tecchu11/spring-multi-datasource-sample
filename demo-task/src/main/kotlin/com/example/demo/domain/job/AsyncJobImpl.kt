package com.example.demo.domain.job

import com.example.demo.infrastructure.repository.AsyncRepository
import mu.KotlinLogging
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service
import java.time.LocalDateTime

private val log = KotlinLogging.logger {}

@Service
class AsyncJobImpl(private val asyncRepository: AsyncRepository) : AsyncJob {

    @Async
    override fun asyncRegister() {
        log.info("start async registering job")
        asyncRepository.registerPrimary(LocalDateTime.now())
        asyncRepository.registerSecondary(LocalDateTime.now())
        log.info {"end job at ${LocalDateTime.now()}"}
    }
}
