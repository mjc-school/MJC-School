package com.epam.mjc.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Demo that shows the usage of simple {@linkplain ExecutorService}.
 */
public class Demo17 {

    static ExecutorService executorService = Executors.newFixedThreadPool(4);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            executorService.submit(new MyTask1());
        }

        executorService.shutdown();
    }
}

class MyTask1 implements Runnable {

    @Override
    public void run() {
        System.out.println("Executing task " + Thread.currentThread().getName());
    }
}
