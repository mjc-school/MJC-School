# Annotation-based Container Configuration

## Materials
+ Overview
+ @Required
+ @Autowired
+ Annotation-based Autowiring with Qualifiers
+ @Resource
+ @Value
+ @PostConstruct and @PreDestroy

## Overview
Annotation-based configuration relies on the bytecode metadata for wiring up components. Instead of using XML to
describe a bean wiring, developer moves the configuration into the component class itself by using annotations on the
relevant class, method, or field declaration. Using a BeanPostProcessor in conjunction with annotations is a common
means of extending the Spring IoC container. For example, Spring 2.0 introduced the possibility of enforcing required
properties with the `@Required` annotation. Spring 2.5 made it possible to follow that same general approach to drive
Spring's dependency injection. Essentially, the `@Autowired` annotation provides the same capabilities as described
in [Autowiring Collaborators][1] but with more fine-grained control and wider applicability. Spring 2.5 also added
support for JSR-250 annotations, such as `@PostConstruct` and `@PreDestroy`. Spring 3.0 added support for JSR-330 (
Dependency Injection for Java) annotations contained in the `javax.inject` package such as `@Inject`
and `@Named` ([JSR 330 Standard Annotations][2]).

> Annotation injection is performed before XML injection. Thus, the XML configuration overrides the annotations for
> properties wired through both approaches.

As always, you can register the post-processors as individual bean definitions, but they can also be implicitly
registered by including the following tag in an XML-based Spring configuration (notice the inclusion of the context
namespace):

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        https://www.springframework.org/schema/context/spring-context.xsd">

    <context:annotation-config/>

</beans>
```

The `<context:annotation-config/>` element implicitly registers the following post-processors:

- [ConfigurationClassPostProcessor][3]
- [AutowiredAnnotationBeanPostProcessor][4]
- [CommonAnnotationBeanPostProcessor][5]
- [PersistenceAnnotationBeanPostProcessor][6]
- [EventListenerMethodProcessor][7]

> `<context:annotation-config/>` only looks for annotations on beans in the same application context in which it is
> defined. This means that, if you put `<context:annotation-config/>` in a `WebApplicationContext` for a
> `DispatcherServlet`, it only checks for `@Autowired` beans in your controllers, and not your services.

## @Required

The `@Required` annotation applies to bean property setter methods, as in the following example:

```java
public class MusicRatingService {

    private MusicRatesFinder musicRatesFinder;

    @Required
    public void setMusicRatesFinder(MusicRatesFinder musicRatesFinder) {
        this.musicRatesFinder = musicRatesFinder;
    }

    // ...
}
```

This annotation indicates that the affected bean property must be populated at configuration time, through an explicit
property value in a bean definition or through autowiring. The container throws an exception if the affected bean
property has not been populated. This allows for eager and explicit failure, avoiding `NullPointerException` instances
or the like later on. We still recommend that you put assertions into the bean class itself (for example, into an init
method). Doing so enforces those required references and values even when you use the class outside of a container.

The [RequiredAnnotationBeanPostProcessor][8] must be registered as a bean to enable support for the `@Required`
annotation.


> The `@Required` annotation and `RequiredAnnotationBeanPostProcessor` are formally deprecated as of
> Spring Framework 5.1, in favor of using constructor injection for required settings (or a custom implementation of
> `InitializingBean.afterPropertiesSet()` or a custom `@PostConstruct` method along with bean property setter methods).

## @Autowired

You can apply the `@Autowired` annotation to constructors, as the following example shows:

```java
public class MusicRatingService {

    private final MusicRatesFinder musicRatesFinder;

    @Autowired
    public MusicRatingService(MusicRatesFinder musicRatesFinder) {
        this.musicRatesFinder = musicRatesFinder;
    }

    // ...
}
```

> As of Spring Framework 4.3, an `@Autowired` annotation on such a constructor is no longer necessary if the target bean
> defines only one constructor to begin with. However, if several constructors are available and there is no
> primary/default constructor, at least one of the constructors must be annotated with `@Autowired` in order to instruct
> the container which one to use.

You can also apply the `@Autowired` annotation to traditional setter methods, to methods with arbitrary names and
multiple arguments, to fields and even mix it with constructors.

You can also instruct Spring to provide all beans of a particular type from the `ApplicationContext` by adding the
`@Autowired` annotation to a field or method that expects an array of that type, as the following example shows:

```java
public class MusicRatingService {

    @Autowired
    private MusicMagazine[] musicMagazines;

    // ...
}
```

The same applies for typed collections.

> Your target beans can implement the [Ordered][9] interface or use the `@Order` or standard `@Priority` annotation if
> you want items in the array or list to be sorted in a specific order. Otherwise, their order follows the registration
> order of the corresponding target bean definitions in the container.

Even typed `Map` instances can be autowired as long as the expected key type is String. The map values contain all beans
of the expected type, and the keys contain the corresponding bean names, as the following example shows:

```java
public class MusicRatingService {

    private Map<String, MusicMagazine> musicMagazines;

    @Autowired
    public void setMusicMagazines(Map<String, MusicMagazine> musicMagazines) {
        this.musicMagazines = musicMagazines;
    }

    // ...
}
```

By default, autowiring fails when no matching candidate beans are available for a given injection point. In the case of
a declared array, collection, or map, at least one matching element is expected.

The default behavior is to treat annotated methods and fields as indicating required dependencies. You can change this
behavior, enabling the framework to skip a non-satisfiable injection point through marking it as non-required (i.e., by
setting the required attribute in `@Autowired` to false):

```
@Autowired(required = false)
```

A non-required method will not be called at all if its dependency (or one of its dependencies, in case of multiple
arguments) is not available. A non-required field will not get populated at all in such cases, leaving its default value
in place.

Alternatively, you can express the non-required nature of a particular dependency through Java 8's `java.util.Optional`,
as the following example shows:

```java
public class MusicRatingService {

    private Optional<MusicRatesFinder> musicRatesFinder;

    @Autowired
    public void setMusicRatesFinder(Optional<MusicRatesFinder> musicRatesFinder) {
        this.musicRatesFinder = musicRatesFinder;
    }

    // ...
}
```

As of Spring Framework 5.0, you can also use a `@Nullable annotation` (of any kind in any package - for example,
`javax.annotation.Nullable` from JSR-305)

```java
public class MusicRatingService {

    private MusicRatesFinder musicRatesFinder;

    @Autowired
    public void setMusicRatesFinder(@Nullable MusicRatesFinder musicRatesFinder) {
        this.musicRatesFinder = musicRatesFinder;
    }

    // ...
}
```

You can also use `@Autowired` for interfaces that are well-known resolvable dependencies: `BeanFactory`,
`ApplicationContext`, `Environment`, `ResourceLoader`, `ApplicationEventPublisher`, and `MessageSource`. These
interfaces and their extended interfaces, such as `ConfigurableApplicationContext` or `ResourcePatternResolver`, are
automatically resolved, with no special setup necessary.

> The `@Autowired`, `@Inject`, `@Value`, and `@Resource` annotations are handled by Spring `BeanPostProcessor`
> implementations. This means that you cannot apply these annotations within your own `BeanPostProcessor` or
> `BeanFactoryPostProcessor` types (if any). These types must be 'wired up' explicitly by using XML or a Spring
> `@Bean` method.

## Annotation-based Autowiring with Qualifiers

If more than one bean of the same type is available in the container, the framework will throw
`NoUniqueBeanDefinitionException`. This is because Spring doesn't know which bean to inject. To avoid this problem,
there are several solutions, the `@Qualifier` annotation is one of them. You can associate qualifier values with
specific arguments, narrowing the set of type matches so that a specific bean is chosen for each argument. In the
simplest case, this can be a plain descriptive value, as shown in the following example:

```java
public class MusicRatingService {

    @Autowired
    @Qualifier("hardRock")
    private MusicMagazine musicMagazine;

    // ...
}
```

You can also specify the `@Qualifier` annotation on individual constructor arguments or method parameters.

The following example shows corresponding bean definitions.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        https://www.springframework.org/schema/context/spring-context.xsd">

    <context:annotation-config/>

    <bean class="com.somepackage.MusicMagazineImpl">
        <qualifier value="hardRock"/>
        <!-- inject any dependencies required by this bean -->
    </bean>

    <bean class="com.somepackage.MusicMagazineImpl">
        <qualifier value="heavyMetal"/>
        <!-- inject any dependencies required by this bean -->
    </bean>

    <bean id="musicRatingService" class="com.somepackage.MusicRatingService"/>

</beans>
```

You can create your own custom qualifier annotations and then provide it on autowired fields and parameters. To do so,
define your custom annotation, provide the `@Qualifier` annotation within its definition and use custom annotation for
appropriate autowired fields and parameters, as the following example shows:

```java

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
public @interface MusicGenre {

    String value();
}

public class MusicRatingService {

    @Autowired
    @MusicGenre("HeavyMetal")
    private MusicMagazine heavyMetalMusicMagazine;

    private MusicMagazine hardRockMusicMagazine;

    @Autowired
    public void setHardRockMusicMagazine(@MusicGenre("HardRock") MusicMagazine hardRockMusicMagazine) {
        this.hardRockMusicMagazine = hardRockMusicMagazine;
    }

    // ...
}
```

Next, you can provide the information for the candidate bean definitions. You can add `<qualifier/>` tags as
sub-elements of the `<bean/>` tag and then specify the `type` and `value` to match your custom qualifier annotations.
The type is matched against the fully-qualified class name of the annotation. Alternately, as a convenience if no risk
of conflicting names exists, you can use the short class name. The following example demonstrates both approaches:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        https://www.springframework.org/schema/context/spring-context.xsd">

    <context:annotation-config/>

    <bean class="com.somepackage.MusicMagazineImpl">
        <qualifier type="MusicGenre" value="HeavyMetal"/>
        <!-- inject any dependencies required by this bean -->
    </bean>

    <bean class="com.somepackage.MusicMagazineImpl">
        <qualifier type="com.somepackage.MusicGenre" value="HardRock"/>
        <!-- inject any dependencies required by this bean -->
    </bean>

    <bean id="musicRatingService" class="com.somepackage.MusicRatingService"/>

</beans>
```

## @Resource

Spring also supports injection by using the JSR-250 `@Resource` annotation (`javax.annotation.Resource`) on fields or
bean property setter methods.

`@Resource` takes a name attribute. By default, Spring interprets that value as the bean name to be injected. In other
words, it follows by-name semantics, as demonstrated in the following example:

```java
public class MusicRatingService {

    private MusicRatesFinder musicRatesFinder;

    @Resource(name = "myMusicRatesFinder")
    public void setMusicRatesFinder(MusicRatesFinder musicRatesFinder) {
        this.musicRatesFinder = musicRatesFinder;
    }
}
```

If no name is explicitly specified, the default name is derived from the field name or setter method. In case of a
field, it takes the field name. In case of a setter method, it takes the bean property name.

In the exclusive case of `@Resource` usage with no explicit name specified, and similar to `@Autowired`, `@Resource`
finds a primary type match instead of a specific named bean and resolves well known resolvable dependencies: the
`BeanFactory`, `ApplicationContext`, `ResourceLoader`, `ApplicationEventPublisher`, and `MessageSource` interfaces.

> - If `@Autowired` is used together with `@Qualifier`, it is the same as the `@Resource`.
> - `@Resource` only supports for fields and setter injection while `@Autowired` supports fields, setter, constructors and
  multi-argument methods injection.

## @Value

`@Value` is typically used to inject externalized properties:

```java

@Service
public class MusicRatingService {

    private final String musicMagazineName;

    public MusicRatingService(@Value("${musicMagazine.name}") String musicMagazineName) {
        this.musicMagazineName = musicMagazineName;
    }
}
```

With the following configuration:

```java

@Configuration
@PropertySource("classpath:application.properties")
public class Config {
}
```

And the following `application.properties` file:

```properties
musicMagazine.name=MetalHammer
```

In that case, the `musicMagazine` parameter and field will be equal to the `MetalHammer` value.

A default lenient embedded value resolver is provided by Spring. It will try to resolve the property value and if it
cannot be resolved, the property name (for example `${musicMagazine.name}`) will be injected as the value. If you want
to maintain strict control over nonexistent values, you should declare a `PropertySourcesPlaceholderConfigurer` bean, as
the following example shows:

```java

@Configuration
public class Config {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
```

> When configuring a `PropertySourcesPlaceholderConfigurer` using JavaConfig, the `@Bean` method must be static.

Using the above configuration ensures Spring initialization failure if any `${}` placeholder could not be resolved. It
is also possible to use methods like `setPlaceholderPrefix`, `setPlaceholderSuffix`, or `setValueSeparator` to customize
placeholders.

> Spring Boot configures by default a `PropertySourcesPlaceholderConfigurer` bean that will get properties from
> `application.properties` and `application.yml` files.

When `@Value` contains a [`SpEL` expression][10] the value will be dynamically computed at runtime as the following
example shows:

```java

@Service
public class MusicRatingService {

    private final String musicMagazineName;

    public MusicRatingService(@Value("#{systemProperties['user.musicMagazine'] + 'Music Magazine' }")
                                      String musicMagazineName) {
        this.musicMagazineName = musicMagazineName;
    }
}
```

## @PostConstruct and @PreDestroy

The `CommonAnnotationBeanPostProcessor` not only recognizes the `@Resource` annotation but also the JSR-250 lifecycle
annotations: `javax.annotation.PostConstruct` and `javax.annotation.PreDestroy`. Introduced in Spring 2.5, the support
for these annotations offers an alternative to the lifecycle callback mechanism described
in [initialization callbacks][11] and [destruction callbacks][12]. Provided that the `CommonAnnotationBeanPostProcessor`
is registered within the Spring `ApplicationContext`, a method carrying one of these annotations is invoked at the same
point in the lifecycle as the corresponding Spring lifecycle interface method or explicitly declared callback method. In
the following example, just simple message is logged into console upon initialization and upon destruction:

```java
public class MusicRatingService {

    @PostConstruct
    public void init() {
        System.out.println("Post construct is called");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Pre destroy is called");
    }
}
```

> Like `@Resource`, the `@PostConstruct` and `@PreDestroy` annotation types were a part of the standard Java libraries
> from JDK 6 to 8. However, the entire `javax.annotation` package got separated from the core Java modules in JDK 9 and
> eventually removed in JDK 11. If needed, the `javax.annotation-api` artifact needs to be obtained via Maven Central
> now, simply to be added to the application's classpath like any other library.

[1] https://docs.spring.io/spring-framework/docs/5.3.x/reference/html/core.html#beans-factory-autowire

[2] https://docs.spring.io/spring-framework/docs/5.3.x/reference/html/core.html#beans-standard-annotations

[3] https://docs.spring.io/spring-framework/docs/5.3.x/javadoc-api/org/springframework/context/annotation/ConfigurationClassPostProcessor.html

[4] https://docs.spring.io/spring-framework/docs/5.3.x/javadoc-api/org/springframework/beans/factory/annotation/AutowiredAnnotationBeanPostProcessor.html

[5] https://docs.spring.io/spring-framework/docs/5.3.x/javadoc-api/org/springframework/context/annotation/CommonAnnotationBeanPostProcessor.html

[6] https://docs.spring.io/spring-framework/docs/5.3.x/javadoc-api/org/springframework/orm/jpa/support/PersistenceAnnotationBeanPostProcessor.html

[7] https://docs.spring.io/spring-framework/docs/5.3.x/javadoc-api/org/springframework/context/event/EventListenerMethodProcessor.html

[8] https://docs.spring.io/spring-framework/docs/5.3.x/javadoc-api/org/springframework/beans/factory/annotation/RequiredAnnotationBeanPostProcessor.html

[9] https://docs.spring.io/spring-framework/docs/5.3.x/javadoc-api/org/springframework/core/Ordered.html

[10] https://docs.spring.io/spring-framework/docs/5.3.x/reference/html/core.html#expressions

[11] https://docs.spring.io/spring-framework/docs/5.3.x/reference/html/core.html#beans-factory-lifecycle-initializingbean

[12] https://docs.spring.io/spring-framework/docs/5.3.x/reference/html/core.html#beans-factory-lifecycle-disposablebean
