# Exceptions and Method Overriding

## Lesson Agenda

+ Intro
+ Main conclusions
+ Exception Handling Rules in Overriding
+ Conclusions

### Intro

**Exception Handling with Method Overriding in Java**. When a superclass method (overridden method) declares that it can
throw an exception then subclass method (overriding method) must also declare that it can throw the same kind of
exception or a sub type of that exception.

### Main conclusions

To handle the exception while you overriding a method in Java, you will have to follow three important rules. They are
as follows:

1. If an overridden method does not throw an exception using throws clause then

    + The overriding method can not throw any checked or compile-time exception.
    + The overriding method can throw any unchecked or runtime exception.

2. If an overridden method throws an unchecked or runtime exception then

    + The overriding method can throw any unchecked or runtime exception.
    + The overriding method can throw the same exception which is thrown by the overridden method.
    + The overriding method can ignore the method level exception.

3. If the superclass method throws checked or compile-time exception then

    + Subclass method can throw an exception which is a subclass of the superclass method’s exception.
    + Subclass method cannot throw the exception which is a superclass of the superclass method’s exception.
    + Subclass method can throw any unchecked or runtime exception.

Look at the below figure to understand better.

![image](./media/handlingMethod.png)

Let’s take different types of example programs based on these rules.

```java
public class Parent {
  // Overridden method is not throwing an exception. 
  void msg() {
    System.out.println("msg-Parent");
  }
}

public class Child extends Parent {
  void msg() throws IOException // Compile-time error because the overriding method is throwing a checked exception. 
  {
    System.out.println("msg-Child");
  }

  public static void main(String[] args) throws IOException {
    Parent p = new Child();
    p.msg();

    Child c = new Child();
    c.msg();
  }
}
```

```Output: 
Unresolved compilation problem: Exception IOException is not compatible with throws clause in Parent.msg()
```

In the above example program, if overriding method throws an unchecked exception, there will be no compile-time error.
Look at the program source code.

```java
public class Parent {
  // Overridden method is not throwing an exception. 
  void msg() {
    System.out.println("msg-Parent");
  }
}

public class Child extends Parent {
  void msg() throws ArithmeticException // No compile-time error because the overriding method is throwing an unchecked exception. 
  {
    System.out.println("msg-Child");
  }

  public static void main(String[] args) throws IOException {
    Parent p = new Child();
    p.msg();
    Child c = new Child();
    c.msg();
  }
}
```

```
Output: 
       msg-Child 
       msg-Child
```

In the above example program, if overriding method throws an unchecked exception, there will be no compile-time error.
Look at the program source code.

Hope that this tutorial has covered almost all important rules of exception handling with method overriding in Java with example programs

### Exception Handling Rules in Overriding

![image](./media/CustomExceptionSyntax.png)

### Conclusions

As perceived from above 3 examples in order to handle such exceptions, the following conclusions derived are as follows:

+ If SuperClass does not declare an exception, then the SubClass can only declare unchecked exceptions, but not the
  checked exceptions.
+ If SuperClass declares an exception, then the SubClass can only declare the same or child exceptions of the exception
  declared by the SuperClass and any new Runtime Exceptions, just not any new checked exceptions at the same level or
  higher.
+ If SuperClass declares an exception, then the SubClass can declare without exception.