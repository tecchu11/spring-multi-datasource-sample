package com.example.demo.infrastructure.configuration

object DataSourceConstants {
    // primary mybatis
    internal const val PRIMARY_SESSION_TEMPLATE = "primarySqlSessionTemplate"
    internal const val PRIMARY_SESSION_FACTORY = "primarySqlSessionFactory"

    // secondary  hikari datasource
    internal const val SECONDARY_HIKARI_CONFIG = "secondaryHikariConfig"
    internal const val SECONDARY_HIKARI_DATASOURCE = "secondaryHikariDataSource"

    // secondary mybatis
    internal const val SECONDARY_MYBATIS_CONFIG = "secondaryConfiguration"
    internal const val SECONDARY_SESSION_FACTORY = "secondarySqlSessionFactory"
    internal const val SECONDARY_SESSION_TEMPLATE = "secondarySqlSessionTemplate"
    internal const val SECONDARY_TRANSACTION_MANAGER = "secondaryDataSourceTransactionManager"
}
