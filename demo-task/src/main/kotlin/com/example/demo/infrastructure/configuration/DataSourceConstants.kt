package com.example.demo.infrastructure.configuration

typealias MybatisConfig = org.apache.ibatis.session.Configuration

// primary config property
internal const val PRIMARY_CONFIG_PROPERTIES = "app.datasource.primary"

// primary mybatis
internal const val PRIMARY_MYBATIS_PROPERTIES = "app.mybatis.primary"
internal const val PRIMARY_MAPPER_PACKAGE = "com.example.demo.infrastructure.mapper.primary"
internal const val PRIMARY_SESSION_TEMPLATE = "primarySqlSessionTemplate"
internal const val PRIMARY_SESSION_FACTORY = "primarySqlSessionFactory"

// secondary config property
internal const val SECONDARY_CONFIG_PROPERTIES = "app.datasource.secondary"

// secondary hikari datasource
internal const val SECONDARY_HIKARI_CONFIG = "secondaryHikariConfig"
internal const val SECONDARY_HIKARI_DATASOURCE = "secondaryHikariDataSource"

// secondary mybatis
internal const val SECONDARY_MYBATIS_PROPERTIES = "app.mybatis.secondary"
internal const val SECONDARY_MAPPER_PACKAGE = "com.example.demo.infrastructure.mapper.secondary"
internal const val SECONDARY_MYBATIS_CONFIG = "secondaryConfiguration"
internal const val SECONDARY_SESSION_FACTORY = "secondarySqlSessionFactory"
internal const val SECONDARY_SESSION_TEMPLATE = "secondarySqlSessionTemplate"
internal const val SECONDARY_TRANSACTION_MANAGER = "secondaryDataSourceTransactionManager"

