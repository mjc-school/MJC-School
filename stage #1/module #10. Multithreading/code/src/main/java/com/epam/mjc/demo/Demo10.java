package com.epam.mjc.demo;

/**
 * Demo that shows usage of synchronized block.
 */
public class Demo10 {

    static int counter = 0;
    static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        CounterThread thread5 = new CounterThread();
        CounterThread thread6 = new CounterThread();

        thread5.start();
        thread6.start();

        thread5.join();
        thread6.join();

        System.out.println("Safe counter is expected to be 2.000.000, actual = " + counter);
    }

    private static void increment() {
        synchronized (lock) {
            counter++;
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
