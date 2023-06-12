package com.frankmoley.lil.fid.service;

public class OutputService {

    private final GreetingService greetingService;
    private final TimeService timeService;

    public OutputService(GreetingService greetingService, TimeService timeService){
        this.greetingService = greetingService;
        this.timeService = timeService;
    }

    public void generateOutput(String name){
        String output = timeService.getCurrentTime() + " " + greetingService.getGreeting(name);
        System.out.println(output);
    }

}
