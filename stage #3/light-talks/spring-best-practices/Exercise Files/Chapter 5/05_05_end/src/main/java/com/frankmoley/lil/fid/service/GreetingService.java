package com.frankmoley.lil.fid.service;

import com.frankmoley.lil.fid.aspect.Loggable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    @Value("${app.greeting}")
    private String greeting;

    public GreetingService(){
        super();
    }

    @Loggable
    public String getGreeting(String name){
        return greeting + " " + name;
    }
}
