package com.epam.mjc.demo;

/**
 * Demo that shows possible problem in non-synchronized code.
 */
public class Demo8 {

    static int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        CounterThread thread1 = new CounterThread();
        CounterThread thread2 = new CounterThread();

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Counter is expected to be 2.000.000, actual = " + counter);
    }

    static class CounterThread extends Thread {
        public void run() {
            for (int i = 0; i < 1_000_000; i++) {
                counter++;
            }
        }
    }
}
