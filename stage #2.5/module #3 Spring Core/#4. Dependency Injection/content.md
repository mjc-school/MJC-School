<h1 style="color: green">Dependency Injection</h1>

## What is a Dependency?

A typical Java application will have three layers in its architecture: web, business and data.

* The web layer
* The business layer
* The data layer

In the above scenario:

Web Layer depends on Business Layer. The business layer is a dependency for the web layer. Business layer depends on
Data Layer. The data layer is a dependency for the business layer.

Let’s look at an example:

```java

@Repository
public class ExampleRepository {
    // some database-related code goes here
}

@Service
public class ExampleService {
    private final ExampleRepository repository;

    public ExampleService(ExampleRepository repository) {
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
public class ExampleController {
    private final ExampleService service;

    public ExampleController(ExampleService service) {
        this.service = service;
    }
    // some end-points definition code goes here...
}
```

In the example above ExampleService is the business class, and it makes use of one data layer class - ExampleRepository.
Also, we have two methods defined in ExampleService class:

* readSomeDataById - returns data by provided id
* saveSomeData - saves provided data

Both methods in ExampleService require ExampleRepository instance to do their logic. ExampleRepository is a dependency
of ExampleService.

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
    private SortingAlgorithm sortingAlgorithm;

    @Autowired
    public ComplexAlgorithm(SortingAlgorithm sortingAlgorithm) {
        this.sortingAlgorithm = sortingAlgorithm;
    }
}
```

When this code is run - Spring creates an instance of QuickSortingAlgorithm which implements SortingAlgorithm interface, and
wires it into an instance of ComplexAlgorithm.

This process, where the Spring framework identifies the beans, identifies the dependencies, and populates the
dependencies inside the beans is called dependency injection.

## Types of Dependency injection in Spring
