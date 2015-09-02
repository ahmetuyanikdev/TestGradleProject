package com.project.config

import org.hibernate.SessionFactory
import org.hibernate.boot.registry.StandardServiceRegistryBuilder
import org.hibernate.cfg.Configuration

class SessionFactoryUtil {
    Configuration configuration

    SessionFactory getSessionFactory() {
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties())
        configuration.buildSessionFactory(builder.build())
    }
}
