package com.example.demo.infrastructure.mapper.secondary

import org.apache.ibatis.annotations.Mapper
import java.time.LocalDateTime

@Mapper
interface SecondaryAsyncDateTimeMapper {

    fun insert(dateTime : LocalDateTime)
}