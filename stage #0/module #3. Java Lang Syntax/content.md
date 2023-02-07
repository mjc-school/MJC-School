# Introduction

Each communicative language has a list of its own rules and laws that are used for standardizing communications and,
as all of us know, this is called syntax. It is used to create well-formed, meaningful and understandable communication
units - sentences. The main idea of communication is information exchange.

![img_1.png](https://github.com/mjc-school/MJC-School/blob/main/stage%20%230/module%20%233.%20Java%20Lang%20Syntax/img/img_1.png?raw=true)

Programming languages have the same purpose - it's the tool for information exchange between human and a computer.
Just the same as in spoken languages, programming languages have their own syntax. Syntax
itself is a set of rules that define certain combination, order and structure of programming language. They are required
to make it possible for computer to "read", understand and execute the code written in language similar to human one. In
other words
it's a bridge between machine commands and human communication, it is used for "explaining" what a programmer wants to
get
from a machine. It's the way of creating commands for the computer to execute.

![img_2.png](https://github.com/mjc-school/MJC-School/blob/main/stage%20%230/module%20%233.%20Java%20Lang%20Syntax/img/img_2.png?raw=true)

The main difference between spoken and programming syntax: humans can understand the sentence even if
there are mistakes, but computers do not accept syntax mistakes, and they refuse to work! (not all languages, but we do
not consider those). This is the reason why knowing and understanding programming syntax is one of the first steps on
programming road.

***

# Java syntax

Each programming language has its own rules of writing code, so java does too.

![img_3.png](https://github.com/mjc-school/MJC-School/blob/main/stage%20%230/module%20%233.%20Java%20Lang%20Syntax/img/img_3.png?raw=true)

- As you can see the first statement of program is *package*, it's an optional statement, which is required only for the
  cases when program file is not straight inside java folder. And in example above this file would be inside main, which
  in turn, is inside java folder: java -> main. Showing path is not the only use-case for package, there are other
- reasons for declaring it. You will get acquainted with them later in that module. For now knowing that this is the
- name of the folder is enough.


- The second is *import* statement. The majority of programs rely on the code that has already been written, and we need
  a way to reuse that code. Otherwise, all programs would be not readable and maintainable, as they would contain
  millions of lines of duplicated code. But copying and pasting the same code is only a part of the problem, as code
  needs to be updated, and if some lines of widely reused legacy code would require updates,
- that would be too difficult. Besides, if project is flexible for reuse, there would be a request for a convenient
- way of using that anywhere, where required. So this is where *import* statement comes in handy.
- It just literally says: take this file and make all allowed components available for using:

  ![img_4.png](https://github.com/mjc-school/MJC-School/blob/main/stage%20%230/module%20%233.%20Java%20Lang%20Syntax/img/img_3.png?raw=true)

- The next important part is **_public class First_**. This is the class declaration. There's no currently need for deep
  understanding of what a class is (you will get acquainted with that later throughout this course, and we will take a
  look at each word that is used in this example later throughout the course, so no worries). For now, it's enough
  to know that this is a "wrapper" for our programs, as java cannot run the code outside classes.

  ![img_5.png](https://github.com/mjc-school/MJC-School/blob/main/stage%20%230/module%20%233.%20Java%20Lang%20Syntax/img/img_5.png?raw=true)

- The following part is **_public static void main(String[] args)_** this is the entering point of our program. Just
  like
  buildings have front doors for entering them, our programs must begin from some certain point, and for java it's *
  main*
  method declaration. Java has constructions that are called *methods*, which are created and used inside of *classes*.
  This starting method must always be called main, as Java looks for any method in program, which is public static void
  main(String[] args), and if only it finds it -> program starts running. There's no need for knowing how it works
  (for now) as this will be described in further chapters. In short, *methods* are the containers for program logics,
  which consist of lists of actions to be performed.

  ![img_6.png](https://github.com/mjc-school/MJC-School/blob/main/stage%20%230/module%20%233.%20Java%20Lang%20Syntax/img/img_6.png?raw=true)

- The following important point is *System.out.println("This is my first Java program");* this is the part where the
  program
  logics is kept. This line is called an expression, it's a command/set of commands that will be read and performed by
  JVM.
  Every expression ends with semicolon, this symbol simply means the end of statement. Just like written
  languages have dots at the end of the sentence, programming languages use semicolons for the same purposes.
  It's the representation of any expression ending. And the whole line (ending with semicolon) is an action to be
  performed
  by Java. This particular line is responsible for writing the text on the console.

  ![img_7.png](https://github.com/mjc-school/MJC-School/blob/main/stage%20%230/module%20%233.%20Java%20Lang%20Syntax/img/img_7.png?raw=true)

## Curly braces

There's another thing to mention about this line. It's an opening curly brace "*_{_*". It is kind of a border that
separates one list of statements from another. Just like walls in real life that help split cottage areas from each
other.
They add some protection and privacy and also hide everything which is not allowed to see. This is what
those braces are responsible for.

Another thing to mention about that example is that not every line starts from the beginning of row, this is used to
make code more readable. This is called *indentation*. Each line that is inside curly braces lies further from beginning
of the row on 1 tab symbol.

And the last 2 lines are closing curly braces: they simply mean the ending of borders that were opened before. There are
two of them as one belong to method and the other belongs to class.

In this module we have got acquainted with key points in Java syntax, and we've also seen a program example.

***

# Java key points

## Identifiers

Each and every person has a name, it's used for identifying a specific human. People use the "naming" concept for
simplifying
process of describing the object they are communicating about. It's hardly imaginable to live in a world without names,
as it would take hours for describing the subjects of any speech.

In programming languages the same technique is also used. The names here are called **_identifiers_**. They are applied
for: classes, fields, variables, methods, arguments etc. In other words anywhere where we need to identify one
construction from another, identifiers are used. As in example in previous chapter, you've seen **_main_** method.

![img_8.png](https://github.com/mjc-school/MJC-School/blob/main/stage%20%230/module%20%233.%20Java%20Lang%20Syntax/img/img_8.png?raw=true)

Here the most significant point for now is **main** word. This is the _method name_ or identifier. If you create another
method and call it speak, that will be something like this:

    public static void speak() {
    }

Identifier in this case is "**speak**". And same as in real world people are associated with their names, Java
constructions are associated with identifiers. Those named pieces of code can be called to execute their job where
necessary. You will get acquainted with the process of calling the code a bit later.

**Note:**
Java has certain naming conventions. Using this [link](https://www.javatpoint.com/java-naming-conventions "link")
you can find information about naming conventions in Java.

## Keywords

Identifiers are tightly tied with _keywords_. Those are special words that are reserved by Java for its needs. They
are used all over any program and have special meaning for Java, and this is the reason why they are reserved. There are
about 50 reserved keywords in Java, and you have already seen some of them: **class**, **public**, **void** etc. Cool
point here is that there's no need in memorizing all of them at once, as you will learn them when necessary. Keywords
are usually used for creating some constructions which should be identified, like classes, methods etc. This is the
reason why Java expects to see identifier after certain combination of keywords.

![img_9.png](https://github.com/mjc-school/MJC-School/blob/main/stage%20%230/module%20%233.%20Java%20Lang%20Syntax/img/img_9.png?raw=true)

Those words cannot be used for names of literals, variables, classes, methods etc. The main reason is that Java
looks for such words to understand what a programmer wants, it's a tool for creating commands for Java to perform.

***

# Java variables

As mentioned above, identifiers are sort of names for something. They are used to associate a certain name with language
construction, for example, with a **_variable_**. Variable is a name (identifier) that is associated with a certain
value
of certain type.

    int t = 10;

The construction above is a variable declaration and assignment. Where the declaration is the process of telling Java
that
variable of this type will be created, and assignment is associating the value with that variable. Sometimes those
processes can come separately:

    int t;
    t = 10;

On the first line we told java to create a container for int type, and only after that we put the value there.
The construction above consists of: identifier (here it is "t"), the value is 10, and "int" is a type, which
represents integer value. So everything must be saved somewhere, mustn't it? Variables in Java are saved in computer
memory. The left-hand side of a variable declaration says: "allocate memory that is enough for saving int value (
so-called
container) and associate an identifier _t_ with that container, and put 10 there". This is actually what is happening
when
someone declares a variable. And as it was mentioned, memory is allocated not for the value, but for the container for
that.
This is done to be able to reuse that container in the future.

![img_10.png](https://github.com/mjc-school/MJC-School/blob/main/stage%20%230/module%20%233.%20Java%20Lang%20Syntax/img/img_10.png?raw=true)

It's just like creating a box that is big enough to store the laptop. And the identifier here is associated with that
box,
not with the laptop. Such approach provides us with an opportunity to take this box later and get the value from it.
Working with the box instead of the value itself is useful, because otherwise each time we would need to reuse some
value, we would need to create a new variable that would contain only certain value.

The process of variable creation is called _declaration_. Variables are declared in the following way:

    data_type variable_name = value;

Where the data_type is the type of container (amount of memory) to be allocated, variable_name is the identifier,
value is something to be put in the container. Or, in other words, **literal**.
Variables are called variables (not constants) as their value can be changed:

    int t = 10;
    t = 0;

Important thing here is that when we reuse the variable we do not set its type, as it was already announced. We just
reassign the new value for the old container, which is addressed with its name "t" in this case. There are some rules
for variables naming in java:

1) Variables naming cannot contain white spaces, for example: **int num ber = 100;** is invalid because the variable
   name
   has space in it.
2) Variable name can begin with special characters such as **$** and **_**.
3) As per the java coding standards the variable name should begin with a lower case letter, for example, **int
   number;**
   For lengthy variable's names that has more than one word do it like this: **int smallNumber; int bigNumber;**
   (start the following word with capital letter).
4) Variable names are case sensitive in Java, which means that number and nUmber - are different variables.

#### Literals

Before diving into numeric primitives theory it's good to take a look at the "literal" definition. So, literals are
simply
the values that are associated with the identifiers that are given to them:

    int t = 1;

So, here the literal is **1** and it's of an integer type, identifier here is **_t_**. So essentially, literals are the
values
that are stored in variables, and are immutable values themselves. But as we can assign different literals to the
variables,
they appear to be mutable.

***

## Java primitives

As was mentioned above, each variable is a container for some values. They store data, just like boxes in real life
store
things. Each box in real life has its parameters, like: size, color, etc. In programming languages those boxes have 2
main characteristics, that we are interested in:

1) data type - type of value that can be saved in container,
2) size of container - each data type in Java requires some space for its needs.

For simplicity imagine that we can have 2 containers:

1) for food

![img_11.png](https://github.com/mjc-school/MJC-School/blob/main/stage%20%230/module%20%233.%20Java%20Lang%20Syntax/img/img_11.png?raw=true)

2) for cargo transportation

![img_12.png](https://github.com/mjc-school/MJC-School/blob/main/stage%20%230/module%20%233.%20Java%20Lang%20Syntax/img/img_12.png?raw=true)

Even though they are both called "containers", they serve completely different tasks. The same in Java, each data_type
can store the values of that type. And just like in the real world, those data types have certain amount of memory that
is
allocated for storing values. Data types that are predefined by Java for the most basic operations are called
primitives. Java has 8 primitive data types namely *byte, short, int, long, float, double, char and boolean*. Sometimes
this set of data types is not enough in programming, so Java provides you with an opportunity to create your own type,
the way of doing that will be introduced later in the future.

## "Numeric" primitives

In real world we have some classes of numbers: natural, real, rational, irrational, etc. So in programming
languages classes of numbers also exist, but they are grouped in a little different way:

1. for integer numbers there are 4 types: byte, short, int, long;
2. for decimal numbers: float and double.

These are 2 main groups for serving numbers in Java. It seems a bit confusing as Java has 4 types for serving integer
values, there's a reason for that: each type as you remember has its size, and those types differ on size:

![img_13.png](https://github.com/mjc-school/MJC-School/blob/main/stage%20%230/module%20%233.%20Java%20Lang%20Syntax/img/img_13.png?raw=true)

*More details you can find using the [link](https://www.baeldung.com/java-primitives)*

The difference between those types is in size they occupy in memory, which also means that numeric values that can be
stored there differ according to memory usage. Different capabilities mean that you should always think about the
integer value that you are going to use when writing code.

For some cases using bytes (which contain values from -128 to 127) is more than enough: if the task is to save the
amount of floors in a building - bytes are perfect. This is done to be able to allocate only necessary amount of memory
for the variable.

There's no doubt that from language perspective you can always use **long** type for integer numbers, but if you need
to store number that is not going to reach huge values (amount of days in a year, etc.), the best option would be to use
something suitable. An average year contains 365 days, which is bigger that a byte can contain => using short here is
the best option.

But why is it a bad idea to use say integer or a long for that? Consider the following example: you need to store a
laptop,
and you have several options for that: a bag, a wallet and a barge. What is the best option here? There's no doubt that
a bag here is the best solution, because if you use a barge for each laptop, you will simply run out of space! Just like
in real life, programs have limited resources to use, this is why you should always think what you are going to create,
store and use. Essentially, even though programs nowadays are running in environments where it's hard to run out of
memory, using the most suitable container for the value is still a mandatory rule.

So if you want to see the reason why numbers depend on size, and how size is related to min & max values, you can take
a look at an advanced chapter:

***
Advance
topic: [Explanation why integer types have different size](https://github.com/mjc-school/MJC-School/blob/main/stage%20%230/module%20%233.%20Java%20Lang%20Syntax/advance/variables-size.md)
***

### Byte

Let's find out how to create a **byte** variable:

    public class Main {
       public static void main(String[] args) {
           byte b = 1;
       }
    }

As you remember, the first 2 lines are needed for Java, so for now we do not pay attention to them.

![](https://github.com/mjc-school/MJC-School/blob/main/stage%20%230/module%20%233.%20Java%20Lang%20Syntax/img/img_14.png?raw=true)

The line that we are interested in is: **byte b = 1;** so this is just a simple variable creation:

1. type definition - the place where we tell Java what container should be used.
2. identifier - the name to be associated with the value.
3. literal - the value to be stored in the container.
4. assignment - process of putting the value to container (setting the literal value to a byte container).

This is an example of **byte** variable creation. Essentially, variable of any type is created this way in Java. Just
like any other variable, byte is a primitive type. It can only hold integer values from -128 to 127. And as it's clear
from its name, it requires 1 byte of free space for managing those values.

### Short

The next primitive type that we are gonna to take a look at is **short**, it's a bit bigger than a byte (actually it
stores 2 bytes or 16 bits of memory):

    short s = 500;

As you can see from an example above, it's the type for integer values. It differs from byte by the values that it can
hold: as it requires twice more free space than a byte (16 bits), it can hold much bigger values - from -32_768 to
32_767.

### Int

If we need to serve even bigger numbers than those, Java provides us with an **int** type, which stores 4 bytes
(32 bits) and holds values from -2_147_483_648 to 2_147_483_647:

    int i = 2_000_000_000;

By the way this is the most commonly used integer type of all, as it covers the majority of use cases in programs.

### Long

**Long** is the biggest type for holding integer values, it requires 8 bytes of free space (64 bits) and
can serve values from -9_223_372_036_854_775_808 to 9_223_372_036_854_775_807 correspondingly:

    long l1 = 100L;
    long l2 = 100_000_000_000;

The only difference here in type declaration is that when a literal is smaller than the biggest integer value (or
less than the smallest) you should clarify that this should be a long value by adding a symbol "L" to literal value.
This is
required because default value type in Java for integer literals is int, and when you want to initialize a *long*
variable,
then you have to explicitly tell Java that you are putting a *long* value to the container.

### Decimal numbers

Sometimes operating with just integer numbers is not enough: if we need to calculate time of a sprint runner, measure
temperature, to express currency etc. This is where decimal numbers come into play. There are 2 primitive types for
decimal numbers: float and double. Even though they both aim to express decimal values, they have 2 main differences:
they differ on precision and values that they can contain:

![img_15.png](https://github.com/mjc-school/MJC-School/blob/main/stage%20%230/module%20%233.%20Java%20Lang%20Syntax/img/img_15.png?raw=true)

As you can see from the table above double is more precise, and can handle a bigger variety of values, but the situation
here is the same as with long values, the bigger and the more precise value the type can store, the more memory it
consumes.

### Float

As you have already seen from picture above, decimal types are represented within float and double types. Float consists
of 4 bytes and is able to manage 7 numbers of precision and stores values from ~ -3.4 * 10^38 to +3.4 * 10^38.

    float f = 0.01f;

Pay attention to "f" symbol here, it's used for the same purposes as "L" for long type: to explicitly tell Java that the
type of literal is float, as the default one is double.

### Double

This is the other primitive type that is used in Java for storing decimal numbers. This type is more precise: the
precision is 15 symbols. Also, it can manage numbers from ~ -1.8 * 10^308 to 1.8 * 10^308.

    double d = 123245.1234567890;

This type requires at least 8 bytes of free memory to be created.

### Boolean

Sometimes we need only two options to describe the state of something: if the light is on or off? For those cases Java
has **_boolean_** primitive type, that can contain only 2 values: _true_ or _false_. By the way, these 2 words are
reserved by Java.

    boolean b = true;

The size of a boolean type is not precisely defined, as it represents only 1 bit of data. Java "rounds" any object in
memory
to 1 byte, and the size of a boolean is in fact JVM dependent (differs in various implementations).

### Char

Char - is a primitive type for symbol representation. It acquires 2 bytes of memory and is able to handle characters
from
UTF-16.

    char c = 'v';

Special point here is that _char_ type needs those single quotes for telling Java that this is literal, that needs to be
treated as symbol. The way Java manages those symbols is the following: it associates value of symbol with unsigned
short
value. So the following is going to be the same:

    char t = 't';
    char t1 = 116;

Besides, char is able to handle also ASCII, and it has special combination of symbols:

    char myChar = '\u0054';

***

## Operators

Any program aims to solve some task, and usually the tasks are aimed to perform some actions on the data that we have:
calculating sum of anything, etc. For that purposes Java has a list of operators that can be divided into groups:

1. Arithmetic Operators.
2. Unary Operators.
3. Relational Operators.
4. Assignment Operators.
5. Bitwise Operator*.
6. Logical Operator*.
7. Ternary Operator*.
8. Shift Operator*.

*- These operators will be introduced later throughout the course.

Arithmetic operators are the ones that can be met in math:+, -, *, /, % (modulo operator), ^ (power operator).

### Unary operators

Usually operators perform calculations over variables or, in other words, _operands_. And if an operator interacts with
2
operands -> they are called binary operators (e.g. math operators). Meanwhile, _unary_ operators need only 1 variable to
work with:

    int t = 10;
    t++;

If you try to print that value you will see 11 as an output, it's all because it's the equivalent to:

    int t = 10;
    t = t + 1;

So it takes previous value and increases it by 1. It's POST INCREMENT. Here is the list of unary operators:

    int t = 11;
    t++;
    ++t;
    t--;
    --t;

The first two and the last two seem to be pretty similar, but they are different in operations order:

    int t = 10;
    int b = 10;
    int v = t++;
    int n = ++b;
    System.out.println("v = " + v + ", n = " + n + ");
    // v = 10, n = 11

In this case int b is PRE INCREMENTED, which means that variable b will be increased before it is assigned to n.
Meanwhile, t is POST INCREMENTED which means that value from "t" it will be assigned to "v" and only after that t will
be
increased. The same is with decrement: post decrement would assign the value to the new variable and then decrease
initial
one, when pre decrement decreases the value of original var and only afterwards performs assignment to the new variable.

### Short forms of assignment operators

Sometimes if we want to calculate sum - we need to take old value and add to it a new one.
Usually it consists of the following actions:

    //calculate sum of 98, 156, 343
    int sum = 0;
    sum = sum + 98;  
    sum = sum + 156;  
    sum = sum + 343; 

As you can see the actions above are really similar with increment operator, with the only difference: we can add any
number. And Java has a _short form_ for such cases:

    int sum = 0;
    sum += 98;
    sum += 156;
    sum += 343;

Which is the same as the example above. These short forms exist for all of arithmetical operators:-=,+=,*=,/=,%=.

### Relational variables

If we need to compare 2 values **in math** we do that with relational signs: >, <, <= (less or equals), >= (more or eq),
= (equals). So, those math signs has correlation in Java, all above but equals sign (in Java equals operator is **==**)
are
the same, and the result of those operators is not a number, but a boolean value:

    boolean b = 4 > 6;
    System.out.println("statement 4 > 6 is " + b);
    //statement 4 > 6 is false

The result of expression is boolean, as we expect to get some kind of comparison result which, in the end, is used to
see if our statement is true or not.

There are 2 operators which look different from math signs: equals operator (==) and not equals (!=). The reason why
equals in Java consists of 2 equal signs is because a single one in Java is an **assignment operator**, which, as you've
already seen, is used to associate literal with identifier.

Advanced topics:
------------------------------------------------------------

- [Type casting](advance/type-casting.md)
- [Operators for different types](advance/operators-and-types.md)
- [Operators priority](advance/operators-priority.md)

------------------------------------------------------------
