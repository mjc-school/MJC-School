## General Overview

Let's imagine a scenario where we want to create a list in Java to store Integer.

We might try to write the following:
```
List list = new LinkedList();
list.add(new Integer(1)); 
Integer i = list.iterator().next();
```

Surprisingly, the compiler will complain about the last line. It doesn't know what data type is returned.

The compiler will require an explicit casting:

```
Integer i = (Integer) list.iterator.next();
```

There is no contract that could guarantee that the return type of the list is an Integer. The defined list could hold any object. We only know that we are retrieving a list by inspecting the context. When looking at types, it can only guarantee that it is an Object and therefore requires an explicit cast to ensure that the type is safe.

This cast can be annoying — we know that the data type in this list is an Integer. The cast is also cluttering our code. It can cause type-related runtime errors if a programmer makes a mistake with the explicit casting.

It would be much easier if programmers could express their intention to use specific types and the compiler ensured the correctness of such types. This is the core idea behind generics.

Let's modify the first line of the previous code snippet:

```
List<Integer> list = new LinkedList<>();
```

By adding the diamond operator <> containing the type, we narrow the specialization of this list to only Integer type. In other words, we specify the type held inside the list. The compiler can enforce the type at compile time.

In small programs, this might seem like a trivial addition. But in larger programs, this can add significant robustness and makes the program easier to read.

**One restriction of generics in Java is that the type parameter cannot be a primitive type.**