package com.epam.mjc.threadsafety.volatilek;

// Java Program to demonstrate the
// use of Volatile Keyword in Java

import lombok.extern.slf4j.Slf4j;

public class VolatileTest {
    private static volatile int MY_INT = 0;

    public static void main(String[] args)
    {
        new ChangeListener().start();
        new ChangeMaker().start();
    }


    @Slf4j
    static class ChangeListener extends Thread {
        @Override public void run()
        {
            int localValue = MY_INT;
            while (localValue < 5) {
                if (localValue != MY_INT) {
                    log.info("Got Change for MY_INT : {}", MY_INT);
                    localValue = MY_INT;
                }
            }
        }
    }

    @Slf4j
    static class ChangeMaker extends Thread {
        @Override public void run()
        {
            int localValue = MY_INT;
            while (MY_INT < 5) {
                log.info("Incrementing MY_INT to {}", localValue + 1);
                MY_INT = ++localValue;
                try {
                    Thread.sleep(500);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
