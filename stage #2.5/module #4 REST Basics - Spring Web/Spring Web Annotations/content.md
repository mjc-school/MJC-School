## Spring Web Annotations

Let's consider annotations which are used in spring web.

**@Controller**<br>
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
**@RestController**<br>
The **@RestController** combines **@Controller** and **@ResponseBody**. By annotating the controller class with **@RestController** annotation, 
you no longer need to add **@ResponseBody** to all the request mapping methods. The **@ResponseBody** annotation is active by default.
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
**@RequestMapping**<br>
The annotation **marks request handler methods** inside **@Controller\@RestController** annotated classes; 
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
You can provide default settings for all handler methods in a **@Controller\@RestController** annotated class if you apply this annotation on the class level. 
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
You can use regular expression in value property of **@RequestMapping annotation**. 
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
There are different variants of **@RequestMapping** with the HTTP method already set to GET, POST, PUT, DELETE, and PATCH respectively: **@GetMapping, @PostMapping, @PutMapping, @DeleteMapping**, and **@PatchMapping**.
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
**@RequestBody** maps the body of the HTTP request to an object:
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
        if (bookUpdateDTO.getId > 0 && bookUpdateDTO.getId != id)
        {
            throw new BadRequestException("Resource id in path and request body does not match.");
        }
        if (bookUpdateDTO.getId == 0)
        {
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
**@PathVariable** annotation indicates that **a method argument is bound to a URI template variable**. You can specify the URI template with the **@RequestMapping** annotation 
and bind a method argument to one of the template parts with **@PathVariable**. The annotation extracts values from the URI path. You can achieve this with the name or its alias, 
the value argument. If the name of the part in the template matches the name of the method argument, you don't have to specify it in the annotation:<br>
```Java
@RestController
@RequestMapping(value = "/books", consumes = {"application/JSON"}, produces = {"application/JSON", "application/XML"})
public class BookController {

    //..........

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

    //..........
    
    @GetMapping(value = "/{title}")
    ResponseEntity<BookDTO> getBookByTitle(@PathVariable("title") long bookTitle) {
        //....
    }
}
```
Moreover, you can mark a path variable optional by setting the argument required to false, the default value for the required property is true:
```Java
@RestController
@RequestMapping(value = "/books", consumes = {"application/JSON"}, produces = {"application/JSON", "application/XML"})
public class BookController {

    //..........

    @PutMapping(value = "/{id:\\d+}")
    ResponseEntity<BookDTO> updateBook(@PathVariable(required = false) long id, @RequestBody BookUpdateDTO bookUpdateDTO) {
        //....
    }
}
```
**@RequestParam** is used for accessing HTTP request parameters. **@RequestParams** extracts values from the query string.
Example of the rest uri with the parameters: http://localhost:8080/bookshop/books?author=Conan Doyle&limit=10, where the query strings is author=Conan Doyle and limit=10.
In **@RequestParam** you can specify an injected value when Spring finds no or empty value in the request. To achieve this, you have to set the defaultValue argument.

Providing a default value implicitly sets required to false:
```Java
@RestController
@RequestMapping(value = "/books", consumes = {"application/JSON"}, produces = {"application/JSON", "application/XML"})
public class BookController {

    //..........

    @GetMapping()
    ResponseEntity<BookDTO> getBooksByAuthor(@RequestParam("author") String authorName, @RequestParam(defaultValue = "5", required = false) int limit) {
        //....
    }
}
```
Besides request parameters, there are other HTTP request parts you can access: cookies and headers. you can access them with the annotations **@CookieValue** and **@RequestHeader** respectively.
You can configure them the same way as **@RequestParam**.

**@RequestHeader** annotation maps all or a particular header values to an argument of a controller method. The type of **@RequestHeader** annotation is parameter. Thus you can add it directly on a controller method argument.
In the next example you are reading all HTTP headers in a HashMap. you are using @RequestHeader annotation to map all HTTP headers into Java Map instance.
```Java
@RestController
@RequestMapping(value = "/books", consumes = {"application/JSON"}, produces = {"application/JSON", "application/XML"})
public class BookController {

    //..........

    @GetMapping()
    ResponseEntity<List<BookDTO>> getAllBooks(@RequestHeader Map<String, String> headers, @RequestParam(defaultValue = "5", required = false) int limit) {
        //....
    }
}
```
Example of reading a specific header in Spring REST Controller:
```Java
@RestController
@RequestMapping(value = "/books", consumes = {"application/JSON"}, produces = {"application/JSON", "application/XML"})
public class BookController {

    //..........

    @GetMapping()
    ResponseEntity<List<BookDTO>> getAllBooks(@RequestHeader(value = "search-criteria", required = false) String contentType, @RequestParam(defaultValue = "5", required = false) int limit) {
        //....
    }
}
```