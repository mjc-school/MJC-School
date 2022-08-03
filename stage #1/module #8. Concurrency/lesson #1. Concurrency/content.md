
# Concurrency

Multithreading is a Java feature that allows concurrent execution of two or more parts of a program for maximum utilization of CPU. Each part of such program is called a thread. So, threads are light-weight processes within a process.

## Commonly used methods of Thread class

1. `public void run()`: is used to perform action for a thread.
2. `public void start()`: starts the execution of the thread.JVM calls the run() method on the thread.
3. `public void sleep(long miliseconds)`: Causes the currently executing thread to sleep (temporarily cease execution) for the specified number of milliseconds.
4. `public void join()`: waits for a thread to die.
5. `public void join(long miliseconds)`: waits for a thread to die for the specified miliseconds.
6. `public Thread currentThread()`: returns the reference of currently executing thread.
7. `public boolean isAlive()`: tests if the thread is alive.
8. `public void yield()`: causes the currently executing thread object to temporarily pause and allow other threads to execute.
9. `public void interrupt()`: interrupts the thread.
10. `public boolean isInterrupted()`: tests if the thread has been interrupted.
11. `public static boolean interrupted()`: tests if the current thread has been interrupted.

## Threads can be created by using two mechanisms
1. Extending the Thread class
2. Implementing the Runnable Interface
3. Callable Interface

We will consider each of them below.

## Materials
* https://highload.today/mnogopotochnost-v-java/
* https://www.w3schools.com/java/java_threads.asp
* https://www.geeksforgeeks.org/multithreading-in-java/
* https://habr.com/ru/post/164487/
* https://federicohaag.medium.com/introduction-to-concurrency-in-java-20b689a36726
* https://www.geeksforgeeks.org/callable-future-java/