# Slight Code writing improvements

## Materials
- Local-Variable Type Inference
- Local-Variable Syntax for Lambda Parameters
- Switch Expressions
- Text Blocks
- Pattern Matching for instanceof

## Local-Variable Type Inference

One of the most visible enhancements in JDK 10 is type inference of local variables with initializers.

Until Java 10, we had to mention the type of the local variable explicitly and ensure it was compatible with the initializer used to initialize it:

    String message = "Good bye, Java 9";

In Java 10, this is how we could declare a local variable:

    var message = "Hello, Java 10";

<b>*We don't provide the data type of message. Instead, we mark the message as a var, and the compiler infers the type of message from the type of the initializer present on the right-hand side.*</b>

Note that this feature is available only for local variables with the initializer. It cannot be used for member variables, method parameters, return types, etc – the initializer is required as without which compiler won't be able to infer the type.

This enhancement helps in reducing the boilerplate code, for example:

    Map<Integer, String> map = new HashMap<>();

This can now be rewritten as:

    var idToNameMap = new HashMap<Integer, String>();

This also helps to focus on the variable name rather than on the variable type.

Another thing to note is that <b>*var is not a keyword*</b> – this ensures backward compatibility for programs using var say, as a function or variable name. var is a reserved type name, just like *int*.

Finally, note that there is no runtime overhead in using var nor does it make Java a dynamically typed language. The type of the variable is still inferred at compile time and cannot be changed later.

<b>Illegal Use of var</b>

As mentioned earlier, var won't work without the initializer:

    var n; // error: cannot use 'var' on variable without initializer

Nor would it work if initialized with null:

    var emptyList = null; // error: variable initializer is 'null'

It won't work for non-local variables:

    public var = "hello"; // error: 'var' is not allowed here

Lambda expression needs explicit target type, and hence var cannot be used:

    var p = (String s) -> s.length() > 10; // error: lambda expression needs an explicit target-type

Same is the case with the array initializer:

    var arr = { 1, 2, 3 }; // error: array initializer needs an explicit target-type

Reinitializing:

    var n = 6;  
    n = "six";  //error: Type mismatch: cannot convert from String to int

<b>Guidelines for Using var</b>

There are situations where var can be used legally, but may not be a good idea to do so.

1. For example, in situations where the code could become less readable:

        var result = obj.prcoess();

    Here, although a legal use of var, it becomes difficult to understand the type returned by the process()making the code less readable.


2. Another situation where it's best to avoid var is in streams with long pipeline:

        var x = emp.getProjects.stream()
            .findFirst()
            .map(String::length)
            .orElse(0);

    Usage of var may also give unexpected result.

3. That's not a good idea to use type inference with the diamond operator. 
Diamond operator is introduced in Java 7 which can cause to the unexpected result using var in below code.

        var studentList = new ArrayList<>();
    
    This code is still valid and it looks to take ArrayList<Object> that means we can add any value to the studentList as below.

        studentList.add(new Student(100));
        studentList.add("second");
        studentList.add(new Car());

    Able to add Student object, String object and Car object to the studentList. This is better to avoid usage in this case.

    If we want to add only Student instances then declaration must be changed to
    
        var studentList = new ArrayList<Student>();
    
4. Moreover, you must be careful while dealing with non-denotable instances.

        var obj = new Object() {
        String name = "java";
        };
   Here created an object for anonymus class and storing the object in var obj.
   
    If we try to reassign to new Object() then will get compile time error.
    
        obj = new Object(); // error: Type mismatch: cannot convert from Object to new Object(){}

    This is because the inferred type of obj isn’t Object.

Thus, we saw the new Java 10 local-variable type inference feature with examples. We found out that:
-  this feature is available only for local variables
- type inference helps in reducing the boilerplate code;
- type inference helps focus on the variable name rather than on the variable type,
- there is no runtime overhead in using type inference nor does it make Java a dynamically typed language
- some cases there it's better to avoid type inference: if code becomes less readable, in streams with long pipelines,
with the diamond operator and with non-denotable types.

## Local-Variable Syntax for Lambda Parameters

One of the key features introduced in Java 10 was *local-variable type inference*. It allowed the use of var as the type of the local variable instead of the actual type. The compiler inferred the type based on the value assigned to the variable.

However, we could not use this feature with lambda parameters. For example, consider the following lambda. Here we explicitly specify the types of the parameters:

      (String s1, String s2) -> s1 + s2

We could skip the parameter types and rewrite the lambda as:

      (s1, s2) -> s1 + s2

Even Java 8 supported this. The logical extension to this in Java 10 would be:

      (var s1, var s2) -> s1 + s2

However, Java 10 did not support this.

Java 11 addresses this by supporting the above syntax. <b>*This makes the usage of var uniform in both local variables and lambda parameters.*</b>

<b>Benefits</b>

But why would we want to use var for lambda parameters when we could simply skip the types?

One benefit of uniformity is that modifiers can be applied to local variables and lambda formals without losing brevity. For example, a common modifier is a type annotation:

      (@Nonnull var s1, @Nullable var s2) -> s1 + s2

<b>*We cannot use such annotations without specifying the types.*</b>

<b>Limitations</b>

There are a few limitations of using var in lambda.

For example, we cannot use var for some parameters and skip for others:

      (var s1, s2) -> s1 + s2

Similarly, we cannot mix var with explicit types:

      (var s1, String s2) -> s1 + s2

Finally, even though we can skip the parentheses in single parameter lambda:

      s1 -> s1.toUpperCase()

but we cannot skip them while using var:

      var s1 -> s1.toUpperCase()

All of the above three usages will result in compilation error.

In this quick chapter, we explored this cool new feature in Java 11 and saw how we can use local variable syntax for lambda parameters.

## Switch Expressions

You may already know syntax of the switch expression and that it may have some of the following input parameter types: byte, short, int, char, and wrappers, enums and strings.

The update of the switch statement from JDK 14 now allows to have multiple case values for the same result in a row.

Classic approach:

    switch (month) {
      case "January":
      case "February":
      case "December":
        System.out.println("Winter");
        break;
      case "March":
      case "April":
      case "May":
        System.out.println("Spring");
        break;
      default:
        System.out.println("Something else");
    }

Enhanced approach:

    switch (month) {
        case "January", "February", "December" -> System.out.println("Winter");
        case "March", "April", "May" -> System.out.println("Spring");      
        default -> System.out.println("Something else");     
    }

All cases should be covered if we need the result to be assigned to some variable (in other words - the statement should be exhaustive):

    return switch (month) {
        case "January", "February", "December" -> "Winter";
        case "March", "April", "May" -> "Spring";      
        default -> "Something else";     
    };

Note, that the new syntax does not require break statements.

When more control over the right side of the case statement is needed, inside the code block the yield word should be used.

    return switch (month) {
        case "January", "February", "December" -> "Winter";
        case "March", "April", "May" -> {
            var message = "Spring";
            yield message + " is the best";
        default -> "Something else";     
    };

## Text blocks

Fully available after JDK 15.

([JEP 355: Text Blocks](https://openjdk.java.net/jeps/355), [JEP 378: Text Blocks](https://openjdk.java.net/jeps/378), [JEP 368: Text Blocks](https://openjdk.java.net/jeps/368))

Text blocks are used to make work with text data more understandable and readable. The main point of the text blocks is to transfer some work with the indents, line terminators, double quotes to the java compiler.

To start and end a text block three double-quotes characters are used (“””)

    String textBlock = """
                Some text   
                Some text on a new line
            """;
    String equalTextBlock = "    Some text\n    Some text on a new line\n"

Let’s discuss key moment of the text blocks.

1. After the opening quotes there may be space or spaces, but they are optional and ignored by the compiler till the new line pointer.
2. The amount of spaces in the result string is dependent on the line with minimal spaces before the text.

![block](media/textBlocks_1.png)

Here the number of minimal spaces before the closing quotes (last line), so 16 spaces before the each line in the block will be excluded.


     18           <String textBlock = """
     19 Some text
     22                           Some test on new line
     22                        """;

And here there are no spaces on the line 19 and as a result the compiled string will have following value: 

    Some text\n                    Some text on a new line\n

Pay attention, that the new line at the end of the second line will be the last part of the line, and the spaces on the 21 line in this situation will be trimmed.

## Pattern Matching for instanceof

In this chapter we will learn what pattern matching for instanceof is and how to use it since Java 14.

<b>Traditional approach</b>

At some point, we've probably all written or seen code that includes some kind of conditional logic to test if an object has a specific type. Typically, we might do this with the instanceof operator followed by a cast. This allows us to extract our variable before applying further processing specific to that type.

Let's imagine we want to check the type in a simple hierarchy of animal objects:

      if (animal instanceof Cat) {
         Cat cat = (Cat) animal;
         cat.meow();
         // other cat operations
      } else if (animal instanceof Dog) {
         Dog dog = (Dog) animal;
         dog.woof();
         // other dog operations
      }

In this example, for each conditional block, we're testing the animal parameter to determine its type, converting it via a cast and declaring a local variable. Then, we can perform operations specific to that particular animal.

Although this approach works, it has several drawbacks:

+ It's tedious to write this type of code where we need to test the type and make a cast for every conditional block
+ We repeat the type name three times for every if block
+ Repeatedly declaring the type name means there's more likelihood of introducing an error. This could lead to an unexpected runtime error
+ The problem magnifies itself each time we add a new animal

<b>New approach</b>

Java 14 brings an improved version of the instanceof operator that both tests the parameter and assigns it to a binding variable of the proper type.

This means we can write our previous animal example in a much more concise way:

      if (animal instanceof Cat cat) {
         cat.meow();
      } else if(animal instanceof Dog dog) {
         dog.woof();
      }

<b>*It is important to note that the variable name cat is not an existing variable, but instead a declaration of a pattern variable.*</b>

We should also mention that the variables cat and dog are only in scope and assigned when the respective pattern match expressions return true. Consequently, <b>*if we try to use either variable in another location, the code will generate compiler errors*</b>.

Moreover, this kind of type of test pattern can be particularly useful when writing equality methods.

As we can see, this version of the code is much easier to understand. We have simplified the code to reduce the overall number of explicit casts dramatically, and the readability is greatly improved.

As we already mention, pattern matching for instanceof was proposed and delivered in JDK 14 but only as a preview feature and finalized in JDK 16 with the following refinements:
+ Lift the restriction that pattern variables are implicitly final, to reduce asymmetries between local variables and pattern variables.
+ Make it a compile-time error for a pattern instanceof expression to compare an expression of type S against a pattern of type T, where S is a subtype of T. (This instanceof expression will always succeed and is then pointless. The opposite case, where a pattern match will always fail, is already a compile-time error.)

In this chapter, we looked at Pattern Matching with instanceof in Java 14. Using this new built-in language enhancement helps us to write better and more readable code, which is generally a good thing. Moreover, we take a look at some refinements added in JDK 16.
