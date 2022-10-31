# Java-based Container Configuration

## Materials
+ Overview
+ Instantiating the Spring Container by Using AnnotationConfigApplicationContext
+ @Bean
+ @Configuration
+ Composing Java-based Configurations

## Overview
The central artifacts in Spring's Java-configuration support are `@Configuration`-annotated classes and
`@Bean`-annotated methods.

The `@Bean` annotation is used to indicate that a method instantiates, configures, and initializes a new object to be
managed by the Spring IoC container. The `@Bean` annotation plays the same role as the `<bean/>` element in XML
configuration. You can use `@Bean`-annotated methods with any Spring `@Component`. However, they are most often used
with `@Configuration` beans.

Annotating a class with `@Configuration` indicates that its primary purpose is as a source of bean definitions.
Furthermore, `@Configuration` classes let inter-bean dependencies be defined by calling other `@Bean` methods in the
same class.

## Instantiating the Spring Container by Using AnnotationConfigApplicationContext

When `@Configuration` classes are provided as input, the `@Configuration` class itself is registered as a bean
definition and all declared `@Bean` methods within the class are also registered as bean definitions.

When `@Component` and JSR-330 classes are provided, they are registered as bean definitions, and it is assumed that DI
metadata such as `@Autowired` or `@Inject` are used within those classes where necessary.

In much the same way that Spring XML files are used as input when instantiating a `ClassPathXmlApplicationContext`, you
can use `@Configuration` classes as input when instantiating an `AnnotationConfigApplicationContext`. This allows for
completely XML-free usage of the Spring container, as the following example shows:

```java
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        MyService myService = context.getBean(MyService.class);
        myService.doWork();
    }
}
```

You can instantiate an `AnnotationConfigApplicationContext` by using a no-arg constructor and then configure it by using
the `register()` method. This approach is particularly useful when programmatically building an
`AnnotationConfigApplicationContext`. The following example shows how to do so:

```java
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.register(Config.class, Config2.class);
        context.register(Config3.class);
        context.refresh();

        MyService myService = context.getBean(MyService.class);
        myService.doWork();
    }
}
```

To enable component scanning, you can annotate your `@Configuration` class with `@ComponentScan` annotation:

```java

@Configuration
@ComponentScan(basePackages = "com.somepackage")
public class Config {
    // your beans
    // ...
}
```

Equivalent XML declaration:

```xml

<beans>
    <context:component-scan base-package="com.somepackage"/>
</beans>
```

In the example above, the `com.somepackage` package is scanned to look for any `@Component`-annotated classes, and those
classes are registered as Spring bean definitions within the container. `AnnotationConfigApplicationContext` exposes the
`scan(String...)` method to allow for the same component-scanning functionality, as the following example shows:

```java
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.scan("com.somepackage");
        context.refresh();

        MyService myService = context.getBean(MyService.class);
        myService.doWork();
    }
}
```

## @Bean

`@Bean` is a method-level annotation and a direct analog of the XML `<bean/>` element. The annotation supports some
attributes offered by `<bean/>`, such as:

- [init-method][1]

- [destroy-method][2]

- [autowiring][3]

- `name`

You can use the `@Bean` annotation in a `@Configuration`-annotated or in a `@Component`-annotated class.

To declare a bean, you can annotate a method with the `@Bean` annotation. You use this method to register a bean
definition within an `ApplicationContext` of the type specified as the method's return value. By default, the bean name
is the same as the method name. A `@Bean`-annotated method can have an arbitrary number of parameters that describe the
dependencies required to build that bean. The following example shows a `@Bean` method declaration:

```java

@Configuration
public class Config {

    @Bean
    public MyService myService(MyRepository myRepository) {
        return new MyServiceImpl(myRepository);
    }

    // ...
}
```

Any classes defined with the `@Bean` annotation support the regular lifecycle callbacks and can use the `@PostConstruct`
and `@PreDestroy` annotations from JSR-250.

The `@Bean` annotation supports specifying arbitrary initialization and destruction callback methods, much like Spring
XML's `init-method` and `destroy-method` attributes on the bean element:

```java
public class MyBean1 {

    public void init() {
        // initialization logic
    }
}

public class MyBean2 {

    public void cleanup() {
        // destruction logic
    }
}

@Configuration
public class Config {

    @Bean(initMethod = "init")
    public MyBean1 myBean1() {
        return new MyBean1();
    }

    @Bean(destroyMethod = "cleanup")
    public MyBean2 myBean2() {
        return new MyBean2();
    }

    // ...
}
```

Spring includes the `@Scope` annotation so that you can specify the scope of a bean. The default scope is `singleton`,
but you can override this with the `@Scope` annotation, as the following example shows:

```java

@Configuration
public class Config {

    @Bean
    @Scope("prototype")
    public MyBean1 myBean1() {
        return new MyBean1();
    }

    // ...
}
```

By default, configuration classes use a `@Bean` method's name as the name of the resulting bean. This functionality can
be overridden, however, with the name attribute:

```java
  @Bean("myCustomName")
```

The `name` attribute of the `@Bean` annotation also accepts a String array:

```java
  @Bean({"myCustomName", "myCustomName1", "myCustomName2"})
```

## @Configuration

`@Configuration` is a class-level annotation indicating that an object is a source of bean definitions. `@Configuration`
classes declare beans through `@Bean`-annotated methods. Calls to `@Bean` methods on `@Configuration` classes can also
be used to define inter-bean dependencies:

```java
@Configuration
public class Config {

    @Bean
    public MyService myService() {
        MyServiceImpl myService = new MyServiceImpl();
        myService.setComponent(myComponent());
        return myService;
    }

    @Bean
    public MyAnotherService myAnotherService() {
        MyAnotherServiceImpl myService = new MyAnotherServiceImpl();
        myService.setComponent(myComponent());
        return myService;
    }


    @Bean
    public MyComponent myComponent() {
        return new MyComponentImpl();
    }
}
```

> This method of declaring inter-bean dependencies works only when the `@Bean` method is declared within a
> `@Configuration` class. You cannot declare inter-bean dependencies by using plain `@Component` classes.

## Composing Java-based Configurations

Spring's Java-based configuration feature lets you compose annotations, which can reduce the complexity of your
configuration.

Much as the `<import/>` element is used within Spring XML files to aid in modularizing configurations, the `@Import`
annotation allows for loading `@Bean` definitions from another configuration class, as the following example shows:

```java

@Configuration
public class Config1 {

    @Bean
    public MusicRatingService musicRatingService(MusicRatesFinder musicRatesFinder) {
        return new MusicRatingServiceImpl(musicRatesFinder);
    }
}

@Configuration
public class Config2 {

    @Bean
    public MusicRatesFinder musicRatesFinder(DataSource dataSource) {
        return new MusicRatesFinderImpl(dataSource);
    }
}

@Configuration
@Import({Config1.class, Config2.class})
public class Config3 {

    @Bean
    public DataSource dataSource() {
        // return new DataSource
    }
}

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Config3.class);
        // everything wires up across configuration classes...
        MusicRatingService musicRatingService = ctx.getBean(MusicRatingService.class);
        musicRatingService.provideRatings("HeavyMetal");
    }
}
```

It is often useful to conditionally enable or disable a complete `@Configuration` class or even individual `@Bean`
methods, based on some arbitrary system state. One common example of this is to use the `@Profile` annotation to
activate beans only when a specific profile has been enabled in the Spring `Environment`.

The `@Profile` annotation is actually implemented by using a much more flexible annotation called [@Conditional][4]. The
`@Conditional` annotation indicates specific `org.springframework.context.annotation.Condition` implementations that
should be consulted before a `@Bean` is registered.

Implementations of the `Condition` interface provide a `matches(...)` method that returns `true` or `false`. For
example, the following listing shows the actual `Condition` implementation used for `@Profile`:

```java
class ProfileCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        MultiValueMap<String, Object> attrs = metadata.getAllAnnotationAttributes(Profile.class.getName());
        if (attrs != null) {
            for (Object value : attrs.get("value")) {
                if (context.getEnvironment().acceptsProfiles(Profiles.of((String[]) value))) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

}

```

[1] https://docs.spring.io/spring-framework/docs/5.3.x/reference/html/core.html#beans-factory-lifecycle-initializingbean

[2] https://docs.spring.io/spring-framework/docs/5.3.x/reference/html/core.html#beans-factory-lifecycle-disposablebean

[3] https://docs.spring.io/spring-framework/docs/5.3.x/reference/html/core.html#beans-factory-autowire

[4] https://docs.spring.io/spring-framework/docs/5.3.x/javadoc-api/org/springframework/context/annotation/Conditional.html
