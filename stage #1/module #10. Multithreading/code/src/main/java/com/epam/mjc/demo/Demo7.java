package com.epam.mjc.demo;

/**
 * Demo that shows handling for uncaught exceptions.
 */
public class Demo7 {

    public static void main(String[] args) throws InterruptedException {
        // Thread that uses default exception handing
        SimpleThread thread0 = new SimpleThread();
        thread0.start();
        thread0.join();
        System.out.println("Thread-0 finished, unhandled exception is printed to System.err by default");

        // Thread that uses custom DefaultUncaughtExceptionHandler
        SimpleThread thread1 = new SimpleThread();
        Thread.setDefaultUncaughtExceptionHandler(
                (thread, exception) -> System.out.println("Got exception " + exception + " in thread " + thread));
        thread1.start();
        thread1.join();
        System.out.println("Thread-1 finished");


        // Thread that uses custom UncaughtExceptionHandler
        SimpleThread thread2 = new SimpleThread();
        thread2.setUncaughtExceptionHandler(
                (thread, exception) -> System.out.println("Thread-2 got exception " + exception));
        thread2.start();
        thread2.join();
        System.out.println("Thread-2 finished");
    }

    static class SimpleThread extends Thread {
        public void run() {
            throw new RuntimeException(Thread.currentThread().getName() + "It is a runtime exception.");
        }
    }
}
