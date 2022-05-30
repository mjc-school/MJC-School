package com.epam.mjc.demo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Demo that shows threads synchronization through locks.
 */
public class Demo14 {

    static int counter = 0;

    static int counter1 = 0;

    static Lock lock = new ReentrantLock();
    static Lock lock1 = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        CounterThread thread1 = new CounterThread();
        CounterThread thread2 = new CounterThread();

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Safe counter is expected to be 2.000.000, actual = " + counter);
        System.out.println("Safe counter is expected to be 2.000.000, actual = " + counter1);
    }

    private static void increment() {
        lock.lock();
        try {
            counter++;
        } finally {
            lock.unlock(); // unlock should be called in finally block
        }

        lock1.lock();
        try {
            counter1++;
        } finally {
            lock1.unlock(); // unlock should be called in finally block
        }
    }

    static class CounterThread extends Thread {

        public void run() {
            for (int i = 0; i < 1_000_000; i++) {
                increment();
            }
        }
    }
}
