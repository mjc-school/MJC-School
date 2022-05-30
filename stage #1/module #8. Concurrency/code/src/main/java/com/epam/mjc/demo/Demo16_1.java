package com.epam.mjc.demo;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Demo that shows the purpose of concurrent collections.
 * Using usual collections without proper synchronization leads to lost updates,
 * iterating though them during modification may lead to {@linkplain ConcurrentModificationException}.
 */
public class Demo16_1 {

//    static List<Integer> list = new ArrayList<>(10_000);
    static List<Integer> list = new CopyOnWriteArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new MapPolluteThread();
        Thread thread2 = new MapPolluteThread();

        thread1.start();
        thread2.start();

        try {
            for (int j = 0; j < 5000; j++) { // execute multiple times to catch concurrent exception
                for (Integer item : list) {
                    // do nothing, just iterate
                }
            }
        } catch (ConcurrentModificationException e) {
            e.printStackTrace();
        }

        thread1.join();
        thread2.join();

        System.out.println("Map size = " + list.size());
    }

    static class MapPolluteThread extends Thread {

        public void run() {
            for (int i = 0; i < 10_000; i++) {
                int value = ThreadLocalRandom.current().nextInt();
                list.add(i, value); // put a random value
            }
        }
    }
}
