## Spring REST Application Configuration

Spring framework provides two ways of configuring a RESTful application:
- using xml configuration files such as web.xml and SpringApplicationContext.xml;
- using Java class.<br>

Let's consider the most widely used approach to configuring a spring REST application which is based on
**Java based Web Configurations**<br>

### Java based Web Configurations

Configuring a application on base of spring framework through Java is a modern approach in comparison with xml one.<br>
Let's consider Java configuration:
```Java
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.epam.mjc.school"})
public class WebConfig
{
 //...
}
```
The **@Configuration annotation** is the central artifact of Spring’s Java-configurations. **@Configuration** is a meta-annotated as a @Component
which make is eligible for component scanning, it also gives the flexibility to use **@Autowired annotations**.
A class annotated with **@Configuration annotation** shows that this can be used by **Spring IoC container** for bean definitions.<br>
The new **@EnableWebMvc annotation** does some useful things – specifically, in the case of REST,
it detects the existence of Jackson and JAXB 2 on the classpath and automatically creates and registers default JSON and XML converters.
The functionality of the annotation is equivalent to the XML version:<br>
> <mvc:annotation-driven />

**@ComponentScan annotation** with **@Configuration classes** enables Spring to scan all classes through the package and will register all beans and controller for our application.

`The WebConfig class` shown above will set up the basic support you need for a spring web project, such as registering controllers and mappings, type converters, validation support,
message converters and exception handling. The config class will replace `SpringApplicationContext.xml` which is used in xml configuration.

If we want to customize this configuration, you should implement the **WebMvcConfigurer interface** or remove the **@EnableWebMvc annotation** and extend **WebMvcConfigurationSupport class** directly.
```Java
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.epam.mjc.school"})
public class WebConfig implements WebMvcConfigurer 
{
// ...
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
    ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher",  new DispatcherServlet(servletAppContext));
    dispatcher.setLoadOnStartup(1);
    dispatcher.addMapping("/");

    //add specific encoding (e.g. UTF-8) via CharacterEncodingFilter 
    FilterRegistration.Dynamic encodingFilter = servletContext.addFilter("encoding-filter", new CharacterEncodingFilter());
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


