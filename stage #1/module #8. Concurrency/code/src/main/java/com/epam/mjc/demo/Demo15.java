package com.epam.mjc.demo;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Demo that shows lock-free threads synchronization through atomic variables.
 */
public class Demo15 {

    static AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        CounterThread thread1 = new CounterThread();
        CounterThread thread2 = new CounterThread();

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Safe counter is expected to be 2.000.000, actual = " + counter);
    }

    static class CounterThread extends Thread {
        public void run() {
            for (int i = 0; i < 1_000_000; i++) {
                counter.incrementAndGet();
            }
        }
    }
}
