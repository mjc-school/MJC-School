package com.epam.mjc.demo;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Demo that shows the usage of {@linkplain ScheduledExecutorService}.
 */
public class Demo18 {

    static ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);

    public static void main(String[] args) throws InterruptedException {
        // schedule single-shot runnable
        executorService.schedule(new MyTask2(), 3, TimeUnit.SECONDS);

        // schedule runnable to execute every second
        executorService.scheduleAtFixedRate(new MyTask2(), 0, 1, TimeUnit.SECONDS);

        System.out.println("Returned from 'schedule' methods, falling asleep");
        Thread.sleep(10_000);
        executorService.shutdown();
    }
}

class MyTask2 implements Runnable {

    @Override
    public void run() {
        System.out.println("Executing single-shot runnable " + Thread.currentThread().getName());
    }
}
