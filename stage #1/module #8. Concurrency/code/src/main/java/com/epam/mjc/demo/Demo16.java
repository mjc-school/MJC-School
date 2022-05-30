package com.epam.mjc.demo;

import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Demo that shows the purpose of concurrent collections.
 * Using usual collections without proper synchronization leads to lost updates,
 * iterating though them during modification may lead to {@linkplain ConcurrentModificationException}.
 */
public class Demo16 {

//    static Map<Integer, Integer> map = new HashMap<>();
    static Map<Integer, Integer> map = new ConcurrentHashMap<>();

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new MapPolluteThread();
        Thread thread2 = new MapPolluteThread();

        thread1.start();
        thread2.start();

        try {
            for (int j = 0; j < 5000; j++) { // execute multiple times to catch concurrent exception
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    // do nothing, just iterate
                }
            }
        } catch (ConcurrentModificationException e) {
            e.printStackTrace();
        }

        thread1.join();
        thread2.join();

        System.out.println("Map size = " + map.size());
    }

    static class MapPolluteThread extends Thread {
        public void run() {
            for (int i = 0; i < 10_000; i++) {
                int key = ThreadLocalRandom.current().nextInt();
                int value = ThreadLocalRandom.current().nextInt();
                map.put(key, value); // put a random key and value
            }
        }
    }
}
