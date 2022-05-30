package com.epam.mjc.demo;

/**
 * Demo that shows the usage of {@code join} method and how thread states change during it's lifetime.
 */
public class Demo3 {

    public static void main(String[] args) {
        System.out.println("Starting main");
        Talk talk = new Talk();

        System.out.println("Another thread's state " + talk.getState());
        System.out.println("Starting new thread");
        talk.start();
        System.out.println("Another thread's state " + talk.getState());
        System.out.println("Started new thread");
        try {
            System.out.println("Waiting for another thread to finish");
            talk.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Another thread finished");
        System.out.println("Another thread's state " + talk.getState());
    }

    public static class Talk extends Thread {
        public void run() {
            for (int i = 0; i < 8; i++) {
                System.out.println("Talking");
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    System.err.print(e);
                }
            }
        }
    }
}
