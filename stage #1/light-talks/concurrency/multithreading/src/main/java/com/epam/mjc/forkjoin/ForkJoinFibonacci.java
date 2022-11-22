package com.epam.mjc.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

public class ForkJoinFibonacci {

    public static void main(String[] args) {

        Fibonacci task = new Fibonacci(10);
        new ForkJoinPool().invoke(task);

        System.out.println(task.getNumber());

    }

    static class Fibonacci extends RecursiveAction {

        private static final long threshold = 10;
        private volatile long number;

        public Fibonacci(long number) {
            this.number = number;
        }

        public long getNumber() {
            return number;
        }

        @Override
        protected void compute() {
            long n = number;
            if (n <= threshold) {
                number = fib(n);
            } else {
                Fibonacci f1 = new Fibonacci(n - 1);
                Fibonacci f2 = new Fibonacci(n - 2);
                ForkJoinTask.invokeAll(f1, f2);
                number = f1.number + f2.number;
            }
        }

        private static long fib(long n) {
            if (n <= 1) return n;
            else return fib(n - 1) + fib(n - 2);
        }

    }
}


