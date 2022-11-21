# Introduction

Every day we make certain actions that we don't even notice: after waking up we brush our teeth, some of us do
exercises, then we go to work/studies etc.

![img_1.png](https://github.com/mjc-school/MJC-School/raw/main/stage%20%230/module%20%234.%20Java%20Fundamentals/lesson%20%231.%20IF%20statement/img/img_1.png)

These are linear activities, as they come one after another with no other options
(for simplicity we consider that we cannot skip any of the actions above). In this block-scheme we can see that there's
no
choice and the activities just are a "flow".

But those scenarios are not met so often in our lives as we can act differently and make different decisions where there
are more than one probable outcomes, depending on some criteria or a condition, for example: when candidate decides
what college/university to enter, he has multiple options to choose from (for simplicity, we will choose between 2), and
also the decision he is about to make is going to have impact on his nearest future, e.g. entering technical University
in
the majority of the cases means that studies and, probably, career is going to be related to dealing with engineering
issues. On the other hand, if the same student enrolls with college of laws, his future will be related to lawyer
activities and so on.

![img_2.png](https://github.com/mjc-school/MJC-School/raw/main/stage%20%230/module%20%234.%20Java%20Fundamentals/lesson%20%231.%20IF%20statement/img/img_2.png)

Here we can see that there's a certain variability (we have to think what abilities do we have), if we have technical
abilities than we probably will think of entering technical university, and it demonstrates that all activities after
the decision was made don't cross with the ones from the other flow (or block of actions), and eventually we get to
certain point which might be completely different from the one with the "law flow". And this demonstrates that one small
choice can lead to a completely different result.

***

# The keyword "if" and "if" block structure

For such particular cases, in all C-like languages there's an "if" construction which provides a developer with an
ability to change the program flow depending on certain circumstances (pseudocode example):

    if (condition) {
         instruction 
    } else {
      the other instruction
    }  

Here we can see the following parts:

1) if - a keyword, which helps execute different code blocks depending on condition check outcome. This keyword must
   always
   be the first in such blocks ("if").
2) a condition to be checked - in the round brackets.
3) an instruction to be executed if the condition is true.
4) else - a keyword, which provides you with an opportunity what to do if the condition in "if"
   block is false.
5) an instruction to be executed if "else" case is in.

## How about java?

Java provides you with the "if-else" blocks, with the following structure:

    if (false) {
        System.out.println("The statement is true");
    } else {
        System.out.println("The statement is false");
    }

This is called conditional operator, and it consists of several parts:

1) if - a keyword.
2) a condition - false in our case.
3) a block of code to be executed if the condition is true.
4) else - a keyword, which provides you with an opportunity what to do if the condition in "if"
   block is false.
5) a block of code to be executed if "else" case is in.

## Time to "uncover" the magic

![img_3](https://github.com/mjc-school/MJC-School/blob/main/stage%20%230/module%20%234.%20Java%20Fundamentals/lesson%20%231.%20IF%20statement/img/img_3.png?raw=true)

If the condition in brackets is true, then console output will be:
"The statement is true", and in our scenario the condition for checking is false, this is why the block of code that is
associated with this flow will not be executed, and block of "otherwise" scenario is executed. And that means that code
in different parts is separate one from another, and it never crosses.


***

# Operators used with booleans

The **boolean** type must contain the result of any conditional (!, ||, &&) or comparative (==, !=, <
, >, >=, <=) operator, as after the calculation of them, we get either true or false.

Each of those operators can be applied in boolean conditions like:

#### Not operator

      boolean notTrue = !true;

This operator converts the result on the right-hand side to the opposite one: in our case we had "true", which with this
operator becomes false, as false is the opposite of true.

#### Or operator

      boolean trueResult = false || true;

This operator looks for ANY condition which is true: in our case the first literal was false this is why searching went
on, and it always continues until the first "true" is met, or the statement has ended. It's like adding numbers with
zeros
(if zero is false and any other number is true) if you add zero and zero you will still get zero, but if you add ANY
other number => the result will be more than 0.

#### And operator

      boolean falseResult = true && false;

This operator is true if ONLY all conditions are true: in our case the first literal was true, this is why searching
went
on, and it always continues until the first "false" is met, or the statement has ended. It's like multiplying numbers by
zeros
(if zero is false and any other number is true) if you multiply zero with anything you will still get zero, but if you
multiply ANY other numbers => the result will be more than 0.

#### Equals operator

      boolean trueResult = 5 == 5;

This operator is used for comparing variables: in our case the result will be true as 5 is equal to 5. And if only those
numbers (or any other variables) are the same the result is true, otherwise it's false. It sounds like: "Is 5 equal to
5?"

#### Not equals operator

      boolean trueResult = 6 != 5;

This operator is used for comparing variables: in our case the result will be true as 6 is not equal to 5. And if only
those numbers (or any other variables) are the not same the result is true, otherwise it's false. It sounds like:
"Is 6 not equal to 5?"

#### More operator

      boolean notTrue = 5 > 6;

This operator is used for comparing variables: in our case the result will be false as 5 is less than 6. And if only the
variable on the left-hand side is more than the right one the result is true, otherwise it's false. It sounds like:
"Is 5 more than 6?"

#### Less operator

      boolean trueResult = 5 < 6;

This operator is used for comparing variables: in our case, the result will be true as 5 is less than 6. And if only the
variable on the left-hand side is less than the right one the result is true, otherwise it's false. It sounds like:
"Is 5 less than 6?"

#### Less equals operator

      boolean trueResult = 5 <= 5;

This operator is used for comparing variables: in our case the result will be true as 5 is equals to 5. And if the
variable on the left-hand side is less OR equals to the right one the result is true, otherwise it's false. It sounds
like:
"Is 5 less OR equals to 5?"

#### More equals operator

      boolean trueResult = 5 >= 5;

This operator is used for comparing variables: in our case the result will be true as 5 is equals to 5. And if the
variable on the left-hand side is more OR equals to the right one the result is true, otherwise it's false. It sounds
like:
"Is 5 more OR equals to 5?"

***

# Multiple conditions within one if block

In reality, we can face cases when a simple checking is not enough, if we need to find number which are at the same time
are even and can be divided by 3(like 6), the simplest way it's going to look like this:

    int number = 6;

    if (number > 0) {
        if (number != 4) {
            System.out.println("Number " + number + " is above 0 and is not equal to 4!");     
        }
    }

All we say here is the if a number is more than 0 AND not equal to 4 than... But instead of inserting one block inside
another, we can just use &&(and) operator:

    expressionOne && expressionTwo

This operator is true only when expressions on both sides are true:

    int number = 6;

    if (number > 0 && number != 4) {
        System.out.println("Number " + number + " is above 0 and is not equal to 4!");     
    }

Special point about boolean conditions: no mater how many boolean or logics operators we have, eventually we will get
final
result. It's the same as calculating numbers in a math expression, in the end we get a final number.

Also, we can check if something is OR something:

    expressionOne || expressionTwo

This operator is true when at least 1 expression is true:

     int number = 9;

    if (number < 0 || number == 9) {
        System.out.println("Number " + number + " is less than 0 or equals to 9!");     
    }

Here number 9 is above 0, but this is nine itself, this is why the whole expression is true.

Also, we can check if something is NOT something:

      !expression

This operator is true when the expression is false:

     int number = 9;

    if (!(number == 0)) {
        System.out.println("Number " + number + " is not zero!");     
    }

The result of that expression is true as 9 doesn't equal to 0 => which makes this expression false, but as we are
using !(not) operator false becomes true(not false => true).

***

# Speeding up the calculations

Consider the following example: we need to find numbers between 0 AND 5 (0>x>5), the first thing to do is to define the
number to check: -1, the following step is to compare it with 0, 0 is more than -1 => which means that it is definitely
less than 5 (as 5 is above 0), which makes no sense to compare it with 5. The same scenario we can find if in "if" block
we have AND (&&) condition, as it was mentioned in chapter about boolean expressions
(it's like multiplying numbers with zero), if we have AND (&&) in if block in this case calculation stops if:
false condition is met or expression has come to end. If any statement is false, the following will not be checked:

![img_4.png](https://github.com/mjc-school/MJC-School/blob/main/stage%20%230/module%20%234.%20Java%20Fundamentals/lesson%20%231.%20IF%20statement/img/img_4.png?raw=true)

It helps save time when performing comparing operations.

"And" block is not the only block in which we can see accelerated computation. In "or" conditions, if any statement is
true the whole expression is true too:

Find positive OR above 5 number. Picked number is 2, which is even, and it suits our condition this is why we found the
number, and we can stop checking here!

![img_5.png](https://github.com/mjc-school/MJC-School/blob/main/stage%20%230/module%20%234.%20Java%20Fundamentals/lesson%20%231.%20IF%20statement/img/img_5.png?raw=true)


***

# Ternary operator

Java has the only "ternary" operator which can be translated as "triple" operator. It is used as shorten version of
plain if-else blocks like:

    int num = 5;
    if (num > 4) {
        ++num;
    } else {
        --num;
    }

which becomes:

    int num = 5;
    num > 4 ?
      ++num:
      --num;

This operator is called ternary as this is the only operator which consists of 3 parts: condition check (num > 4), and
parts in which the first one is executed is statement is true, and the other one if false. Condition and blocks are
separated by a question mark (which, like, asks if the statement on the left-hand side is true). Where the first block
is
executed if the statement is true. The next is colon ":" operator, which splits statements.

Another important thing about ternary operator is that each block is able to return the value after execution:

    int num = 5;
    int result = 0;
    result = num > 4 ? 
      ++num: 
      --num;
    System.out.println(result);

    // output will be: 6

The following thing happens: firstly the condition is checked, secondly the appropriate block of code is executed,
thirdly,
the result is assigned to the value "result". There's almost no difference between those code constructions in terms of
performance (or at least it's so small that it can be ignored). So, when you chose between those options, the only thing
that
you have to worry about is readability. Sometimes, being verbose in terms of writing code is more efficient than writing
less code, as code is written once, but it's read dozens times. Which means that it's better to use if-else block when
executed blocks of code consist of more than one statement.

***

# Multiple if cases

In each of the examples above we had only two options: either something was true or not, but in reality usually we have
more than just 2 options, we have to choose between multiple cases like: finding out the season by current month. For
such scenario, java provides programmers with "else if" syntax:

![img_6.png](https://github.com/mjc-school/MJC-School/blob/main/stage%20%230/module%20%234.%20Java%20Fundamentals/lesson%20%231.%20IF%20statement/img/img_6.png?raw=true)

      int month = 3; // mart
      String season; // season

      if (month == 1 || month == 2 || month == 12) {
         season = "winter";
      } else if (month == 3 || month == 4 || month == 5) {
         season = "spring";
      } else if (month == 6 || month == 7 || month == 8) {
         season = "summer";
      } else if (month == 9 || month == 10 || month == 11) {
         season = "autumn";
      } else {
         season = "invalid number of month!";
      }
      
      //this example was taken from http://developer.alexanderklimov.ru/android/java/if.php

In this case, as you can see, we go through conditions checking multiple times until we get into true statement or find
out that all the statements are false. And if the first checking condition is false we switch to the next one, until we
meet true, or we get into "else" block. For our case, if number of month wouldn't be bounded between 1 and 12 we'd got
to
the
"else" flow.

***

# Introducing switch statement

### Note: We are not considering changes in switch logic after Java 14

In the example where we tried to define the season based on current month, and those long if-else constructions are not
so convenient to read and create and for such cases java proposes "switch" statement:

      switch (statementToCompare) {
           case  (matchingValue1):
               codeBlock1;
               break;
           case (matchingValue1):
               codeBlock2;
               break;
           ... 
           case (matchingValueN):
               codeBlockN;
               break;
           default:
               codeBlockIfTheRestAreFalse;
               break;
      }

This construction consists of several parts:

1. "switch" statement itself, which says that construction begins.
2. "statementToCompare" which is passed to this switch statement to be compared with all the rest "matchingValues".
3. "case" which compares statementToCompare with the  "matchingValue", and if they are equal executes "codeBlock".
4. "break" means that execution of switch statement must end here and proceed outside of switch.
5. "default"  is responsible for executing the code block if all the rest conditions are false.

But switch statement has some limitations, it is able to compare and work with
byte, short, char, int, Byte, Short, Character, Integer, String (Java 7+), Enum.
And also another important thing to mention is that switch statements always compare values for equality unlike
"if-else" which can work with any statements that are eventually become boolean.

Returning to our example with seasons:

      int month = 3; // mart
      String season; // season

      switch (month) {
           case (1):
               season = "winter";
               break;
           case (2):
               season = "winter";
               break;
           case (12):
               season = "winter";
               break;
           case (3):
               season = "spring";
               break;
           case (4):
               season = "spring";
               break;
           case (5):
               season = "spring";
               break;
           case (6):
               season = "summer";
               break;
           case (7):
               season = "summer";
               break;
           case (8):
               season = "summer";
               break;
           case (9):
               season = "autumn";
               break;
           case (10):
               season = "autumn";
               break;
           case (11):
               season = "autumn";
               break;
           default:
               season = "invalid number of month!";
               break;
      }

This option doesn't seem to be less verbose, but this example shows the way this block works: it consumes "month" and
then compares that with the options within "case" blocks, and when those values are equal executes code until the first
"break" is met. A bit more optimized version is:

      int month = 3; // mart
      String season; // season

      switch (month) {
           case (1):
           case (2):
           case (12):
               season = "winter";
               break;
           case (3):
           case (4):
           case (5):
               season = "spring";
               break;
           case (6):
           case (7):
           case (8):
               season = "summer";
               break;
           case (9):
           case (10):
           case (11):
               season = "autumn";
               break;
           default:
               season = "invalid number of month!";
               break;
      }

This means the following: if the value equals to 1, 2, 12 => execute that block of code (it's common for all of that
cases) and it's the same for all the rest options.

### What was new in further java versions with switch

As java versions were increasing and new features were introduced, there were some changes, related to that
construction.
In java 13 we had the significant improvements like key word yield was introduced, and it helps return values from
switch blocks.(if no value is returned => "break"), and "arrow syntax"(lambda) were included:

      int toBeAssigned = switch (count) {
         case 1-> {
               System.out.println(count);
               yield 12;
         }
         default-> {
               System.out.println(count);
               yield 0;
         }
      };

In the code snippet above, the result of executing switch statement is assigned to toBeAssigned variable, but what value
should
be assigned? Dependent on the value of "count" either 12 or 0 will be assigned to "toBeAssigned": if count is 1, then
the first block of code is executed output will be "1" and toBeAssigned will become 12. Otherwise, the other block will
be involved, toBeAssigned will be 0.

***

# Logical vs boolean

There are such operators that are called "logical": &(AND),|(OR),^(XOR). To explain what do they do, we need to take a
glance at "binary systems". Those operators can be applied not only to booleans, but also to int-s:
if we convert an "8" and a 5 to binary numbers, we'll get: 1000, and 101.

### Logical "and" operator

      int result = 8 & 5;
      System.out.println(result);

      //*: 0

The result is 0 because, the following is happening: jvm converts those numbers to binaries, and then applies the
following logics:

       1000
      &
        101
      ------
       0000     

It is binary multiplication! It multiplies each number with the corresponding number below:
first column: 0x1 => 0  
second column: 0x0 => 0  
third column: 0x1 => 0

Which appears to be 0. This is just a kind of multiplication.

### Logical "or" operator

     int result = 8 | 5;
     System.out.println(result);

      //*: 13

The result is 13 because, the following is happening: jvm converts those numbers to binaries, and then applies the
following logics:

       1000
      |
        101
      ------
       1101     

It is binary addition! It adds each number with the corresponding number below:
first column: 0+1 => 1  
second column: 0+0 => 0  
third column: 0+1 => 1
fourth column: 1+0 => 1

Which eventually becomes 1101 -> 13

### Logical "xor" operator

     int result = 8 | 5;
      System.out.println(result);

      //*: 13

The result is 13 because, the following is happening: jvm converts those numbers to binaries, and then applies the
following logics:

       1000
      |
        101
      ------
       1101     

This simply checks if those binaries are different. And if only they are different, the final result is 1:
first column: 0^1 => 1  
second column: 0^0 => 0  
third column: 0^1 => 1
fourth column: 1^0 => 1

Which eventually becomes 1101 -> 13

And all those operands can be applied to boolean variables:

      System.out.println(true&false);
      System.out.println(true|false);
      System.out.println(true^false);

      //*: false true true

***

# Difference between booleans and logical operators

It's always better to use boolean operators. Even though
logical operators have a higher priority, they, unlike booleans, do not do "short-circuit"-ing which means that even if
in statement with (logical AND)& the first expression is false it will still calculate the right-had side,
when boolean conditions do not do extra calculations if not necessary.
