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
    basePackages = [PRIMARY_MAPPER_PACKAGE],
    sqlSessionFactoryRef = PRIMARY_SESSION_FACTORY,
    sqlSessionTemplateRef = PRIMARY_SESSION_TEMPLATE
)
class PrimaryMybatisConfig {

    @Primary
    @Bean
    @ConfigurationProperties(PRIMARY_MYBATIS_PROPERTIES)
    fun configuration(): MybatisConfig = MybatisConfig()

    @Primary
    @Bean(PRIMARY_SESSION_FACTORY)
    fun sqlSessionFactory(dataSource: DataSource, configuration: MybatisConfig): SqlSessionFactory? =
        SqlSessionFactoryBean().apply {
            setDataSource(dataSource)
            setConfiguration(configuration)
        }.`object`


    @Primary
    @Bean(PRIMARY_SESSION_TEMPLATE)
    fun sqlSessionTemplate(sqlSessionFactory: SqlSessionFactory?): SqlSessionTemplate =
        SqlSessionTemplate(sqlSessionFactory)


    @Primary
    @Bean
    fun dataSourceTransactionManager(dataSource: DataSource): DataSourceTransactionManager =
        DataSourceTransactionManager(dataSource)

}
