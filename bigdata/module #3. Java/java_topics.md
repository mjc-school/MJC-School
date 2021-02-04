## Java Topics
- Object, Class, ClassLoader
    - Class as a type and as a file
        - Class as a type and class as a file (.class)
        - Classes kinds (inner, outer, nested, anonymous, static and etc.)
        - Static vs Non Static Block
    - Class Loading
        - What is ClassLoader?
        - ClassLoader types and hierarchy: Bootstrap, Extensions, System, User-defined
        - Dynamic class loading
        - Exceptions during class loading
        - Class Unloading
- Collections
    - Hierarchy of collections API (internal organization of each implementation)
    - Performance of accessing/inserting/deleting data with different implementations
    - Be able to compare different collection structures (e.g. Vector vs ArrayList, HashMap vs Hashtable)
    - java.util.Arrays methods
    - java.util.Collections methods
- Serialization 
    - Serialization/Deserialization process, pros and cons
    - Serializable vs. Externalizable
    - SerialVersionUID   
- Multithreading
    - Definition of process, thread. Highlight the difference
    - Thread manager, Executor, Future, ThreadPool
    - Thread creation
    - Thread lifecycle
    - Static methods of Thread VS notify(),notifyAll(),wait()
    - How thread works with local and global variables, static and non-static methods?
    - Volatile key-word
- Concurrency
    - Concurrent collections
    - Queues
    - Synchronizers
    - Executors
    - Locks
    - Atomics
- Singleton object and ways of its creation
- JVM memory model
    - Run-Time Data Areas
    - JVM Memory spaces
    - Types of reference in Java ( Strong, Weak, Soft, Phantom)
    - GC types (Serial GC, Parallel GC, CMS GC, G1GC)

#### Links 
- [Difference between Externalizable vs Serializable in Java](https://howtodoinjava.com/java/serialization/externalizable-vs-serializable/)
- [Java Serialization API article](https://www.infoworld.com/article/2076120/flatten-your-objects.html)
- [Run-Time Data Areas for Java 8](https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-2.html#jvms-2.5)
- [Memory Management in Java](https://iq.opengenus.org/java-jvm-memory-model-memory-management/)
- [Oracle Java 8 tutorials: Concurrency](https://docs.oracle.com/javase/tutorial/essential/concurrency/index.html)
- [Java Concurrency and 29 related topics](https://datacadamia.com/lang/java/concurrency/concurrency)
- [Java 8 Concurrency Tutorial: Threads and Executors](https://winterbe.com/posts/2015/04/07/java8-concurrency-tutorial-thread-executor-examples/)
 
## Task 1 (theoretic task)

1. Complete this task to harden knowledge in class loading and static/non-statics terms :
    
BaseClass definition:

```
public class BaseClass {

  private int numBase = 90;

  {
    System.out.println("Logic block BaseClass.");
    System.out.println("numBase = " + numBase);
    System.out.println("x = " + x);
  }

  public static int x;

  static {
    System.out.println("Static BaseClass block.");
    System.out.println("x = " + x);
    x = 54;
    System.out.println("x = " + x);
  }

  public BaseClass() {
    System.out.println("BaseClass() without param.\n" + "numBase = " + numBase);
  }

  public BaseClass(final int a) {
    System.out.println("BaseClass() with param.\n" + "numBase = " + numBase);
  }
}
```
 DrivedClass definition: 
 
```
public class DrivedClass extends BaseClass {

  public static int numDerived = 777;
  private String name = "Ivan";

  {
    System.out.println("Logic block DrivedClass");
    System.out.println("name = " + name);
  }

  static{
    System.out.println("Static block DrivedClass.");
    System.out.println("numDrived = " + numDerived);
  }

  public DrivedClass() {
   System.out.println("DrivedClass() without param.\n" + "numDrived = " + numDerived 
                          + "\n name = " + name);
  }

  public DrivedClass(final int a) {
    System.out.println("DrivedClass() with param.\n");
  }
}
```
Try to say what'd be the output of the next code lines without actually running the code, 
remind all you knowledge about class loading and initialization. (5 different outputs are expected)

```
public class Main {
  public static void main(final String[] args) {
    1)  int a = BaseClass.x;

    2)  int a = BaseClass.x;
        System.out.println("a = " + a);
        int a1 = BaseClass.x;
        System.out.println("a1 = " + a1);

    3) int a = DrivedClass.numDrived;
       System.out.println("a = " + a);
       int a1 = DrivedClass.x;
       System.out.println("a1 = " + a1);

    4) int a = DrivedClass.numDerived;
       System.out.println(a);

    5) BaseClass dr1 = new DrivedClass(1);
       DrivedClass dr2 = new DrivedClass(1);
       BaseClass bc = new BaseClass(1);  
 }
}
```

