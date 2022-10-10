
package com.epam.mjc.creation;

public class HelloRunnable implements Runnable {

    @Override
    public void run() {
        // do smth
        System.out.println("Hello from "+Thread.currentThread().getName()+" "
                                + "a thread created by "
                                + "implementing a Runnable Interface!");
    }
}
