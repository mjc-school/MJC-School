package com.epam.mjc.demo;

/**
 * Demo that shows an example of deadlock.
 */
public class Demo12 {

    static final Object objectA = new Object();
    static final Object objectB = new Object();

    public static void main(String[] args) throws InterruptedException {
        ThreadA threadA = new ThreadA();
        ThreadB threadB = new ThreadB();

        threadA.start();
        threadB.start();

        threadA.join();
        threadB.join();

        // Java deadlock detection:
        // > jps
        // > jstack <PID>
        System.out.println("Main thread ends");
    }

    static class ThreadA extends Thread {
        @Override
        public void run() {
            synchronized (objectA) {
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Entered objectA, going to try acquire objectB");
                synchronized (objectB) {
                    System.out.println("Entered objectA and objectB");
                }
            }
        }
    }


    static class ThreadB extends Thread {
        @Override
        public void run() {
            synchronized (objectB) {
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Entered objectB, going to try acquire objectA");
                synchronized (objectA) {
                    System.out.println("Entered objectB and objectA");
                }
            }
        }
    }


}
