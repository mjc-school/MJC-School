package com.epam.mjc.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * Demo that shows usage of {@link Object#wait()} and {@link Object#notify()} methods.
 */
public class Demo11 {

    static final List<String> queue = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        ProducerThread producerThread = new ProducerThread();
        ConsumerThread consumerThread = new ConsumerThread();

        producerThread.start();
        consumerThread.start();

        producerThread.join();
        consumerThread.join();
    }

    static class ProducerThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                synchronized (queue) {
                    String str = "String-" + i;
                    System.out.println("Pushing " + str);
                    queue.add(str);
                    queue.notify();
                }
                try {
                    sleep(i % 2 == 0 ? 2000 : 1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class ConsumerThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                synchronized (queue) {
                    while (queue.isEmpty()) {
                        try {
                            System.out.println("Waiting...");
                            queue.wait();
                            System.out.println("Thread notified");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    String str = queue.remove(0);
                    System.out.println("Removed " + str);
                }
                try {
                    sleep(i % 2 == 0 ? 1500 : 2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
