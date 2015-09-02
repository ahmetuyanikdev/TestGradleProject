package com.project.config

import com.project.service.UserService
import org.codehaus.groovy.transform.AbstractASTTransformUtil
import org.hibernate.service.spi.InjectService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import org.springframework.context.annotation.PropertySource
import org.springframework.orm.hibernate4.HibernateTemplate
import org.springframework.web.servlet.config.annotation.EnableWebMvc


@Import([HibernateConfig])
@Configuration
@ComponentScan(basePackages = ["com.project.domain","com.project.controller"])
@PropertySource("classpath:app.properties")
@EnableWebMvc
class AppConfig {

    @Autowired
    HibernateTemplate hibernateTemplate

    @Bean
    UserService userService(){
        new UserService(hibernateTemplate: hibernateTemplate)
    }

}
