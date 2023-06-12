package com.frankmoley.lil.fid.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.frankmoley.lil.fid.aspect.Countable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TimeService {

    private static final DateTimeFormatter FORMATTER_24 = DateTimeFormatter.ofPattern("HH:mm:ss");
    private static final DateTimeFormatter FORMATTER_12 = DateTimeFormatter.ofPattern("hh:mm:ss a");

    @Value("#{new Boolean(environment['spring.profiles.active']!='dev')}")
    private boolean is24;

    public TimeService(){
        super();
    }


    @Countable
    public String getCurrentTime(){
        LocalDateTime now = LocalDateTime.now();
        if (is24) {
            return FORMATTER_24.format(now);
        }
        return FORMATTER_12.format(now);
    }

}
