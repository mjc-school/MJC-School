## Error Handling for REST with Spring

https://www.baeldung.com/exception-handling-for-rest-with-spring

Spring provides several ways of handling thrown exception in a spring web application. 
Let's consider some of them: <br>

### Solution 1: the Controller-Level @ExceptionHandler
The first solution works at the `@RestController level`. We will define a method to handle exceptions and annotate that with **@ExceptionHandler**:<br>
```Java
@RestController
public class BookController 
{
    //...
    @ExceptionHandler({ CustomException1.class, CustomException2.class })
    public void handleException() {
        //
    }
}
```
This approach has a major drawback: `**The @ExceptionHandler** annotated method is only active for that particular Controller, not globally for the entire application`. 
Of course, adding this to every controller makes it not well suited for a general exception handling mechanism.
We can work around this limitation by having all Controllers extend a Base Controller class.
However, this solution can be a problem for applications where, for whatever reason, that isn't possible. 
For example, the Controllers may already extend from another base class, which may be in another jar or not directly modifiable, or may themselves not be directly modifiable.

