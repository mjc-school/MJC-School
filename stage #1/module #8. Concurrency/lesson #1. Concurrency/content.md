
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

## Thread creation by extending the Thread class

We create a class that extends the `java.lang.Thread` class. This class overrides the `run()` method available in the Thread class. A thread begins its life inside `run()` method. We create an object of our new class and call `start()` method to start the execution of a thread. `Start()` invokes the `run()` method on the Thread object.

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
## Thread creation by implementing the Runnable Interface

We create a new class which implements `java.lang.Runnable` interface and override `run()` method. Then we instantiate a Thread object and call `start()` method on this object.

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
## Thread Class vs Runnable Interface

1. If we extend the Thread class, our class cannot extend any other class because Java doesn’t support multiple inheritance. But, if we implement the Runnable interface, our class can still extend other base classes.
2. We can achieve basic functionality of a thread by extending Thread class because it provides some inbuilt methods like `yield()`, `interrupt()` etc. that are not available in Runnable interface.
3. Using runnable will give you an object that can be shared amongst multiple threads.

## Thread creation by Callable interface

However, one feature lacking in  Runnable is that we cannot make a thread return result when it terminates, i.e. when `run()` completes. For supporting this feature, the Callable interface is present in Java.

## Callable vs Runnable

1. For implementing Runnable, the `run()` method needs to be implemented which does not return anything, while for a Callable, the `call()` method needs to be implemented which returns a result on completion. Note that a thread can’t be created with a Callable, it can only be created with a Runnable.
2. Another difference is that the `call()` method can throw an exception whereas `run()` cannot.

Method signature that has to overridden for implementing Callable.

```
public Object call() throws Exception;
```
Here is the code for an example Callable, which will return a random number after a delay of around 0 – 4 seconds.

```

// Java program to illustrate Callable
// to return a random number
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
  
class CallableExample implements Callable {
  
    public Object call() throws Exception {
        // Create random number generator
        Random generator = new Random();
  
        Integer randomNumber = generator.nextInt(5);
  
        // To simulate a heavy computation,
        // we delay the thread for some random time
        Thread.sleep(randomNumber * 1000);
  
        return randomNumber;
    }
}
```
## Future

When the `call()` method completes, answer must be stored in an object known to the main thread, so that the main thread can know about the result that the thread returned. How will the program store and obtain this result later? For this, a Future object can be used. Think of a Future as an object that holds the result – it may not hold it right now, but it will do so in the future (once the Callable returns). Thus, a Future is basically one way the main thread can keep track of the progress and result from other threads. To implement this interface, 5 methods have to be overridden, but as the example below uses a concrete implementation from the library, only the important methods are listed here.

Observe that Callable and Future do two different things – Callable is similar to Runnable, in that it encapsulates a task that is meant to run on another thread, whereas a Future is used to store a result obtained from a different thread. In fact, the Future can be made to work with Runnable as well, which is something that will become clear when Executors come into the picture.

* `public boolean cancel(boolean mayInterrupt)`: Used to stop the task. It stops the task if it has not started. If it has started, it interrupts the task only if mayInterrupt is true.
* `public Object get()`: throws InterruptedException, ExecutionException: Used to get the result of the task. If the task is complete, it returns the result immediately, otherwise it waits till the task is complete and then returns the result.
* `public boolean isDone()`: Returns true if the task is complete and false otherwise

To create the thread, a Runnable is required. To obtain the result, a Future is required.

The Java library has the concrete type FutureTask, which implements Runnable and Future, combining both functionality conveniently.
A FutureTask can be created by providing its constructor with a Callable. Then the FutureTask object is provided to the constructor of Thread to create the Thread object. Thus, indirectly, the thread is created with a Callable. For further emphasis, note that there is no way to create the thread directly with a Callable.

Here is the code for the full example using Callable and FutureTask.

```
// Java program to illustrate Callable and FutureTask
// for random number generation
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
  
class CallableExample implements Callable {
  public Object call() throws Exception  {
    Random generator = new Random();
    Integer randomNumber = generator.nextInt(5);
  
    Thread.sleep(randomNumber * 1000);
  
    return randomNumber;
  }
}
  
public class CallableFutureTestw 
* 

{
  public static void main(String[] args) throws Exception  {
  
    // FutureTask is a concrete class that
    // implements both Runnable and Future
    FutureTask[] randomNumberTasks = new FutureTask[5];
  
    for (int i = 0; i < 5; i++)    {
      Callable callable = new CallableExample();
  
      // Create the FutureTask with Callable
      randomNumberTasks[i] = new FutureTask(callable);
  
      // As it implements Runnable, create Thread
      // with FutureTask
      Thread t = new Thread(randomNumberTasks[i]);
      t.start();
    }
  
    for (int i = 0; i < 5; i++) {
      // As it implements Future, we can call get()
      System.out.println(randomNumberTasks[i].get());
  
      // This method blocks till the result is obtained
      // The get method can throw checked exceptions
      // like when it is interrupted. This is the reason
      // for adding the throws clause to main
    }
  }
}
```

## Materials
* https://highload.today/mnogopotochnost-v-java/
* https://www.w3schools.com/java/java_threads.asp
* https://www.geeksforgeeks.org/multithreading-in-java/
* https://habr.com/ru/post/164487/
* https://federicohaag.medium.com/introduction-to-concurrency-in-java-20b689a36726
* https://www.geeksforgeeks.org/callable-future-java/