package com.epam.mjc.demo;

/**
 * Demo that shows some static and instance methods of {@code Thread} class.
 */
public class Demo2 {

    public static void main(String args[]) {
        Thread t = Thread.currentThread();
        System.out.println("Current thread: " + t);
        System.out.println("Current thread's state: " + t.getState());
        t.setName("My Thread");
        System.out.println("After name changed: " + t);
        try {
            for (int n = 3; n > 0; n--) {
                System.out.println(n);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.err.println("Exception " + e);
        }
    }
}
