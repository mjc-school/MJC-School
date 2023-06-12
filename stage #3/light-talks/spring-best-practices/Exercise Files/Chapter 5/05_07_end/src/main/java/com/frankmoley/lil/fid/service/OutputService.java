package com.frankmoley.lil.fid.service;

import com.frankmoley.lil.fid.aspect.Countable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class OutputService {

    @Value("${app.name}")
    private String name;

    private final GreetingService greetingService;
    private final TimeService timeService;

    @Autowired
    public OutputService(GreetingService greetingService, TimeService timeService){
        this.greetingService = greetingService;
        this.timeService = timeService;
    }

    @Countable
    public void generateOutput(){
        String output = timeService.getCurrentTime() + " " + greetingService.getGreeting(name);
        System.out.println(output);
    }

}
