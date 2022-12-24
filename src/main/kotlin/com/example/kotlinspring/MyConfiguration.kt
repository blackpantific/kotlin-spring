package com.example.kotlinspring

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import org.springframework.core.env.Environment
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.datasource.DriverManagerDataSource
import javax.sql.DataSource

@Configuration
@PropertySource("classpath:database.properties")
class MyConfiguration (private val environment: Environment){

    @Bean
    fun dataSource(): DataSource {
        var dataSource = DriverManagerDataSource()
        dataSource.setDriverClassName(environment.getProperty("driver")!!)
        dataSource.url = environment.getProperty("url")
        dataSource.username = environment.getProperty("username")
        dataSource.password = environment.getProperty("password")

        return dataSource
    }

    @Bean
    fun jdbcTemplate(): JdbcTemplate{
        return JdbcTemplate(dataSource())
    }
}