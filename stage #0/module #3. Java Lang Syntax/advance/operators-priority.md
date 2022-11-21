## Operator precedence

Just like math, Java has priorities for operators. If you put circle brackets to subtraction it will be executed
earlier than multiplication:

    int result = (2 - 1) * 10;//10 
    int result2 = 2 - 1 * 10; //-8

But this is not only applied for math operators:

![img_18.png](https://github.com/mjc-school/MJC-School/blob/main/stage%20%230/module%20%233.%20Java%20Lang%20Syntax/img/img_18.png?raw=true)

Some operators haven't been present yet, so no worries, they will be explained in the next chapters.

This basically means that you need to know the execution order of operators in Java, because that may impact your
program logic. The same as if you are performing certain operations over numbers in math, some transformation and data
processing is happening with the help of operators in Java. And if you declare them in a wrong order, that might impact
the result and produce unexpected behaviour and bugs. The best tactics if you do not remember the priority of
operators execution is to use circle brackets.
