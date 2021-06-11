package com.epam.mjc.demo;

/**
 * Demo that shows usage of daemon threads.
 */
public class Demo5 {

    public static void main(String[] args) {
        System.out.println("Start main thread.");

        DaemonThread daemon = new DaemonThread();
        daemon.setDaemon(true);
        daemon.start();

        try {
            daemon.setDaemon(false);
        } catch (IllegalThreadStateException exception) {
            System.out.println("Can not call setDaemon on RUNNING thread");
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("End main thread.");
    }

    static class DaemonThread extends Thread {

        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
