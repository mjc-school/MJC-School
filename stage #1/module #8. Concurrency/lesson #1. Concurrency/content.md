
##  Concurrency



Multithreading is a Java feature that allows concurrent execution of two or more parts of a program for maximum utilization of CPU. Each part of such program is called a thread. So, threads are light-weight processes within a process.

**Commonly used methods of Thread class**

1. **public void run()**: is used to perform action for a thread.
2. **public void start()**: starts the execution of the thread.JVM calls the run() method on the thread.
3. **public void sleep(long miliseconds)**: Causes the currently executing thread to sleep (temporarily cease execution) for the specified number of milliseconds.
4. **public void join()**: waits for a thread to die.
5. **public void join(long miliseconds)**: waits for a thread to die for the specified miliseconds.
6. **public Thread currentThread()**: returns the reference of currently executing thread.
7. **public boolean isAlive()**: tests if the thread is alive.
8. **public void yield()**: causes the currently executing thread object to temporarily pause and allow other threads to execute.
9. **public void interrupt()**: interrupts the thread.
10. **public boolean isInterrupted()**: tests if the thread has been interrupted.
11.  **public static boolean interrupted()**: tests if the current thread has been interrupted.

**Threads can be created by using two mechanisms**
1. Extending the Thread class
2.  Implementing the Runnable Interface

**Thread creation by extending the Thread class**

We create a class that extends the java.lang.Thread class. This class overrides the run() method available in the Thread class. A thread begins its life inside run() method. We create an object of our new class and call start() method to start the execution of a thread. Start() invokes the run() method on the Thread object.

```
class MultithreadingDemo extends Thread {
    public void run()
    {
        try {
            // Displaying the thread that is running
            System.out.println(
                "Thread " + Thread.currentThread().getId()
                + " is running");
        }
        catch (Exception e) {
            // Throwing an exception
            System.out.println("Exception is caught");
        }
    }
}
 
public class Main {
    public static void main(String[] args)
    {
        int n = 8; // Number of threads
        for (int i = 0; i < n; i++) {
            MultithreadingDemo object
                = new MultithreadingDemo();
            object.start();
        }
    }
}
```
**Thread creation by implementing the Runnable Interface**

We create a new class which implements java.lang.Runnable interface and override run() method. Then we instantiate a Thread object and call start() method on this object.

```
class MultithreadingDemo implements Runnable {
    public void run()
    {
        try {
            // Displaying the thread that is running
            System.out.println(
                "Thread " + Thread.currentThread().getId()
                + " is running");
        }
        catch (Exception e) {
            // Throwing an exception
            System.out.println("Exception is caught");
        }
    }
}
 
class Main {
    public static void main(String[] args)
    {
        int n = 8; // Number of threads
        for (int i = 0; i < n; i++) {
            Thread object
                = new Thread(new MultithreadingDemo());
            object.start();
        }
    }
}
```
**Thread Class vs Runnable Interface**

1. If we extend the Thread class, our class cannot extend any other class because Java doesn’t support multiple inheritance. But, if we implement the Runnable interface, our class can still extend other base classes.
2. We can achieve basic functionality of a thread by extending Thread class because it provides some inbuilt methods like yield(), interrupt() etc. that are not available in Runnable interface.
3. Using runnable will give you an object that can be shared amongst multiple threads. 