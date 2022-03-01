## REST with Spring

### Understanding REST in Spring

The Spring framework supports two ways of creating RESTful services:
- using MVC with ModelAndView;
- using HTTP message converters.<br>

The **ModelAndView approach** is older and much better documented, but also more verbose and configuration heavy. 
The new approach, based on **HttpMessageConverter and annotations**, is much more lightweight and easy to implement.
Configuration is minimal, and it provides sensible defaults for what you would expect from a RESTful service.
  
### Java based Web Configurations
Spring framework provides two ways of configuring a RESTful application:
- using xml configuration files such as web.xml and SpringApplicationContext.xml;
- using Java class.<br>

Configuring a application on base of spring framework through Java is a modern approach in comparison with xml one.<br>
Let's consider Java configuration:
```Java
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.epam.mjc.school"})
public class WebConfig
{
 //...
}
```
The **@Configuration annotation** is the central artifact of Spring’s Java-configurations. **@Configuration** is a meta-annotated as a @Component 
which make is eligible for component scanning, it also gives the flexibility to use **@Autowired annotations**. 
A class annotated with **@Configuration annotation** shows that this can be used by **Spring IoC container** for bean definitions.<br>
The new **@EnableWebMvc annotation** does some useful things – specifically, in the case of REST, 
it detects the existence of Jackson and JAXB 2 on the classpath and automatically creates and registers default JSON and XML converters. 
The functionality of the annotation is equivalent to the XML version:<br>
> <mvc:annotation-driven /> <br>

**@ComponentScan annotation** with **@Configuration classes** enables Spring to scan all classes through the package and will register all beans and controller for our application.

`The WebConfig class` shown above will set up the basic support you need for a spring web project, such as registering controllers and mappings, type converters, validation support, 
message converters and exception handling. The config class will replace `SpringApplicationContext.xml` which is used in xml configuration.

If we want to customize this configuration, you should implement the **WebMvcConfigurer interface** or remove the **@EnableWebMvc annotation** and extend **WebMvcConfigurationSupport class** directly.
```Java
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.epam.mjc.school"})
public class WebConfig implements WebMvcConfigurer 
{
// ...
}
```

To bootstrap an spring web application that loads this configuration, you need an initializer class. For this purpose Spring Web provides **WebApplicationInitializer** which is **Servlet 3.0 + implementation** 
to configure ServletContext programmatically in comparison to using web.xml in xml configuration.
```Java
public class MainWebAppInitializer implements WebApplicationInitializer {
@Override
public void onStartup(final ServletContext servletContext) throws ServletException {

    //create the root Spring application context
    AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
    rootContext.register(WebConfig.class);
    rootContext.setConfigLocation("com.epam.mjc.school.config");

    //add ContextLoaderListner to the ServletContext which will be responsible to load the application context
    servletContext.addListener(new ContextLoaderListener(rootContext));
    
    //register and map the dispatcher servlet
    //note Dispatcher servlet with constructor arguments
    ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher",  new DispatcherServlet(servletAppContext));
    dispatcher.setLoadOnStartup(1);
    dispatcher.addMapping("/");

    //add specific encoding (e.g. UTF-8) via CharacterEncodingFilter 
    FilterRegistration.Dynamic encodingFilter = servletContext.addFilter("encoding-filter", new CharacterEncodingFilter());
    encodingFilter.setInitParameter("encoding", "UTF-8");
    encodingFilter.setInitParameter("forceEncoding", "true");
    encodingFilter.addMappingForUrlPatterns(null, true, "/*");
    }
}
```
Let's have a look what **onStartup** method of **WebApplicationInitializer interface** contains:<br>
If you want to use `Java-based annotation` instead of XML configuration, you should use **AnnotationConfigWebApplicationContext** for this
```Java
AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
```
You need to register application context, this can be easily done by registering your custom configuration class.<br>
```Java
servletAppContext.register(WebConfig.class);
```
If your application configurations are spread across multiple classes and you want to use all of these configurations, Spring **WebApplicationInitializer** provide a way 
to specify root package to be scanned for configuration classes.
```Java
rootContext.setConfigLocation("com.epam.mjc.school.config");
```
To load the application context when the application starts you should add **ContextLoaderListner** to the **ServletContext** which will be responsible to load the context.
```Java
servletContext.addListener(new ContextLoaderListener(rootContext));
```
Finally, you should create and register **Dispatcher servlet**, which is the entry point of our application.
```Java
ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher",  new DispatcherServlet(servletAppContext));
dispatcher.setLoadOnStartup(1);
dispatcher.addMapping("/");
```
If you want to add specific encoding you can add **FilterRegistration.Dynamic filter**:
```Java
FilterRegistration.Dynamic encodingFilter = servletContext.addFilter("encoding-filter", new CharacterEncodingFilter());
encodingFilter.setInitParameter("encoding", "UTF-8");
encodingFilter.setInitParameter("forceEncoding", "true");
encodingFilter.addMappingForUrlPatterns(null, true, "/*");
```
Normally, for bootstrapping a spring web application it is easy to use **AbstractAnnotationConfigDispatcherServletInitializer class** which is 
an implemantation of **WebApplicationInitializer interface**. The **AbstractAnnotationConfigDispatcherServletInitializer class** registers a **ContextLoaderlistener** (optionally) 
and a **DispatcherServlet** and allows you to easily add configuration classes to load for both classes and to apply filters to the **DispatcherServlet** and to provide the servlet mapping. 

```Java
public class MainWebAppInitializer implements AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] { SecurityConfig.class, ApplicationConfig.class, RepositoryConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { WebConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        //add specific encoding (e.g. UTF-8) via CharacterEncodingFilter
        FilterRegistration.Dynamic encodingFilter = servletContext.addFilter("encoding-filter", new CharacterEncodingFilter());
        encodingFilter.setInitParameter("encoding", "UTF-8");
        encodingFilter.setInitParameter("forceEncoding", "true");
        encodingFilter.addMappingForUrlPatterns(null, true, "/*");
    }
}
```
In the Spring Web framework, each **DispatcherServlet** has its own **WebApplicationContext**, 
which inherits all the beans already defined in the root **WebApplicationContext**. 
These inherited beans can be overridden in the servlet-specific scope, and you can define new scope-specific beans 
local to a given Servlet instance. See the picture below:
![Typical Сontext Hierarchy in Spring Web Application](media/TypicalСontextHierarchyInSpringWebApplication.PNG)

### Rest Controller
Rest controllers are annotated with **@RestController**. The annotation includes the **@RestController** and **@ResponseBody** annotations, and as a result, simplifies the controller implementation:
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
In the code above, Such annotations as **@GetMapping, @PostMapping, @PutMapping, @PatchMapping and  @DeleteMapping** are used for mapping HTTP GET, POST, PUT, PATCH and DELETE requests onto specific handler methods.
**@RequestBody** annotation binds request body to method parameters. The process of serialization/deserialization is performed by **HttpMessageConverter**. 
Automatic validation in controller methods can be applied by annotating the argument with **@Valid**. In order to validate BookPatchDTO via **@Valid** you should add **@NotNull**, **@Min** and other validation annotations on fields.
**@PathVariable** is used for data passed in the URI.
**@RequestParam** annotation is used for extracting query parameters, form parameters, and even files from the request.

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


