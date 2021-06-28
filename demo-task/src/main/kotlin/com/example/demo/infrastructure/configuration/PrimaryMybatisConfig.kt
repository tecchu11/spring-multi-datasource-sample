package com.example.demo.infrastructure.configuration

import org.apache.ibatis.session.SqlSessionFactory
import org.mybatis.spring.SqlSessionFactoryBean
import org.mybatis.spring.SqlSessionTemplate
import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.jdbc.datasource.DataSourceTransactionManager
import javax.sql.DataSource

@Configuration
@MapperScan(
    basePackages = ["com.example.demo.infrastructure.mapper.primary"],
    sqlSessionFactoryRef = DataSourceConstants.PRIMARY_SESSION_FACTORY,
    sqlSessionTemplateRef = DataSourceConstants.PRIMARY_SESSION_TEMPLATE
)
class PrimaryMybatisConfig {

    @Primary
    @Bean
    @ConfigurationProperties("app.mybatis.primary")
    fun configuration(): org.apache.ibatis.session.Configuration {
        return org.apache.ibatis.session.Configuration()
    }

    @Primary
    @Bean(DataSourceConstants.PRIMARY_SESSION_FACTORY)
    fun sqlSessionFactory(
        dataSource: DataSource,
        configuration: org.apache.ibatis.session.Configuration
    ): SqlSessionFactory? {
        val factoryBean = SqlSessionFactoryBean()
        factoryBean.setDataSource(dataSource)
        factoryBean.setConfiguration(configuration)
        return factoryBean.`object`
    }

    @Primary
    @Bean(DataSourceConstants.PRIMARY_SESSION_TEMPLATE)
    fun sqlSessionTemplate(
        sqlSessionFactory: SqlSessionFactory?
    ): SqlSessionTemplate {
        return SqlSessionTemplate(sqlSessionFactory)
    }

    @Primary
    @Bean
    fun dataSourceTransactionManager(
        dataSource: DataSource
    ): DataSourceTransactionManager {
        return DataSourceTransactionManager(dataSource)
    }
}
