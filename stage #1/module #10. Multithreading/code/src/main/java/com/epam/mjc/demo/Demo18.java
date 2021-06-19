package com.epam.mjc.demo;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Demo that shows the usage of {@linkplain ScheduledExecutorService}.
 */
public class Demo18 {

    static ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

    public static void main(String[] args) throws InterruptedException {
        // schedule single-shot runnable
        executorService.schedule(() -> System.out.println("Executing single-shot runnable"),
                3, TimeUnit.SECONDS);
        // schedule runnable to execute every second
        executorService.scheduleAtFixedRate(() -> System.out.println("Executing repeating runnable"),
                0, 1, TimeUnit.SECONDS);

        System.out.println("Returned from 'schedule' methods, falling asleep");
        Thread.sleep(5_000);
        executorService.shutdown();
    }
}
