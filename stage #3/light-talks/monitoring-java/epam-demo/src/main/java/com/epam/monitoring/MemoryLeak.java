package com.epam.monitoring;

import java.util.ArrayList;
import java.util.List;

public class MemoryLeak {

    // run with -Xmx1024m
    public static void main(String[] args) throws InterruptedException {

        List<String> strings = new ArrayList<>();
        while (true) {
            for (int i = 0; i < 50_000; i++) {
                strings.add("Hello world " + i);
            }
            System.out.println(strings.size());
            Thread.sleep(50);
        }
    }
}
