# REST Basics - Spring Web

## Basics of RESTful APIs
REST is an API architecture style. It stands for Representational State Transfer (REST). 
RREST is an architectural style that defines a set of constraints to be used for creating web services. 
REST API is a way of accessing web services in a simple and flexible way without having any processing.
REST technology is generally preferred to the more robust Simple Object Access Protocol (SOAP) technology because REST uses less bandwidth, 
simple and flexible making it more suitable for internet usage. It’s used to fetch or give some information from a web service. 
All communication done via REST API uses only HTTP request.

## Richardson REST API Maturity Model
[TO DO]

## Some definitions related to REST API

- State [TO DO]

- Resource [TO DO]

- Stateless [TO DO]

- REST API endpoint [TO DO]

- HTTP request/response [TO DO]

- URL [TO DO]

- Media types [TO DO]

- HTTP verbs [TO DO]

- _**Idempotence:**_ An idempotent method is a method that can be called many times without different outcomes. 
It would not matter if the method is called only once, or ten times over. 
NOTE: POST is neither safe nor idempotent.
<br>Example:<br>

```
a = 5 // It is Idempotence, as final value(a = 5) would not change after executing it multiple times.
 
a++ // It is not Idempotence because the final value will depend upon the number of times the statement is executed.

```

- _**Safety:**_ The concepts of _**‘idempotent methods’**_ and _**‘safe methods’**_ are often confused. 
A safe method does not change the value that is returned, it reads – but it never writes. Safe methods are HTTP methods that do not modify resources. 
For instance, using GET or HEAD on a resource URL, should NEVER change the resource.
<br>Example:<br>

```
x + 0; //it is idempotent and also safe, as final value x would not change after executing it multiple times.

x = 5; //it is idempotent but is not safe, as original value x could be changed to 5

```

The first of these, adding zero, will return the same value every time (it is idempotent), and adding zero will have no effect on that value (it is also safe). 
The second example will return the same value every time (it is idempotent) but is not safe (if x is anything other than 5 before the operation runs, it changes x).
Therefore, all safe methods are idempotent, but not all idempotent methods are safe.

- _**HTTP PUT vs HTTP PATCH:**_ The HTTP PATCH request method applies partial modifications to a resource.
A PATCH request is considered a set of instructions on how to modify a resource. Contrast this with PUT; which is a complete representation of a resource.
A PATCH is not necessarily idempotent, although it can be. Contrast this with PUT; which is always idempotent. 
The word "idempotent" means that any number of repeated, identical requests will leave the resource in the same state. 
For example if an auto-incrementing counter field is an integral part of the resource, then a PUT will naturally overwrite it (since it overwrites everything), 
but not necessarily so for PATCH.
PATCH (like POST) may have side-effects on other resources so it is not safe.

## REST architectural constraints

- **Client-Server:**<br> [TO DO]

- **Uniform Interface:**<br> [TO DO]

- **Stateless:**<br> [TO DO]

- **Cacheable:**<br> [TO DO]

- **Layered System:**<br> This constraint tells that the architecture of the application can be layered, without letting the client know about it.
An application architecture needs to be composed of multiple layers. Each layer doesn’t know any thing about any layer other than that of immediate layer and 
there can be lot of intermediate servers between client and the end server. 
Intermediary servers may improve system availability by enabling load-balancing and by providing shared caches.

- **Code on demand (optional):**<br> [TO DO]

## Basic principals of designing REST APIs

### Organize the API design around resources

- **Use nouns instead of verbs in endpoint paths** [TO DO]

- **Use Nesting on Endpoints to Show Relationships** [TO DO]

- **Use Name convention** [TO DO]

### Define API operations in terms of HTTP methods 
[TO DO]

### Conform to HTTP semantics 
[TO DO]

### Use HTTP response status codes 
[TO DO]

### Allow filtering, sorting, and pagination
[TO DO]

### Handle errors gracefully and return standard error codes
[TO DO]

### Maintain good security practices
[TO DO]

### Cache data to improve performance
[TO DO]

### Support partial responses for large binary resources
[TO DO]

### Use HATEOAS to enable navigation to related resources
[TO DO]

### Versioning a RESTful web API
[TO DO]

### Provide Accurate API Documentation
[TO DO]

### REST APIs testing
[TO DO]

### Some tools for testing REST APIs
[TO DO]

