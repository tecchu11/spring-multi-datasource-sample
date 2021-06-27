package com.example.demo.infrastructure.configuration

import org.apache.ibatis.session.SqlSessionFactory
import org.mybatis.spring.SqlSessionFactoryBean
import org.mybatis.spring.SqlSessionTemplate
import org.mybatis.spring.annotation.MapperScan
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.datasource.DataSourceTransactionManager
import javax.sql.DataSource

@Configuration
@MapperScan(
    basePackages = ["com.example.demo.infrastructure.mapper.secondary"],
    sqlSessionTemplateRef = DataSourceConstants.SECONDARY_SESSION_TEMPLATE
)
class SecondaryMybatisConfig {

    @Bean(DataSourceConstants.SECONDARY_MYBATIS_CONFIG)
    @ConfigurationProperties("app.mybatis.secondary")
    fun configuration(): org.apache.ibatis.session.Configuration {
        return org.apache.ibatis.session.Configuration()
    }

    @Bean(DataSourceConstants.SECONDARY_SESSION_FACTORY)
    fun sqlSessionFactory(
        @Qualifier(DataSourceConstants.SECONDARY_HIKARI_DATASOURCE) dataSource: DataSource,
        @Qualifier(DataSourceConstants.SECONDARY_MYBATIS_CONFIG) configuration: org.apache.ibatis.session.Configuration
    ): SqlSessionFactory? {
        val sessionFactoryBean = SqlSessionFactoryBean()
        sessionFactoryBean.setDataSource(dataSource)
        sessionFactoryBean.setConfiguration(configuration)
        return sessionFactoryBean.getObject()
    }

    @Bean(DataSourceConstants.SECONDARY_SESSION_TEMPLATE)
    fun sqlSessionTemplate(
        @Qualifier(DataSourceConstants.SECONDARY_SESSION_FACTORY) sqlSessionFactory: SqlSessionFactory?
    ): SqlSessionTemplate {
        return SqlSessionTemplate(sqlSessionFactory)
    }

    @Bean(DataSourceConstants.SECONDARY_TRANSACTION_MANAGER)
    fun transactionManager(
        @Qualifier(DataSourceConstants.SECONDARY_HIKARI_DATASOURCE) dataSource: DataSource
    ): DataSourceTransactionManager {
        return DataSourceTransactionManager(dataSource)
    }
}