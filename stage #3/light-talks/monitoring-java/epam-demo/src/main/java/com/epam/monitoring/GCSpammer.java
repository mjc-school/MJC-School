package com.epam.monitoring;

import java.util.ArrayList;
import java.util.List;

public class GCSpammer {

    public static void main(String[] args) throws InterruptedException {
        while (true) {
            singleComputationCycle();
        }
    }

    private static void singleComputationCycle() throws InterruptedException {
        int[] i = new int[10];
        System.arraycopy();
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            strings.add("Hello world " + i);
        }
        System.out.println(strings.size());
        Thread.sleep(5_000);
    }
}
