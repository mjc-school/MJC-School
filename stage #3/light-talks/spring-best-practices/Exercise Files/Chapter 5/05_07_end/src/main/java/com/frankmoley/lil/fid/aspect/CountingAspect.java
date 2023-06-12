package com.frankmoley.lil.fid.aspect;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CountingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger("LIL Application Counter");

    private static final Map<String, Integer> countingMap = new HashMap();

    @Pointcut("@annotation(Countable)")
    public void executeCounting() {
    }

    @Before("executeCounting()")
    public void incrementCount(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getDeclaringType() + "." + joinPoint.getSignature().getName();
        if (countingMap.containsKey(methodName)) {
            int current = countingMap.get(methodName);
            current++;
            countingMap.put(methodName, current);
        } else {
            countingMap.put(methodName, 1);
        }
        StringBuilder message = new StringBuilder("Current counts are: | ");
        countingMap.forEach((k, v) -> message.append(k + "::" + v + " | "));
        LOGGER.info(message.toString());
    }
}

