package com.example.demo.infrastructure.mapper.primary

import org.apache.ibatis.annotations.Mapper
import java.time.LocalDateTime

@Mapper
interface PrimaryAsyncDateTimeMapper {

    fun insert(dateTime: LocalDateTime)
}