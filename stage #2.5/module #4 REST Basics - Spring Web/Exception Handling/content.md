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
Spring brings support for a global **@ExceptionHandler** with the **@ControllerAdvice** annotation.
This enables a mechanism that breaks away from the older MVC model and makes use of ResponseEntity along 
with the type safety and flexibility of **@ExceptionHandler**:
```Java
@ControllerAdvice
public class RestResponseEntityExceptionHandler 
  extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value 
      = { IllegalArgumentException.class, IllegalStateException.class })
    protected ResponseEntity<Object> handleConflict(
      RuntimeException ex, WebRequest request) {
        String bodyOfErrorResponse = "Argument or State of resource hase a illegal value.";
        return handleExceptionInternal(ex, bodyOfResponse, 
          new HttpHeaders(), HttpStatus.CONFLICT, request);
    }
}
```
The **@ControllerAdvice** annotation allows us to **consolidate our multiple, scattered @ExceptionHandlers from before into a single, global error handling component**.
The actual mechanism is extremely simple but also very flexible:
- It gives us full control over the body of the response as well as the status code.
- It provides mapping of several exceptions to the same method, to be handled together.
- It makes good use of the newer RESTful ResposeEntity response.
One thing to keep in mind here is to match the exceptions declared with @ExceptionHandler to the exception used as the argument of the method.
If these don't match, the compiler will not complain — no reason it should — and Spring will not complain either.
However, when the exception is actually thrown at runtime, **the exception resolving mechanism will fail with**:
```Java
java.lang.IllegalStateException: No suitable resolver for argument [0] [type=...]
HandlerMethod details: ...
```
### Solution 4: ResponseStatusException
Spring 5 provides introduced the **ResponseStatusException** class.
We can create an instance of it providing an HttpStatus and optionally a reason and a cause:
```Java
@GetMapping(value = "/{id}")
public Book findById(@PathVariable("id") Long id, HttpServletResponse response) {
    try {
        Book book = RestPreconditions.checkFound(service.findOne(id));
        return book;
     }
    catch (CustomResourceNotFoundException exc) {
         throw new ResponseStatusException(
           HttpStatus.NOT_FOUND, "Book Not Found", exc);
    }
}
```
What are the benefits of using **ResponseStatusException**?
- Excellent for prototyping: We can implement a basic solution quite fast.
- One type, multiple status codes: One exception type can lead to multiple different responses. This reduces tight coupling compared to the **@ExceptionHandler**.
- We won't have to create as many custom exception classes.
- We have more control over exception handling since the exceptions can be created programmatically.

what are the tradeoffs?
- There's no unified way of exception handling: It's more difficult to enforce some application-wide conventions as opposed to **@ControllerAdvice**, which provides a global approach.
- Code duplication: We may find ourselves replicating code in multiple controllers.
- We should also note that it's possible to combine different approaches within one application.

You may combine different approaches within one application.
For example, you can implement a **@ControllerAdvice** globally but also **ResponseStatusExceptions** locally.
However, we need to be careful: If the same exception can be handled in multiple ways, we may notice some surprising behavior. 
A possible convention is to handle one specific kind of exception always in one way.