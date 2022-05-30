package com.epam.mjc.demo;

public class Playground {

    public static int COUNTER_1 = 0;

    public static int COUNTER_2 = 0;

    public static int COUNTER_3 = 0;

    private static Object lock1 = new Object();

    private static Object lock2 = new Object();

    public static void increase1() {
        synchronized (lock1) {
            COUNTER_1++;
        }

        synchronized (lock2) {
            COUNTER_2++;
        }
    }

    public static void increase2() {
        synchronized (lock1) {
            COUNTER_3++;
        }
    }

    public static void main(String[] args) throws InterruptedException {

        String s = new String("asdasd");
        s.wait();

    }
}

class MyTask implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            Playground.increase1();
        }
    }
}
