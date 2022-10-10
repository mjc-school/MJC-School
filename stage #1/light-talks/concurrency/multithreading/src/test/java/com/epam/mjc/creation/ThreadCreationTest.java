package com.epam.mjc.creation;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ThreadCreationTest {

    /**
     * How to test new thread.
     * The JUnit framework captures only assertion errors in the main thread running the test.
     * It is not aware of exceptions from within new spawn threads. In order to do it right,
     * you should communicate the thread's termination state to the main thread.
     * You should synchronize the threads correctly,
     * and use some kind of shared variable to indicate the nested thread's outcome.
     * <p>
     * ConcurrentUnit - A simple, zero-dependency toolkit for testing multithreaded code. Supports Java 1.6+.
     * Thread Weaver - is essentially a Java framework for testing multithreaded code.
     *
     */

    @Test
    void runThread() {

    }

    @Test
    void runRunnable() {
    }
}
