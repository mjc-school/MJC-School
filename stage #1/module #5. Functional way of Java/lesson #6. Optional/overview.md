### Optional

Optional – it’s a final class java.util.Optional<T>.

It’s a container object which may or may not contain a non-null value. The purpose of the class is to provide a type-level solution for representing optional values instead of null references.

<b>*Creation Optional*</b>

There are several ways of creating Optional objects. To create an empty Optional object, we simply need to use its *empty()* static method:

      Optional<String> empty = Optional.empty();

We can also create an Optional object with the static method *of()*:

      String name = "java";
      Optional<String> opt = Optional.of(name);

However, the argument passed to the of() method can't be null. Otherwise, we'll get a NullPointerException. But in case we expect some null values, we can use the *ofNullable()* method:

      String name = "java";
      Optional<String> opt = Optional.ofNullable(name);

By doing this, if we pass in a null reference, it doesn't throw an exception but rather returns an empty Optional object.

<b>*Optional methods*</b>

When we have an Optional object returned from a method or created by us, we can check if there is a value in it or not, receive value, define alternative value or method, or exception.

The *get()* method of an object returns its value or throws a java.util.NoSuchElementException if there is no value.

The Optional class provides a number of methods to avoid getting this exception. The easiest way is a preliminary check for the presence of a value in Optional using the *isPresent()* method.

      ArrayList<Integer> numbers = new ArrayList<Integer>();
      Optional<Integer> min = numbers.stream().min(Integer::compare);
      if(min.isPresent()){
         System.out.println(min.get());
      }

The second way is the *orElse()* method. It allows you to define an alternative value that will be returned if the Optional doesn’t have any value:

      Optional<Integer> min = numbers.stream().min(Integer::compare);
      System.out.println(min.orElse(-1));

Another way is the *orElseGet()* method. It allows you to define a function that will return a default value:

      Optional<Integer> min = numbers.stream().min(Integer::compare);
      Random random = new Random();
      System.out.println(min.orElseGet(() -> random.nextInt(100)));

Another method, *orElseThrow()*, allows you to throw an exception if the Optional does not contain a value:

      System.out.println(min.orElseThrow(IllegalStateException::new));

The *ifPresent()* method defines actions on the value in Optional, if the value is present:

      Optional<Integer> min = numbers.stream().min(Integer::compare);
      min.ifPresent(v -> System.out.println(v));

The *ifPresentOrElse()* method allows you to define actions on the Optional's value if a value is present, and alternative logic in case the Optional's value is missing.

      Optional<Integer> min = numbers.stream().min(Integer::compare);
      min.ifPresentOrElse(
         v -> System.out.println(v),
         () -> System.out.println("Value not found")
      );

Thus, Optional is a container object which helps to avoid using null, and provides a lot of methods to check the existence of a value and specify alternative behavior.