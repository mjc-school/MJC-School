## Engineering Best-Practices part#1.

___
___
Coding best practices are a set of informal rules that 
the software development community employs to help improve
software quality.

Many computer programs remain in use for long 
periods of time so any rules need to facilitate both initial development
and subsequent maintenance and enhancement by 
people other than the original authors.

By applying the java coding best practices, it can drastically improve the quality of your code making it much more
understandable for you as well as others, flexible, reusable and maintainable. Some java best practices can even
increase the performance of code, making it significantly efficient.

### **1. Use Proper Naming Conventions**

First thing, before start writing code, 
set a proper naming convention for your Java project. Pre-decide names
for every class, interfaces, methods and variables etc. 
If other developers are also working with you on the same
project, they should also follow it to maintain the uniformity. 
A meaningful naming convention is extremely important as
everything, from classes to interfaces are identified from 
their names in the code.

Do not assign random names just to satisfy the compiler, 
use meaningful and self-explanatory names so that it is
readable and can be later understood by yourself, your 
teammates, quality assurance engineers and by staff who will be
handling maintenance of the project.

#### _Antipattern example_

```java
public class Мойкласс implements hieih47hfb {
    int huvbefbireb;
    int yj94m5w8ctc;
    double x = 8;
    List<User> jjjjj = new ArrayList<>();

    public void itcoldbegoodnameforclass() {
        System.out.println((huvbefbireb - yj94m5w8ctc) > x);
    }

    Мойкласс(int huvbefbireb, int yj94m5w8ctc, double x) {
        this.huvbefbireb = huvbefbireb;
        this.yj94m5w8ctc = yj94m5w8ctc;
        this.x = x;
    }
}
```

The code in this class is unreadable, it is impossible to understand
from variables and method names, what they are responsible for.

#### _Pattern example_

```java
    public class SubtractAndCompareService implements Calculator {
    private int minuend;
    private int subtrahend;
    private double comparisonValue;
    protected List<User> studentList = new ArrayList<>();

    SubtractAndCompareService(int minuend, int subtrahend, double comparisonValue) {
        this.minuend = minuend;
        this.subtrahend = subtrahend;
        this.comparisonValue = comparisonValue;
    }
    // getters and setters

    public void multiplyVariablesAndCompareWithComparisonValue() {
        int compareResult = minuend - subtrahend;
        System.out.println(compareResult > comparisonValue);
    }
}
```

Since this article is for Java developers, here we have mentioned some typical Java naming conventions.

- For naming classes, one should only use nouns and the names should begin with uppercase letters.

- Package names should entirely be in lowercase.

- Programmers should use as few acronyms as possible.

- Interfaces should be named while following Camel Case.

- Method names should be verbs. Also, programmers should capitalise the first letter of every word in a method name
  except the first word.

- Variable names should follow the mixed case convention (Camel Case but with the first letter not capitalised).

- All names used should be precise and relevant to the program.

___

### **2. Class Members should be private**

According to Joshua Bloch (author of Effective Java), we should minimize the accessibility of class members
(fields) as inaccessible as possible. That means we should use the lowest possible access modifier (hence the private
modifier)
to protect the fields. This practice is recommended in order to enforce information hiding or encapsulation in software
design.

#### _Antipattern example:_

Consider the following class whose fields are made public:

```java
public class Student {
    public String name;
    public int age;
}
```

The problem with this poor design is that anyone can change the values of the fields inappropriately.

```java
Student student = new Student();
student.name = "";
student.age = 2005;
```

#### _Pattern example:_

Of course we don’t want the name to be empty and the age to be unrealistic. So this practice encourages us to hide the
fields and allow the outside code to change them the through setter methods (or mutators). Here’s an example of a better
design:

```java
public class Student {

    private String name;
    private int age;

    public void setName(String name) {
        if (name == null || name.equals("")) {
            throw new IllegalArgumentException("Name is invalid");
        }
        this.name = name;
    }

    public void setAge(int age) {
        if (age < 1 || age > 100) {
            throw new IllegalArgumentException("Age is invalid");
        }

        this.age = age;
    }
}
```

As you can see, the fields _name_ and _age_
are declared to be private so the outside code cannot change them directly (information hiding). And we provide two
setter methods _setName()_ and
_setAge()_
which always check for valid arguments before actually updating the fields. This ensures the fields always get
appropriate values.
___

### **3. Never leave a Catch Blocks empty**

It is a java best practice preferred by elite developers to write a proper and meaningful message in the catch block
while exception handling. New developers often leave the catch block empty as initially they are the only ones working
on a code but when the exception is caught by the empty catch block, when the program gets an exception, it does not
show anything, making debugging harder and time-consuming.

#### _Antipattern example:_

It’s a very bad habit to leave catch blocks empty, as when the exception is caught by the empty catch block, the program
fails in silence, which makes debugging harder. Consider the following program which iterate over string list which
contain null argument:

```java
public class Print {

    void print(String s) {
        if (s == null) {
            throw new NullPointerException("Exception: s is null!");
        }
        System.out.println("Inside method print: " + s);
    }

    public static void main(String[] args) {
        Print print = new Print();
        List<String> list = Arrays.asList("first step", null, "second step");

        for (String s : list) {
            try {
                print.print(s);
            } catch (NullPointerException e) {
            } finally {
                System.out.println("Inside bloсk finally");
            }
        }

    }
}
```

Note that the catch block is empty. If we run this program it will fail silently with result:

```
Inside method print: first step
Inside bloсk finally
Inside bloсk finally
Inside method print: second step
Inside bloсk finally
```

#### _Pattern example:_

```java
public class Print {

    void print(String s) {
        if (s == null) {
            throw new NullPointerException("Exception: s is null!");
        }
        System.out.println("Inside method print: " + s);
    }

    public static void main(String[] args) {
        Print print = new Print();
        List<String> list = Arrays.asList("first step", null, "second step");

        for (String s : list) {
            try {
                print.print(s);
            } catch (NullPointerException e) {
                log.error("NullPointerException occurred while trying iterate over list: '{}'", e.getMessage());
                System.out.println("Exception was processed. Program continues");
            } finally {
                System.out.println("Inside bloсk finally");
            }
        }

    }
}
```

In pattern case exception will catched and logged, information about this will drawed in consol.

```
Inside method print: first step
Inside bloсk finally
Exception was processed. Program continues
Inside bloсk finally
Inside method print: second step
Inside bloсk finally
```

Therefore, the best practice is to avoid empty catch blocks. Generally, we should do the following things when catching
an exception:
Inform the user about the exception, e.g. tell them to re-enter inputs or show an error message. This is strongly
recommended. Log the exception using JDK Logging or Log4J. Wrap and re-throw the exception under a new exception.
Depending on the nature of the program, the code for handling exception may vary. But the rule of thumb is never “eat”
an exception by an empty catch block.
____

### **4. Avoid Redundant Initialization**

A common java coding practice that sets apart beginner programmers from veterans is how and when they initialise
variables.

Programmers fresh out of school are more used to initialising every variable in a program. And while this is a good
practice, at times, it results in redundancies when an initialised variable gets another value assigned to it without
using its initial value even once.

#### _Antipattern example:_

```java
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int initVariable = 0;

        System.out.println("Enter temperature in degree Celsius:");
        initVariable = temp.nextInt();

        int result = ((initVariable * 9) / 5) + 32;

        System.out.println("Temperature in degree Fahrenheit is: " + result);
    }
}
```

The variable _“initVariable”_ in the above code has zero has its initial value. However, it gets overwritten when the
user inputs a different number. Thus, the program never utilizes the “zero” value of variable  _“initVariable”_,
resulting in a redundant initialisation. Redundant initialisations are frowned upon as they do nothing more than
occupying memory. Hence, initialise variables only if you plan to use their initial values in the program.

#### _Pattern example:_

```java
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner temp = new Scanner(System.in);
        int initVariable = 0;

        System.out.println("Enter temperature in degree Celsius:");
        try {
          initVariable = temp.nextInt();
        } catch (InputMismatchException e) {
            log.error(e.getMessage());
            System.out.println("initVariable must have int value " + e.getMessage());
        }

        int result = ((initVariable * 9) / 5) + 32;

        System.out.println("Temperature in degree Fahrenheit is: " + result);
    }
}
```
In above case initialization of initVariable not redundant, 
because if user for instance enter the string value it 
will catch the exception and the result block will be using 
default zero value.


#### _Pattern example:_
In other case without try-catch block, 
we don't have a reasons for redundant initialization initVariable, 
and our app must look like this:
```java
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner temp = new Scanner(System.in);

    System.out.println("Enter temperature in degree Celsius:");
    int initVariable = temp.nextInt();
    int result = ((initVariable * 9) / 5) + 32;

    System.out.println("Temperature in degree Fahrenheit is: " + result);
  }
}
```
____

### **5. Use StringBuilder or StringBuffer for String Concatenation**
   
Using the “+” operator to join Strings together 
is a common practice in many programming languages including Java.

This is a common practice and not a wrong, however, 
with you need to concatenating numerous strings, the “+” 
operator proves to be inefficient as the Java compiler creates 
multiple intermediate String objects before creating the final 
concatenated string.

The java best practice, in that case, would be using “StringBuilder” 
or “StringBuffer”. These built-in functions modify a String without 
creating intermediate String objects saving processing time and 
unnecessary memory usage.

#### _Antipattern example:_
```java
public String createSQl(User user){
        String sql="Insert Into Users (name, email, pass, address)";
        sql+=" values ('"+user.getName();
        sql+="', '"+user.getEmail();
        sql+="', '"+user.getPass();
        sql+="', '"+user.getAddress();
        sql+="')";
        return sql;
}
```

This is perfectly fine since only few String objects involved. 
However, with code that involves in concatenating many Strings such as 
building a complex SQL statements or generating 
lengthy HTML text, the + operator becomes 
inefficient as the Java compiler creates many 
intermediate String objects during the concatenation process.
Therefore, the best practice recommends using StringBuilder or
StringBuffer to replace the + operator for concatenating many String objects together as they modify a String without creating intermediate String objects. StringBuilder is a non-thread safe and StringBuffer is a thread-safe version.
For example, consider the following code snippet that uses the + 
operator to build a SQL query:
#### _Pattern example:_
```java
public String createSQl(User user) {
        StringBuilder sbSql
        = new StringBuilder("Insert Into Users (name, email, pass, address)");

        sbSql.append(" values ('").append(user.getName());
        sbSql.append("', '").append(user.getEmail());
        sbSql.append("', '").append(user.getPass());
        sbSql.append("', '").append(user.getAddress());
        sbSql.append("')");

        return sbSql.toString();
}
```

______
### **6. Using Enums or Constant Class instead of Constant Interface**
It’s a very bad idea to create an interface which is solely 
for declaring some constants without any methods. Here’s such 
an interface:
#### _Antipattern example:_
```java
public interface Color {
  public static final int RED = 0xff0000;
  public static final int BLACK = 0x000000;
  public static final int WHITE = 0xffffff;
}
```
It’s because the purpose of interfaces is for inheritance
and polymorphism, not for static stuffs like that. So the best 
practice recommends us to use an enum instead. For example:
#### _Pattern example:_
```java
public enum Color {
  BLACK, WHITE, RED
}
```

In case the color code does matter, we can update the enum like this:

```java
public enum Color {

  BLACK(0x000000),
  WHITE(0xffffff),
  RED(0xff0000);

  private int code;

  Color(int code) {
    this.code = code;
  }

  public int getCode() {
    return this.code;
  }
}
```
In a complex project, we can have a class which is dedicated 
to define constants for the application. For example:
```java
public class AppConstants {
  public static final String TITLE = "Application Name";

  public static final int VERSION_MAJOR = 2;
  public static final int VERSION_MINOR = 4;

  public static final int THREAD_POOL_SIZE = 10;

  public static final int MAX_DB_CONNECTIONS = 50;

  public static final String ERROR_DIALOG_TITLE = "Error";
  public static final String WARNING_DIALOG_TITLE = "Warning";
  public static final String INFO_DIALOG_TITLE = "Information";
}
```
So the rule of thumb is: Do not use interfaces for constants, 
use enums or dedicated classes instead.

___

### **7. Using Interface References to Collections**
When declaring collection objects, references 
to the objects should be as generic as possible. 
This is to maximize the flexibility and protect the code 
from possible changes in the underlying collection implementations
class. That means we should declare collection objects using their 
interfaces List, Set, Map, Queue and Deque.

#### _Antipattern example:_
```java
public class CollectionsRef {

  private HashSet<Integer> numbers;

  public ArrayList<String> getList() {

    return new ArrayList<String>();
  }

  public void setNumbers(HashSet<Integer> numbers) {
    this.numbers = numbers;
  }
}
```
Look at the reference types which are collection implementation 
classes - this locks the code to work with only these classes 
HashSet and ArrayList. What if we want the method getList() can 
return a LinkedList and the method 
setNumbers() can accept a TreeSet?
The above class can be improved by replace the class references to
interface references like int this pattern example:
#### _Pattern example:_
```java
public class CollectionsRef {
 
    private Set<Integer> numbers;
 
    public List<String> getList() {
        // can return any kind of List
        return new ArrayList<String>();
    }
 
    public void setNumbers(Set<Integer> numbers) {
        // can accept any kind of Set
        this.numbers = numbers;
    }
}
```
### **8. Avoid using for loops with indexes**
Don’t use a for loop with an index (or counter) variable if
you can replace it with the enhanced for loop (since Java 5) 
or forEach (since Java 8). It’s because the index variable is 
error-prone, as we may alter it incidentally in the loop’s body, 
or we may starts the index from 1 instead of 0.
Consider the following antipattern example that iterates 
over an array of 
Strings:
#### _Antipattern example:_
```java
String[] names = {"Alice", "Bob", "Carol", "David", "Eric", "Frank"};
 
for (int i = 0; i < names.length; i++) {
    doSomething(names[i]);
}
```
As you can see, the index variable i in this for loop can 
be altered incidentally which may cause unexpected result. 
We can avoid 
potential problems by using an enhanced for loop like this:
#### _Pattern example:_
```java
for (String aName : names) {
    doSomething(aName);
}
```
This does not only remove potential issues but also make the code cleaner 
and more succinct.
___

### **9. Proper handling of Null Pointer Exceptions**

Java NullPointerException (NPE) is an unchecked exception
and extends RuntimeException. NullPointerException doesn’t force
us to use a try-catch block to handle it.

NullPointerException has been very much 
a nightmare for most Java developers. It usually pop 
up when we least expect them.
NullPointerException can occur anywhere 
in the code for various reasons, but it's a list of
the most frequent places where can occur NullPointerException.

 - Invoking methods on an object which is not initialized
 - Parameters passed in a method are null
 - Calling toString() method on object which is null
 - Comparing object properties in if block without checking null equality
 - Incorrect configuration for frameworks like Spring which works on dependency injection
 - Using synchronized on an object which is null
 - Chained statements i.e. multiple method calls in a single statement

 The ways to avoid NullPointerException:

 1. Use Ternary Operator
Ternary operator results in the value on the 
left-hand side if not null else right-hand side is evaluated. 
It has syntax like :
```java
boolean expression ? value1 : value2;
```
If the expression is evaluated as true then 
the entire expression returns value1 otherwise value2.

It is more like an if-else construct but it is more e
ffective and expressive. To prevent NullPointerException (NPE), 
use this operator like the below code:
```java
String str = (param == null) ? "NA" : param;
```
 2. Use Apache Commons StringUtils for String Operations
Apache Commons Lang is a collection of several utility 
classes for various kinds of operation. One of them is
StringUtils.java.

Use the following methods for better handling the strings in your code.
```java
StringUtils.isNotEmpty()
StringUtils. IsEmpty()
StringUtils.equals()
if (StringUtils.isNotEmpty(obj.getvalue())){
String s = obj.getvalue();
....
}
```
3. Fail Fast Method Arguments
We should always do the method input validation at the 
beginning of the method so that the rest of the code does 
not have to deal with the possibility of incorrect input.

Therefore if someone passes in a null as the method 
argument, things will break early in the execution lifecycle 
rather than in some deeper location where the root problem will 
be rather difficult to identify.

Aiming for fail-fast behavior is a good choice in most situations.

4. Consider Primitives instead of Objects
A null problem occurs where object references point to nothing. So it is always safe to use primitives. Consider using primitives as necessary because they do not suffer from null references.
All primitives have some default value assigned to them so be careful.


5. Carefully Consider Chained Method Calls
While chained statements are nice to look at in the code, 
they are not NPE friendly.
A single statement spread over several lines will give you the 
line number of the first line in the stack trace regardless 
of where it occurs.
```java
ref.method1().method2().method3().methods4();
```
These kind of chained statement will print only
“NullPointerException occurred in line number xyz”. 
It really is hard to debug such code. Avoid such calls if possible.

6. Use valueOf() in place of toString() 
If we have to print the string representation of any object, 
then consider not using toString() method. This is a very s
oft target for NPE.

Instead use String.valueOf(object). Even if the object is null in 
this case, it will not give an exception and will print ‘null‘ to
the output stream.

 7. Avoid Returning null from Methods
An awesome tip to avoid NPE is to return empty strings or empty 
collections rather than null. Java 8 Optionals are a great alternative
here.

Do this consistently across your application. 
You will note that a bucket load of null checks becomes unneeded
if you do so.
```java

List<string> data = null;

@SuppressWarnings("unchecked")
public List getDataDemo()
{
if(data == null)
return Collections.EMPTY_LIST; //Returns unmodifiable list
return data;
}
```
Users of the above method, even if they missed the null check, 
will not see the ugly NPE.

8. Discourage Passing of null as Method Arguments
We have seen some method declarations where the method expects 
two or more parameters. If one parameter is passed as null, 
then also method works in a different manner. Avoid this.

Instead, we should define two methods; one with a single parameter 
and the second with two parameters.

Make parameters passing mandatory. This helps a lot when 
writing application logic inside methods because you are sure that
method parameters will not be null; so you don’t put unnecessary
assumptions and assertions.

 9. Call equals() on ‘Safe’ Non-null Strings
Instead of writing the below code for string comparison

if (param.equals("check me")) {
// some code
}
write the above code like given below example. This will not cause in NPE even if param is passed as null.

if ("check me".equals(param)) {
// some code
}


____

### **10. Use of single quotes and double quotes**
We all know double quotes are used to represent strings 
and single quotes are for characters but in some unique cases, 
it can go wrong. When it is required to concatenate characters to 
make a string, it is java best practice to use double quotes for the 
characters that are about to be concatenated. The reason behind it is that if double quotes are used, the characters will be treated as a simple string and there will be no issues but if you use single quotes the integer values of the characters will be considered due to a process called widening primitive conversion.

#### _Antipattern example:_
```java
public class classA {
  public static void main(String args[]) {
    System.out.print("A" + "B");
    System.out.print('C' + 'D');
  }
}
```
Here the output should be ABCD on the screen but 
you will be seeing AB135 because AB is fine but because C and D are 
in single quotes, their ASCII values are used and added together 
due to “+” operator resulting in AB135 on screen.

#### _Pattern example:_
```java
public class classA {
  public static void main(String args[]) {
    System.out.print("A" + "B");
    System.out.print("C" + "D");
  }
}
```

_____

### **11.Avoiding Memory leaks**

1. A Memory Leak is a situation where there are objects
present in the heap that are no longer used, but the garbage 
collector is unable to remove them from memory, and therefore, 
they're unnecessarily maintained.
 A memory leak is bad because it blocks memory resources and degrades 
system performance over time. If not dealt with, the application will 
eventually exhaust its resources, finally terminating with a 
fatal java.lang.OutOfMemoryError.
There are two different types of objects that reside in Heap memory,
referenced and unreferenced. Referenced objects are those that still 
have active references within the application, whereas unreferenced 
objects don't have any active references.
The garbage collector removes unreferenced objects periodically, but 
it never collects the objects that are still being referenced.
In any application, memory leaks can occur for numerous reasons.
In this section, we'll discuss the most common ones.

#### _Antipattern example:_
```java
public class StaticTest {
  public static List<Double> list = new ArrayList<>();

  public void populateList() {
    for (int i = 0; i < 10000000; i++) {
      list.add(Math.random());
    }
    Log.info("Debug Point 2");
  }
  
  public static void main(String[] args) {
    Log.info("Debug Point 1");
    new StaticTest().populateList();
    Log.info("Debug Point 3");
  }
}
```
If we analyze the Heap memory during this program execution, then we'll
see that between debug points 1 and 2, the heap memory 
increased as expected.

But when we leave the populateList() method at the debug point 
3, the heap memory isn't yet garbage collected
However, if we just drop the keyword static in line number 2 of the above program, 
then it'll bring a drastic change to the memory usage
The first part until the debug point is almost the same as what we obtained in the case of static. But this time, after we leave the populateList() method, all the memory of the list is garbage collected because we don't have any reference to it.

So we need to pay very close attention to our usage of static variables. If collections or large objects are declared as static, then they remain in the memory throughout the lifetime of the application, thus blocking vital memory that could otherwise be used elsewhere.

>How to Prevent It?
 - Minimize the use of static variables. 
 - When using singletons, rely upon an implementation 
that lazily loads the object, instead of eagerly loading.

2. Through Unclosed Resources

Whenever we make a new connection or open a stream, the JVM allocates memory for these resources. A few examples of this include database connections, input streams, and session objects.
Forgetting to close these resources can block the memory, thus keeping them out of the reach of the GC. This can even happen in case of an exception that prevents the program execution from reaching the statement that's handling the code to close these resources.
Either way, open connections left over from resources consume memory, and if we don't deal with them, they can degrade performance and even result in an OutOfMemoryError.

>How to Prevent It?

- Always use finally block to close resources.

#### _Pattern example:_
```java
Scanner scanner = null;
        try {
        scanner = new Scanner(new File("test.txt"));
        while (scanner.hasNext()) {
        System.out.println(scanner.nextLine());
        }
        } catch (FileNotFoundException e) {
        e.printStackTrace();
        } finally {
        if (scanner != null) {
        scanner.close();
        }
}
```
- The code (even in the finally block) that closes the resources shouldn't have any exceptions itself.
When using Java 7+, we can make use of the try-with-resources block.
```java
try(Scanner scanner=new Scanner(new File("test.txt"))){
        while(scanner.hasNext()){
        System.out.println(scanner.nextLine());
        }
        }catch(FileNotFoundException e){
        e.printStackTrace();
        }
```
#### _Pattern example:_
```java
try(Scanner scanner=new Scanner(new File("test.txt"))){
        while(scanner.hasNext()){
        System.out.println(scanner.nextLine());
        }
        catch(FileNotFoundException fnfe){
        fnfe.printStackTrace();
        }
```
  3. Improper equals() and hashCode() Implementations
     When defining new classes, a very common oversight is not writing proper overridden methods for the equals() and hashCode() methods.

HashSet and HashMap use these methods in many operations, and if they're not overridden correctly, they can become a source for potential memory leak problems.

Let's take an example of a trivial Person class, and use it as a key in a HashMap:
#### _Antipattern example:_
```java
public class Person {
    public String name;
    
    public Person(String name) {
        this.name = name;
    }
}
```
Now we'll insert duplicate Person
objects into a Map that uses this key.
Remember that a Map can't contain duplicate keys:

```java
public void givenMap_whenEqualsAndHashCodeNotOverridden_thenMemoryLeak() {
    Map<Person, Integer> map = new HashMap<>();
    for(int i=0; i<100; i++) {
        map.put(new Person("jon"), 1);
    }
    Assert.assertFalse(map.size() == 1);
}
```
Here we're using Person as a key. Since Map doesn't allow duplicate keys, the numerous duplicate Person objects that we inserted as a key shouldn't increase the memory.

But since we haven't defined the proper equals() method, 
\the duplicate objects pile up and increase the memory, which is why 
we see more than one object in the memory.


However, if we'd overridden the equals() and hashCode() methods properly, then only one Person object would exist in this Map.
#### _Pattern example:_
```java
public class Person {
    public String name;
    
    public Person(String name) {
        this.name = name;
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Person)) {
            return false;
        }
        Person person = (Person) o;
        return person.name.equals(name);
    }
    
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + name.hashCode();
        return result;
    }
}
```

>How to Prevent It?
- As a rule of thumb, when defining new entities, always override the equals() and hashCode() methods.
- It's not enough to just override, these methods must be overridden in an optimal way as well.

Memory leak can occur with:
  - Inner Classes That Reference Outer Classes
    This happens in the case of non-static inner classes (anonymous classes). For initialization, these inner classes always require an instance of the enclosing class.
  Every non-static Inner Class has, by default, an implicit reference to its containing class. If we use this inner class' object in our application, then even after our containing class' object goes out of scope, it won't be garbage collected.
  - Through finalize() Methods
    Use of finalizers is yet another source of potential memory leak issues. Whenever a class' finalize() method is overridden, then objects of that class aren't instantly garbage collected. Instead, the GC queues them for finalization, which occurs at a later point in time.
  Additionally, if the code written in the finalize() method isn't optimal, and if the finalizer queue can't keep up with the Java garbage collector, then sooner or later our application is destined to meet an OutOfMemoryError.
  - Interned Strings
    The Java String pool went through a major change in Java 7 when it was transferred from PermGen to HeapSpace. However, for applications operating on version 6 and below, we need to be more attentive when working with large Strings.
  If we read a massive String object, and call intern() on that object, it goes to the string pool, which is located in PermGen (permanent memory), and will stay there as long as our application runs. This blocks the memory and creates a major memory leak in our application.
  - Using ThreadLocals
    ThreadLocal (discussed in detail in the Introduction to ThreadLocal in Java tutorial) is a construct that gives us the ability to isolate state to a particular thread, and thus allows us to achieve thread safety.
  When using this construct, each thread will hold an implicit reference to its copy of a ThreadLocal variable and will maintain its own copy, instead of sharing the resource across multiple threads, as long as the thread is alive.

___

### **12. Using Underscores in Numeric Literals**
This little update from Java 7 helps us write lengthy numeric literals 
much more readable. Consider the following declaration:

#### _Antipattern example:_
```java
int maxUploadSize = 20971520;
long accountBalance = 1000000000000L;
float pi = 3.141592653589F;
```
And compare with this pattern example:
#### _Pattern example:_
```java
int maxUploadSize = 20_971_520;
long accountBalance = 1_000_000_000_000L;
float pi = 3.141_592_653_589F;
```
Which is more readable?
So remember to use underscores in
numeric literals to improve readability of your code.
____

### **13. Get used to Logging**
It fundamentally refers to the process of generating logs for every event happening within an application during its execution.

Programmers then use these logs to trace any changes in the application code and further perform functions such as debugging the application.

Java comes with the Java Logging API out of the box. It consists of the java.util.logging package using which programmers carry out logging in a program.

To do this, they first import the java.util.logging package using the import java.util.logging.level; syntax.

Importing the java.util.logging package allows programmers to call the logger object which logs the changes occurring in the application during run time.

Logging is an essential java coding best practice that experienced
programmers exercise regularly. And as a beginner, you should also 
incorporate it into your programming routine.

By following good practices you will get more value out of 
your logs and make it easier to use them. You will be able to more easily 
pinpoint the root cause of errors and poor 
performance and solve problems before they impact end-users
____

### **14. Write Relatable Code Comments**
Commenting is an integral part of any programming language. 
Good programmers tend to comment as they go while writing the code.

Most of the time, when you write code, you will need to go back
and make changes later. Without Java comments, it's easy to get lost.

This is why I specifically make sure to make comments as I write code.
Not only does it help me keep track of the code as it grows 
more complicated, but it also makes the code more understandable
for anyone that needs to reference the code at a later date.

Comments in Java are the statements in the Java code that 
are not executed when the program is run. Think of them as markers 
that guide the reader.

Said differently, comments provide information about the code
without changing the code's functionality. 
Some programmers can also use it to disable certain portions of 
code during development.


 - Remember that comments are not subtitles and therefore, your comments 
shouldn't translate each line of code into human language. Said differently, comments are supposed to support the code so that when you or anybody comes back to it, they can make sense of it. Explaining the code in detail will only look silly and also make your code bulky.

#### _Antipattern example:_
```java
//create int variable
int a = 7;
//create int variable
int b = 8;
//create double variable
double c = 8;
```

 - Do not just repeat what you code is able to explain clearly. 
There are certain commands that are clear enough and do not 
need explanation. As an example, the following comment is unecessary:
#### _Antipattern example:_
```java
System.out.println("Hello World!"); 
//prints Hello World! to 
// console.
```
To reiterate, the above code is simple and clear. 
The comment in it is redundant and not required.

- Smelly comments need to be avoided at all cost. 
When you try to explain a code in detail to make sure the reader 
is not confused, it's a signal that something is wrong with your code.
No comment can fix that.

- Write your comments as you go and do not make it a habit of going back and commenting after code completion.
- Keep the comments short and precise.
- When you place comments inline, make sure they are separated from the main code with at least two spaces.
_____
### **15. Singleton Pattern**

Java Singleton Pattern is one of the Gangs of Four Design patterns
and comes in the Creational Design Pattern category. 
From the definition, it seems to be a very simple design 
pattern but when it comes to implementation, it comes with 
a lot of implementation concerns. The implementation of 
Java Singleton pattern has always been a controversial
topic among developers. Here we will learn about Singleton 
design pattern principles, different ways to implement the 
Singleton design pattern and some of the best practices for its usage.

 - Singleton pattern restricts the instantiation of a class and ensures that only one instance of the class exists in the java virtual machine.
 - The singleton class must provide a global access point to get the instance of the class.
 - Singleton pattern is used for logging, drivers objects, caching and thread pool.
 - Singleton design pattern is also used in other design patterns like Abstract Factory, Builder, Prototype, Facade etc.
 - Singleton design pattern is used in core java classes also, for example java.lang.Runtime, java.awt.Desktop.

To implement a Singleton pattern, we have different approaches but all of them have the following common concepts.

- Private constructor to restrict instantiation of the class from other classes.
- Private static variable of the same class that is the only instance of the class.
- Public static method that returns the instance of the class, this is the global access point 
for outer world to get the instance of the singleton class.

In further sections, we will learn different approaches o
Singleton pattern implementation and design concerns with
the implementation.

1. *Eager initialization*

In eager initialization, the instance of Singleton Class is
created at the time of class loading, this is the easiest method
to create a singleton class but it has a drawback that instance
is created even though client application might not be using it. 
Here is the implementation of the static initialization singleton 
class.
```java
public class EagerInitializedSingleton {
    
    private static final EagerInitializedSingleton instance = new EagerInitializedSingleton();
    
    //private constructor to avoid client applications to use constructor
    private EagerInitializedSingleton(){}

    public static EagerInitializedSingleton getInstance(){
        return instance;
    }
}
```
If your singleton class is not using a lot of resources, 
this is the approach to use. But in most of the scenarios,
Singleton classes are created for resources such as File System
, Database connections, etc. We should avoid the instantiation until
unless client calls the getInstance method. Also,
this method doesn’t provide any options for exception handling.

 2. *Static block initialization*
 
 Static block initialization implementation is similar 
to eager initialization, except that instance of class is created
 in the static block that provides option for exception handling.
```java
public class StaticBlockSingleton {

    private static StaticBlockSingleton instance;
    
    private StaticBlockSingleton(){}
    
    //static block initialization for exception handling
    static{
        try{
            instance = new StaticBlockSingleton();
        }catch(Exception e){
            throw new RuntimeException("Exception occured in creating singleton instance");
        }
    }
    
    public static StaticBlockSingleton getInstance(){
        return instance;
    }
}
```
Both eager initialization and static block initialization 
creates the instance even before it’s being used and that
is not the best practice to use. So in further sections, we wil
l learn how to create a Singleton class that supports lazy
initialization. 

 3. *Lazy Initialization*

   Lazy initialization method to implement Singleton pattern creates the
   instance in the global access method. Here is the sample code
   for creating Singleton class with this approach.

```java
public class LazyInitializedSingleton {

    private static LazyInitializedSingleton instance;
    
    private LazyInitializedSingleton(){}
    
    public static LazyInitializedSingleton getInstance(){
        if(instance == null){
            instance = new LazyInitializedSingleton();
        }
        return instance;
    }
}
```

The above implementation works fine in case of the single-threaded
environment but when it comes to multithreaded systems, it can 
cause issues if multiple threads are inside the if condition at 
the same time. It will destroy the singleton pattern and both 
threads will get the different instances of the singleton class. 
In next section, we will see different ways to create a thread-safe 
singleton class.

 4. *Thread Safe Singleton*
  
The easier way to create a thread-safe singleton class is to make
the global access method synchronized, so that only one thread can 
execute this method at a time. General implementation of this
approach is like the below class.
```java
public class ThreadSafeSingleton {

    private static volatile ThreadSafeSingleton instance;
    
    private ThreadSafeSingleton(){}
    
    public static synchronized ThreadSafeSingleton getInstance(){
        if(instance == null){
            instance = new ThreadSafeSingleton();
        }
        return instance;
    }
    
}
```
Above implementation works fine and provides thread-safety but it reduces the performance because of the cost associated with the synchronized method, although we need it only for the first few threads who might create the separate instances (Read: Java Synchronization). 
To avoid this extra overhead every time,
double checked locking principle is used. 
In this approach, the synchronized block is used inside
the if condition with an additional check to ensure that only 
one instance of a singleton class is created. The following code 
snippet provides the double-checked locking implementation.
```java
public static ThreadSafeSingleton getInstanceUsingDoubleLocking(){
    if(instance == null){
        synchronized (ThreadSafeSingleton.class) {
            if(instance == null){
                instance = new ThreadSafeSingleton();
            }
        }
    }
    return instance;
}
```

5. *Bill Pugh Singleton Implementation*

Prior to Java 5, java memory model had a lot of issues and the above
approaches used to fail in certain scenarios where too many threads
try to get the instance of the Singleton class simultaneously. 
So Bill Pugh came up with a different approach to create the
Singleton class using an inner static helper class.
The Bill Pugh Singleton implementation goes like this;
```java
public class BillPughSingleton {

    private BillPughSingleton(){}
    
    private static class SingletonHelper{
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }
    
    public static BillPughSingleton getInstance(){
        return SingletonHelper.INSTANCE;
    }
}
```
Notice the private inner static class that contains 
the instance of the singleton class. When the singleton class is
loaded, SingletonHelper class is not loaded into memory and only 
when someone calls the getInstance method, this class gets loaded
and creates the Singleton class instance. This is the most widely
used approach for Singleton class as it doesn’t require
synchronization. I am using this approach in many of my projects and
it’s easy to understand and implement also. Read: Java Nested Classes

6. *Using Reflection to destroy Singleton Pattern*

Reflection can be used to destroy all the above singleton 
implementation approaches. Let’s see this with an example class.
```java
public class ReflectionSingletonTest {

    public static void main(String[] args) {
        EagerInitializedSingleton instanceOne = EagerInitializedSingleton.getInstance();
        EagerInitializedSingleton instanceTwo = null;
        try {
            Constructor[] constructors = EagerInitializedSingleton.class.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                //Below code will destroy the singleton pattern
                constructor.setAccessible(true);
                instanceTwo = (EagerInitializedSingleton) constructor.newInstance();
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(instanceOne.hashCode());
        System.out.println(instanceTwo.hashCode());
    }

}
```
When you run the above test class, you will notice that hashCode 
f both the instances is not same that destroys the singleton pattern.
Reflection is very powerful and used in a lot of frameworks 
like Spring and Hibernate.

7. *Enum Singleton*

To overcome this situation with Reflection,
Joshua Bloch suggests the use of Enum to implement 
Singleton design pattern as Java ensures that any enum value
is instantiated only once in a Java program. Since Java Enum 
values are globally accessible, so is the singleton. 
The drawback is that the enum type is somewhat inflexible; 
for example, it does not allow lazy initialization.
```java
public enum EnumSingleton {

    INSTANCE;
    
    public static void doSomething(){
        //do something
    }
}
```
8. *Serialization and Singleton*

Sometimes in distributed systems, we need to implement Serializable 
interface in Singleton class so that we can store its state in the
file system and retrieve it at a later point of time.
Here is a small singleton class that implements Serializable 
interface also.
```java
public class SerializedSingleton implements Serializable{

    private static final long serialVersionUID = -7604766932017737115L;

    private SerializedSingleton(){}
    
    private static class SingletonHelper{
        private static final SerializedSingleton instance = new SerializedSingleton();
    }
    
    public static SerializedSingleton getInstance(){
        return SingletonHelper.instance;
    }
    
}
```
The problem with serialized singleton class is
that whenever we deserialize it, it will create a new instance 
of the class.

