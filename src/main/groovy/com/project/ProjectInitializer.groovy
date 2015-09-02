package com.project

import com.project.utility.Constants
import groovy.util.logging.Slf4j
import org.springframework.context.ApplicationContextInitializer
import org.springframework.core.env.ConfigurableEnvironment
import org.springframework.core.env.PropertiesPropertySource
import org.springframework.core.io.ClassPathResource
import org.springframework.core.io.support.PropertiesLoaderUtils
import org.springframework.web.context.ConfigurableWebApplicationContext
import static com.project.utility.Constants.*
@Slf4j
class ProjectInitializer implements ApplicationContextInitializer<ConfigurableWebApplicationContext> {

    @Override
    void initialize(ConfigurableWebApplicationContext applicationContext) {
        ConfigurableEnvironment environment = applicationContext.getEnvironment()

        String env = environment.getProperty(Constants.ENV)
        if (!env)
            throw new IllegalStateException("Couldn't find ENV environment variable")

        log.info("environment is ${env}")

        prepareEnvironment(env, environment)
    }

    void prepareEnvironment(String env, ConfigurableEnvironment environment) {

        def properties = getMergedProperties(env, "app")
        properties.put(Constants.ENV, env)
        environment.getPropertySources().addFirst(new PropertiesPropertySource("appProperties", properties))
    }


    private Properties getMergedProperties(String env, String propertyGroup) {

        String location = "${propertyGroup}.properties"
        getProperties(location)
    }

    private Properties getProperties(String location) {
        def resource = new ClassPathResource(location)
        if (resource.exists())
            PropertiesLoaderUtils.loadProperties(resource)
        else
            new Properties()
    }


}
