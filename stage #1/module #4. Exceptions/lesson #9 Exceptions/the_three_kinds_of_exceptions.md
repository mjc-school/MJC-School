# The Three Kinds of Exceptions

## Lesson Agenda
+ Checked, Unchecked Exception and Error
+ Exception Hierarchy 


### Checked, Unchecked Exception and Error
**A Checked Exception** is an exceptional condition that a well-written application should anticipate and recover from. If your code invokes a method which is defined to throw checked exception, your code MUST provide a catch handler. The compiler generates an error if the appropriate catch handler is not present.

**An Error** is an exceptional condition that is external to the application, and that the application usually cannot anticipate or recover from.

**A Runtime Exception** is an exceptional conditions that is internal to the application, and that the application usually cannot anticipate or recover from. 

**An Unchecked Exception** is the exception indicated by Errors and Runtime Exceptions.

### Exception Hierarchy
![image](./media/image4.png)

## Homework
* Solve problems: TODO -- add link to autocode?

