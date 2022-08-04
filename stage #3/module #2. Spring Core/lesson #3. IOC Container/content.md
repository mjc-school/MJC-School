# IoC Container

## Materials
+ Inversion of Control
+ Spring IoC Container
+ Configuration Metadata
+ Instantiating a Container
+ Using the Container

## Inversion of Control

Inversion of Control is a principle in software engineering which transfers the control of objects or portions of a
program to a container or framework. We most often use it in the context of object-oriented programming.

In contrast with traditional programming, in which our custom code makes calls to a library, IoC enables a framework to
take control of the flow of a program and make calls to our custom code. To enable this, frameworks use abstractions
with additional behavior built in. If we want to add our own behavior, we need to extend the classes of the framework or
plugin our own classes.

The advantages of this architecture are:

- decoupling the execution of a task from its implementation
- making it easier to switch between different implementations
- greater modularity of a program
- greater ease in testing a program by isolating a component or mocking its dependencies, and allowing components to
  communicate through contracts

We can achieve Inversion of Control through various mechanisms such as:
Strategy design pattern, Service Locator pattern, Factory pattern, and Dependency Injection (DI).

## Spring IoC Container

In Spring, the objects that form the backbone of your application and that are managed by the Spring IoC container are
called beans. A bean is an object that is instantiated, assembled, and managed by a Spring IoC container. In other
words, a bean is simply one of many objects in your application. Beans, and the dependencies among them, are reflected
in the configuration metadata used by a container.

The [org.springframework.context.ApplicationContext][1] interface represents the Spring IoC container and is responsible
for instantiating, configuring, and assembling the beans. The container gets its instructions on what objects to
instantiate, configure, and assemble by reading configuration metadata. The configuration metadata is represented in
XML, Java annotations or Java code. It lets you express the objects that compose your application and the rich
interdependencies between those objects.

Several implementations of the `ApplicationContext` interface are supplied with Spring. In stand-alone applications, it
is common to create an instance of [ClassPathXmlApplicationContext][2] or [FileSystemXmlApplicationContext][3]. While
XML has been the traditional format for defining configuration metadata, you can instruct the container to use Java
annotations or Java code as the metadata as well using [AnnotationConfigApplicationContext][4] or even to use Groovy
script using [GenericGroovyApplicationContext][5]. But in most application scenarios, explicit user code is not required
to instantiate one or more instances of a Spring IoC container.

The following diagram shows a high-level view of how Spring works. Your application classes are combined with
configuration metadata so that, after the `ApplicationContext` is created and initialized, you have a fully configured
and executable system or application.

![Spring IoC Container](media/spring-container.png)

## Configuration Metadata

As the preceding diagram shows, the Spring IoC container consumes a form of configuration metadata. This configuration
metadata represents how you, as an application developer, tell the Spring container to instantiate, configure, and
assemble the objects in your application. Configuration metadata can be supplied in different formats:

- XML configuration example

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans 
        https://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="myComponent" class="com.somepackage.MyComponentImpl"/>

    <bean id="myService" class="com.somepackage.MyServiceImpl">
        <property name="myComponent" ref="myComponent"/>
    </bean>

    <!-- other bean definitions -->
</beans>
```

- Annotation-based configuration example

```java

@Component
public class MyComponentImpl implements MyComponent {
    // ...
}

@Service
public class MyServiceImpl implements MyService {

    private final MyComponent myComponent;

    @Autowired
    public MyServiceImpl(MyComponent myComponent) {
        this.myComponent = myComponent;
    }

    // ...
}
```

- Java-based configuration example

```java

@Configuration
public class Config {

    @Bean
    public MyComponent myComponent() {
        return new MyComponentImpl();
    }

    @Bean
    public MyService myService(MyComponent myComponent) {
        return new MyServiceImpl(myComponent);
    }

    // ...
}
```

- Groovy configuration example

```groovy
beans {
    myComponent(com.somepackage.MyComponentImpl) {}

    myService(com.somepackage.MyServiceImpl) {
        myComponent = ref('myComponent')
    }

    // ...
}
```

Spring configuration consists of at least one and typically more than one bean definition that the container must
manage. These bean definitions correspond to the actual objects that make up your application. Typically, you define
service layer objects, data access objects (DAOs), presentation objects, infrastructure objects, and so forth.
Typically, one does not configure fine-grained domain objects in the container, because it is usually the responsibility
of DAOs and business logic to create and load domain objects. However, you can use Spring's integration with AspectJ to
configure objects that have been created outside the control of an IoC container.
See [Using AspectJ to dependency-inject domain objects with Spring][6].

## Instantiating a Container

The location path or paths supplied to an `ApplicationContext` constructor are resource strings that let the container
load configuration metadata from a variety of external resources, such as the local file system, the Java CLASSPATH, and
so on (see some examples below).

```
ApplicationContext context = new ClassPathXmlApplicationContext("config1.xml", "config2.xml");
```

```
ApplicationContext ctx = new AnnotationConfigApplicationContext("com.somepackage");
```

```
ApplicationContext context = new GenericGroovyApplicationContext("config.groovy");
```

## Using the Container

The `ApplicationContext` is the interface for an advanced factory capable of maintaining a registry of different beans
and their dependencies. By using the method `T getBean(String name, Class<T> requiredType)`, you can retrieve instances
of your beans.

The `ApplicationContext` lets you read bean definitions and access them, as the following example shows:

```java

public class Main {
    public static void main(String[] args) {
        // create and configure beans
        ApplicationContext context = new ClassPathXmlApplicationContext("config1.xml", "config2.xml");

//        or
//
//        ApplicationContext context = new AnnotationConfigApplicationContext("com.package");
//
//        or
//
//        ApplicationContext context = new GenericGroovyApplicationContext("config.groovy");

        // retrieve configured instance
        MyService myService = context.getBean(MyService.class);

        // use configured instance
        myService.doWork();
    }
}

```

You can use `getBean()` to retrieve instances of your beans. The `ApplicationContext` interface has a few other methods
for retrieving beans, but, ideally, your application code should never use them. Indeed, your application code should
have no calls to the `getBean()` method at all and thus have no dependency on Spring APIs at all. For example, Spring's
integration with web frameworks provides dependency injection for various web framework components such as controllers
and JSF-managed beans, letting you declare a dependency on a specific bean through metadata (such as an autowiring
annotation).

[1]: https://docs.spring.io/spring-framework/docs/5.3.x/javadoc-api/org/springframework/context/ApplicationContext.html

[2]: https://docs.spring.io/spring-framework/docs/5.3.x/javadoc-api/org/springframework/context/support/ClassPathXmlApplicationContext.html

[3]: https://docs.spring.io/spring-framework/docs/5.3.x/javadoc-api/org/springframework/context/support/FileSystemXmlApplicationContext.html

[4]: https://docs.spring.io/spring-framework/docs/5.3.x/javadoc-api/org/springframework/context/annotation/AnnotationConfigApplicationContext.html

[5]: https://docs.spring.io/spring-framework/docs/5.3.x/javadoc-api/org/springframework/context/support/GenericGroovyApplicationContext.html

[6]: https://docs.spring.io/spring-framework/docs/5.3.x/reference/html/core.html#aop-atconfigurable
