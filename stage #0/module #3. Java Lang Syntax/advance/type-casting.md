## Type casting

Sometimes we want to convert the value of one type into another type, and this process is called ***casting*** in Java.
There are 2 types of casting:

- Widening Casting (automatically) - converting a type of a smaller size to a larger one:
  byte -> short -> char -> int -> long -> float -> double

`int myInt = 9;`

`double myDouble = myInt; // Automatic casting: int to double`

`System.out.println(myInt); // Outputs 9`

`System.out.println(myDouble); // Outputs 9.0`

Widening is done automatically because casting happens from a smaller type, and the container that value is transferred
to is able to handle any value from a smaller one.

- Narrowing Casting (manually) - converting a type of a larger size to a smaller one:
  double -> float -> long -> int -> char -> short -> byte

Narrowing is a bit more complicated:

    double myDouble = 9.78d;
    int myInt = (int) myDouble; // Manual casting: double to int

    System.out.println(myDouble);   // Outputs 9.78
    System.out.println(myInt);      // Outputs 9

When we are trying to convert the value from the bigger type, Java is aware that this value can be bigger than max value
of type we are casting to -> it makes programmer to do conversion explicitly:

    double myDouble = 9.78d;
    int myInt = (int) myDouble; 
