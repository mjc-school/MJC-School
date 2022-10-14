package com.epam.mjc.daemon;

import lombok.extern.slf4j.Slf4j;

// Java program to demonstrate the usage of
// setDaemon() and isDaemon() method.
@Slf4j
public class DaemonThread extends Thread {
    public DaemonThread(String name){
        super(name);
    }

    @Override
    public void run() {
        // Checking whether the thread is Daemon or not
        if(Thread.currentThread().isDaemon()) {
           log.info("Daemon thread is {}", getName());
        }

        else {
            log.info("User thread is {}", getName());
        }
    }

    public static void main(String[] args) {

        DaemonThread t1 = new DaemonThread("t1");
        DaemonThread t2 = new DaemonThread("t2");
        DaemonThread t3 = new DaemonThread("t3");

        // Setting user thread t1 to Daemon
        t1.setDaemon(true);

        // starting first 2 threads
        t1.start();
        t2.start();

        log.info("isDaemon {}", t1.isDaemon());
        // Setting user thread t3 to Daemon
        t3.setDaemon(true);
        t3.start();
    }
}
