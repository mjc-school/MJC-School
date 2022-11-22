# Introduction

Before diving into "loops", make the console output with the words: "writing the same code doesn't have much impact,
and it's also time-consuming" for 20 times.

# Task

Repeat is bad. Create a program that will make console output for 20 times, saying:
"writing the same code doesn't have much impact, and it's also time consuming".
No loops, streams are allowed. The task should be implemented inside of repeatIsBad() of code snippet:

    public class Main {
        public void repeatIsBad(){
            //write your code here
        }
    }

### Plain task solution

You should have got something like this:

    System.out.println("writing the same code doesn't have much impact, and it's also time consuming");
    System.out.println("writing the same code doesn't have much impact, and it's also time consuming");
    System.out.println("writing the same code doesn't have much impact, and it's also time consuming");
    System.out.println("writing the same code doesn't have much impact, and it's also time consuming");
    System.out.println("writing the same code doesn't have much impact, and it's also time consuming");
    ...
    System.out.println("writing the same code doesn't have much impact, and it's also time consuming");
    System.out.println("writing the same code doesn't have much impact, and it's also time consuming");
    System.out.println("writing the same code doesn't have much impact, and it's also time consuming");

There's something wrong with that code, isn't it? Imagine that you were to make this action not 20 times, but
a hundred, a thousand... a million times. This would take eternity to do that with almost no impact, and what is more,
the code will become unreadable. As you should have already guessed, the whole point of this code is just REPEATING
THE SAME block of code over and over again.


***

# The most basic loops

## While

For cases when we have to repeat certain action several times in all C-like
languages there's a loop construction, which provides a developer with an ability to extract a repeatable action to some
block and declare amount of times for that action to be executed. The following diagram illustrates the algorithm:

![img_1.png](https://github.com/mjc-school/MJC-School/blob/main/stage%20%230/module%20%234.%20Java%20Fundamentals/lesson%20%232.%20FOR%20statement/img/img_1.png?raw=true)

The main idea of that algorithm is to make console output for 20 times. As you can see, to do so we need to declare
the variable through which we will be able to have control over the loop itself, which is (in our case):

- int counter = 1. This variable is necessary to know how many times we have already gone through the loop.
- is counter less than or equals 20. At this point we are checking the amount of times that we have already gone through
  the loop, and after that, there are 2 possible options:
    - counter is less than or equals 20, which means that the loop continues, and we need to execute the code, which
      basically is:
        - make console output, which is the code inside loop section
        - increase counter by 1, which means that actual iteration of code execution is over
    - counter is more than 20, which means that we shouldn't do anything else as we have reached the amount of necessary
      repetitions

There are 3 (actually 4, but we will get acquainted with the 4th one in the future modules) main types of loop
constructions: "while", "for", "do-while". We will begin with the "while" loop, and the task with console output
becomes:

    int counter = 1
    while (counter <= 20) {
        System.out.println("writing the same code doesn't have much impact, and it's also time consuming");
        counter++;
    }

And that's all! This seems to be much better and much more laconic, isn't it? Let's take a look under the hood:

1) Just like in the block scheme, we define the counter.
2) Next comes the condition checking. The keyword "while", which literally says "until the counter is less than or
   equals 20 do the following":
    - Make the console output: System.out.println("writing the same code doesn't have much impact, and it's also
      time-consuming");
    - Increase the counter by one.
3) AND if the condition checking in the 2nd step was true (the counter is still less than or equals 20), after executing
   actions described above, we have to return to the 2nd step to check the condition once again, and repeat it until
   the value of counter reaches 21. Otherwise, if the condition checking is false, we proceed to the 4th step.
4) The execution of loop ends.

After taking a look at "while" loop, this task becomes much less time-consuming. Also, we almost don't have
limitations on the amount of repetitions, which can save much time for us if the task scales up.


***

## For

"while" loop looks much better than just copy-pasting the same code lines required amount of times (and you are less
likely
to make mistakes), but using it we had to take some additional space to **define**, **check** and **increase** the
variable that will give us the control. There's a way to make this even shorter, which is basically the "for" loop,
which
looks like this:

    for (int counter = 1; counter <= 20; counter++) {
        System.out.println("writing the same code doesn't have much impact, and it's also time consuming");
    }

The code has become even shorter, as we have extracted all the code that is responsible to control the "loop" flow into
one block (or even one line), but the principle is still the same:

![img_2.png](https://github.com/mjc-school/MJC-School/blob/main/stage%20%230/module%20%234.%20Java%20Fundamentals/lesson%20%232.%20FOR%20statement/img/img_2.png?raw=true)

1) Define the counter (just like before).
2) Go to the following statement, which is checking the condition.
3) Execute the code block if condition is true.
4) Increase the variable counter.
5) Execute the 2nd step and so on until false is met.

Tricky point here is that if the condition is true, it appears to be logical to increment the counter and only after
that
go to the code block execution. But it doesn't work like this, as the increment (counter++) statement is executed only
after the code block with the logics itself is finished.

Also, the last "increment" statement usually interacts with the counter to be able to break the loop once we need it.
Those interactions can be different (not only increment): we can multiply, divide , decrease the counter
(any math operation can be applied).

### While vs For

So when to use "while" and when is it preferable to use "for" loops? The answer is simple: when you know the final
amount
of iterations, it's better (simpler) to use "for", and when you have to check something, which cannot be easily
determined, it's better to use "while".

Another point worth mentioning is that if you are to interact with the variable that has already been defined,
it's also "while" use-case:

    int toBeChanged = 742;
    ... // actions with the toBeChanged which eventually change it's value to -5
    while (toBeChanged > toBeChanged * 5) {
        System.out.println(toBeChanged);
        toBeChanged++;
    }

In this case we are not sure how many times those operations will be executed until we meet the condition, and also our
variable was defined long before the loop itself. As the value of toBeChanged is equal to -5, when it's multiplied by 5
we get -25, which is less than -5, and that goes on until 0 is met.

"for" loops can be used when we need to count something. Like count the amount of even numbers from -5 to 17:

    int counter = 0;
    for (int iterator = -5; iterator < 18; iterator++) {
        if (iterator % 2 == 0) {
            counter++;
        }
    }
    System.out.println(counter);

Here we go from -5 to 17 inclusive, and each time the number is even, we increase the counter.


***

## Do-while

"do-while" loop is a bit different than "while" and "for" as this loop literally says "before checking the condition
execute the code block":

![img_3.png](https://github.com/mjc-school/MJC-School/blob/main/stage%20%230/module%20%234.%20Java%20Fundamentals/lesson%20%232.%20FOR%20statement/img/img_3.png?raw=true)

In this case the action block will be executed before the condition checking, which literally means that even if the
condition is false, then the action block will be executed AT LEAST once. Only after that condition is checked.

"do-while" block has the following structure:

    int counter = 0
    do {
        System.out.println(counter);
        counter++;
    } while (conter > 0 && counter < 10);

In this case console output will be from 0 to 9, as the number is printed before the increment statement. And if we were
to use simple "while" or "for" loop here, the code block wouldn't be executed, as the condition check would be performed
before the action block. This means that counter would still remain 0, which is obviously not more than 0.

"Do-while" block is not used as often as "while" and "for", because it has a bit different use-case scenarios. It's
usually used when we need to perform some action at least once before checking some condition. For example, when we
have to get some data from anywhere, and the data is provided continuously, we can try to get it, and
while the data is still provided, we continue going through the loop. Pseudocode example:

    do {
        boolean isThereStillData = // some actions to get data
    } while (isThereStillData);

This example can be rewritten with "while" loop:

    boolean isThereStillData = // some actions to get data
    while (isThereStillData) {
        isThereStillData = // some actions to get data
    }

But here we have to execute the same action twice, which is not that efficient.


***

# Loop keywords

## Continue

Sometimes it's necessary to skip some loop iterations if a specific condition is met, like, if we have numbers from 0 to
9 and want to print all numbers except 5, we can do the following:

    for (int i = 0; i < 10; i++) {
        if (i == 5) {
            continue;
        }
        System.out.println(i);
    }
    // output will be: 012346789

This operator is responsible for stopping executing the rest of the code9 for CURRENT iteration, which means that
overall
loop execution will be proceeded. Literally, that means that we do not want to execute the iteration anymore (the code
execution is skipped until the brace which closes the loop is met), and we want to continue with the next one. **But in
case of "for" loop, as you know, after executing the block of code, before checking the condition, Java goes to
increasing
iterator statement and only after that it proceeds with the condition check.**

The example above also can be changed to something like:

    for (int i = 0; i < 10; i++) {
        if (i != 5) {
            System.out.println(i);
        }
    }

Seems that it's even better right? But tricky point here is that as the amount of nested blocks of code is increasing,
we
are running into situations where we have 5 or even 6 times nested blocks of code, which makes it hard to read,
understand and maintain. The less nested blocks we have, the better it is. Even though this operator is not used too
often.

## Break

There can be situations when we do not want to proceed loop execution, because of different facts. For example, if the
data that our program consumes is unexpected (if we are expecting to get only positive numbers, but the number we
receive
is zero or below), for that particular case Java offers you the "break" keyword:

    for (int i = 0; i < 10; i++) {
        if (i == 5) {
            break;
        }
        System.out.println(i);
    }
    // output will be: 01234

The example above describes that what "break" keyword actually does is just skipping the code that would have been
executed if "break" wasn't present. So the operator is responsible for "ending" current loop, which means that even if
this
statement is used within "for", loop increment statement will not be executed, as Java just skips everything within the
loop.

We have already seen this "break" keyword in switch statements, and the role of this key word was the same there. It was
the command (or the flag) for Java to stop code execution within switch statement and proceed outside of switch.
Here the logics are the same.


***

# Infinite loops

Basically, the main job of any loop is to run the same block of code definite amount of times. This is achieved
through iterator (counter), as it helps us to know the number of current iteration. And it works perfectly while we are
controlling
this iterator. But what happens if we stop counting each iteration:

        int counter = 1
        while (counter <= 20) {
            System.out.println(i);
        }

What do you think will happen in this case? The program will get stuck and will be printing to the console "1" infinite
amount of times (or until it is terminated), this happens because the condition is always true, as our counter is never
increased.

The same situation is with "for" loops, ignoring increasing statement will get the program stuck just like "while"
loops:

    for (int i = 0; i < 10;) {
        if (i == 5) {
            break;
        }
        System.out.println(i);
    }

As you can see, increment statement is omitted here, which means that our iterator will never change, and the condition
is
always true. So this loop will proceed executing until termination is performed. Besides, this example shows that some
statements in "for" loops can be skipped, and infinite loop can be achieved with the following syntax:

    for (;;) {
        System.out.println("i");
    }

This looks a bit weird but it works! There's no iterator, condition is always true, and no increment statement, which
makes Java iterate over and over again.

There's also another way to create such loop with "while":

    while (true) {
        System.out.println('i');
    }

This loop is infinite is because the condition is always true, and never changed. So you have to always control this
iterator, not to let your code get stuck at any point.


***

# Nested loops

We've already got acquainted with basics of loops, those were just 1 dimensioned loops, but there can be situations when
we
need to take a "step" in depth of a loop. Imagine we have a two-dimensional square on the coordinate plane, and if you
want
to get to the middle of it, you have to shift the X coordinate to the middle, and after that do the same with Y
coordinate:

![img_4.png](https://github.com/mjc-school/MJC-School/blob/main/stage%20%230/module%20%234.%20Java%20Fundamentals/lesson%20%232.%20FOR%20statement/img/img_4.png?raw=true)

In this case we would be moving the Y coordinate ONLY WHEN X = 4, but to be able to do so we have the coordinate plane
which
consists of 7 X points and 7 Y points. In real world we don't create these fields manually, but it can be achieved by
the following code:

    for (int x = 0; x < 8; x++) {
        for (int y = 0; y < 8; y++) {
        }
    }    

What actually happens is:

![img_5.png](https://github.com/mjc-school/MJC-School/blob/main/stage%20%230/module%20%234.%20Java%20Fundamentals/lesson%20%232.%20FOR%20statement/img/img_5.png?raw=true)

On each X step it does 8 steps on Y coordinate and then goes to the next X step. By doing so we can have control over
n-dimensional spaces, where n is any positive number (this will be super useful later, when you will be dealing with
things
like arrays of arrays).

It's necessary to understand that those 2 loops are independent, the example above is just an illustration of how it
works, and those iterators can have different counts, steps, and can work with different data structures and types. The
only common thing is that inner loop executes all its steps on EACH step of outer loop. And outer one is a "counter" for
the inner one. Having this information about iterations of inner and outer one, we can access any point of the
"coordinate plane" in the example above, e.g. if we need to reach point (2, 4), it looks like this:

![img_7.png](https://github.com/mjc-school/MJC-School/blob/main/stage%20%230/module%20%234.%20Java%20Fundamentals/lesson%20%232.%20FOR%20statement/img/img_6.png?raw=true)

Iterations will proceed until the conditions are true, and by controlling iterators we can reach any point of the
coordinate plane.


***

# Go to

In procedural programming there was a "go to" operator (which made program go to a certain point of code and
proceed execution there), but later programmers decided to get rid of it, because it made the code less readable and
maintainable. Many leaps from one line of code to another aren't very helpful for understanding the logics of that code.

Java doesn't have this operator, but it has something similar called "labels". These won't be studied in this course,
as they are not used in modern programming at all, and their usage is harmful for common programming principles. You
should avoid using labels when writing code and creating your architecture. If you desperately want to know more about
them, do some research on your own.
