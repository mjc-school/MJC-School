## Big-O

* Topic is very complex, good course takes at least 20 hours
* Introduction
    * Why should we care?
        * Example of difference in execution time
    * Why can't we exactly calculate execution time?
    * How to approximate execution time
* Big-O basics
    * Basic definition
    * Definition applied to algorithms
    * Popular complexities in order
        * 1, logn, n, nlogn, n^2, n^3
* Big-O in math
    * Definition - f(x) growth not faster than g(x), so it's O(g(x))
    * Linear vs square graphs
    * Some properties
        * O(an + b) = O(n)
        * if f(x) = O(g(x)), then O(f(x) + g(x)) = O(g(x)). O(n + n^2) = O(n^2)
    * Selected properties of Big-O - ask students on examples
    * Questions? If you don't understand it at all, maybe in would be better on examples 
* Big-O in algorithms
    * Examples
        * Array max
            * Method call with input of size 1000 will work twice as fast comparing to the input of size 2000
            * Cycle has a O(n) complexity
        * Pairs - difference will be 4 times
            * Nested cycle has a O(n^2) complexity
        * Method call - difference will be 8 times
        * ArrayList "add" extention complexity
    * Gathering complexity as constructor
* Memory complexity
* Basic java opeartion and their complexities
* Selected data structures and algorithms
    * Stack, queue
    * Lists
    * Tree
    * Hash table
    * PriorityQueue
* General-case sorting - O(nlogn)
    * Proof is not covered in this course, but you can read it yourself
* FAQ
    * Constant in front of complexity can be very high, making algorithm inefficient
* Complexity-time matrix
* Advanced data structures and algorithms
