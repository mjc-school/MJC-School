# REST API Advanced
This task is an extension of the RESTful web-service from Module #2 REST API Basics.

## Sub-module #1 - Spring Boot
Spring Boot makes it easy to create stand-alone, production-grade Spring based Applications that you can "just run". 
In this module you will learn how to create RESTful web service using Spring Boot. 

### Task #1
1. Migrate your existing Spring application from a previous module to a Spring Boot application.

### Materials (Videos & Links)
* [Spring Boot: Intro (video)](https://videoportal.epam.com/video/6Rn164or)
* [Spring Boot official page](https://spring.io/projects/spring-boot/)
* [Spring Boot Hello World tutorial](https://spring.io/guides/gs/rest-service/)
* [Spring Initializr](https://start.spring.io/)
* [Spring Boot: от начала до продакшена](https://habr.com/ru/post/257223/)


## Sub-module #2 - REST API
This sub-module is an extension of REST API Basic and it covers such topics as pagination, sorting, filtering and HATEOAS.

Please imagine that your application has a lot of data, so when you make a GET request it will return, for instance, 1 million records. 
This will take much time to process such request and return the result to the consumer of your API. 
That is exactly what pagination, sorting, and filtering can solve.

The other topic is HATEOAS what stands for the phrase "Hypermedia As The Engine Of Application State". 
When you are viewing a web page, you see data on it and can perform some actions with this data. 
In REST when you request a resource you get the details of the resource in the response. 
Along with it you can send the operations that you can perform on the resource. 
And this is what HATEOAS does.

### Task #2
The application should be extended to expose the following REST APIs:
1. Change single field of main entity.
2. Make an order (or any relevant action) on main entity for a User.
3. Get information about user’s orders.
4. Get information about user’s order: cost and timestamp of a purchase.
5. Get the most widely used secondary entity of a user with the highest cost of all orders. 
    * Demonstrate SQL execution plan for this query.
6. Search main entity by several secondary entities (“and” condition).
7. Pagination should be implemented for all GET-all endpoints. Please create a flexible and non-erroneous solution. Handle all exceptional cases.
8. Support HATEOAS on REST endpoints.
9. For demo, generate at least:
    * 1000 users;
    * 1000 secondary entities;
    * 10 000 main entities;
    * all entities should be linked, all values should look meaningful: random words, but not random letters. 
10. APIs should be demonstrated using Postman tool. 
11. For demo, prepare Postman collections with APIs.

### Materials (Videos & Links)
* [REST API Design: Filtering, Sorting, and Pagination](https://www.moesif.com/blog/technical/api-design/REST-API-Design-Filtering-Sorting-and-Pagination/)
* [REST Pagination in Spring](https://www.baeldung.com/rest-api-pagination-in-spring/)
* [Что такое HATEOAS?](https://habr.com/ru/post/483328/)
* [HATEOAS with Spring](https://spring.io/guides/gs/rest-hateoas/)
* [Richardson Maturity Model](https://martinfowler.com/articles/richardsonMaturityModel.html)


## Sub-module #3 - JPA

Sub-module description

### Task #3

Task description & conditions


## Sub-module #4 - Authentication

Sub-module description

### Task #4 
Application should support user-based authentication. This means a user is stored in a database with some basic information and a password.

User Permissions
1. Guest:
    1. Read operations for main entity. 
    2. Signup.
    3. Login.
2. User:
    1. Make an order on main entity. 
    2. All read operations.
3. Administrator (can be added only via database call):
    1. All operations, including addition and modification of entities.

