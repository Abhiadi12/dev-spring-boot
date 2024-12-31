package com.luv2code.springcoredemo.rest;

import com.luv2code.springcoredemo.common.Coach;
import com.luv2code.util.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // define a private field for the dependency
    private Coach myCoach;
    private Car car;

    // define a constructor for dependency injection
    @Autowired
    public DemoController(Coach theCoach, Car car) {
        myCoach = theCoach;
        this.car = car;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }

    @GetMapping("/getCar")
    public  String getCarName() {
        return car.getName() + "-" + car.getPrice();
    }
}






