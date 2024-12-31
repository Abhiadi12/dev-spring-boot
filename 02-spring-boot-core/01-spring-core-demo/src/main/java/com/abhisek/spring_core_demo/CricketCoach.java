package com.abhisek.spring_core_demo;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach  implements  Coach {
    @Override
    public  String getDailyWorkout() {
        return "Practise cover drive for 10 mins.!!!";
    }
}
