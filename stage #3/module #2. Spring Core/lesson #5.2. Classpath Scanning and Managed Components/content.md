# Classpath Scanning and Managed Components

## Materials
+ Overview
+ @Component and Further Stereotype Annotations
+ Using Meta-annotations and Composed Annotations
+ Automatically Detecting Classes and Registering Bean Definitions
+ Using Filters to Customize Scanning
+ Naming Autodetected Components
+ Providing a Scope for Autodetected Components
+ Providing Qualifier Metadata with Annotations


## Overview
Annotation-based Container Configuration demonstrates how to provide a lot of the configuration metadata through
source-level annotations, however, the "base" bean definitions are explicitly defined in the XML file, while the
annotations drive only the dependency injection. Here we describe an option for implicitly detecting the candidate
components by scanning the classpath. Candidate components are classes that match against a filter criteria and have a
corresponding bean definition registered with the container. This removes the need to use XML to perform bean
registration. Instead, you can use annotations (for example, `@Component`), AspectJ type expressions, or your own custom
filter criteria to select which classes have bean definitions registered with the container.

## @Component and Further Stereotype Annotations

Spring provides further stereotype annotations: `@Component`, `@Service`, and `@Controller`. `@Component` is a generic
stereotype for any Spring-managed component. `@Repository`, `@Service`, and `@Controller` are specializations
of `@Component` for more specific use cases (in the persistence, service, and presentation layers, respectively).
Therefore, you can annotate your component classes with `@Component`, but, by annotating them with `@Repository`,
`@Service`, or `@Controller` instead, your classes are more properly suited for processing by tools or associating with
aspects. For example, these stereotype annotations make ideal targets for pointcuts. `@Repository`, `@Service`,
and `@Controller` can also carry additional semantics in future releases of the Spring Framework. Thus, if you are
choosing between using `@Component` or `@Service` for your service layer, `@Service` is clearly the better choice.
Similarly,  `@Repository` is already supported as a marker for automatic [exception translation][1] in your persistence
layer.

## Using Meta-annotations and Composed Annotations

Many of the annotations provided by Spring can be used as meta-annotations in your own code. A meta-annotation is an
annotation that can be applied to another annotation. For example, the `@Service` annotation mentioned earlier is
meta-annotated with `@Component`, as the following example shows:

```java

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface Service {

    // ...
}
```

The `@Component` causes `@Service` to be treated in the same way as `@Component`.

You can also combine meta-annotations to create "composed annotations". For example, the `@RestController` annotation
from Spring MVC is composed of `@Controller` and `@ResponseBody`.

## Automatically Detecting Classes and Registering Bean Definitions

Spring can automatically detect stereotyped classes and register corresponding `BeanDefinition` instances with the
`ApplicationContext`. For example, the following two classes are eligible for such autodetection:

```java

@Service
public class MusicRatingService {

    private MusicRatesFinder musicRatesFinder;

    public MusicRatingService(MusicRatesFinder musicRatesFinder) {
        this.musicRatesFinder = musicRatesFinder;
    }

    // ...
}

@Repository
public class MusicRatesFinderImpl implements MusicRatesFinder {
    // ...
}
```

To autodetect these classes and register the corresponding beans, you need to add `@ComponentScan` to
your `@Configuration` class, where the `basePackages` attribute is a common parent package for the two classes. 
Alternatively, you can specify a comma- or semicolon- or space-separated list that includes the parent package of each
class.

```java

@Configuration
@ComponentScan(basePackages = "com.somepackage")
public class Config {
    // ...
}
```

The following alternative uses XML:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        https://www.springframework.org/schema/context/spring-context.xsd">

    <context:component-scan base-package="com.somepackage"/>

</beans>
```

> The use of `<context:component-scan>` implicitly enables the functionality of `<context:annotation-config>`. There is
> usually no need to include the `<context:annotation-config>` element when using `<context:component-scan>`.

## Using Filters to Customize Scanning

By default, classes annotated with `@Component`, `@Repository`, `@Service`, `@Controller`, `@Configuration`, or a custom
annotation that itself is annotated with `@Component` are the only detected candidate components. However, you can
modify and extend this behavior by applying custom filters. Add them as `includeFilters` or `excludeFilters` attributes
of the `@ComponentScan` annotation. Each filter element requires the `type` and `expression` attributes.

The following example shows the configuration ignoring all `@Repository` annotations and using "stub" repositories
instead ([see more details about filtering options][2]):

```java

@Configuration
@ComponentScan(basePackages = "com.somepackage",
        includeFilters = @Filter(type = FilterType.REGEX, pattern = ".*Stub.*Repository"),
        excludeFilters = @Filter(Repository.class))
public class Config {
    // ...
}
```

## Naming Autodetected Components

When a component is autodetected as part of the scanning process, its bean name is generated by the `BeanNameGenerator`
strategy known to that scanner. By default, any Spring stereotype annotation (`@Component`, `@Repository`,
`@Service`, and `@Controller`) that contains a name `value` thereby provides that name to the corresponding bean
definition.

If such an annotation contains no name `value` or for any other detected component (such as those discovered by custom
filters), the default bean name generator returns the uncapitalized non-qualified class name. For example, if the
following component classes were detected, the names would be `myMusicService` and `musicRatesFinderImpl`:

```java

@Service("myMusicService")
public class MusicService {
    // ...
}

@Repository
public class MusicRatesFinderImpl implements MusicRatesFinder {
    // ...
}
```

If you do not want to rely on the default bean-naming strategy, you can provide a custom bean-naming strategy. First,
implement the `BeanNameGenerator` interface, and be sure to include a default no-arg constructor. Then, provide the
fully qualified class name when configuring the scanner, as the following example annotation and bean definition show.

```java

@Configuration
@ComponentScan(basePackages = "com.somepackage", nameGenerator = MyNameGenerator.class)
public class Config {
    // ...
}
```

## Providing a Scope for Autodetected Components

As with Spring-managed components in general, the default and most common scope for autodetected components is
`singleton`. However, sometimes you need a different scope that can be specified by the `@Scope` annotation. You can
provide the name of the scope within the annotation, as the following example shows:

```java

@Scope("prototype")
@Repository
public class MusicRatesFinderImpl implements MusicRatesFinder {
    // ...
}
```

## Providing Qualifier Metadata with Annotations

When relying upon classpath scanning for auto-detection of components, you can provide the qualifier metadata with
type-level annotations on the candidate class:

```java

@Component
@Qualifier("Main")
public class MusicMagazineImpl implements MusicMagazine {
    // ...
}

@Component
@MusicGenre("HeavyMetal")
public class MusicMagazineImpl implements MusicMagazine {
    // ...
}
```

[1] https://docs.spring.io/spring-framework/docs/5.3.x/reference/html/data-access.html#orm-exception-translation

[2] https://docs.spring.io/spring-framework/docs/5.3.x/reference/html/core.html#beans-scanning-filters
