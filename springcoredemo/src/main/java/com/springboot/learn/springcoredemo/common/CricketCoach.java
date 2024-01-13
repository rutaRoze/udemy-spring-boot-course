package com.springboot.learn.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

    public CricketCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @PostConstruct
    public void doStuff() {
        System.out.println("In doStuff(): " + getClass().getSimpleName());
    }
    @PreDestroy
    public void doCleanupStuff() {
        System.out.println("In doCleanupStuff(): " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 min.";
    }
}
