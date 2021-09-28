# Exceptions and Method Overriding

## Lesson Agenda

+ Main conclusions
+ Exception Handling Rules in Overriding

### Main conclusions

1. If SuperClass does not declare an exception, then the SubClass can only **declare unchecked exceptions**, but not the
   checked exceptions.
2. If SuperClass declares an exception, then the SubClass can only **declare the child exceptions to the exception
   declared by the SuperClass**, but not any other exception.
3. If SuperClass declares an exception, then the SubClass can **declare without exception**.

### Exception Handling Rules in Overriding

![image](./media/CustomExceptionSyntax.png)