package com.springboot.learn.myapp.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    // inject properties for: coach.name and team.name

    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    //  expose new endpoint for teaminfo

    @GetMapping("/teamInfo")
    public String getTeamInfo() {
        return "Coach " + coachName + ", Team name: " + teamName;
    }

    @GetMapping
    public  String sayHello() {
        return "Hello world!";
    }

    @GetMapping("/workout")
    public String getDailyWorkout() {
        return "Run 5k!";
    }

    @GetMapping("/fortune")
    public String getDailyFortune() {
        return "Lucky day!";
    }


}
