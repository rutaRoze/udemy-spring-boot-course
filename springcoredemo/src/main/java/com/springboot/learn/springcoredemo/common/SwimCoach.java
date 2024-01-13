package com.springboot.learn.springcoredemo.common;

public class SwimCoach implements Coach{


    // no @Component annotation on purpose
    public SwimCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Swim 1000 meters as a warm up.";
    }
}
