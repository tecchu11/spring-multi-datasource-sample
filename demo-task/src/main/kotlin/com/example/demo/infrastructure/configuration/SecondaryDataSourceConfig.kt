package com.example.demo.infrastructure.configuration

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource

@Configuration
class SecondaryDataSourceConfig {

    @Bean(SECONDARY_HIKARI_CONFIG)
    @ConfigurationProperties(SECONDARY_CONFIG_PROPERTIES)
    fun hikariConfig(): HikariConfig = HikariConfig()

    @Bean(SECONDARY_HIKARI_DATASOURCE)
    fun dataSource(@Qualifier(SECONDARY_HIKARI_CONFIG) hikariConfig: HikariConfig?): DataSource =
        HikariDataSource(hikariConfig)

}
