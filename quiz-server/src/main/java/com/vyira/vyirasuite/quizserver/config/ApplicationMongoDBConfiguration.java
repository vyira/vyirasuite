package com.vyira.vyirasuite.quizserver.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

@Configuration
public class ApplicationMongoDBConfiguration extends AbstractMongoClientConfiguration {

    @Override
    protected String getDatabaseName() {
        return "${spring.data.mongodb.database}";
    }
}
