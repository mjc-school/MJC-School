## REST with Spring

## Materials
+ Understanding REST in Spring
+ Rest Controllers
+ Spring REST Application Configuration
+ Versioning a REST API
+ REST Pagination in Spring
+ Spring HATEOAS

## Understanding REST in Spring
The Spring framework supports two ways of creating RESTful services:
- using MVC with ModelAndView
- using HTTP message converters<br>

The **ModelAndView approach** is older and much better documented, but also more verbose and configuration heavy. 
The new approach, based on **HttpMessageConverter and annotations**, is much more lightweight and easy to implement.
Configuration is minimal, and it provides sensible defaults for what you would expect from a RESTful service.

Let's consider how to build REST application using Spring Web framework step by step.

## Rest Controllers
Let's consider how to build REST controllers using Spring Web framework.
Spring REST controllers are annotated with @RestController. The annotation includes the @RestController and @ResponseBody annotations, and as a result, simplifies the controller implementation:
```Java
@RestController
@RequestMapping(value = "/books", consumes = {"application/JSON"}, produces = {"application/JSON", "application/XML"})
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private Convertor<BookDTO, Book> convertor;

    @GetMapping
    ResponseEntity<List<BookDTO>> getAll(
           @RequestParam(defaultValue = "10", required = false) int limit, 
           @RequestParam(defaultValue = "5", required = false) int offset) {
        List<Book> bookList = bookService.getAllBooks(limit, offest);
        List<BookDTO> bookDTOList = convertor.convertModelListToDtoList(bookList);
        return new ResponseEntity<>(bookDTOList, HttpStatus.OK);
    }

    @GetMapping(value = "/{id:\\d+}")
    ResponseEntity<List<BookDTO>> getById(@PathVariable long id) {
        Book book = bookService.getBookById(id);
        BookDTO bookDTO = convertor.convertModelToDto(book);
        return new ResponseEntity<>(bookDTO, HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<BookDTO> create(@RequestBody BookCreateDTO bookCreateDTO) {
        Book book = convertor.convertDtoToModel(bookCreateDTO);
        Book createdBook = bookService.createBook(book);
        return new ResponseEntity<>(convertor.convertModelToDto(createdBook), HttpStatus.CREATE);
    }

    @PutMapping(value = "/{id:\\d+}")
    ResponseEntity<BookDTO> update(@PathVariable long id, @Valid @RequestBody BookUpdateDTO bookUpdateDTO) {
        Book book = convertor.convertDtoToModel(bookUpdateDTO);
        Book updatedBook = bookService.updateBook(book);
        return new ResponseEntity<>(convertor.convertModelToDto(updatedBook), HttpStatus.OK);
    }

    @PatchMapping(value = "/{id:\\d+}")
    ResponseEntity<BookDTO> patch(@PathVariable long id, @Valid @RequestBody BookPatchDTO bookPatchDTO) {
        Book book = convertor.convertDtoToModel(bookPatchDTO);
        Book patchedBook = bookService.patchBook(id, book);
        return new ResponseEntity<>(convertor.convertModelToDto(patchedBook), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id:\\d+}")
    ResponseEntity<V> delete(@PathVariable long id) {
        bookService.deleteBok(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);;
    }
}
```
**ResponseEntity** is used as method response. ResponseEntity represents an HTTP response, including headers, body, and status.

## Spring REST Application Configuration

Spring framework provides two ways of configuring a RESTful application:
- using xml configuration files such as web.xml and SpringApplicationContext.xml
- using Java class

Let's consider the most widely used approach to configuring a spring REST application which is based on
**Java based Web Configurations**.

Configuring a application on base of spring framework through Java is a modern approach in comparison with xml one.
Let's consider Java configuration:
```Java
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.epam.mjc.school"})
public class WebConfig
{
 //Here, you configure beans related to web application context
}
```
The **@Configuration annotation** is the central artifact of Spring’s Java-configurations. @Configuration is a meta-annotated as a @Component
which make is eligible for component scanning, it also gives the flexibility to use **@Autowired annotations**.
A class annotated with @Configuration annotation shows that this can be used by Spring IoC container for bean definitions.<br>
The new **@EnableWebMvc annotation** does some useful things – specifically, in the case of REST,
it detects the existence of Jackson and JAXB 2 on the classpath and automatically creates and registers default JSON and XML converters.
The functionality of the annotation is equivalent to the XML version:
````xml
<mvc:annotation-driven />
````
**@ComponentScan annotation** with **@Configuration classes** enables Spring to scan all classes through the package and will register all beans and controller for our application.

`The WebConfig class` shown above will set up the basic support you need for a spring web project, such as registering controllers and mappings, type converters, validation support,
message converters and exception handling. The config class will replace `SpringApplicationContext.xml` which is used in xml configuration.

If we want to customize this configuration, you should implement the **WebMvcConfigurer interface** or remove the **@EnableWebMvc annotation** and extend **WebMvcConfigurationSupport class** directly.
```Java
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.epam.mjc.school"})
public class WebConfig implements WebMvcConfigurer {
// Here, you configure beans related to web application context
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
    ServletRegistration.Dynamic dispatcher = 
            servletContext.addServlet("dispatcher",  new DispatcherServlet(servletAppContext));
    dispatcher.setLoadOnStartup(1);
    dispatcher.addMapping("/");

    //add specific encoding (e.g. UTF-8) via CharacterEncodingFilter 
    FilterRegistration.Dynamic encodingFilter = 
            servletContext.addFilter("encoding-filter", new CharacterEncodingFilter());
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

## Versioning a REST API

There are some ways of versioning REST API. Let's consider the high level approaches to versioning the REST API:
- URI Versioning – version the URI space using version indicators
- Using Accept Header – version REST API using Media Type
- Using Custom Header - version REST API using custom http header
- Using URI parameter - version REST API using URI query parameter

**1. URI Versioning**

When we introduce the version in the URI space, the Representations of Resources are considered immutable.

So when changes need to be introduced in the API, a new URI space needs to be created.
For example, say an API publishes the following resources – users and privileges:
```
http://host/v1/users
http://host/v1.0/books
```
If you make a breaking changes in the users and book API requires introducing a second version like this:
```
http://host/v2/users
http://host/v2/privileges
```

**2. Versioning using Accept Header**

Content negotiation using **HTTP Accept header** can be used for the REST API versioning. To handle versioning,
REST API would use MIME type to determine the API versioning.
```
Accept: application/vnd.javadevjournal.v2+json
Accept: application/vnd.javadevjournal+json;version=1.0
```
It is important to understand here is that the client makes no assumptions about the structure of the response
beyond what it define in the media type.
The response:
```json
############## GET Request for Products ##############
GET /products/228781 HTTP/1.1
Accept: application/vnd.javadevjournal.v1+json

############## Response ##############
HTTP/1.1 200 OK
Content-Type: application/vnd.javadevjournal.v1+json
{
   "product": {
      "code": "228781",
      "name": "Running shoes",
      "description": "one of the best running shoes"
   }
}
```

**3. Versioning using Custom Header**

You can use a custom header for handling API versioning.
The example:
```
Accept-version: v1
Accept-version: v2
```

**4. Versioning using URI parameter**

This is the least used method to version your REST API. Append version as a query parameter.
The example:
```
http://host/shopping?version=2.0
http://host/catalog/titles/series/70023522?v=1.5
```

If REST API client tries to use old API, the system should return **HTTP 410 status code**.
**HTTP 410 Gone status code** indicates that access to the target resource is no longer available at the origin server and that this condition is likely to be permanent.

## REST Pagination in Spring

Pagination is a mechanism for handling the big result set in any type of application.
Implementing pagination in REST API is not different but need some extra thought process.
Providing a fluent and efficient pagination for REST API could increase user experience and help to build efficient and fast REST API.

**Resource vs Representation**

Before you start designing pagination API, you need to have a clear understanding of page as a resource or a representation of the resource.
1. If you consider that the page is not a resource in REST but its a property of the request.<br>
   The example:
   ```
   http://domainname/products?page=1
   ```
2. If you consider that the page as a resource then:
   ```
   http://domainname/products/page/1?sort_by=date
   
   //URL part for sorting by date 
   http://domainname/products/date/page/1
   ```
**Discoverability**

Discoverability helps to make RESTful API more useful and elegant.
Discoverability is closely related to HATEOAS in the REST API. REST API pagination discoverability will pass on "next","previous","first" and "last" link as part of the response data.
You are covering how to add this feature to your API during pagination.
Let's consider some of the main points while building your REST API pagination interface.

1. **Page & Size\Limit**
   **Page and Size\Limit** allow REST API and client to control the number of results requested in the result set. By passing the page and the limit\size parameter, you can specify what page you want to get and how many items on each page you want to return.
   API can configure default limit but should allow the client to specify `a limit\size`.

2. **Sorting**
   **Sorting** always goes side by side with searching and pagination. While designing the REST API, provide the flexibility to let client specify the sorting option while getting the results back from the API.
   The recommendation is to use `sort_by=[attribute name]::[asc/desc]` pattern while designing your API.API designer should specify the allowed attribute name as the sort parameter.
   For example, you can use `?name::asc` to sort resource by name or ?name::desc to sort in reverse.

The example of REST controller with pagination and sorting:
```Java
@RestController
@RequestMapper("/books")
public class BookController {

   @Autowired
   private BookService bookService;
   
   @Autowired
   private BookMapper bookMapper;
   
   @Autowired 
   private EntityLinks links;

   @GetMapping
   public ResponseEntity<PagedResources<BookDTO>> getAllBooks(
            @Min(1) @RequestParam int page, 
            @RequestParam(required = false, defaultValue = "10") int size, 
            @RequestParam(name = "sort_by", required = false, defaultValue = "title::asc") String sortBy, 
            PagedResourcesAssembler assembler) {
      Page<BookDTO> bookDTOPage = bookMapper.mapToBookDTOPage(bookService.findAllBooks(page, size, sortBy));
      PagedResources<BookDTO> bookDTOResources = 
              assembler.toResource(bookDTOPage, linkTo(BookController.class).slash("/books").withSelfRel());
      HttpHeaders responseHeaders = new HttpHeaders();
      responseHeaders.add("Link", createLinkHeader(bookDTOResources));
      return new ResponseEntity<>(
              assembler.toResource(products, linkTo(BookController.class).slash("/books").withSelfRel()), 
              responseHeaders, 
              HttpStatus.OK);
   }

   private String createLinkHeader(PagedResources<BookDTO> bookDTOResources) {
      final StringBuilder linkHeader = new StringBuilder();
      linkHeader.append(buildLinkHeader(bookDTOResources.getLinks("first").get(0).getHref(), "first"));
      linkHeader.append(", ");
      linkHeader.append(buildLinkHeader(bookDTOResources.getLinks("next").get(0).getHref(), "next"));
      return linkHeader.toString();
   }

   public static String buildLinkHeader(final String uri, final String rel) {
      return "<" + uri + ">; rel=\"" + rel + "\"";
   }
}
```
Each paged response will return links to the `previous and next pages` of results based on the current page using the IANA defined link relations `prev and next`.
If you are currently on the first page of results, however, no `prev link` will be rendered.
Let’s look at the following uri example:
```
http://host:port/books?page=1&size=20&sort_by=title::asc
```
The response example:
```json
{
    "_embedded": {
        "bookDTO": [
            ...data...
        ]
    },
    "_links": {
        "first": {
            "href": "http://host:port/books?page=1&size=20"
    },
    "self": {
        "href": "http://host:port/books"
    },
    "next": {
        "href": "http://host:port/books?page=2&size=20"
    },
    "last": {
        "href": "http://host:port/books?page=5&size=20"
    }
    },
    "page": {
        "size": 20,
        "totalElements": 100,
        "totalPages": 5,
        "number": 0
    }
}
```
Let's look at the response data where:<br>
- The `next link` points to the next page. The `last link` points to the last result set.
- The `self link` serves up the whole collection.
- The `bottom page section` provides information about the pagination including `page size, total results, total pages and current page number`.

**HTTP link header** can also be used to pass pagination information to the client. With the above REST controller example, the system will return following additional information as part of the `Link HTTP header`.
```
Link → 
<http://host:port/books?page=1&size=20>; rel="first", 
<http://host:port/books?page=2&size=20>; rel="next"
```
For example, `Github API` use the link header for pagination.

## Spring HATEOAS
https://www.baeldung.com/spring-hateoas-tutorial
https://www.javadevjournal.com/spring/spring-hateoas/

HATEOAS (Hypermedia as the Engine of Application State) is a constraint of the REST application architecture.
A hypermedia driven REST API provides information to help to navigate through the API dynamically.
This is done by passing hypermedia links with the responses. HATEOAS is a fundamental concept to create Discoverable REST APIs.

The Spring framework provides the `HATEOAS library` that you can use to easily create REST representations that follow the principle of HATEOAS (Hypertext as the Engine of Application State).