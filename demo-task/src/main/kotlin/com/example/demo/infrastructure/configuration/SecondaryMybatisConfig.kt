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
    basePackages = [SECONDARY_MAPPER_PACKAGE],
    sqlSessionFactoryRef = SECONDARY_SESSION_FACTORY,
    sqlSessionTemplateRef = SECONDARY_SESSION_TEMPLATE
)
class SecondaryMybatisConfig {

    @Bean(SECONDARY_MYBATIS_CONFIG)
    @ConfigurationProperties(SECONDARY_MYBATIS_PROPERTIES)
    fun configuration(): MybatisConfig = MybatisConfig()

    @Bean(SECONDARY_SESSION_FACTORY)
    fun sqlSessionFactory(
        @Qualifier(SECONDARY_HIKARI_DATASOURCE) dataSource: DataSource,
        @Qualifier(SECONDARY_MYBATIS_CONFIG) configuration: MybatisConfig
    ): SqlSessionFactory? =
        SqlSessionFactoryBean().apply {
            setDataSource(dataSource)
            setConfiguration(configuration)
        }.`object`

    @Bean(SECONDARY_SESSION_TEMPLATE)
    fun sqlSessionTemplate(@Qualifier(SECONDARY_SESSION_FACTORY) sqlSessionFactory: SqlSessionFactory?): SqlSessionTemplate =
        SqlSessionTemplate(sqlSessionFactory)

    @Bean(SECONDARY_TRANSACTION_MANAGER)
    fun transactionManager(@Qualifier(SECONDARY_HIKARI_DATASOURCE) dataSource: DataSource): DataSourceTransactionManager =
        DataSourceTransactionManager(dataSource)

}
