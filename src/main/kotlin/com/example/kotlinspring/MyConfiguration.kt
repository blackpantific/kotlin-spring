package com.example.kotlinspring

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import org.springframework.core.env.Environment
import org.springframework.jdbc.datasource.DriverManagerDataSource
import org.springframework.orm.hibernate5.HibernateTransactionManager
import org.springframework.orm.hibernate5.LocalSessionFactoryBean
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.annotation.EnableTransactionManagement
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import java.util.*
import javax.sql.DataSource


@Configuration
@PropertySource("classpath:hibernate.properties")
@EnableTransactionManagement
@EnableWebMvc
class MyConfiguration (private val environment: Environment){

    @Bean
    fun dataSource(): DataSource {
        var dataSource = DriverManagerDataSource()
        dataSource.setDriverClassName(environment.getProperty("hibernate.driver_class")!!)
        dataSource.url = environment.getProperty("hibernate.connection.url")
        dataSource.username = environment.getProperty("hibernate.connection.username")
        dataSource.password = environment.getProperty("hibernate.connection.password")

        return dataSource
    }

//    @Bean
//    fun jdbcTemplate(): JdbcTemplate{
//        return JdbcTemplate(dataSource())
//    }

    private fun hibernateProperties(): Properties? {
        val properties = Properties()
        properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"))
        properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"))
        return properties
    }

    @Bean
    fun sessionFactory(): LocalSessionFactoryBean {
        val sessionFactory = LocalSessionFactoryBean()
        sessionFactory.setDataSource(dataSource())
        sessionFactory.setPackagesToScan("com.example.kotlinspring.models")
        sessionFactory.hibernateProperties = hibernateProperties()!!
        return sessionFactory
    }

    @Bean
    fun hibernateTransactionManager(): PlatformTransactionManager? {
        val transactionManager = HibernateTransactionManager()
        transactionManager.sessionFactory = sessionFactory().getObject()
        return transactionManager
    }
}