# Spring Web Annotations

## Materials
+ @Controller
+ @RestController
+ @RequestMapping
+ @RequestBody
+ @PathVariable
+ @RequestParam
+ @RequestHeader
+ @CookieValue
+ @ResponseBody
+ @ExceptionHandler
+ @ResponseStatus
+ @ModelAttribute
+ @CrossOrigin

Let's consider annotations which are used in spring web.

## @Controller
This is a class level annotation, which tells the Spring Framework that this class serves as a controller in Spring MVC:
```Java
@Controller
@ResponseBody
@ResponseStatus( HttpStatus.OK )
public class BookController {
    @RequestMapping(value = "/books", method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus( HttpStatus.OK )
    List<Book> getAllBooks() {
        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
    }
}
```
## @RestController
The @RestController combines @Controller and @ResponseBody. By annotating the controller class with @RestController annotation, 
you no longer need to add @ResponseBody to all the request mapping methods. The @ResponseBody annotation is active by default.
Therefore, the following declarations are equivalent:
```Java
@Controller
@ResponseBody
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    @ResponseStatus( HttpStatus.OK )
    List<Book> getAllBooks() {
        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
    }
}
```
```Java
@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    @ResponseStatus( HttpStatus.OK )
    List<Book> getAllBooks() {
        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
    }
}
```
## @RequestMapping
The annotation **marks request handler methods** inside @Controller \ @RestController annotated classes; 
it can be configured using:<br>
- **path**, or its aliases, name, and value: which URL the method is mapped to
- **method**: compatible HTTP methods
- **params**: filters requests based on presence, absence, or value of HTTP parameters
- **headers**: filters requests based on presence, absence, or value of HTTP headers
- **consumes**: which media types the method can consume in the HTTP request body
- **produces**: which media types the method can produce in the HTTP response body
Here's a quick examples:<br>
The example of rest controller for spring mvc application:<br> 
```Java
@Controller
public class BookController {
    @Autowired
    private BookService bookService;
    
    @RequestMapping(value = "/books", method = RequestMethod.GET)
    String getAllBooks(Model model) {
        model.addAttribute("bookList", bookService.getAllBooks());
        return "books";
    }
}
```
The example of rest controller for spring rest application:<br>
```Java
@RestController
public class BookController {
    @Autowired
    private BookService bookService;
    
    @RequestMapping(value = "/books", method = RequestMethod.GET)
    ResponseEntity<List<Book>> getAllBooks() {
        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
    }
}
```
You can provide default settings for all handler methods in a @Controller \ @RestController annotated class if you apply this annotation on the class level. 
The only exception is the URL which Spring won't override with method level settings but appends the two path parts.
For example, the following configuration has the same effect as the one above:<br>
```Java
@RestController
@RequestMapping(value = "/books")
public class BookController {
    @Autowired
    private BookService bookService;
    
    @RequestMapping(method = RequestMethod.GET)
    ResponseEntity<List<Book>> getAllBooks() {
        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id:\\d+}", method = RequestMethod.GET)
    ResponseEntity<List<Book>> getBookById(@PathVariable long id) {
        return new ResponseEntity<>(bookService.getBookById(id), HttpStatus.OK);
    }
}
```
You can use regular expression in value property of @RequestMapping annotation. 
For example:<br>
```Java
@RestController
@RequestMapping(value = "/books", produces = {"application/JSON", "application/XML"})
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping(method = RequestMethod.GET)
    ResponseEntity<List<Book>> getAllBooks() {
        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id:\\d+}", method = RequestMethod.GET)
    ResponseEntity<List<Book>> getBookById(@PathVariable long id) {
        return new ResponseEntity<>(bookService.getBookById(id), HttpStatus.OK);
    }
}
```
There are different variants of @RequestMapping with the HTTP method already set to GET, POST, PUT, DELETE, and PATCH respectively: **@GetMapping, @PostMapping, @PutMapping, @DeleteMapping**, and **@PatchMapping**.
```Java
@RestController
@RequestMapping(value = "/books", consumes = {"application/JSON"}, produces = {"application/JSON", "application/XML"})
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private Convertor<BookDTO, Book> convertor;

    @GetMapping
    ResponseEntity<List<BookDTO>> getAllBooks() {
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

    @PostMapping()
    ResponseEntity<BookDTO> createBook(@RequestBody BookCreateDTO bookCreateDTO) {
        Book book = convertor.convertDtoToModel(bookCreateDTO);
        Book createdBook = bookService.createBook(book);
        return new ResponseEntity<>(convertor.convertModelToDto(createdBook), HttpStatus.CREATE);
    }

    @PutMapping(value = "/{id:\\d+}")
    ResponseEntity<BookDTO> updateBook(@PathVariable long id, @RequestBody BookUpdateDTO bookUpdateDTO) {
        Book book = convertor.convertDtoToModel(bookUpdateDTO);
        Book updatedBook = bookService.updateBook(book);
        return new ResponseEntity<>(convertor.convertModelToDto(updatedBook), HttpStatus.OK);
    }

    @PatchMapping(value = "/{id:\\d+}")
    ResponseEntity<BookDTO> patchBook(@PathVariable long id, @RequestBody BookPatchDTO bookPatchDTO) {
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
## @RequestBody
Maps the body of the HTTP request to an object:
```Java
@RestController
@RequestMapping(value = "/books", consumes = {"application/JSON"}, produces = {"application/JSON", "application/XML"})
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private Convertor<BookDTO, Book> convertor;
    
    @PostMapping()
    ResponseEntity<BookDTO> createBook(@RequestBody BookCreateDTO bookCreateDTO) {
        Book book = convertor.convertDtoToModel(bookCreateDTO);
        Book createdBook = bookService.createBook(book);
        return new ResponseEntity<>(convertor.convertModelToDto(createdBook), HttpStatus.CREATE);
    }

    @PutMapping(value = "/{id:\\d+}")
    ResponseEntity<BookDTO> updateBook(@PathVariable long id, @RequestBody BookUpdateDTO bookUpdateDTO) {
        if (bookUpdateDTO.getId > 0 && bookUpdateDTO.getId != id) {
            throw new BadRequestException("Resource id in path and request body does not match.");
        }
        if (bookUpdateDTO.getId == 0) {
            bookUpdateDTO.setId(id);
        }
        Book book = convertor.convertDtoToModel(bookUpdateDTO);
        Book updatedBook = bookService.updateBook(book);
        return new ResponseEntity<>(convertor.convertModelToDto(updatedBook), HttpStatus.OK);
    }

    @PatchMapping(value = "/{id:\\d+}")
    ResponseEntity<BookDTO> patchBook(@PathVariable long id, @RequestBody BookPatchDTO bookPatchDTO) {
        Book book = convertor.convertDtoToModel(bookPatchDTO);
        Book patchedBook = bookService.patchBook(id, book);
        return new ResponseEntity<>(convertor.convertModelToDto(patchedBook), HttpStatus.OK);
    }
}
```
## @PathVariable
This annotation indicates that **a method argument is bound to a URI template variable**. You can specify the URI template with the @RequestMapping annotation 
and bind a method argument to one of the template parts with @PathVariable. The annotation extracts values from the URI path. You can achieve this with the name or its alias, 
the value argument. If the name of the part in the template matches the name of the method argument, you don't have to specify it in the annotation:<br>
```Java
@RestController
@RequestMapping(value = "/books", consumes = {"application/JSON"}, produces = {"application/JSON", "application/XML"})
public class BookController {
    //....

    @GetMapping(value = "/{id:\\d+}")
    ResponseEntity<List<BookDTO>> getBookById(@PathVariable long id) {
        //....
    }
}
```
If the name of the part in the template does not matche the name of the method argument, you need to specify it in the annotation:
```Java
@RestController
@RequestMapping(value = "/books", consumes = {"application/JSON"}, produces = {"application/JSON", "application/XML"})
public class BookController {
    //....
    
    @GetMapping(value = "/{title}")
    ResponseEntity<BookDTO> getBookByTitle(@PathVariable("title") String bookTitle) {
        //....
    }
}
```
Moreover, you can mark a path variable optional by setting the argument required to false, the default value for the required property is true:
```Java
@RestController
@RequestMapping(value = "/books", consumes = {"application/JSON"}, produces = {"application/JSON", "application/XML"})
public class BookController {
    //....

    @PutMapping(value = "/{id:\\d+}")
    ResponseEntity<BookDTO> updateBook(@PathVariable(required = false) long id, @RequestBody BookUpdateDTO bookUpdateDTO) {
        //....
    }
}
```
## @RequestParam
It is used for accessing HTTP request parameters. @RequestParams extracts values from the query string.
Example of the rest uri with the parameters: http://localhost:8080/bookshop/books?author=Conan Doyle&limit=10, where the query strings is author=Conan Doyle and limit=10.
In @RequestParam you can specify an injected value when Spring finds no or empty value in the request. To achieve this, you have to set the defaultValue argument.

Providing a default value implicitly sets required to false:
```Java
@RestController
@RequestMapping(value = "/books", consumes = {"application/JSON"}, produces = {"application/JSON", "application/XML"})
public class BookController {
    //....

    @GetMapping()
    ResponseEntity<BookDTO> getBooksByAuthor(
            @RequestParam("author") String authorName, 
            @RequestParam(defaultValue = "5", required = false) int limit) {
        //....
    }
}
```
Besides request parameters, there are other HTTP request parts you can access: cookies and headers. you can access them with the annotations **@CookieValue** and **@RequestHeader** respectively.
You can configure them the same way as @RequestParam.

## @RequestHeader
This annotation maps all or a particular header values to an argument of a controller method. The type of @RequestHeader annotation is parameter. Thus you can add it directly on a controller method argument.
In the next example you are reading all HTTP headers in a HashMap. you are using @RequestHeader annotation to map all HTTP headers into Java Map instance.
```Java
@RestController
@RequestMapping(value = "/books", consumes = {"application/JSON"}, produces = {"application/JSON", "application/XML"})
public class BookController {
    //....

    @GetMapping()
    ResponseEntity<List<BookDTO>> getAllBooks(
            @RequestHeader Map<String, String> headers, 
            @RequestParam(defaultValue = "5", required = false) int limit) {
        //....
    }
}
```
Example of reading a specific header in Spring REST Controller:
```Java
@RestController
@RequestMapping(value = "/books", consumes = {"application/JSON"}, produces = {"application/JSON", "application/XML"})
public class BookController {
    //....

    @GetMapping()
    ResponseEntity<List<BookDTO>> getAllBooks(
            @RequestHeader(value = "content-type", required = false) String contentType, 
            @RequestParam(defaultValue = "5", required = false) int limit) {
        //....
    }
}
```
## @CookieValue 
This annotation is used to get the value of any HTTP cookie without iterating over all the cookies fetched from the request. This annotation can be used to map the value of a cookie to the controller method parameter.
```Java
@RestController
@RequestMapping(value = "/info")
public class InfoController {
    //....

    @GetMapping()
    public String getSessionInfo(@CookieValue("JSESSIONID") String jsessionid, Model model) {
        model.addAttribute("info", "JSESSIONID: " + jsessionid );
        return "sessionInfo";
    }
}
```

## @ResponseBody
Annotation is used with @Controller annotation. Spring treats the result of the method as the response itself:
```Java
@Controller
@RequestMapping(value = "/books", produces = {"application/JSON", "application/XML"})
public class BookController {
    //....

    @GetMapping
    @ResponseBody
    ResponseEntity<List<BookDTO>> getAllBooks(
            @RequestParam(defaultValue = "10", required = false) int limit, 
            @RequestParam(defaultValue = "5", required = false) int offset) {
        //....
    }
}
```

## @ExceptionHandler
is used to declare **a custom error handler method**. Spring calls this method when a request handler method throws any of the specified exceptions.
The caught exception can be passed to the method as an argument:
```Java
@Controller
@RequestMapping(value = "/books", produces = {"application/JSON", "application/XML"})
public class BookController {
    //....

    @GetMapping(value = "/{id}")
    ResponseEntity<BookDTO> getBookById(@PathVariable long id) {
        //....
    }

    @ExceptionHandler(NoSuchResourceFoundException.class)
    public ResponseEntity<String> handleNoSuchResourceFoundException(
            NoSuchResourceFoundException exc
    ) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(exc.getMessage());
    }
}
```
The exception handler method takes in an exception or a list of exceptions as an argument that you want to handle in the defined method. You annotate the method with **@ExceptionHandler** 
to define the exception you want to handle.

## @ResponseStatus
This is used to specify the desired HTTP status of the response if you annotate a request handler method with this annotation. you can declare the status code with the code argument, 
or its alias, the value argument. Also, you can provide a reason using the reason argument.
You also can use it along with @ExceptionHandler:
```Java
@RestController
@RequestMapping(value = "/books", produces = {"application/JSON", "application/XML"})
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    BookDTO getBookById(@PathVariable long id) {
        if (bookService.getBookById(id) == null) {
            throw new NoSuchResourceFoundException();
        }
    }

    @ExceptionHandler(NoSuchResourceFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNoSuchResourceFoundException(NoSuchResourceFoundException exc) {
        return exc.getMessage();
    }
}

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
}
```
## @ModelAttribute
This is used in Spring MVC application. You can access elements that are already in the model of an MVC **@Controller**, 
by providing the model key:
```Java
@Controller
@RequestMapping(value = "/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(method = RequestMethod.POST)
    String submitNewBook(@ModelAttribute("book") Book book) {
        bookService.createNewBook(book);
        return "newBookView";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ModelAttribute("book")
    Book getBookById(@PathVariable long id) {
        return bookService.getBookById(id);
    }
}
```
In the above code snippet, you are populating the book model attribute with data from a form submitted to the new book creation endpoint. 
Spring MVC does this behind the scenes before invoking the submitNewBook method.
If you annotate a method with @ModelAttribute, Spring will automatically add the method's return value to the model.

## @CrossOrigin
Enables cross-domain communication for the annotated request handler methods:
```Java
@CrossOrigin
@RestController
@RequestMapping(value = "/books")
public class BookController {
    //....

    @GetMapping(value = "/{id}")
    ResponseEntity<BookDTO> getBookById(@PathVariable long id) {
        //....
    }
}
```
The @CrossOrigin annotation uses the default values:<br>
- All origins are allowed.
- The HTTP methods allowed are those specified in the @RequestMapping annotation (GET, for this example).
- The time that the preflight response is cached (maxAge) is 30 minutes.
