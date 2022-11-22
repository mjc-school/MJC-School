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

   To specialize the return type for a type that has both generic return type and generic arguments, we prefix ToXxx, as in *ToIntFunction*. Otherwise, type arguments are specialized left-to-right, as in *DoubleConsumer* or *ObjIntConsumer*. (The type prefix Obj is used to indicate that we don't want to specialize this parameter, but want to move on to the next parameter, as in *ObjIntConsumer*.) These schemes can be combined, as in *IntToDoubleFunction*.

The Functional Interface is one of the most important concepts of Java 8 which actually powers lambda expression. If you know what the functional interface is and how lambda is related to it, you can use powerful features of Java 8 like Lambda expression and Stream API. Without knowledge of the functional interface, you won't be able to understand where you can use a lambda in the code but also you will struggle to write a lambda expression the method is expecting, hence, it's important to have a good understanding of the functional interface.