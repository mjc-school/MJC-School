# Dependency Injection

## Materials
+ What is a Dependency?
+ What Is Dependency Injection?
+ Dependency Injection In Spring
+ Types of Dependency injection in Spring

## What is a Dependency?

A typical Java application will have three layers in its architecture: web, business and data.

- The web layer
- The business layer
- The data layer

In the above scenario:

Web Layer depends on Business Layer. The business layer is a dependency for the web layer. Business layer depends on
Data Layer. The data layer is a dependency for the business layer.

Let’s look at an example:

```java

@Repository
public class MyRepository {
    // some database-related code goes here...
}

@Service
public class MyService {
    
    private final MyRepository repository;

    public MyService(MyRepository repository) {
        this.repository = repository;
    }

    public Data readSomeDataById(Long id) {
        return repository.findDataById(id);
    }

    public void saveSomeData(Data data) {
        repository.saveData(data);
    }
}

@RestController
public class MyController {
    private final MyService service;

    public MyController(MyService service) {
        this.service = service;
    }
    
    // some end-points definition code goes here...
}
```

In the example above MyService is the business class, and it makes use of one data layer class - MyRepository.
Also, we have two methods defined in MyService class:

- readSomeDataById - returns data by provided id
- saveSomeData - saves provided data

Both methods in MyService require MyRepository instance to do their logic. MyRepository is a dependency
of MyService.

## What Is Dependency Injection?

Dependency injection is the core feature of the Spring Framework. Dependency injection is a concept that is borrowed
from the Dependency Inversion Principle (DIP).

Have a look at the following example of code:

```java
public class ComplexAlgorithm {
    
    private final BubbleSortingAlgorithm sortingAlgorithm = new BubbleSortingAlgorithm();
}
```

ComplexAlgorithm is meant to perform a lot of complex logic, and one of the things it does is sorting. Here, it is
directly creating an instance of BubbleSortingAlgorithm within itself.

This is the example of tight coupling in the code.

Imagine what you need to do, if you want to change the sort algorithm to quicksort. You need to change the relevant code
within ComplexAlgorithm.

Hence, ComplexAlgorithm is tightly coupled to BubbleSortAlgorithm, a specific sort algorithm.

How do we decouple ComplexAlgorithm from the specific sort algorithm?

We want it to be used with bubble sort, or quick sort, or radix sort, or any other sort. The solution is to make use of
an interface.

Have a look at the following code:

```java
public interface SortingAlgorithm {
    int[] sort(int[] numbers);
}

public class ComplexAlgorithm {
    
    private SortingAlgorithm sortingAlgorithm;

    public ComplexAlgorithm(SortingAlgorithm sortingAlgorithm) {
        this.sortingAlgorithm = sortingAlgorithm;
    }
}

public class BubbleSortingAlgorithm implements SortingAlgorithm {
    // implementation...
}

public class QuickSortingAlgorithm implements SortingAlgorithm {
    // implementation...
}
```

We have created an interface named SortingAlgorithm that has sort() method defined. Specific sort algorithms all
implement SortingAlgorithm by overriding sort(). Here, ComplexAlgorithm makes use of SortingAlgorithm as a dependency by
declaring it as a member. However, the actual implementation of SortingAlgorithm needs to be passed in as a parameter to
its constructor. The user decides which specific sort algorithm ComplexAlgorithm gets to use.

Whichever class wants to make use of ComplexAlgorithm needs to write code such as this:

```java
public class Program {
    
    public static void main(String[] args) {
        CompexAlgorithm binarySearch = new ComplexAlgorithm(new QuickSortingAlgorithm());
    }
}
```

Other classes may choose to pass in SortingAlgorithm implementations for bubble sort or quick sort.

## Dependency Injection In Spring

Now where does Spring framework come into picture? In the above piece of code, we are manually creating the objects and
tying them up with dependencies. In a typical application, we might have thousands of objects. Do you want to write the
code for all it manually? How about having a framework that does this for you?

Let’s consider the following example:

```java

@Component
public class QuickSortingAlgorithm implements SortingAlgorithm {
    // implementation...
}

@Component
public class ComplexAlgorithm {

    @Autowired
    private SortingAlgorithm sortingAlgorithm;
}
```

When this code is run - Spring creates an instance of QuickSortingAlgorithm which implements SortingAlgorithm interface,
and wires it into an instance of ComplexAlgorithm.

This process, where the Spring framework identifies the beans, identifies the dependencies, and populates the
dependencies inside the beans is called dependency injection.

## Types of Dependency injection in Spring

Dependency Injection in Spring can be done through constructors, setters or fields.

### Constructor-Based Dependency Injection

In the case of constructor-based dependency injection, the container will invoke a constructor with arguments each
representing a dependency we want to set.

Spring resolves each argument primarily by type, followed by name of the attribute, and index for disambiguation. Let's
see the example:

```java

@Component
public class ConsumerBean {

    private final DependencyBean dependency;

    @Autowired
    public ConsumerBean(DependencyBean dependency) {
        this.dependency = dependency;
    }
}
```

In the example above we declared a single explicit constructor with a component dependency as an argument. Spring will
try to find an instance of *DependencyBean* class and provide it as an argument to the *ConsumerBean* class constructor.

Also, it is worth to mention, that in case when only one constructor is declared in a component class, spring will use
it to inject any required dependencies, so annotation *@Autowired* is not required in this case.

### Setter-Based Dependency Injection

For setter-based DI, the container will call setter methods of our class after invoking a no-argument constructor or
no-argument static factory method to instantiate the bean. Let's create see an example:

```java

@Component
public class ConsumerBean {

    private DependencyBean dependency;

    @Autowired
    public void setDependency(DependencyBean dependency) {
        this.dependency = dependency;
    }
}
```

We can combine constructor-based and setter-based types of injection for the same bean. The Spring documentation
recommends using constructor-based injection for mandatory dependencies, and setter-based injection for optional ones.

### Field-Based Dependency Injection

In case of Field-Based DI, we can inject the dependencies by marking them with an *@Autowired* annotation:

```java

@Component
public class ConsumerBean {

    @Autowired
    private DependencyBean dependency;
}
```

While constructing the ConsumerBean object, if there's no constructor or setter method to inject the DependencyBean
instance, the container will use reflection to inject DependencyBean into ConsumerBean.

This approach might look simpler and cleaner, but we don't recommend using it because it has a few drawbacks such as:

- This method uses reflection to inject the dependencies, which is costlier than constructor-based or setter-based
  injection.
- It's really easy to keep adding multiple dependencies using this approach. If we were using constructor injection,
  having multiple arguments would make us think that the class does more than one thing, which can violate the Single
  Responsibility Principle.
