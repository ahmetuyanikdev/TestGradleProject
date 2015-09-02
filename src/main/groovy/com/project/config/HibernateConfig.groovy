package com.project.config

import org.apache.commons.dbcp.BasicDataSource
import org.hibernate.SessionFactory
import org.hibernate.internal.SessionFactoryImpl
import org.hibernate.metamodel.SessionFactoryBuilder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.parsing.Location
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.env.Environment
import org.springframework.core.io.Resource
import org.springframework.jdbc.datasource.DataSourceTransactionManager
import org.springframework.orm.hibernate3.LocalSessionFactoryBean
import org.springframework.orm.hibernate4.HibernateTemplate
import org.springframework.orm.hibernate4.HibernateTransactionManager
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.annotation.EnableTransactionManagement
import org.reflections.Reflections
import org.springframework.transaction.annotation.Transactional

import javax.persistence.Entity
import javax.servlet.ServletContext
import javax.sql.DataSource
import static com.project.utility.Constants.*

@Configuration
@EnableTransactionManagement
class HibernateConfig {
    @Autowired
    Environment environment

    @Bean
    DataSource dataSource(){
        BasicDataSource dataSource  = new BasicDataSource()
        dataSource.setDriverClassName(environment.getProperty(PROP_MYSQL_DRIVER))
        dataSource.setUrl(environment.getProperty(PROP_MYSQL_HOST_NAME))
        dataSource.setUsername(environment.getProperty(PROP_MYSQL_USER_NAME))
        dataSource.setPassword(environment.getProperty(PROP_MYSQL_PASSWORD))
        dataSource
    }

    private Properties hibernateProperties(){

        Properties properties = new Properties()
        properties.put("hibernate.dialect", environment.getRequiredProperty("database-platform"))
        properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"))
        properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"))
        properties
    }

    @Bean
    org.springframework.orm.hibernate4.LocalSessionFactoryBean sessionFactory(DataSource dataSource){

        org.springframework.orm.hibernate4.LocalSessionFactoryBean sessionFactory = new org.springframework.orm.hibernate4.LocalSessionFactoryBean()
        sessionFactory.setDataSource(dataSource)
        sessionFactory.setHibernateProperties(hibernateProperties())
        sessionFactory.setPackagesToScan('com.project.domain')
        sessionFactory
    }

    @Bean
    PlatformTransactionManager txManager() {
        new DataSourceTransactionManager(dataSource());
    }

    @Bean
    HibernateTemplate hibernateTemplate(SessionFactory sessionFactory){
        new HibernateTemplate(sessionFactory)
    }
}
