package com.epam.mjc.priority;

/**
 * Demo that shows how thread priority influences the amount of time thread gets from the scheduler.
 */
public class Demo4 {

    public static void main(String[] args) {
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        Clicker hi = new Clicker();
        Clicker lo = new Clicker();

        lo.setPriority(Thread.MIN_PRIORITY);
        hi.setPriority(Thread.MAX_PRIORITY);

        lo.start();
        hi.start();


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }
        lo.stopClick();
        hi.stopClick();

        try {
            lo.join();
            hi.join();
        } catch (InterruptedException e) {
            System.out.println("InterruptedException caught");
        }
        System.out.println(lo.click + " - Low-priority thread");
        System.out.println(hi.click + " - High-priority thread");
    }

    static class Clicker extends Thread {
        int click = 0;
        private volatile boolean running = true;

        public Clicker() {
        }

        @Override
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
