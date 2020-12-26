package com.vyira.vyirasuite.recruits.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "api")
@Getter
@Setter
public class CustomProperties {
    /**
     * Defines the current version of active api
     */
    String version;
}
