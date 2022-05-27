## REST with Spring

### Understanding REST in Spring

The Spring framework supports two ways of creating RESTful services:
- using MVC with ModelAndView;
- using HTTP message converters.<br>

The **ModelAndView approach** is older and much better documented, but also more verbose and configuration heavy. 
The new approach, based on **HttpMessageConverter and annotations**, is much more lightweight and easy to implement.
Configuration is minimal, and it provides sensible defaults for what you would expect from a RESTful service.

Let's consider how to build REST application using Spring Web framework step by step.

### [REST Controllers in Spring](./spring-rest-controller-content.md)

### [Spring REST Application Configuration](./spring-rest-application-configuration-content.md)

### [Versioning a REST API in Spring](./spring-versioning-rset-api-content.md)

### [REST Pagination in Spring](./spring-rest-pagination-content.md)

### [Spring HATEOAS](./spring-hateoas-content.md)