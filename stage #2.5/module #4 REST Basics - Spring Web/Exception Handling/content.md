## Error Handling for REST with Spring

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
This approach has a major drawback: **The @ExceptionHandler** `annotated method is only active for that particular Controller, not globally for the entire application`. 
Of course, adding this to every controller makes it not well suited for a general exception handling mechanism.
We can work around this limitation by having all Controllers extend a Base Controller class.
However, this solution can be a problem for applications where, for whatever reason, that isn't possible. 
For example, the Controllers may already extend from another base class, which may be in another jar or not directly modifiable, or may themselves not be directly modifiable.

### Solution 2: the HandlerExceptionResolver
This solution is to define an **HandlerExceptionResolver**. This will resolve any exception thrown by the application. It will also allow us to implement `a uniform exception handling mechanism` in our REST API.
Let's consider the existing implementations of ExceptionResolvers.

- **ExceptionHandlerExceptionResolver** is enabled by default in the `DispatcherServlet`.
- **DefaultHandlerExceptionResolver** is enabled by default in the DispatcherServlet. It's used to resolve standard Spring exceptions to their corresponding HTTP Status Codes, namely Client error 4xx and Server error 5xx status codes. Here's the full list of the Spring Exceptions it handles and how they map to status codes. 
  While it does set the Status Code of the Response properly, `one limitation is that it doesn't set anything to the body of the Response`. In some cases for a REST API — the Status Code is really not enough information to present to the Client — the response has to have a body as well, to allow the application to give additional information about the failure.
- **ResponseStatusExceptionResolver** is enabled by default in the `DispatcherServlet`. Its main responsibility is to use the **@ResponseStatus annotation** available on custom exceptions and to map these exceptions to `HTTP status codes`.
  Such a custom exception may look like:
```Java
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ApplicationResourceNotFoundException extends RuntimeException 
{
    public ApplicationResourceNotFoundException() {
        super();
    }
    public ApplicationResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    public ApplicationResourceNotFoundException(String message) {
        super(message);
    }
    public ApplicationResourceNotFoundException(Throwable cause) {
        super(cause);
    }
}
```
The same as the **DefaultHandlerExceptionResolver**, this resolver is limited in the way it deals with the body of the response — `it does map the Status Code on the response`, but does not set a body to Response, so the body is still null.
- **Custom HandlerExceptionResolver** [TO DO]

### Solution 3: @ControllerAdvice
[TO DO]

### Solution 4: ResponseStatusException
[TO DO]