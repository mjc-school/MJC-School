# REST Basics - Spring Web

## Basics of RESTful APIs
_**REST is an API architecture style.**_ It stands for Representational State Transfer (REST). 
RREST is an architectural style that defines a set of constraints to be used for creating web services. 
REST API is a way of accessing web services in a simple and flexible way without having any processing.
REST technology is generally preferred to the more robust Simple Object Access Protocol (SOAP) technology because REST uses less bandwidth, 
simple and flexible making it more suitable for internet usage. It’s used to fetch or give some information from a web service. 
All communication done via REST API uses only HTTP request.

## Richardson REST API Maturity Model
The Richardson REST Maturity Model describes four different levels of REST (starting at Level 0). A REST API that supports hypermedia controls is classified as Level 3 in this maturity model.<br>
- **Level 0 - a single URI and use a single HTTP method (typically POST):** <br> These services have a single URI and use a single HTTP method (typically POST). These are the most primitive way of building SOA applications with a single POST method and using XML to communicate between services.Level zero of maturity does not make use of any of URI, HTTP Methods, and HATEOAS capabilities.

- **Level 1 - different URLs for different resources but use a single HTTP method (typically POST):** <br> API design at Level 1 is all about using different URLs to interact with the different resources in your application but only a single HTTP verb – generally HTTP POST. These services will give each resource, available in the application, a unique URI. A unique URI separately identifies one unique resource – and that makes these REST API better than level zero.

- **Level 2 - HTTP Verbs:** <br>
- Level 2 of maturity uses different URIs and HTTP Methods, but does not use the HATEOAS. Such RSET API supports several of the HTTP verbs on each exposed resource – Create, Read, Update and Delete (CRUD) operations. Here the state of resources, typically representing business entities, can be manipulated over the network.Maturity level 2 is the most popular usecase of REST principles, which advocate using different verbs based on the HTTP request methods, while the system can have multiple resources.

- **Level 3 - Hypermedia Controls:** <br>

## Some definitions related to REST API

- _**Resource:**_ <br> The key abstraction of information in REST is a resource. Any information that can be named can be a resource: a document or image, a temporal service (e.g. "today's weather in Los Angeles"), a collection of other resources, a non-virtual object (e.g. a person), and so on. In other words, any concept that might be identified by a URL provided by the server can be called a resource. A resource is an object with a type, associated data, relationships to other resources, and a set of methods that operate on it. It is similar to an object instance in an object-oriented programming language, with the important difference that only a few standard methods are defined for the resource (corresponding to the standard HTTP GET, POST, PUT and DELETE methods), while an object instance typically has many methods.Resources can be singleton or grouped into collections. <br>
_**1.Singleton and Collection Resources**_<br>
For example, _“customers”_ is a collection resource and _“customer”_ is a singleton resource (in a banking domain).We can identify _“customers”_ collection resource using the URI **“/customers“**.  We can identify a single _“customer”_ resource using the URI **“/customers/{customerId}“**.<br>
_**2.Collection and Sub-collection Resources**_<br>
A resource may contain sub-collection resources also. For example, sub-collection resource _“accounts”_ of a particular _“customer”_ can be identified using the URN **“/customers/{customerId}/accounts”** (in a banking domain). Similarly, a singleton resource _“account”_ inside the sub-collection resource _“accounts”_ can be identified as follows: **“/customers/{customerId}/accounts/{accountId}“**.

- _**Resource state:**_ <br> Resource state is the current state of a resource on a server at any point in time – and it has nothing to do with the interaction between client and server. It is what we get as a response from the server as the API response. We refer to it as resource representation.

- _**Resource representations:**_ <br> A server can provide different representations for the same resource. A resource state can be represented in multiple formats, such as JSON, XML, YAML, etc. A client can use _**content negotiation (Accept ot Content-Type)**_ to request different representations of the same resource.

- _**Resource identifiers:**_ <br> REST APIs use _**Uniform Resource Identifiers (URIs)**_ to address resources. REST API designers should create URIs that convey a REST API’s resource model to the potential clients of the API. When resources are named well, an API is intuitive and easy to use. If done poorly, that same API can be challenging to use and understand. Creating URIs for resources you should follow the principale (the best practice) described lower in this document.

- _**Application state:**_<br>
Application state is server-side data that servers store to identify incoming client requests, their previous interaction details, and current context information.
It is important to understand the difference between the application state and the resource state. Both are completely different things.

- _**Stateless:**_ Statelessness means that every HTTP request happens in complete isolation. When the client makes an HTTP request, it includes all information necessary for the server to fulfill the request. The server never relies on information from previous requests from the client and doesn't store state about the client session on the server-side. If any such information is important then the client will send that as part of the current request. REST statelessness means being free from the application state.

- _**REST API endpoint:**_ An endpoint is one end of a communication channel. When an API interacts with another system, the touchpoints of this communication are considered endpoints. For APIs, an endpoint can include a URL of a server or service. Each endpoint is the location from which APIs can access the resources they need to carry out their function.
APIs work using ‘requests’ and ‘responses.’ When an API requests information from a web application or web server, it will receive a response. The place that APIs send requests and where the resource lives, is called an endpoint.

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

1.**Client-Server:**<br> REST application should have a client-server architecture. This constraint essentially means that client applications and server applications MUST be able to evolve separately without any dependency on each other. A client should know only resource URIs, and that’s all. A Client requests resources and is not concerned with data storage, which remains internal to each server, and server holds the resources and is not concerned with the user interface or user state. They can evolve independently. Client doesn’t need to know anything about business logic and server doesn’t need to know anything about frontend UI.

2.**Uniform Interface:**<br> It is a key constraint that differentiate between a REST API and Non-REST API. It suggests that there should be an uniform way of interacting with a given server irrespective of device or type of application (website, mobile app).
There are four guidelines principle of Uniform Interface are:
- _**Resource-Based:**_ Individual resources are identified in requests. For example: API/users.<br>
- _**Manipulation of Resources Through Representations:**_ Client has representation of resource and it contains enough information to modify or delete the resource on the server, provided it has permission to do so. Example: Usually user get a user id when user request for a list of users and then use that id to delete or modify that particular user.
- _**Self-descriptive Messages:**_ Each message includes enough information to describe how to process the message so that server can easily analyses the request.
- _**Hypermedia as the Engine of Application State (HATEOAS):**_ It need to include links for each response so that client can discover other resources easily.

3.**Stateless:**<br> The restriction is called _**Statelessness**_ if the server does not store any data about the client session on the server-side.  It means that the necessary data\state to handle the request is contained within the request itself and server would not store anything related to the client session. The server will not store anything about the latest HTTP request the client made. It will treat every request as new. _No client context shall be stored on the server between requests. No session, no history. The client is responsible for managing the state of the application._ In REST, the client must include all information for the server to fulfill the request whether as a part of query params, headers or URI. For making REST API stateless, Even authentication/authorization details of the client should not be stored on the server side. Provide authentication credentials with each request. Statelessness enables greater availability since the server does not have to maintain, update or communicate that client session state. There is a drawback when the client need to send too much data to the server so it reduces the scope of network optimization and requires more bandwidth.

4.**Cacheable:**<br> In order to provide a better performance, the applications are often made cacheable. Every response should include whether the response is cacheable or not and for how much duration responses can be cached at the client side. Client will return the data from its cache for any subsequent request and there would be no need to send the request again to the server. A well-managed caching partially or completely eliminates some client–server interactions, further improving availability and performance. But sometime there are chances that user may receive stale data To prevent it, the cached data needs to be updated each time the data is getting updated server side.

5.**Layered System:**<br> This constraint tells that the architecture of the application can be layered, without letting the client know about it.
An application architecture needs to be composed of multiple layers. Each layer doesn’t know any thing about any layer other than that of immediate layer and 
there can be lot of intermediate servers(layers) between client and the end server. 
Intermediary servers may improve system availability by enabling load-balancing and by providing shared caches.

6.**Code on demand (optional):**<br> It is an optional feature. According to this, servers can also provide executable code to the client. The examples of code on demand may include a UI widget rendering code or client-side scripts such as JavaScript/Python.

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

