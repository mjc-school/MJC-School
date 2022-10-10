package com.epam.mjc.state;

import java.util.concurrent.TimeUnit;

import com.epam.mjc.creation.HelloRunnable;
import lombok.extern.slf4j.Slf4j;

/**
 * Thread states -  NEW, RUNNABLE, BLOCKED, WAITING, TIMED_WAITING, TERMINATED
 */
@Slf4j
public class ThreadState {

    public static void main(String[] args) throws InterruptedException {

        // NEW
        HelloRunnable newStateRunnable = new HelloRunnable();
        Thread thread = new Thread(newStateRunnable);
        log.info("{}} state {}", thread.getName(), thread.getState());

        // RUNNABLE
        thread.start();
        log.info("{} state {}", thread.getName(), thread.getState() );

        // TERMINATED
        TimeUnit.SECONDS.sleep(1);
        log.info("{} state {}", thread.getName(), thread.getState());
    }
}
