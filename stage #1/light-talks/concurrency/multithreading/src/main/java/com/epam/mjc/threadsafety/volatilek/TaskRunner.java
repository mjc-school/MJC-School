package com.epam.mjc.threadsafety.volatilek;

public class TaskRunner {
    public static void main(String[] args) throws InterruptedException {
        Clicker clicker = new Clicker();
        clicker.start();
        Thread.sleep(1000);
        clicker.stopClick();
        for (int i = 0; i < 5; i++) {
            System.out.println(clicker.click);
            Thread.sleep(500);
        }
    }

    static class Clicker extends Thread {

        long click = 0;

        private  boolean running = true;

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
