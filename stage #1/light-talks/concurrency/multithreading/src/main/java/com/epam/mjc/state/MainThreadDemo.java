package com.epam.mjc.state;

import java.util.concurrent.TimeUnit;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MainThreadDemo {
    public static void main(String[] args) {
        Thread t = Thread.currentThread();
        log.info("Current thread: {}", t);
        log.info("Current thread's state: {}", t.getState());
        t.setName("My Thread");
        log.info("After name changed: {}", t);
        try {
            for (int n = 3; n > 0; n--) {
                log.info("loop index {}",n);
//                TimeUnit.SECONDS.sleep(1000);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            log.error("Exception " + e);
        }
    }
}
