# How to catch and handle exception?

## Agenda
+ Try Catch Finally syntax
+ Try-with-resources syntax
+ Materials

## Try Catch Finally syntax

![image](./media/TryCatchFinallySyntax1.png)

A __try__ block can be followed by one or more __catch__ blocks, each specifying a different type. The first catch block that handles the exception class or one of its superclasses will be executed. So, make sure to catch the most specific class first.

If an exception occurs in the __try__ block, the exception is thrown to the first __catch__ block. If not, the Java exception passes down to the second __catch__ statement. This continues until the exception either is caught or falls through all catches.

![image](./media/TryCatchFinallySyntax2.png)

![image](./media/TryCatchFinallySyntax3.png)

## Try-with-resources syntax
**The Try-with-resources statement** is a try statement that declares one or more resources. It
ensures that each resource is closed at the end of the statement. A try-with-resources
statement can have catch and finally blocks just like an ordinary try statement. In a try-with-resources statement, any catch or finally block is run after the resources declared have been
closed.

![image](./media/TryWithResources.png)

## Materials
https://docs.oracle.com/javase/tutorial/essential/exceptions/index.html

https://www.geeksforgeeks.org/exceptions-in-java

https://www.javatpoint.com/exception-handling-in-java