## Type casting
Sometimes we want to convert the value of one type into another type, and this process is called ***casting*** in java.
There are 2 types of casting:

- Widening Casting (automatically) - converting a smaller type to a larger type size
- - byte -> short -> char -> int -> long -> float -> double


    int myInt = 9;
    double myDouble = myInt; // Automatic casting: int to double

    System.out.println(myInt);      // Outputs 9
    System.out.println(myDouble);   // Outputs 9.0

Widening is done automatically because casting happens from a smaller type, and the container that value is transferred
to is able to handle any value from a smaller one.

- Narrowing Casting (manually) - converting a larger type to a smaller size type
- - double -> float -> long -> int -> char -> short -> byte

Narrowing is a bit more complicated:

    double myDouble = 9.78d;
    int myInt = (int) myDouble; // Manual casting: double to int

    System.out.println(myDouble);   // Outputs 9.78
    System.out.println(myInt);      // Outputs 9

When we are trying to convert the value from the bigger type, java is aware that this value can be bigger than max value
from converted type -> it makes programmer to do conversion explicitly:

    double myDouble = 9.78d;
    int myInt = (int) myDouble; 