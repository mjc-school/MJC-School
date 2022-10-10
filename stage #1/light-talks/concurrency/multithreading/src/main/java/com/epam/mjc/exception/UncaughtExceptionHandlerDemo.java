package com.epam.mjc.exception;

import java.lang.Thread.UncaughtExceptionHandler;

import lombok.extern.slf4j.Slf4j;

public class UncaughtExceptionHandlerDemo implements Runnable{

    @Override
    public void run() {
        throw new RuntimeException("Run err...");
    }

    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler("Exception handler A"));
        new Thread(new UncaughtExceptionHandlerDemo()).start();
    }
}

/**
 * UncaughtExceptionHandler can be designed for different dimensions
 * Design an exception handler for the program
 * Each thread is designed separately
 * Design a line pool
 */
@Slf4j
class MyUncaughtExceptionHandler implements UncaughtExceptionHandler {

    private final String handlerName;

    public MyUncaughtExceptionHandler(String handlerName) {
        this.handlerName = handlerName;
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        e.printStackTrace();
        log.error("Exception caught, processor:" + this.handlerName);
        log.error("Abnormal information: threadName: {}  e: {}",  t.getName(), e);
    }

}
