# Thread creation by implementing the Runnable Interface

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

## Materials
* https://highload.today/mnogopotochnost-v-java/
* https://www.w3schools.com/java/java_threads.asp
* https://www.geeksforgeeks.org/multithreading-in-java/
* https://habr.com/ru/post/164487/
* https://federicohaag.medium.com/introduction-to-concurrency-in-java-20b689a36726
* https://www.geeksforgeeks.org/callable-future-java/