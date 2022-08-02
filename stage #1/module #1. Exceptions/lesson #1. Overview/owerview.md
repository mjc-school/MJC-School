# Exceptions Overview

## Agenda
+ [What is an Exception?](#what-is-an-exception)
+ [The Three Kinds of Exceptions](#the-three-kinds-of-exceptions)
+ [Materials](#materials)

## <a id="what-is-an-exception"></a> What is an Exception? 
### Throwing an exception
**An exception** is an event that occurs during the execution of a program that disrupts the normal flow of instructions.

**Throwing an exception** is the process of creating an exception object and handing it to the runtime system.

![image](./media/ExceptionExample.png)

### The call stack
**The call stack** is the ordered list of methods that had been called to get to the method where the error occurred.

![image](./media/CallStack.png)

### A stack trace
**A Stack trace** is an information on the execution history of the current thread and lists the names of the classes and methods that were called at the point when the exception occurred.

![image](./media/StackTrace.png)

##  <a id="the-three-kinds-of-exceptions"></a> The Three Kinds of Exceptions
### Checked, Unchecked Exception and Error
**A Checked Exception** is an exceptional condition that a well-written application should anticipate and recover from. If your code invokes a method which is defined to throw checked exception, your code MUST provide a catch handler. The compiler generates an error if the appropriate catch handler is not present.

**An Error** is an exceptional condition that is external to the application, and that the application usually cannot anticipate or recover from.

**A Runtime Exception** is an exceptional conditions that is internal to the application, and that the application usually cannot anticipate or recover from.

**An Unchecked Exception** is the exception indicated by Errors and Runtime Exceptions.

### Exception Hierarchy

![image](./media/Hierarchy.png)

## <a id="materials"></a> Materials
https://docs.oracle.com/javase/tutorial/essential/exceptions/index.html

https://www.geeksforgeeks.org/exceptions-in-java

https://www.javatpoint.com/exception-handling-in-java