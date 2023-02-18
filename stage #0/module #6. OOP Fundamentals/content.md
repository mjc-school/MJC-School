# Object Oriented Programming (OOP) Fundamentals
## Introduction
**_Object-Oriented Programming (OOP)_** is a programming methodology, which is based on functioning of a software product
as a result of interaction of objects, each of which is an instance of a particular class. _**Class**_ is a template of
an entity, which defines its initial state and behaviour. _**Object**_ is an existing instance of an entity,
which possesses certain state and behaviour.

## Objects
Object is a core concept to understand OOP. A good example of object from real-world is a dog. All real-life
objects have two main features: state and behaviour. Dogs have the following state: nickname, breed, color, character;
and the following behaviour: barking, eating, guarding, wagging tail. Software objects are conceptually similar to
real-world objects: they consist of state and related behavior as well. An object stores its state in fields (variables)
and defines its behavior through methods (functions). Methods operate on an object's internal state and serve as the
primary mechanism for communication among objects. Fields and methods of classes are called their members. It is common
practise to name class members in lowercase in compliance with ["camelCase" style](https://betterprogramming.pub/string-case-styles-camel-pascal-snake-and-kebab-case-981407998841).
More detailed information about objects can be found [here](https://docs.oracle.com/javase/tutorial/java/concepts/object.html).

## Classes
Class is a template, which objects are created from. In the real world, we can find many individual objects, which are
of the same kind. There may be thousands of smartphones, which have the same make and model. Each this smartphone was
built from the same set of blueprints and therefore contains the same components. In object-oriented terms, we say that
somebody's smartphone is an instance of the class of objects known as "smartphones".
***
Example
```
class Smartphone {

    public Smartphone() {
        // it is a constructor, which is a special method  
    }

    boolean isScreenTurnedOn = false; // an initial state of every smartphone is a turned-off screen;

    void turnOnScreen() {
        isScreenTurnedOn = true; // if a method is called, a screen of smartphone will be turned on;
    }

    void turnOffScreen() {
        isScreenTurnedOn = false; // if a method is called, a screen of smartphone will be turned off;
    }
}
```

### Declaration of Classes and its Members

#### Class Declaration
The simplest way to declare class is the following:
```
public class Bicycle {

   // The class has a name "Bicycle";
   
   // This class has no state (fields) and behaviour (methods). 
}
```
Here we declared an empty class body, which is an area between curly-braces - "{}".

#### Fields Declaration
In order to add state for a class, it is necessary to declare a field in a class body.
Field declarations contain three components in the following order:
- (Optional) Modifier, which can be public, protected, private;
- (Required) Field Type;
- (Required) Field Name.
```
public class Bicycle {
    
    public int speed = 0; // now a class has a state: an initial speed is "0";
      
    // This class still has no behaviour (methods).
}
```
Modifiers allow us to control, what other classes can have access to the field (this topic will be discussed further).
Type is a parameter, which describes a structure of a class state. Fields can be of primitive type (int, float, boolean,
etc.) and reference type (arrays and other objects). Names should follow the same naming rules and conventions
(this topic will be discussed further).

#### Methods Declaration
In order to add behaviour for a class, it is necessary to declare a method in class body.
Method declarations contain components in the following order:
- (Optional) Modifier, which can be public, protected, private
- (Required) Return type;
- (Required) Method Name;
- (Required) Parentheses "()";
- (Required) Method Body.

A special case of return types is "void", which means that a method doesn't return anything and just performs actions
within a method body. Keyword "return" is obligatory in case of return type is not "void", and it is placed aside with a
returning value. Anyway, "return" always terminates an execution of a method. In parentheses there can be a list of
parameters, which is an input data of a method. Such parameters are separated from each other by commas, the parameters consist
of two components: type and name.

```
public class Bicycle {
    
    public int speed = 0;
    
    // New behaviour, which allows a bicycle to move.
    // If a method is called, the following message will be printed: "A bicycle is moving at speed 0".
    public void move() {
        System.out.println("A bicycle is moving at speed " + speed);
    }
    
    // New behavior, which provide a current value of state "speed".
    public int getSpeed() {
        return speed;
    }
    
    // New behaviour, which allows to change a value of state "speed".
    // In order to call a method, it is necessary to pass a value of primitive "int" type, as a parameter.
    // if a method "getSpeed()" is called after that, a new value of "speed" will be returned. 
    public void increaseSpeed(int newSpeed) {
        speed = newSpeed;
    }
    
    // New behaviour, which allows to change a value of state "speed", which isn't greater than a limit of "20".
    // Note, keyword "return" can be used in "void" case.
    public void increaseSpeedWithLimit(int newSpeed) { // a parameter named "newSpeed" of the primitive type "int"  
        if (newSpeed > 20) {
            return; // just terminates an execution of a method without changing a state "speed"
        }
        speed = newSpeed;
    }
}
```

### Constructor
In order to start to use a class, it is necessary to create its object. Here are creation steps:
1) Create a variable of an object:
```
Bicycle bicycle; 
```
A created variable doesn't contain object. Variables of reference types (arrays and objects) don't contain objects
themselves, they are used in order to store references (addresses) of objects (instances of classes) in memory.
Initially, the variable will only have an empty value called `null`.

2) Initialize a variable by the means of an operator `new`, which invokes a constructor and therefore allocates memory for an object.
```
bicycle = new Bicycle();
```
The first and the second step can be merged.
```
Bicycle bicycle = new Bicycle();
```

As you may notice a constructor is a special construction, which is obligatory to create an object. Constructor itself
is a special method, which is being called while object creation. Requirements for a constructor:
- it must have a name, which is similar to a name of a class;
- it must not have any return value, even "void".

Constructor declarations contain components in the following order:
- (Optional) Modifier, which can be public, protected, private
- (Required) Class Name;
- (Required) Parentheses "()";
- (Required) Constructor Body.

Obviously you may pay attention that the previous example of a class doesn't have any constructors, but we were able to
invoke it. It's because when we don't explicitly write any constructor, the compiler adds a default, no-argument constructor.
```
public Bicycle() { // a default no-argument constructor with an empty body
}
```
A default no-argument constructor will simply set all members to their default values. "Defaults" for primitive type can
be found [here](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html), regarding reference types the
default value will be `null`. A common scenario of using constructors is to define in a constructor's body a required
state of an object.
```
public Bicycle() {
    speed = 5; // initilizes a bicycle object with an initial state of speed of "5"
}
```

Constructors can have input parameters as well as methods. These constructors are called "parameterized". In this
case during object creation we may specify values for these parameters.
```
// An example of the "parameterized" constructor
public Bicycle(int speed){
    this.speed = speed; // initilizes a bicycle object with a initial state of speed defined at the time of object creation
}
```

We may specify several constructors with different parameters in a class, but it is worth noting that if one or more
parametrized constructors are specified, the compiler won't add a default, no-argument constructor. In this case if it
is required, we will have to specify a no-argument constructor explicitly.

In case when a name of a constructor's parameter and a name of a class field are equal (`name`), it is necessary to use
a keyword `this` with a dot (`this.`) before a name of a class field in order to refer it and exclude a conflict of names.
The keyword `this` is a reference to an object, which called a current method, where the execution is performed.

The keyword `this` can also be used in order to call a constructor from another constructor.
```
public class Bicycle {

    ...

    public Bicycle(int speedFromConstructor) {
        speed = speedFromConstructor;
    }

    public Bicycle() {
        this(5); // when a default no-argument constructor is called, a new "bicycle" object is created with a state of speed of "5"
    }
}
```

### Overloading
Process of specifying several constructors in one class is called as "overloading", the same refers to methods.
"Overloading" is a definition of methods with the same name, but different signatures. Actually such methods are
completely different methods, which have only the same name in common. A signature of methods is defined by a name of 
a method, a quantity and types of its parameters. A return type is not included in a method signature, it means that the
following construction lead to a compilation error.
```
public class RandomObject {

    public void method() {
        
    }
    
    public int method() { // Compilation error: "method method() is already defined in class Scratch"
        return 1;
    }
}
```

After creation of an object we can refer to its fields with the help of their name and can change values of the fields.
```
Bicycle bicycle = new Bicycle(5);
System.out.println(bicycle.speed); // Output: 5
bicycle.speed = 10;
System.out.println(bicycle.speed); // Output: 10
```

### Initializers
In addition to constructors an initialization of an object can be carried out with the help of initializer block.
Initializer blocks are called before any constructors. We can place common code for all constructors.

```
public class Bicycle {
    
    public int maxSpeed;
    public int currentSpeed;
    
    // Initializer block start
    {
        maxSpeed = 90;
    }
    // Initializer block end

    public Bicycle(int speedFromConstructor) {
        speed = speedFromConstructor;
    }

    public Bicycle() {
        this(5);
    }
}
```

### Packages
Java classes are combined into packages. Such combination allows avoiding conflicts, when developers may give classes
same names. Packages ensure uniqueness of each class. Package in Java is included as the first operator in a class by
the means of a keyword "package": ```package name_of_package```.

Here is an example:
```
line 1: package com.example;
line 2:
line 3: public RandomClass {
line 4:     // empty class
line 5: }
line 6:
```
A name of a package corresponds to the organization of directories (folders), which source code files are located in:
a package name of a class is composed of directories separated by dots ".", where a class-file is located.

For example, if a class `RandomClass` has a package name `com.example.app`, then a project will contain a folder named
`com`, which will contain a folder `example`, that will contain one other folder `app` with a file named 
`RandomClass.java` containing Java code.

If we need to use classes from other packages, we will need to connect these packages and classes. The exception is
classes from the `java.lang` package (for example, String), which are automatically included in the program.
There are two ways to connect classes from other packages:
- to specify a name of package before a class each time when the class is used:
```
package com.example;

public Example {
    
    public static void main(String[] args) {
        com.example.app.RandomClass randomClass = new com.example.app.RandomClass(); // it is called as "package name" 
    }
}
```
- to use a keyword `import`, which is followed by a package name of a class:
```
package com.example;

import com.example.app.RandomClass;

public Example {

    public static void main(String[] args) {
        RandomClass randomClass = new RandomClass();
    }
}
```

If we want to connect all classes from other package, we need to specify a keyword `import` and a `package name` with a
symbol called an asterisk `*`: `import com.example.app.*`.

### Access Modifiers
Let's discuss modifiers, which were mentioned in previous subtopics. Such modifiers are also called as "access modifiers"
and they are applicable to both class fields and class methods. There are the following modifiers (from the most
restrictive modifier to the least restrictive one):
- private: fields and methods can be accessed only from a current class;
```
package com.example.app;

public class AppClass {

    private int version = 1;
    
    private int getVersion() {
        return version;
    }
}
```

```
package com.example;

public class ExampleClass {

    public static void main(String[] args){
        AppClass appClass = new AppClass();
        // appClass.version      // Error: a field 'version' has private access in 'AppClass' and it is accessed not from 'AppClass'
        // appClass.getVersion() // Error: a method 'getVersion()' has private access in 'AppClass' and it is accessed not from 'AppClass'
    }
}
```
- *no modifier* (when there is no modifier) called "package-friendly" or "package-private": fields and methods of a class
can be accessed from a current class and by classes from a package, where a current class is located;
```
package com.example.app;

public class AppClass {

    int version;        // a 'package-friendly' modifier 
    
    int getVersion() {  // a 'package-friendly' modifier
        return version;
    }
}
```

```
package com.example.app;

public class FriendlyClass {

    public static void main(String[] args){
        AppClass appClass = new AppClass();
        System.out.println(appClass.version);       // Output: 0
        appClass.version = 1;
        System.out.println(appClass.getVersion());  // Output: 1
    }
}
```

```
package com.example;

public class ExampleClass {

    public static void main(String[] args){
        AppClass appClass = new AppClass();
        // appClass.version      // Error: a field 'version' has package-friendly access in 'AppClass' and it is accessed not from the package 'com.example.app'
        // appClass.getVersion() // Error: a method 'getVersion()' has package-friendly access in 'AppClass' and it is accessed not from the package 'com.example.app'
    }
}
```
- protected: fields and methods of a class can be accessed from a current class, by classes from a package, where a 
current class is located, and by class, which inherits a current class (a topic "inheritance" is covered [here](#inheritance));
- public: both fields and methods of a class can be accessed by classes from any package (in all cases).

### Getters and setters
While creating a class, it is extremely recommended to enclose its state and organize work with field by the means of
functions. It means that fields of a class must have a "private" modifier. For the purposes of accessing such fields,
"public" methods are created. Such methods are called getters and setters: a `getter` method just returns a value of a
class field without modification, a `setter` methods changes completely a value of fields with a new value.
A getter/setter name must be the following: `get`/`set` + `fieldName`. This practice is called `Encapsulation` and its 
meaning will be discussed later.
```
package com.example.app;

public class AppClass {

    private int version;        // close state of a class 
    private String name;
    
    pubclic int getVersion() {
        return version;         // returns a current value of the field 'version'
    }
    
    public void setVersion(int version) {
        this.version = version; // overrides a value of the field 'version' with a new one
    }
    
    pubclic int getName() {
        return name;            // returns a current value of the field 'name'
    }
    
    public void setName(int name) {
        this.name = name;       // overrides a value of the field 'name' with a new one
    }
}
```

### Static class members
If it is required for all objects of a class to use the same field or method, such class may be marked with a keyword `static`.
```
package com.example.app;

public class AppClass {

    public static int VERSION = 1; 
    
}
```
Static fields exist before the field instance of a class is created, therefore, such fields can be accessed with the
help of both a variable of a class instance and a class name. Basically, all static fields should be in uppercase in
compliance with ["snake_case" style](https://betterprogramming.pub/string-case-styles-camel-pascal-snake-and-kebab-case-981407998841).
```
package com.example;

public class ExampleClass {
    
    public static void main(String[] args){
        int version = AppClass.VERSION;
        System.out.println(version); // Output: 1
    }
}
```
It is necessary to remember that static methods can be called without of creating an object with the help of a class
name. But such static methods can not access a non-static fields and methods.
```
package com.example;

public class ExampleClass {
    
    private int version = 10;
    
    public void printVersion(){
        System.put.println(version);
    }
    
    public static void main(String[] args){
        // printVersion(); // Error
        
        new ExampleClass().printVersion(); // Output: 10  
    }
}
```
Sometimes, when it is necessary to perform many complex actions in order to initialize a static field, special language
constructions are used. They are called as "static initialization blocks", which are similar to [initialization blocks](#initializers).
```
package com.example;

public class ExampleClass {
    
    private static int version;
    
    // Static initialization block start
    static {
        version = 10*10;
    }
    // Static initialization block end
    
    public void printVersion(){
        System.put.println(version);
    }
    
    public static void main(String[] args){
        // printVersion(); // Error
        
        new ExampleClass().printVersion(); // Output: 100
    }
}
```

### Static Import
In Java there is one more way to [connect classes from other packages](#packages): static import. For these purposes it
is necessary to use a keyword `static` along with an `import` keyword. With the help of static import we can use static
members of a class without specifying a name of the class.
```
package com.example.app;

public class AppClass {
    
    public static int VERSION = 10;
    
    public static int multiplie(int x, int y) {
        return x*y;
    } 
}
```

```
package com.example;

import static com.example.app.AppClass.VERSION; 
import static com.example.app.AppClass.multiplie;
// or "import static com.example.app.AppClass.*" instead

public class ExampleClass {

    public static void main(String[] args){
        int result = VERSION + multiplie(2,3);
        System.out.println(result); // Output: 60
    }
}
```

### Constants
Sometimes it is required that some fields of a class should not be changed after their initialization, in other words,
they should be constants. A modifier `final` is used in order to mark a variable as a constant: once final variable is 
initialized, it can’t be altered.

It is worth noting that final fields must be initialized before a constructor completes. Static final fields may be initialized:
- during a field declaration;
```
class Scratch {
    private static final int VARIABLE = 1;
}
```
- in a static initialization block;
```
class Scratch {
    private static final int VARIABLE;
    
    static {
        VARIABLE = 1;
    }
}
```
Non-static final fields may be initialized:
- during a field declaration;
```
class Scratch {
    private final int variable = 1;
}
```
- in the instance initializer block;
```
class Scratch {
    private final int variable;

    {
        variable = 1;
    }
}
```
- in a constructor.
```
class Scratch {
    private final int variable;

    public Scratch() {
        this.variable = 1;
    }

    public Scratch(int variable) {
        this.variable = variable;
    }
}
```
If we mark a field of a primitive type, its value can not be modified at runtime:
```
class Scratch {
    public final int variable = 1;

    public static void main(String[] args) {
        Scratch scratch = new Scratch();
        // scratch.variable = 1; // Error: Cannot assign a value to final variable 'variable'
    }
}
```
But if we mark a field of reference type, its variable can not refer to another object, but contents of the object, 
which it refers to, may be altered.
```
public class Example {
    private int variable = 1;

    public int getVariable() {
        return variable;
    }

    public void setVariable(int variable) {
        this.variable = variable;
    }
}
```
```
public class Scratch {
    public final Example example = new Example();   // constant of a reference type

    public static void main(String[] args) {
        Scratch scratch = new Scratch();
        // scratch.example = new Example();         // Error: cannot assign a value to final variable 'example'
        int previousValue = scratch.example.getVariable();
        scratch.example.setVariable(111);           // Contents of a constant of a reference type may be altered
        int presentValue = scratch.example.getVariable();
        System.out.println(previousValue);          // Output: 1
        System.out.println(presentValue);           // Output: 111
    }
}
```
## OOP Pillars
Object-oriented programming is based on the following pillars:
- [Inheritance](#inheritance)
- [Encapsulation](#encapsulation)
- [Polymorphism](#polymorphism)
- [Abstraction](#abstraction)

### Inheritance
As well as most of object-oriented languages, Java allows using Inheritance. Inheritance is a process, when a class
(a child class) can be created on the basis of another class (a parent class).

In order to make a class as a child towards a parent one, while its creation it is necessary to add a keyword `extends`
and a name of a parent class:
```
// a parent class
public class Parent {
}

// a child class
public class Child extends Parent {
}
```
A child class receives the same fields and methods, which were declared in a parent class, except for ones, which are
marked with a private access modifier. Along with parent's fields and methods, a child may have additional fields and
methods. While calling parent's fields and methods from a child's code a keyword `super` may be used.
```
public class ParentClass {

    private String uniqueParentField = "uniqueParentField";
    protected String sharedField = "shareParentField";

    public String getUniqueParentField() {
        return uniqueParentField;
    }

    public void printUniqueParentField() {
        System.out.println(uniqueParentField);
    }

    public void printSharedField() {
        System.out.println(sharedField);
    }

    private void printAllFields() {
        System.out.println(uniqueParentField);
        System.out.println(sharedField);
    }
}
```
```
public class ChildClass extends ParentClass {

    private String childField = "childField";

    // It is a completely new method even if ParentClass has a method with a same signature, because it has a private modifier 
    public void printAllFields() {
        // System.out.println(uniqueParentField);   // Error: 'uniqueParentField' has private access in 'ParentClass'
        System.out.println(getUniqueParentField()); // A method from a parent class is called. Output: uniqueParentField
        System.out.println(sharedField);            // A field from a parent class is called. Output: shareParentField
        super.printSharedField();                   // A method from a parent class is called. Output: shareParentField
        System.out.println(childField);             // Output: childField
        // super.printAllFields();                  // A method from a parent class is called. Error: 'printAllFields()' has private access in 'ParentClass'
    }
}
```

In Java a class may have only one parent class, multiple inheritance is not supported.

In order to forbid inheritance from a class, it is required to mark it with a modifier `final`.
```
public final NoInheritableClass {
    // a class which can not be extended.
}
```
If a parent class has a default no-argument constructor, a child constructor may not call it, because a compiler adds it
implicitly. In other cases, it is obligatory to call a parent constructor explicitly with the help of a keyword `super`
in the following way:
```
super (input parameters);
```
Call of `super` must be the first in a child constructor.
```
public class Parent {
    
    private String parentField;

    public Parent(String parentField) {
        this.parentField = parentField;
    }
}
```
```
public class Child extends Parent {

    private String childField;

/*
    public Child(String parentField, String childField) {
        this.childField = childField;
        super(parentField); // Error: call to 'super()' must be first statement in constructor body
    }
*/

    public Child(String parentField) {
        super(parentField);
        this.childField = "childField";
    }
}
```

A child class may alter methods, which are received from a parent class, with its own ones ([overriding](#overriding)).

#### Overriding
Java allows us to create a method in a child class with same signature (name, input parameters) and same return type as
in a parent class. Such process is called as "overriding". By the means of overriding we may alter a behaviour of a
parent method completely or partially. It is a good practice to place an `@Override` annotation before an overridden method,
but that is optional.

```
package com.example;

public class Parent {

    void print(){
        System.out.println("I am a Parent.");
    }
    
    public void greet() {
        System.out.println("Hello"); // a formal greeting
    }
}
```
```
package com.example;

public class Child extends Parent {

    // Any access modifier can be used except for "private", because it will an attempt to assign weaker
    // access privileges than there were "package-friendly"
    @Override
    protected void print() {
        System.out.println("I am a Child"); // Overrides behaviour of a parent method
    }

    // Only "public" access modifier can be used
    // "@Override" may be ommitted
    public void greet() {
        System.out.println("Hi"); // less formal greeting
    }
}
```
Methods marked as final cannot be overridden. When we design a class and feel that a method should not be overridden,
we can make such method `final`.
```
public class Parent {

    public final void print() {
        System.out.println("I am unrepeatable :)");
    }
}
```
```
public class Child extends Parent {
/*    
@Override
public void print() { // Error: can not override final method
super.print();
}
*/
}
```
All classes have "Object" as a parent class (superclass), even if Object is not explicitly defined. Class "Object" is
the root of the class hierarchy. All objects, including arrays, implement the methods of this class. The following
declarations of a class named "ExampleClass" are absolutely equal.
```
public class ExampleClass extends Object {
}
```
```
public class ExampleClass {
    // Compiler will add a statement "extends Object" implicitly
}
```
One of the most useful methods, which are inherited from "Object", is "toString()". It is called automatically when it
is necessary to convert some class into text (String). For example, when `System.out.println(variableName);` is called
in order to print into a console some text. In this case, toString() method will be called on `variableName`. We can
override this method in order to print necessary useful information.
```
public class Scratch {

//    @Override
//    public String toString() {
//        return "I am an empty Scratch object.";
//    }

    public static void main(String[] args) {
        Scratch scratch = new Scratch();
        System.out.println(scratch); Output: Scratch@27f674d
    }
}
```
```
class Scratch {

    @Override
    public String toString() {
        return "I am an empty Scratch object.";
    }

    public static void main(String[] args) {
        Scratch scratch = new Scratch();
        System.out.println(scratch.toString()); // Output: I am an empty Scratch object.
        System.out.println(scratch);            // Completely the same output.
    }
}
```

### Encapsulation
Encapsulation is referred to encapsulating or enclosing class's state. This principle is mostly about closing access to 
the fields of a class to external users (other developers in our case). 

Let's consider a simple example: a class `Dog` with `age` integer field. If it'll be allowed for anyone to change value
of that field for a `Dog` class object, someone will definitely use such values as `-10` or `666`. It's obvious that such values 
are not correct, but these are already set. If someone notices that and wants to change the values, field have to be 
reassigned with new ones. 

Obviously, this is not the best choice. It'll be much smarter to prevent such situations, and
that is why an **Encapsulation** principle is so important. It helps to avoid unauthorized access to the class's fields
by making them `private` and creating `getter` and `setter` methods pair for manipulating this field. Such mechanism was
already described [here](#getters-and-setters).

### Polymorphism
This OOP pillar is mostly related to the [overloading](#overloading) and [overriding](#overriding) of methods. From
Ancient Greek "poly-" means "many" and "-morph" is "shape", just like a magic spell :)

And it is called so because single method name may refer to different methods (as it was
described in **Overloading**, these are actually treated as different, because they are compiled to Java bytecode as different
methods).

While overloading is a static form of polymorphism, overriding is dynamic. Such separation is introduced because
with the overriding it is not decided by the compiler, which method will be executed at runtime. This is the subtleties 
of an **Inheritance** process, so if you want to dive deeper, it is recommended to read about **Early** and **Late 
Binding** in Java.

### Abstraction
And the last one is the Abstraction principle. Some people throw this one out and recognize only 3 OOP pillars, as 
Abstraction is more about way of thinking rather than coding. But it's mostly decided to be the rightful 4th pillar.

Abstraction is referred to the way of describing the real-world objects in form of Java classes. The example of this 
process was already described here in the **[Objects](#objects)** topic. The real-world dog has lots of state attributes,
like the tone of its skin under the coat, form of its nose and so on. But for veterinary hospital site the most valuable
are name, breed and health state. The same goes for behaviour. 

So when coding the `Dog` class, programmer creates a model or an abstraction, which has only those attributes that are
valuable for the task. This helps to get read of unnecessary coding and lessens the amount of stored data. Or even makes
possible to describe the real object with innumerable possible characteristics using code.

### Additional topics to read about
- #### Order of Initialization ([useful link](https://www.baeldung.com/java-initialization))
- #### Abstract classes
- #### Interfaces
- #### Enumerations
- #### Exceptions
- #### Java Beans
- #### JavaDoc
- #### Java Code Conventions
- #### OOD Introduction
- #### SOLID, DRY, YAGNI, KISS Principles
