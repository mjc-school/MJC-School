## Rest Controller

Let's consider how to build REST controllers using Spring Web framework.
Spring REST controllers are annotated with **@RestController**. The annotation includes the **@RestController** and **@ResponseBody** annotations, and as a result, simplifies the controller implementation:
```Java
@RestController
@RequestMapping(value = "/books", consumes = {"application/JSON"}, produces = {"application/JSON", "application/XML"})
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private Convertor<BookDTO, Book> convertor;

    @GetMapping
    ResponseEntity<List<BookDTO>> getAllBooks(@RequestParam(defaultValue = "10", required = false) int limit, @RequestParam(defaultValue = "5", required = false) int offset) {
        List<Book> bookList = bookService.getAllBooks();
        List<BookDTO> bookDTOList = convertor.convertModelListToDtoList(bookList);
        return new ResponseEntity<>(bookDTOList, HttpStatus.OK);
    }

    @GetMapping(value = "/{id:\\d+}")
    ResponseEntity<List<BookDTO>> getBookById(@PathVariable long id) {
        Book book = bookService.getBookById(id);
        BookDTO bookDTO = convertor.convertModelToDto(book);
        return new ResponseEntity<>(bookDTO, HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<BookDTO> createBook(@RequestBody BookCreateDTO bookCreateDTO) {
        Book book = convertor.convertDtoToModel(bookCreateDTO);
        Book createdBook = bookService.createBook(book);
        return new ResponseEntity<>(convertor.convertModelToDto(createdBook), HttpStatus.CREATE);
    }

    @PutMapping(value = "/{id:\\d+}")
    ResponseEntity<BookDTO> updateBook(@PathVariable long id, @Valid @RequestBody BookUpdateDTO bookUpdateDTO) {
        Book book = convertor.convertDtoToModel(bookUpdateDTO);
        Book updatedBook = bookService.updateBook(book);
        return new ResponseEntity<>(convertor.convertModelToDto(updatedBook), HttpStatus.OK);
    }

    @PatchMapping(value = "/{id:\\d+}")
    ResponseEntity<BookDTO> patchBook(@PathVariable long id, @Valid @RequestBody BookPatchDTO bookPatchDTO) {
        Book book = convertor.convertDtoToModel(bookPatchDTO);
        Book patchedBook = bookService.patchBook(id, book);
        return new ResponseEntity<>(convertor.convertModelToDto(patchedBook), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id:\\d+}")
    ResponseEntity<V> deleteBook(@PathVariable long id) {
        bookService.deleteBok(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);;
    }
}
```
**@RequestMapping** annotation that maps HTTP requests to handler methods of MVC and REST controllers.
In the code above, Such annotations as **@GetMapping, @PostMapping, @PutMapping, @PatchMapping and  @DeleteMapping** are used for mapping HTTP GET, POST, PUT, PATCH and DELETE requests onto specific handler methods.
**@RequestBody** annotation binds request body to method parameters. The process of serialization/deserialization is performed by **HttpMessageConverter**.
Automatic validation in controller methods can be applied by annotating the argument with **@Valid**. In order to validate BookPatchDTO via **@Valid** you should add **@NotNull**, **@Min** and other validation annotations on fields.
**@PathVariable** is used for data passed in the URI.
**@RequestParam** annotation is used for extracting query parameters, form parameters, and even files from the request.
**ResponseEntity** is used as method response. **ResponseEntity** represents an HTTP response, including headers, body, and status.

### Error Handling
Spring web provides support for a global **@ExceptionHandler** with the **@ControllerAdvice** annotation.
```Java
@ControllerAdvice
public class RestResponseExceptionHandler  implements AbstractAnnotationConfigDispatcherServletInitializer {
    @ExceptionHandler(value = {NoSuchResourceFoundException.class})
    protected ResponseEntity<Object> handleConflict(NoSuchResourceFoundException ex, WebRequest request) {
        String bodyOfErrorResponse = "No such resource are found.";
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(),  HttpStatus.NOT_FOUND, request);
    }
}
```
The **@ControllerAdvice** annotation allows us to consolidate our multiple, scattered **@ExceptionHandlers** from before into a single, global error handling component.
The actual mechanism is extremely simple but also very flexible:<br>
- It gives us full control over the body of the response as well as the status code.
- It provides mapping of several exceptions to the same method, to be handled together.
- It makes good use of the newer RESTful ResposeEntity response.
  One thing to keep in mind here is to match the exceptions declared with **@ExceptionHandler** to the exception used as the argument of the method.



