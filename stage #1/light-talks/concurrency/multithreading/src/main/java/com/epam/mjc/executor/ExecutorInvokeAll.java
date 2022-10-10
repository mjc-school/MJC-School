package com.epam.mjc.executor;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorInvokeAll {
    public static void main(String[] args) {

        ExecutorService executor = Executors.newCachedThreadPool();

        List<Callable<Integer>> listOfCallable = Arrays.asList(
                () -> 1,
                () -> 2,
                () -> 3);

        try {

            List<Future<Integer>> futures = executor.invokeAll(listOfCallable);

            int sum = futures.stream().map(f -> {
                try {
                    return f.get();
                } catch (Exception e) {
                    throw new IllegalStateException(e);
                }
            }).mapToInt(Integer::intValue).sum();

            System.out.println(sum);

        } catch (InterruptedException e) {// thread was interrupted
            e.printStackTrace();
        } finally {

            // shut down the executor manually
            executor.shutdown();

        }

    }
}
