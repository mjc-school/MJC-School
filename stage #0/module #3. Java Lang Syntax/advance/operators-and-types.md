## Operators for different types

As it was mentioned above, Java has several numbers of data types, and operators aim to work with them. So dependent on
the
type, the same operator can perform different actions: plus operator (+) can be used with numbers and with strings.
Strings haven't been considered yet, but as a short overview those are representation of combination of characters in
java:

    String s = "any text";

Special point here is that strings require presence of double quotes: "". And "+" can be used with strings to append
them.

    String any = "any "
    String text = "text";
    String result = any + text;
    System.out.println(result);
    //any text

The example above aims to illustrate that operators depend on the type they are used with. Essentially, that means that
Java changes operator behaviour dependent on the type it's used with, those differences are called operator
**_overloading_**. In the example above "+" sign, which is usually expected to perform addition of numbers, in this case
performs "_**concatenation**_" - the operation that appends one string to the end of the first one.

Another thing to mention here is that when operation is performed over variables of different type (byte and double) ->
the smallest is implicitly casted to the bigger one:

    byte b = 9;
    double d = 8.5;
    System.out.println(b + d);
    //17.5

This implicit casting occurs, because Java needs to know the type of resulting value. The question here is what type to
choose from? The most suitable answer here is the biggest type of those involved in calculation. This is done because
double in this particular case is more likely to be able to handle the resulting value (also results of operations with
integer and floating point value are casted to floating point).

Essentially, this means that Java has several versions of the same operators (e.g. "+"): for int, long, float, double
and String. There are no math operators in Java for bytes and shorts as those operations are casted to int.
