package com.epam.mjc.threadsafety.synchronizedk;

public class SynchronizedCounter {
    public static void main(String[] args)
            throws InterruptedException
    {
        // Instance of Counter Class
        Counter c = new Counter();

        // Defining Two different threads
        Thread first = new Thread(c, "First");
        Thread second = new Thread(c, "Second");

        // Threads start executing
        first.start();
        second.start();

        // main thread will wait for both
        // threads to complete execution
        first.join();
        second.join();

        // Printing final value of count variable
        System.out.println(c.count);
    }
}

class Counter extends Thread {

    // Counter Variable
    int count = 0;

    @Override
    public synchronized void run()
    {

        int max = 1_000_000;

        // incrementing counter total of max times
        for (int i = 0; i < max; i++) {
            count++;
        }
    }
}
