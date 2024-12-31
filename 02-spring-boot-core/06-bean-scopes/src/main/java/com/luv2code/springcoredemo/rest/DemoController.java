package com.luv2code.springcoredemo.rest;

import com.luv2code.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // define a private field for the dependency
    private Coach myCoach;
    private Coach anotherCoach;

    private Coach tennisCoachA;
    private Coach tennisCoachB;

    @Autowired
    public DemoController(
                @Qualifier("cricketCoach") Coach theCoach,
                @Qualifier("cricketCoach") Coach theAnotherCoach,
                @Qualifier("tennisCoach") Coach theTenisA,
                @Qualifier("tennisCoach") Coach theTenisB
                ) {
        System.out.println("In constructor: " + getClass().getSimpleName());
        myCoach = theCoach;
        anotherCoach = theAnotherCoach;
        tennisCoachA = theTenisA;
        tennisCoachB = theTenisB;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }

    @GetMapping("/check")
    public String check() {
        return "Comparing beans: myCoach == anotherCoach, " + (myCoach == anotherCoach);
    }

    @GetMapping("/checkTennis")
    public String checkTennis() {
        return "Comparing beans: tennisCoachA == tennisCoachB " + (tennisCoachA == tennisCoachB);
    }
}






