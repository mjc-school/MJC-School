# Functional way of Java

## Materials
- Functional Interfaces
- Lambda Expression
- Functional Composition 
- Method References
- Stream API
- Optional



## Functional Interfaces

Functional interfaces are interfaces that have only ONE ABSTRACT method (you can create default and static methods, or private ones after Java 9). There is even a special <b>@FunctionalInterface</b> annotation for them, which blocks the creation of several abstract methods at the compiler level.

For example, the well-known Runnable is also functional, because it has only one run method.

You can create and use your own functional interface or implement one of the existing ones.
The most famous functional interfaces(FI) that appeared in Java 8 are:
- Predicate
- Consumer
- Supplier
- Function & BiFunction
- UnaryOperator & BinaryOperator
- FI with additional type prefixes 
  
Let's take a look at them.
1. Predicate – takes T as input, returns boolean.
        
        public static Predicate<Integer> isEvenNumber = x -> {
          System.out.println("x = " + x);
          return x % 2 == 0;
        };
    Call:

        boolean b = isEvenNumber.test(20);
        System.out.println(b);
   
2. Consumer – takes the type T, returns nothing (void).

        Consumer<Integer> print = x -> {
          System.out.println("Consumer start...");
          System.out.println(x + " dollars");
          System.out.println("Consumer end.");
        };
     Call:
        
        print.accept(50);
3. Supplier – accepts nothing, but returns T. 

        Supplier<String> supplier = () -> {
          return "abc";
        };
     Call:      
    
        System.out.println(supplier.get());
4. Function – takes as input the type T, returns the type R.

        Function<Integer, String> convertRub = x -> {
          return String.valueOf(x) + " dollars.";
        };
   Call:

        System.out.println(convertRub.apply(9));
   
    BiFunction – takes two objects with types T and U as input and returns the type R.


5. There are additional derived function shapes that extend the basic function shapes.
     UnaryOperator extends from Function – Takes T and returns T.
     BinaryOperator extends from BiFunction – takes two objects of type T as input and returns T. 
   For example:

        UnaryOperator<Integer> square = x -> x * x;
        System.out.println(square.apply(5)); // 25

        BinaryOperator<Integer> sum = (x, y) -> x + y;
        System.out.println(sum.apply(-5, 15)); // 10
   
6. Type parameters of functional interfaces can be specialized to primitives with additional type prefixes.
   
   To specialize the return type for a type that has both generic return type and generic arguments, we prefix ToXxx, as in <i>ToIntFunction</i>. Otherwise, type arguments are specialized left-to-right, as in <i>DoubleConsumer</i> or <i>ObjIntConsumer</i>. (The type prefix Obj is used to indicate that we don't want to specialize this parameter, but want to move on to the next parameter, as in <i>ObjIntConsumer</i>.) These schemes can be combined, as in <i>IntToDoubleFunction</i>.
   
The Functional Interface is one of the most important concepts of Java 8 which actually powers lambda expression. If you know what the functional interface is and how lambda is related to it, you can use powerful features of Java 8 like Lambda expression and Stream API. Without knowledge of the functional interface, you won't be able to understand where you can use a lambda in the code but also you will struggle to write a lambda expression the method is expecting, hence, it's important to have a good understanding of the functional interface.


## Lambda Expression

A lambda is a set of instructions that can be separated into a variable and then called multiple times in different places in the program.

The basis of a lambda expression is the lambda operator, which represents the arrow «->». This operator divides the lambda expression into two parts: the left part contains the list of input parameters of the expression, and the right part represents the body of the lambda expression, where all the actions are performed. 

For example, the lambda expression (x, y) -> x + y specifies that the lambda expression takes two arguments x and y and returns the sum of these.

     //Syntax of lambda expression
     (parameter_list) -> {function_body}

A lambda expression does not execute on its own, it only constitutes an implementation of a method defined in a functional interface.
Let's look at an example:

      @FunctionalInterface
      interface Operationable {
        int calculate(int x, int y);
      }

      public class LambdaApp {
        public static void main(String[] args) {
          Operationable operation = (x, y) -> { return x + y; };
          int result = operation.calculate(10, 20);
          System.out.println(result); //30
        }
      } 

The Operationable interface acts as a functional interface, in which one method is defined without implementation – the calculate method. This method takes two parameters – integers, and returns some integer.

<b><i>Lambda Expression vs method in Java</i></b>

A method (or function) in Java has these main parts:
1. Name
2. Parameters
3. Body
4. Return type
   
A lambda expression in Java has these main parts:
   Lambda expression <u>has only parameters and body</u>.
1. <b>No</b> name – function is anonymous so we don’t care about the name
2. Parameters
3. Body – This is the main part of the function.
4. <b>No</b> return type – The java 8 compiler is able to infer the return type by checking the code. you need not to mention it explicitly.

<b><i>Lambda Expression design</i></b>
The parameters of the lambda expression must match the type of the method parameters from the functional interface. When writing the lambda expression, it is <u>not necessary to write the type</u> of the parameters, although in principle this can be done, for example:

      operation = (int x, int y) -> { return x + y; };

If the method takes no parameters, then empty parentheses are written, for example:

      () -> { return 30 + 20; };

If the method takes only one parameter, then the parentheses can be omitted:

      n -> { return n * n; };

If body of a lambda expression have one line, braces and ‘return’ can be omitted:
Absolutely the same things:

      n -> { return n * n; };   and   n -> n * n;

<b><i>Lambdas and local variables</i></b>

A lambda expression can use variables that are declared in a more general scope – at the class or method level in which the lambda expression is defined. However, depending on how and where variables are defined, the way they are used in lambdas can differ.

Let's look at the first example - using class-level variables:
 
      @FunctionalInterface
      interface Operation {
         int calculate();
      }

      public class LambdaApp {

        static int x = 10;
        static int y = 20;
    
        public static void main(String[] args) {         
           Operation op = () -> {
               x = 30;
               return x + y;
           };
           System.out.println(op.calculate()); // 50
           System.out.println(x); // 30 - x value changed
        }
      }

The variables x and y are declared at the class level, and in the lambda expression we can get them and even change them. So, in this case, after the expression is executed, the value of the variable x changes.

We can also use method-level local variables in lambdas, but we cannot change their value either in the lambda or outside the lambda. If we try to do this, then the development environment can show us an error «Variable used in lambda expression should be final or effectively final».

See example:
      
      public class LambdaApp {
      
         static int x = 10;
         static int y = 20;
         
         public static void main(String[] args) {
            int n = 70;
            int m = 30;
            Operation op = ()-> {
               //n = 100; - this cannot be done
               return m + n;
            };
      
          // n = 100; - this cannot be done
          System.out.println(op.calculate()); // 100
         }
      }

Thus, we have covered the definition of lambda expressions, why they are better to use, and some rules for using them.


## Functional Composition

Functional composition is a technique to combine multiple functions into a single function which uses the combined functions internally. You can compose individual functions (typically one or more <b>Java Lambda Expressions</b>) into a single function yourself, but Java also comes with built-in support for functional composition to make the job easier for you. In this chapter we will explain both how to compose functions from smaller functions yourself, and via Java's built-in features.

To get started, let’s take a look at an example of Java functional composition. Here is a single function composed from two other functions:

      Predicate<String> startsWithA = text -> text.startsWith("A");
      Predicate<String> endsWithX = text -> text.endsWith("x");
      
      Predicate<String> startsWithAAndEndsWithX =
      text -> startsWithA.test(text) && endsWithX.test(text);
      
      String  input = "A hardworking person must relax";
      boolean result = startsWithAAndEndsWithX.test(input);
      System.out.println(result);

The previous example we showed how to compose a new function from two other functions. Several of the functional interfaces in Java already have support for functional composition built into them. The functional composition support comes in the shape of default and static methods in the functional interfaces.

<b><i>Predicate Composition</i></b>

The Predicate interface contains a few methods that help you compose new Predicate instances from other Predicate instances. These methods are:

<b>1.</b> and()

   The Predicate and() method is a default method. The and() method is used to combine two other Predicate functions in a new one in the same way we showed at the beginning of this chapter. Here is an example of functional composition with the Predicate and() method:
          
         Predicate<String> startsWithA = text -> text.startsWith("A");
         Predicate<String> endsWithX = text -> text.endsWith("x");

         Predicate<String> composed = startsWithA.and(endsWithX);
         
         String input = "A hardworking person must relax";
         boolean result = composed.test(input);
         System.out.println(result);

<b>2.</b> or()

   The Predicate or() method is used to combine a Predicate instance with another, to compose a third Predicate instance. The composed Predicate will return true if either of the Predicate instances it is composed from return true, when their test() methods are called with same input parameter as the composed Predicate. Here is a Predicate or() functional composition example with the same startWithA and endsWithX predicates:
       
         Predicate<String> composed = startsWithA.or(endsWithX);
         
         String input = "A hardworking person must relax sometimes";
         boolean result = composed.test(input);
         System.out.println(result);

<b><i>Consumer Composition</i></b>

The Consumer interface also contains a few methods that can be used to compose new Consumer instances:

<b>1.</b> andThen()

This method will first call the Function that andThen() was called on, and then it will call the Function passed as parameter to the andThen() method. Here is an example:

      Consumer<String> lowerPrint = text -> System.out.println(text.toLowerCase());
      Consumer<String> upperPrint = text -> System.out.println(text.toUpperCase());

      lowerPrint.andThen(upperPrint).accept("MJC School");
Result:

      mjc school
      MJC SCHOOL

<b><i>Function Composition</i></b>

The Function interface also contains a few methods that can be used to compose new Function instances:

<b>1.</b> andThen()
   
   It works the same as in the Consumer.
   
<b>2.</b> compose()
   
   This method works opposite of the andThen() method. The method composes a new Function instance from the Function instance it is called on, and the Function instance passed as parameter to the compose() method.
   
   The Function returned by compose() will first call the Function passed as parameter to compose(), and then it will call the Function which compose() was called on. This is easier to understand with an example:

         Function<Integer, Integer> multiply = value -> value * 2;
         Function<Integer, Integer> add = value -> value + 3;
         
         Function<Integer, Integer> addThenMultiply = multiply.compose(add);
         
         Integer result1 = addThenMultiply.apply(3);
         System.out.println(result1); // (3 + 3) * 2 = 12

   When called with the value 3, the composite Function will first call the addition Function and then the multiplication Function.
   
   Note: As mentioned in the beginning, compose() works opposite of  andThen(). Therefore, calling a.andThen(b) is actually the same as calling b.compose(a).


## Method References

In the previous chapters we learned lambda expressions in Java 8. Here we will discuss another new feature of java 8, method reference. Method reference is a shorthand notation of a lambda expression to call a method. For example:

If your lambda expression is like this:

      str -> System.out.println(str)

then to make the code clearer you can replace it with a method reference like this:

      System.out::println

The :: operator is used in a method reference to separate the class or object from the method name(we will learn this with the help of examples).

Java 8 allows four types of method references.

| Type                                                                           | Syntax                      | 
| -------------------------------------------------------------------------------|:---------------------------:| 
| 1. Reference to a static method                                                | Class::staticMethodName     |
| 2. Reference to an instance method of an arbitrary object of a particular type | Class::instanceMethodName   |
| 3. Reference to an instance method of a particular object                      | object::instanceMethodName  |
| 4. Reference to a constructor                                                  | ClassName::new              |

<b>1.</b> Reference to a static method
   For example:

      Function<String, Boolean> function = e -> Boolean.valueOf(e);
      System.out.println(function.apply("TRUE"));

   Let's rewrite using the method reference:

      Function<String, Boolean> function = Boolean::valueOf;
      System.out.println(function.apply("TRUE"));

<b>2.</b> Reference to an instance method of an arbitrary object of a particular type.
      
   This type is used when a lambda expression calls a method on an external, pre-existing object.
   
   For example:

      Consumer<String> consumer = e -> System.out.println(e);
      consumer.accept("OCPJP 8");
Let's rewrite using a method reference:
      
      Consumer<String> consumer = System.out::println;
      consumer.accept("OCPJP 8");
One more example:

      Integer integer = 5;
      Supplier<String> supplier = () -> integer.toString();
      System.out.println(supplier.get());

Rewritten using method reference:

      Integer integer = 5;
      Supplier<String> supplier = integer::toString;
      System.out.println(supplier.get());

<b>3.</b> Reference to an instance method of a particular object
   
For example:
   
      Function<String, String> function = s -> s.toLowerCase();
      System.out.println(function.apply("OCPJP 8"));

Rewritten using method reference:

      Function<String, String> function = String::toLowerCase;
      System.out.println(function.apply("OCPJP 8"));

<b>4.</b> Reference to a constructor

For example:

      Function<String, Integer> function = (d) -> new Integer(d);
      System.out.println(function.apply("4"));

Rewritten using method reference:

      Function<String, Integer> function = Integer::new;
      System.out.println(function.apply("4"));

Keep in mind that you can turn a lambda expression into a method reference to make the code clearer. The real power of lambda expressions and method references comes when they are combined with streams.


## Stream API

The Stream API is a new way to work with data structures in a functional style.

The advent of the Stream API allowed programmers to write things that used to take a lot of code much shorter. For example, work with datasets has been simplified, in particular, filtering, sorting and other data manipulations have been simplified.

The Java Stream API provides a functional approach to processing collections of objects.

First, you need to draw a clear line between collection and stream. Stream is not a collection. Stream is inherently a stream of data. This stream can be in different states. For example, it can be “executed”, which means that attempts to process it again will result in a runtime error.

Also, unlike a collection, it cannot be said that a stream is a store of elements. It is more like a set of “operations” that are applied to a collection and the result of which is another collection or value, and the original collection will not be modified.

Stream have 3 types of operations:

1) Build operations – create a stream
2) Intermediate operations – convert one stream into another
3) Terminal operations – convert stream into something or nothing
![image info](media/streams.png)

1. <b>Build operations</b>. There are many ways to create a stream. You may create stream from:
   - static sequence of objects: <i>Stream.of(T… values)</i>
     
      For example: <i>Stream.of(1,2,3,4)</i>
   - collection: <i>someList.stream()</i>
   - array: <i>Arrays.stream(someArray)</i>
   - by computation. It dynamically generates every single object on the fly.
     
   There are 2 ways:

   - each one separately via Supplier

         Stream.generate(random::nextInt)

   - each one separately from the previous one via UnaryOperator
   
         Stream.iterate(1, num -> num + 1)

2. <b>Internal operations</b> of the Stream API are operations that transform or filter the elements in the stream. When you add an internal operation to a stream, you get a new stream back as result. Here we list only the most popular operators that can be used in the most basic tasks, even at the earliest stage of using Stream.

- map()

   some elements enter into it, and others come out. In this case, the operator is applied to the elements separately, the Stream element that got into the method “does not know” about other elements.

      Stream.of(1,2,3,4).map(num -> “book_” + num); //convert int values to string values

- flatMap()

  converts each element to a Stream, concatenates all streams into one and passes it to the next operator.
![image info](media/flatMap.png)
  
- filter()
  
   returns a new stream of elements that meets Predicate in a filter() method.
   
      books.stream().filter(b -> b.getName().filter(b -> !b.getName().isEmpty())

- takeWhile(), dropWhile()
  
      books.stream().takeWhile(b -> b.getName().startsWith("A"))

- limit()
   
   method can limit the number of elements in a stream to a number given to the limit() method as parameter.

      booksStream.stream().limit(3) //returns stream with no more than 3 elements
- distinct()

   returns a stream without duplicates

      books.stream().distinct()

3. <b>Terminal operations</b> of the Java Stream API typically return a single value. Once the terminal operation is invoked on a Stream, the iteration of the Stream and any of the chained streams will get started. Once the iteration is done, the result of the terminal operation is returned.
   
   A terminal operation typically does not return a new Stream instance. Thus, once you call a terminal operation on a stream, the chaining of Stream instances from non-terminal operation ends. Here is an example of calling a terminal operation on a Java Stream:
   
         long count = stream
            .map((value) -> { return value.toLowerCase(); })
            .map((value) -> { return value.toUpperCase(); })
            .map((value) -> { return value.substring(0,3); })
            .count();

   It is the call to count() at the end of the example that is the terminal operation. Since count() returns a long, the Stream chain of non-terminal operations (the map() calls) is ended.
   
   There are some of the popular terminal operations:

- anyMatch(), allMatch(), noneMatch()
  
   these methods take a single Predicate as a parameter, start the internal iteration of the Stream, and apply the Predicate parameter to each element. If the Predicate returns true for any/all/none of the elements, the method returns true.
  
      wordList.stream().anyMatch(value -> value.startsWith("One"));

- collect()
  
   method starts the internal iteration of elements, and collects the elements in the stream in a collection or object of some kind. The collect() method takes a Collector (java.util.stream.Collector) as parameter.
     
      List<String> uppercaseWordList = wordList.stream()
        .map(value -> value.toUpperCase())
        .collect(Collectors.toList());

- count()
   
   method starts the internal iteration of the elements in the Stream, and counts the elements.

- findAny(), findFirst()
   
   first method finds a single element from the Stream, second method finds the first element from the Stream.

- forEach()
  
   applies a Consumer (java.util.function.Consumer) to each element in the Stream. The forEach() method returns void.
  
      Stream.of(1,2,3,4).forEach(num -> { System.out.println(num); }

<b><i>Streams of primitive types</i></b>

IntStream, LongStream, DoubleStream.

Using these types of stream is more efficient because they avoid the wrapping and unwrapping operations. Moreover, they add a couple of specified operations that work with primitive types such as range(), rangeClosed() for building streams, sum(), average() arithmetic operations, min(), max() and etc.

There are some operations which will help to convert stream into stream of primitive type:

      maxToInt() – return IntSream
      mapToLong() – return LongStream
      mapToDouble() – return DoubleStream

Example:

      employees.stream().mapToInt(Employee::getSalary).average();

In addition, it’s important to mention that streams can be ordered or unordered, sequential or parallel, but it’s an extra material. It would be nice if you pay attention to these things on your own.


### Optional

Optional – it’s a final class java.util.Optional<T>.

It’s a container object which may or may not contain a non-null value. The purpose of the class is to provide a type-level solution for representing optional values instead of null references.

<b><i>Creation Optional</i></b>

There are several ways of creating Optional objects. To create an empty Optional object, we simply need to use its <i>empty()</i> static method:

      Optional<String> empty = Optional.empty();

We can also create an Optional object with the static method <i>of()</i>:
   
      String name = "java";
      Optional<String> opt = Optional.of(name);

However, the argument passed to the of() method can't be null. Otherwise, we'll get a NullPointerException. But in case we expect some null values, we can use the <i>ofNullable()</i> method:

      String name = "java";
      Optional<String> opt = Optional.ofNullable(name);

By doing this, if we pass in a null reference, it doesn't throw an exception but rather returns an empty Optional object.

<b><i>Optional methods</i></b>

When we have an Optional object returned from a method or created by us, we can check if there is a value in it or not, receive value, define alternative value or method, or exception.

The <i>get()</i> method of an object returns its value or throws a java.util.NoSuchElementException if there is no value.

The Optional class provides a number of methods to avoid getting this exception. The easiest way is a preliminary check for the presence of a value in Optional using the <i>isPresent()</i> method.

      ArrayList<Integer> numbers = new ArrayList<Integer>();
      Optional<Integer> min = numbers.stream().min(Integer::compare);
      if(min.isPresent()){
         System.out.println(min.get());
      }

The second way is the <i>orElse()</i> method. It allows you to define an alternative value that will be returned if the Optional doesn’t have any value:

      Optional<Integer> min = numbers.stream().min(Integer::compare);
      System.out.println(min.orElse(-1));

Another way is the <i>orElseGet()</i> method. It allows you to define a function that will return a default value:

      Optional<Integer> min = numbers.stream().min(Integer::compare);
      Random random = new Random();
      System.out.println(min.orElseGet(() -> random.nextInt(100)));

Another method, <i>orElseThrow()</i>, allows you to throw an exception if the Optional does not contain a value:

      System.out.println(min.orElseThrow(IllegalStateException::new));

The <i>ifPresent()</i> method defines actions on the value in Optional, if the value is present:

      Optional<Integer> min = numbers.stream().min(Integer::compare);
      min.ifPresent(v -> System.out.println(v));

The <i>ifPresentOrElse()</i> method allows you to define actions on the Optional's value if a value is present, and alternative logic in case the Optional's value is missing.
      
      Optional<Integer> min = numbers.stream().min(Integer::compare);
      min.ifPresentOrElse(
         v -> System.out.println(v),
         () -> System.out.println("Value not found")
      );

Thus, Optional is a container object which helps to avoid using null, and provides a lot of methods to check the existence of a value and specify alternative behavior.




         

