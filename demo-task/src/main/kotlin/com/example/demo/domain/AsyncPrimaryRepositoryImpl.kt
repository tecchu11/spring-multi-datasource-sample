package com.example.demo.domain

import com.example.demo.infrastructure.repository.AsyncRepository
import com.example.demo.infrastructure.mapper.primary.PrimaryAsyncDateTimeMapper
import com.example.demo.infrastructure.mapper.secondary.SecondaryAsyncDateTimeMapper
import org.springframework.stereotype.Repository
import java.time.LocalDateTime

@Repository
class AsyncPrimaryRepositoryImpl (
    private val primaryAsyncDateTimeMapper: PrimaryAsyncDateTimeMapper,
    private val secondaryAsyncDateTimeMapper: SecondaryAsyncDateTimeMapper
) : AsyncRepository {

    override fun registerPrimary(localDateTime: LocalDateTime) {
        primaryAsyncDateTimeMapper.insert(localDateTime)
    }

    override fun registerSecondary(localDateTime: LocalDateTime) {
        secondaryAsyncDateTimeMapper.insert(localDateTime)
    }
}
