package com.epam.mjs;

public class DemoFinalizer {

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(3000);
        while (true) {
            new ClassWithBadFinalizer(new Integer[10000]);
            Thread.sleep(10);
        }
    }

}
