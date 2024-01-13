package com.springboot.learn.springcoredemo.config;

import com.springboot.learn.springcoredemo.common.Coach;
import com.springboot.learn.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean("aquatic")
    public Coach swimCoach() {
        return new SwimCoach();
    }
}
