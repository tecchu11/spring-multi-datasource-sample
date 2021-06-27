package com.example.demo.application.task

import com.example.demo.domain.job.AsyncJob
import mu.KotlinLogging
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

private val log = KotlinLogging.logger {  }

@Component
class ScheduledTasks(
    private val asyncJob: AsyncJob
) {

    @Scheduled(fixedRate = 1000)
    fun scheduledAsyncTask() {
        log.info("Start scheduled job")
        asyncJob.asyncRegister()
        log.info("Finish scheduled job")
    }
}
