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