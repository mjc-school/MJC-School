package com.epam.mjc.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Demo that shows the usage of simple {@linkplain ExecutorService}.
 */
public class Demo17 {

    static ExecutorService executorService = Executors.newFixedThreadPool(4);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1_000; i++) {
            int index = i;
            executorService.submit(() -> System.out.println("Executing task " + index));
        }
        executorService.shutdown();
    }
}
