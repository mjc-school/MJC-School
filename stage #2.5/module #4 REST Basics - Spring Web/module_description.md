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
Example:

a = 5 // It is Idempotence, as final value(a = 5) would not change after executing it multiple times.
 
a++ // It is not Idempotence because the final value will depend upon the number of times the statement is executed.

- _**Safety:**_ The concepts of ‘idempotent methods’ and ‘safe methods’ are often confused. 
A safe method does not change the value that is returned, it reads – but it never writes. 
Example:

x + 0; //it is idempotent and also safe, as final value x would not change after executing it multiple times.

x = 5; //it is idempotent but is not safe, as original value x could be changed to 5

The first of these, adding zero, will return the same value every time (it is idempotent), and adding zero will have no effect on that value (it is also safe). 
The second example will return the same value every time (it is idempotent) but is not safe (if x is anything other than 5 before the operation runs, it changes x).
Therefore, all safe methods are idempotent, but not all idempotent methods are safe.


## REST architectural constraints
- **Client-Server:** [TO DO]
- **Uniform Interface:** [TO DO]
- **Stateless:** [TO DO]
- **Cacheable:** [TO DO]
- **Layered System:** [TO DO]
- **Code on demand (optional):** [TO DO]

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

