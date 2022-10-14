package com.epam.mjc.priority;

import lombok.extern.slf4j.Slf4j;

/**
 * Thread with the highest priority will get an execution chance prior to other threads.
 * Suppose there are 3 threads t1, t2, and t3 with priorities 4, 6, and 1.
 * So, thread t2 will execute first based on maximum priority 6 after that t1 will execute and then t3.
 * The default priority for the main thread is always 5, it can be changed later.
 * The default priority for all other threads depends on the priority of the parent thread.
 */
@Slf4j
public class PriorityThreadDemo extends Thread {

    // Method 1
    // run() method for the thread that is called
    // as soon as start() is invoked for thread in main()
    public void run()
    {
        // Print statement
        log.info("Inside run method");
    }

    // Main driver method
    public static void main(String[] args)
    {
        // Creating random threads
        // with the help of above class
        PriorityThreadDemo t1 = new PriorityThreadDemo();
        PriorityThreadDemo t2 = new PriorityThreadDemo();
        PriorityThreadDemo t3 = new PriorityThreadDemo();

        // Thread 1
        // Display the priority of above thread
        // using getPriority() method
        log.info("t1 thread priority {}", t1.getPriority());

        // Thread 1
        // Display the priority of above thread
        log.info("t2 thread priority {} ", t2.getPriority());


        // Thread 3
        log.info("t3 thread priority {}", t3.getPriority());

        // Setting priorities of above threads by
        // passing integer arguments
        t1.setPriority(2);
        t2.setPriority(5);
        t3.setPriority(8);

        // t3.setPriority(21); will throw
        // IllegalArgumentException

        // 2
        log.info("t1 thread priority {} ", t1.getPriority());

        // 5
        log.info("t2 thread priority {} ", t2.getPriority());

        // 8
        log.info("t3 thread priority {} ", t3.getPriority());

        // Main thread

        // Displays the name of
        // currently executing Thread
        log.info("Currently Executing Thread {} ", Thread.currentThread().getName());

        log.info("Main thread priority {} ", Thread.currentThread().getPriority());

        // Main thread priority is set to 10
        Thread.currentThread().setPriority(10);

        log.info("Main thread priority {} ", Thread.currentThread().getPriority());
    }

}
