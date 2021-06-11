package com.epam.mjc.demo;

/**
 * Demo that shows how thread priority influences the amount of time thread gets from the scheduler.
 */
public class Demo4 {

    public static void main(String[] args) {
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        Clicker hi = new Clicker();
        Clicker lo = new Clicker();

        hi.setPriority(Thread.MAX_PRIORITY);
        lo.setPriority(Thread.MIN_PRIORITY);

        lo.start();
        hi.start();

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }
        lo.stopClick();
        hi.stopClick();

        try {
            hi.join();
            lo.join();
        } catch (InterruptedException e) {
            System.out.println("InterruptedException caught");
        }
        System.out.println("Low-priority thread: " + lo.click);
        System.out.println("High-priority thread: " + hi.click);
    }

    static class Clicker extends Thread {
        int click = 0;
        private volatile boolean running = true;

        public Clicker() {
        }

        public void run() {
            while (running) {
                click++;
            }
        }

        public void stopClick() {
            running = false;
        }
    }

}
