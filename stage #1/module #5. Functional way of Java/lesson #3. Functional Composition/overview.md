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

<b>*Predicate Composition*</b>

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

<b>*Consumer Composition*</b>

The Consumer interface also contains a few methods that can be used to compose new Consumer instances:

<b>1.</b> andThen()

This method will first call the Function that andThen() was called on, and then it will call the Function passed as parameter to the andThen() method. Here is an example:

      Consumer<String> lowerPrint = text -> System.out.println(text.toLowerCase());
      Consumer<String> upperPrint = text -> System.out.println(text.toUpperCase());

      lowerPrint.andThen(upperPrint).accept("MJC School");
Result:

      mjc school
      MJC SCHOOL

<b>*Function Composition*</b>

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