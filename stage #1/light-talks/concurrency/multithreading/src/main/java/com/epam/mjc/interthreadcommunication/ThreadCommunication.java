package com.epam.mjc.interthreadcommunication;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

/**
 * Solving Producer-Consumer problem using wait, notify
 */
public class ThreadCommunication {
    static final List<String> queue = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        ProducerThread producerThread = new ProducerThread();
        ConsumerThread consumerThread = new ConsumerThread();

        producerThread.start();
        consumerThread.start();

        producerThread.join();
        consumerThread.join();
    }

    @Slf4j
    static class ProducerThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                synchronized (queue) {
                    String str = "String-" + i;
                    log.info("Pushing {}", str);
                    queue.add(str);
                    queue.notifyAll();
                }
                try {
                    sleep(i % 2 == 0 ? 2000 : 1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Slf4j
    static class ConsumerThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                synchronized (queue) {
                    while (queue.isEmpty()) {
                        try {
                            log.info("Waiting...");
                            queue.wait();
                            log.info("Thread notified");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    String str = queue.remove(0);
                    log.info("Removed {}", str);


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

