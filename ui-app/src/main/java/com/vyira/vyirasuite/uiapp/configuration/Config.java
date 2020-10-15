package com.vyira.vyirasuite.uiapp.configuration;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class Config extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(final HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf().disable();
    }

    public void configure(final WebSecurity webSecurity) {
        webSecurity.ignoring().antMatchers("*");
    }
}
