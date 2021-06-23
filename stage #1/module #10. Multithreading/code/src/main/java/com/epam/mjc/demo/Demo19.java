package com.epam.mjc.demo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Demo that shows simple usage of {@linkplain Future}.
 */
public class Demo19 {

    static ExecutorService executorService = Executors.newSingleThreadExecutor();

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Future<Integer> future = executorService.submit(new MyCallableTask());

        System.out.println("Future isDone = " + future.isDone());

        System.out.println("Going to block on future");
        Integer result = future.get();
        System.out.println("Got result from future = " + result);

        executorService.shutdown();
    }
}

class MyCallableTask implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("Doing heavy calculations");
        Thread.sleep(7000);
        System.out.println("Finished heavy calculations");
        return 1 + 2;
    }
}
