package com.epam.mjc.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LambdaUncaughtExcHandler {
    public static void main(String[] args) throws InterruptedException {
        // Thread that uses default exception handing
        SimpleThread thread0 = new SimpleThread();
        thread0.start();
        thread0.join();
        log.info("Thread-0 finished, unhandled exception is printed to System.err by default");

        // Thread that uses custom DefaultUncaughtExceptionHandler
        SimpleThread thread1 = new SimpleThread();
        Thread.setDefaultUncaughtExceptionHandler(
                (thread, exception) -> log.error("Got exception {} in thread {}", exception, thread));
        thread1.start();
        thread1.join();
        log.info("Thread-1 finished");


        // Thread that uses custom UncaughtExceptionHandler
        SimpleThread thread2 = new SimpleThread();
        thread2.setUncaughtExceptionHandler(
                (thread, exception) -> log.error("Thread-2 got exception {}", exception));
        thread2.start();
        thread2.join();
        log.info("Thread-2 finished");
    }

    static class SimpleThread extends Thread {
        @Override
        public void run() {
            throw new RuntimeException(Thread.currentThread().getName() + "It is a runtime exception.");
        }
    }
}
