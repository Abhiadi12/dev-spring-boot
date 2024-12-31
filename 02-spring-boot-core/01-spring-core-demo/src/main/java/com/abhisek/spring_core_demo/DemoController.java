package com.abhisek.spring_core_demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    // define a private field for dependency
    private Coach myCoach;

    // Define a constructor for dependency injection
    // it is optional if you only have one constructor.

    @Autowired
    public  DemoController(Coach ch) {
        myCoach = ch;
    }

    @GetMapping("/")
    public String sayHello() {
        return "Hello Abhisek";
    }

    @GetMapping("/dailyworkout")
    public String getWorkoutMessage() {
        return myCoach.getDailyWorkout();
    }
}
