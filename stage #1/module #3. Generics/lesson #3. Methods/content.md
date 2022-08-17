# Generic Methods

## Overview
Generic _Java_ method takes a parameter and returns some value after performing a task. It is exactly like a normal
function, however, a generic method has type parameters that are cited by actual type. This allows the generic method to
be used in a more general way. The compiler takes care of the type of safety which enables programmers to code easily
since they do not have to perform long, individual type castings.

These are some properties of generic methods:
- Generic methods have a type parameter (the diamond operator enclosing the type) before the return type of the method
declaration.
- Type parameters can be bounded (we explain bounds later in this article).
- Generic methods can have different type parameters separated by commas in the method signature.
- Method body for a generic method is just like a normal method.

```
    public <T> List<T> fromArrayToList(T[] a) {   
        return Arrays.stream(a).collect(Collectors.toList());
    }
```

The `<T>` in the method signature implies that the method will be dealing with generic type **T**. This is needed even
if the method is returning void.

As mentioned, the method can deal with more than one generic type. Where this is the case, we must add all generic types
to the method signature.

Here is how we would modify the above method to deal with type **T** and type **G**:
```
    public static <T, G> List<G> fromArrayToList(T[] a, Function<T, G> mapperFunction) {
        return Arrays.stream(a)
            .map(mapperFunction)
            .collect(Collectors.toList());
    }
```

We're passing a function that converts an array with the elements of type **T** to list with elements of type **G**.

## Bounded Type Parameters
To declare a bounded type parameter, list the type parameter's name, followed by the extends keyword, followed by its
_upper bound_, which in this example is `Number`. Note that, in this context, extends is used in a general sense to mean
either `extends` (as in **classes**) or `implements` (as in **interfaces**).
```
public class Box<T> {
    private T t;          

    public void set(T t) { this.t = t; }
    
    public T get() { return t; }

    public <U extends Number> void inspect(U u) {}

    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<Integer>();
        integerBox.set(new Integer(10));
        integerBox.inspect("some text"); // error: this is still String!
    }
}
```

By modifying our generic method to include this bounded type parameter, compilation will now **fail**, since our
invocation of inspect still includes a `String`:
```
    Box.java:21: <U>inspect(U) in Box<java.lang.Integer> cannot
    be applied to (java.lang.String)
    integerBox.inspect("10");
    ^
    1 error
```

### Multiple Bounds
The preceding example illustrates the use of a type parameter with a single bound, but a type parameter can have
multiple bounds:
```
    <T extends B1 & B2 & B3>
```

A type variable with multiple bounds is a subtype of all the types listed in the bound. If one of the bounds is a class,
it must be specified first. For example:
```
    Class A { /* ... */ }
    interface B { /* ... */ }
    interface C { /* ... */ }

    class D <T extends A & B & C> { /* ... */ }
```

If bound A is not specified first, you get a compile-time error:
```
    class D <T extends B & A & C> { /* ... */ }  // compile-time error
```

## Materials
<https://www.baeldung.com/java-generics>

<https://docs.oracle.com/javase/tutorial/java/generics/methods.html>

<https://docs.oracle.com/javase/tutorial/java/generics/bounded.html>
###
