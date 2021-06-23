package com.epam.mjc.demo;

/**
 * Demo that shows how to create threads extending {@code Thread} class and implementing {@code Runnable} class.
 * Difference between {@code start} and {@code run}.
 */
public class Demo1 {

    public static void main(String[] args) {
        System.out.println("Starting main");
        Talk talk = new Talk();
        System.out.println("Starting new thread");
        talk.start();
        System.out.println("Started new thread");

//        Walk walk = new Walk();
//        Thread thread = new Thread(walk);
//        System.out.println("Starting new thread");
//        thread.start();
//        System.out.println("Started new thread");
//
//         Walk w = new Walk(); // it's just an object, not a thread
//         w.run(); // this will run the method in current thread without creating new
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

    public static class Walk implements Runnable {
        public void run() {
            for (int i = 0; i < 8; i++) {
                System.out.println("Walking");
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    System.err.println(e);
                }
            }
        }
    }
}
