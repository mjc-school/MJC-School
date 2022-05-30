package com.epam.mjc.demo;

import java.util.concurrent.RecursiveTask;

/**
 * Demo that shows the usage of {@linkplain java.util.concurrent.ForkJoinPool} through Fibonacci numbers.
 */
public class Demo20 {

    public static void main(String[] args) throws InterruptedException {
        FibonacciRecursiveTask task = new FibonacciRecursiveTask(5);
        Integer compute = task.compute();
        System.out.println(compute);
    }

    static class FibonacciRecursiveTask extends RecursiveTask<Integer> {

        private final int index;

        FibonacciRecursiveTask(int index) {
            this.index = index;
        }

        @Override
        protected Integer compute() {
            if (index == 1 || index == 0){
                System.out.println("Task is small enough, returning value = 1");
                return 1;
            }
            System.out.println("Task " + index + " is too big, will split it into two");
            FibonacciRecursiveTask previous = new FibonacciRecursiveTask(index - 1);
            FibonacciRecursiveTask prePrevious = new FibonacciRecursiveTask(index - 2);

            previous.fork();
            prePrevious.fork();

            Integer previousValue = previous.join();
            Integer prePreviousValue = prePrevious.join();
            int result = previousValue + prePreviousValue;
            System.out.println("Task " + index + " result is " + previousValue + " + " + prePreviousValue
                    + " = " + result);
            return result;
        }
    }
}
