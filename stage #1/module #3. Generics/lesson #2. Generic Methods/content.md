## Generic Methods

We write generic methods with a single method declaration, and we can call them with arguments of different types. The compiler will ensure the correctness of whichever type we use.

These are some properties of generic methods:

* Generic methods have a type parameter (the diamond operator enclosing the type) before the return type of the method declaration.
* Type parameters can be bounded (we explain bounds later in this article).
* Generic methods can have different type parameters separated by commas in the method signature.
* Method body for a generic method is just like a normal method.

Here's an example of defining a generic method to convert an array to a list:


```
public <T> List<T> fromArrayToList(T[] a) {   
    return Arrays.stream(a).collect(Collectors.toList());
}
```

The <T> in the method signature implies that the method will be dealing with generic type T. This is needed even if the method is returning void.

As mentioned, the method can deal with more than one generic type. Where this is the case, we must add all generic types to the method signature.

Here is how we would modify the above method to deal with type T and type G:


```
public static <T, G> List<G> fromArrayToList(T[] a, Function<T, G> mapperFunction) {
    return Arrays.stream(a)
      .map(mapperFunction)
      .collect(Collectors.toList());
}
```

We're passing a function that converts an array with the elements of type T to list with elements of type G.

An example would be to convert Integer to its String representation:


```
@Test
public void givenArrayOfIntegers_thanListOfStringReturnedOK() {
    Integer[] intArray = {1, 2, 3, 4, 5};
    List<String> stringList
      = Generics.fromArrayToList(intArray, Object::toString);
 
    assertThat(stringList, hasItems("1", "2", "3", "4", "5"));
}
```

Note that Oracle recommendation is to use an uppercase letter to represent a generic type and to choose a more descriptive letter to represent formal types. In Java Collections, we use T for type, K for key and V for value.