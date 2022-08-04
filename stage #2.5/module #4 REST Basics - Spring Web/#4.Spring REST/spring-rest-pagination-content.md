## REST Pagination in Spring

**Pagination** is a mechanism for handling the big result set in any type of application. 
Implementing pagination in REST API is not different but need some extra thought process. 
Providing a fluent and efficient pagination for REST API could increase user experience and help to build efficient and fast REST API.

## Resource vs Representation
Before you start designing pagination API, you need to have a clear understanding of page as a resource or a representation of the resource.
1. If you consider that the page is not a resource in REST but its a property of the request.
The example
```
http://domainname/products?page=1
```
2. If you consider that the page as a resource then:
```
http://domainname/products/page/1?sort_by=date

//URL part for sorting by date 
http://domainname/products/date/page/1
```
## Discoverability
**Discoverability** helps to make RESTful API more useful and elegant.
Discoverability is closely related to [HATEOAS](./spring-hateoas-content.md) in the REST API. REST API pagination discoverability will pass on **"next","previous","first" and "last" link** as part of the response data. 
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
 public ResponseEntity < PagedResources < BookDTO >> getAllBooks(@Min(1) @RequestParam int page, @RequestParam(required = false, defaultValue = "10") int size, @RequestParam(name = "sort_by", required = false, defaultValue = "title::asc") String sortBy, PagedResourcesAssembler assembler) {
  Page < BookDTO > bookDTOPage = bookMapper.mapToBookDTOPage(bookService.findAllBooks(page, size, sortBy));
  PagedResources < BookDTO > bookDTOResources = assembler.toResource(bookDTOPage, linkTo(BookController.class).slash("/books").withSelfRel());
  HttpHeaders responseHeaders = new HttpHeaders();
  responseHeaders.add("Link", createLinkHeader(bookDTOResources));
  return new ResponseEntity < > (assembler.toResource(products, linkTo(BookController.class).slash("/books").withSelfRel()), responseHeaders, HttpStatus.OK);
 }

 private String createLinkHeader(PagedResources < BookDTO > bookDTOResources) {
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
```
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