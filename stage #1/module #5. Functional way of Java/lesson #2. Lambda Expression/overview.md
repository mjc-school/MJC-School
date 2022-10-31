## Lambda Expression

A lambda is a set of instructions that can be separated into a variable and then called multiple times in different places in the program.

The basis of a lambda expression is the lambda operator, which represents the arrow «->». This operator divides the lambda expression into two parts: the left part contains the list of input parameters of the expression, and the right part represents the body of the lambda expression, where all the actions are performed.

For example, the lambda expression (x, y) -> x + y specifies that the lambda expression takes two arguments x and y and returns the sum of these.

     //Syntax of lambda expression
     (parameter_list) -> {function_body}

A lambda expression does not execute on its own, it only constitutes an implementation of a method defined in a functional interface.
Let's look at an example:

      @FunctionalInterface
      interface Operationable {
        int calculate(int x, int y);
      }

      public class LambdaApp {
        public static void main(String[] args) {
          Operationable operation = (x, y) -> { return x + y; };
          int result = operation.calculate(10, 20);
          System.out.println(result); //30
        }
      } 

The Operationable interface acts as a functional interface, in which one method is defined without implementation – the calculate method. This method takes two parameters – integers, and returns some integer.

<b>*Lambda Expression vs method in Java*</b>

A method (or function) in Java has these main parts:
1. Name
2. Parameters
3. Body
4. Return type

A lambda expression in Java has these main parts:
Lambda expression <u>has only parameters and body</u>.
1. <b>No</b> name – function is anonymous so we don’t care about the name
2. Parameters
3. Body – This is the main part of the function.
4. <b>No</b> return type – The java 8 compiler is able to infer the return type by checking the code. you need not to mention it explicitly.

<b>*Lambda Expression design*</b>
The parameters of the lambda expression must match the type of the method parameters from the functional interface. When writing the lambda expression, it is <u>not necessary to write the type</u> of the parameters, although in principle this can be done, for example:

      operation = (int x, int y) -> { return x + y; };

If the method takes no parameters, then empty parentheses are written, for example:

      () -> { return 30 + 20; };

If the method takes only one parameter, then the parentheses can be omitted:

      n -> { return n * n; };

If body of a lambda expression have one line, braces and ‘return’ can be omitted:
Absolutely the same things:

      n -> { return n * n; };   and   n -> n * n;

<b>*Lambdas and local variables*</b>

A lambda expression can use variables that are declared in a more general scope – at the class or method level in which the lambda expression is defined. However, depending on how and where variables are defined, the way they are used in lambdas can differ.

Let's look at the first example - using class-level variables:

      @FunctionalInterface
      interface Operation {
         int calculate();
      }

      public class LambdaApp {

        static int x = 10;
        static int y = 20;
    
        public static void main(String[] args) {         
           Operation op = () -> {
               x = 30;
               return x + y;
           };
           System.out.println(op.calculate()); // 50
           System.out.println(x); // 30 - x value changed
        }
      }

The variables x and y are declared at the class level, and in the lambda expression we can get them and even change them. So, in this case, after the expression is executed, the value of the variable x changes.

We can also use method-level local variables in lambdas, but we cannot change their value either in the lambda or outside the lambda. If we try to do this, then the development environment can show us an error «Variable used in lambda expression should be final or effectively final».

See example:

      public class LambdaApp {
      
         static int x = 10;
         static int y = 20;
         
         public static void main(String[] args) {
            int n = 70;
            int m = 30;
            Operation op = ()-> {
               //n = 100; - this cannot be done
               return m + n;
            };
      
          // n = 100; - this cannot be done
          System.out.println(op.calculate()); // 100
         }
      }

Thus, we have covered the definition of lambda expressions, why they are better to use, and some rules for using them.