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
- using xml configuration files;
- using Java class.<br>

Configuring a application on base of spring framework through Java is a modern approach in comparison with xml one.<br>
Let's consider Java configuration:
```Java
 @Configuration
 @EnableWebMvc
@ComponentScan(basePackages = {"com.epam.mjc.school"})
 public class WebConfig
{
 //
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

When you need more complex configuration, you should remove the **@EnableWebMvc annotation** and extend **WebMvcConfigurationSupport class** directly.


