package com.example.demo.infrastructure.configuration

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import javax.sql.DataSource

@Configuration
class PrimaryDataSourceConfig {

    @Primary
    @Bean
    @ConfigurationProperties(PRIMARY_CONFIG_PROPERTIES)
    fun hikariConfig(): HikariConfig = HikariConfig()

    @Primary
    @Bean
    fun dataSource(hikariConfig: HikariConfig?): DataSource = HikariDataSource(hikariConfig)
}
