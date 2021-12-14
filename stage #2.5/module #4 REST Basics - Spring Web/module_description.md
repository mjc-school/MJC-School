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

- _**State:**_ [TO DO]

- Resource [TO DO]

- _**Stateless:**_ [TO DO]

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
but not necessarily so for PATCH. The PATCH body should not just be a modified part of the resource, but in some kind of patch language like _**JSON Patch**_ or _**XML Patch**_.
PATCH (like POST) may have side-effects on other resources so it is not safe.

## REST architectural constraints

1.**Client-Server:**<br> REST application should have a client-server architecture. A Client is someone who is requesting resources and are not concerned with data storage, which remains internal to each server, and server is someone who holds the resources and are not concerned with the user interface or user state. They can evolve independently. Client doesn’t need to know anything about business logic and server doesn’t need to know anything about frontend UI.

2.**Uniform Interface:**<br> It is a key constraint that differentiate between a REST API and Non-REST API. It suggests that there should be an uniform way of interacting with a given server irrespective of device or type of application (website, mobile app).
There are four guidelines principle of Uniform Interface are:
- _**Resource-Based:**_ Individual resources are identified in requests. For example: API/users.<br>
- _**Manipulation of Resources Through Representations:**_ Client has representation of resource and it contains enough information to modify or delete the resource on the server, provided it has permission to do so. Example: Usually user get a user id when user request for a list of users and then use that id to delete or modify that particular user.
- _**Self-descriptive Messages:**_ Each message includes enough information to describe how to process the message so that server can easily analyses the request.
- _**Hypermedia as the Engine of Application State (HATEOAS):**_ It need to include links for each response so that client can discover other resources easily.

3.**Stateless:**<br> It means that the necessary state to handle the request is contained within the request itself and server would not store anything related to the session. In REST, the client must include all information for the server to fulfill the request whether as a part of query params, headers or URI. Statelessness enables greater availability since the server does not have to maintain, update or communicate that session state. There is a drawback when the client need to send too much data to the server so it reduces the scope of network optimization and requires more bandwidth.

4.**Cacheable:**<br> In order to provide a better performance, the applications are often made cacheable. Every response should include whether the response is cacheable or not and for how much duration responses can be cached at the client side. Client will return the data from its cache for any subsequent request and there would be no need to send the request again to the server. A well-managed caching partially or completely eliminates some client–server interactions, further improving availability and performance. But sometime there are chances that user may receive stale data To prevent it, the cached data needs to be updated each time the data is getting updated server side.

5.**Layered System:**<br> This constraint tells that the architecture of the application can be layered, without letting the client know about it.
An application architecture needs to be composed of multiple layers. Each layer doesn’t know any thing about any layer other than that of immediate layer and 
there can be lot of intermediate servers(layers) between client and the end server. 
Intermediary servers may improve system availability by enabling load-balancing and by providing shared caches.

6.**Code on demand (optional):**<br> It is an optional feature. According to this, servers can also provide executable code to the client. The examples of code on demand may include the compiled components such as Java applets and client-side scripts such as JavaScript/Python.

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

