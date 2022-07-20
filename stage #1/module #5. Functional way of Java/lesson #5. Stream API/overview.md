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
  - static sequence of objects: *Stream.of(T… values)*

    For example: *Stream.of(1,2,3,4)*
  - collection: *someList.stream()*
  - array: *Arrays.stream(someArray)*
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

<b>*Streams of primitive types*</b>

IntStream, LongStream, DoubleStream.

Using these types of stream is more efficient because they avoid the wrapping and unwrapping operations. Moreover, they add a couple of specified operations that work with primitive types such as range(), rangeClosed() for building streams, sum(), average() arithmetic operations, min(), max() and etc.

There are some operations which will help to convert stream into stream of primitive type:

      maxToInt() – return IntSream
      mapToLong() – return LongStream
      mapToDouble() – return DoubleStream

Example:

      employees.stream().mapToInt(Employee::getSalary).average();

In addition, it’s important to mention that streams can be ordered or unordered, sequential or parallel, but it’s an extra material. It would be nice if you pay attention to these things on your own.