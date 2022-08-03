# Thread creation by extending the Thread class

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

## Materials
* https://highload.today/mnogopotochnost-v-java/
* https://www.w3schools.com/java/java_threads.asp
* https://www.geeksforgeeks.org/multithreading-in-java/
* https://habr.com/ru/post/164487/
* https://federicohaag.medium.com/introduction-to-concurrency-in-java-20b689a36726
* https://www.geeksforgeeks.org/callable-future-java/