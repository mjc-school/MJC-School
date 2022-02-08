## REST with Spring

https://www.baeldung.com/rest-with-spring-series

### Understanding REST in Spring

The Spring framework supports two ways of creating RESTful services:
- using MVC with ModelAndView
- using HTTP message converters
The ModelAndView approach is older and much better documented, but also more verbose and configuration heavy. 
The new approach, based on **HttpMessageConverter and annotations**, is much more lightweight and easy to implement.
Configuration is minimal, and it provides sensible defaults for what you would expect from a RESTful service.
  
### The Java Configuration
Spring framework provides two ways of configuring a RESTful application:
- using xml configuration files;
- using Java class.
Configuring a application on base of spring framework through Java is a modern approach in comparison with xml one.
Let's consider Java configuration:
```Java
> @Configuration
> @EnableWebMvc
> public class WebConfig{
> //
> }
```
