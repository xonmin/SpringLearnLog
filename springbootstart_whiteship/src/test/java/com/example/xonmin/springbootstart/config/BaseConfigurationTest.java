package com.example.xonmin.springbootstart.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import static org.junit.jupiter.api.Assertions.*;

@Profile("test")
@Configuration
class BaseConfigurationTest {

    @Bean
    public String hello(){

        return "hello test";
    }

}