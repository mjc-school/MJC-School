# Generics

## Why Use Generics?
In a nutshell, generics enable types (classes and interfaces) to be parameters when defining classes, interfaces and
methods. Much like the more familiar formal parameters used in method declarations, type parameters provide a way for
you to re-use the same code with different inputs. The difference is that the inputs to formal parameters are values,
while the inputs to type parameters are types.

Code that uses generics has many benefits over non-generic code:

- Stronger type checks at compile time.
- Elimination of casts.
- Enabling programmers to implement generic algorithms.

## Type Parameters in Java Generics
The type parameters naming conventions are important to learn generics thoroughly. The common type parameters are as
follows:

- T – Type
- E – Element
- K – Key
- N – Number
- V – Value

## Type Erasure
Generics were introduced to the Java language to provide tighter type checks at compile time and to support generic
programming. To implement generics, the Java compiler applies type erasure to:

- Replace all type parameters in generic types with their bounds or Object if the type parameters are unbounded. The
produced bytecode, therefore, contains only ordinary classes, interfaces, and methods.
- Insert type casts if necessary to preserve type safety.
- Generate bridge methods to preserve polymorphism in extended generic types.

Type erasure ensures that no new classes are created for parameterized types; consequently, generics incur no runtime
overhead.

This is an example of type erasure:
```
    public <T> List<T> genericMethod(List<T> list) {
        return list.stream().collect(Collectors.toList());
    }
```

With type erasure, the unbounded type T is replaced with Object:
```
    // for illustration
    public List<Object> withErasure(List<Object> list) {
        return list.stream().collect(Collectors.toList());
    }
    
    // which in practice results in
    public List withErasure(List list) {
        return list.stream().collect(Collectors.toList());
    }
```

If the type is bounded, the type will be replaced by the bound at compile time:
```
    public <T extends Building> void genericMethod(T t) {}
```

and would change after compilation:
```
    public void genericMethod(Building t) {}
```

## Materials
<https://docs.oracle.com/javase/tutorial/java/generics/index.html>

<https://www.baeldung.com/java-generics>
###
