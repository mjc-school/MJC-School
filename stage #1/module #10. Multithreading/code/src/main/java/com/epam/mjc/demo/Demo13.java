package com.epam.mjc.demo;

import static java.lang.Thread.sleep;

/**
 * Demo that shows possible undesired behaviour of Java Memory Model.
 */
public class Demo13 {

    public static void main(String[] args) throws InterruptedException {
        Clicker clicker = new Clicker();
        clicker.start();
        sleep(1000);
        clicker.stopClick();
        for (int i = 0; i < 5; i++) {
            System.out.println(clicker.click);
            sleep(500);
        }
    }

    static class Clicker extends Thread {

        long click = 0;

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
