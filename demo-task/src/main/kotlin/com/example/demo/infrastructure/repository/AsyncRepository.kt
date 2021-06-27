package com.example.demo.infrastructure.repository

import java.time.LocalDateTime

interface AsyncRepository {

    fun registerPrimary(localDateTime: LocalDateTime)

    fun registerSecondary(localDateTime: LocalDateTime)
}