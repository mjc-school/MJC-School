package com.epam.mjc.state;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BlockedState {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new DemoThreadB());
        Thread t2 = new Thread(new DemoThreadB());

        t1.start();
        t2.start();

        Thread.sleep(1000);

        log.info("T1 state {}",t1.getState());
        log.info("T2 state {}",t2.getState());
        System.exit(0);
    }
}

@Slf4j
class DemoThreadB implements Runnable {
    @Override
    public void run() {
        commonResource();
    }

    public static synchronized void commonResource() {
        while(true) {
            // Infinite loop to mimic heavy processing
            // 't1' won't leave this method
            // when 't2' try to enter this
        }
    }
}
