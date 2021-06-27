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
    @ConfigurationProperties("app.datasource.primary")
    fun hikariConfig(): HikariConfig {
        return HikariConfig()
    }

    @Primary
    @Bean
    fun dataSource(hikariConfig: HikariConfig?): DataSource {
        return HikariDataSource(hikariConfig)
    }
}