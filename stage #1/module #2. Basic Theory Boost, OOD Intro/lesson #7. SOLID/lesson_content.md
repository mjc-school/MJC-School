# Intro to OOP


## Contents
+ SOLID
+ Dependency injection
+ Mockito


## Task
Write an application and tests for it according to the requirements given below. The application must implement the functionality defined by the individual task. 

#### Task example:
**Circle**. Create the classes Point and Circle. Create methods and tests: calculating the area and perimeter of a circle; Is the shape a circle? (the radius cannot be <= 0); Does the figure intersects only one of the coordinate axes at a specified distance?

### Requirements

+ Create entity classes, for example: "Create Point and Circle classes"
+ Entity-classes should not be filled with methods which perform functional actions (business logic methods such as calculation, search, etc.).
+ Create logic classes that implement the specified functionality, for example: "Implement methods for calculating the area and perimeter of a circle"
+ The parameters required for creating objects to organize as reading information from a file (.txt). Some of the data must be incorrect. If an invalid line is encountered, the application should go to the next line. All files must be in a separate directory.
+ Create classes for validating the source data for creating entity class objects. For example: 
    + the correct line in the file for creating the Circle object: "1.0 2.0 3.0", where the first number specifies the radius of the circle, the second and third - the coordinates of the center; 
    + incorrect line in the file for creating the Circle object: "1.z0 2.0 3.0" - invalid "z" character, the entire line should be considered incorrect here and in the cases below; 
    + incorrect line in the file for creating a Circle object: "1.0 2.0" - not enough information to create an object;
    + Incorrect line in the file for creating a Circle object: "-1.0 2.0 3.0" - it is impossible to create a Circle with a negative radius.
+ For entity classes, you should override the methods of the Object class: toString (), equals (), hashCode (). Do not use methods of the Objects class.

+ All application classes should be structured in packages.
+ Use your own classes for Exception.
+ The formatting of the code follows the Java Code Convention.
+ Use Log4J2 to write logs.
+ The code must be covered with Unit tests. When writing tests it is forbidden: write logs and use branching operators: if, for, while, do \ while, switch;
+ The class with the main method must be absent in the task. Run with tests only.

### Variants:

1. **Triangle**. Create the classes Point and Triangle. Create methods and tests: calculate the area and perimeter of a triangle; Do the points form a triangle? (Do the points lie on the same straight line?); Is the triangle rectangular, isosceles, equilateral, acute/obtuse?
2. **Quadrangle**. Create the classes Point and Quadrangle. Create methods and tests: calculate the area and perimeter of a figure; Do the points form a quadrangle? (Do three points lie on the same straight line?); is the quadrilateral convex; Is the quadrilateral a square, a rhombus, a trapezoid?
3. **Oval**. Create the classes Point and Oval (form by two points of the circumscribed rectangle). Create methods and tests: calculate the area and perimeter of a figure; Do the points form an oval? (Do two points lie on the same straight line parallel to the coordinate axes?) Do the shape intersects only one of the coordinate axes at a specified distance? Is the figure an oval, a circle?
4. **Sphere**. Create the classes Point and Sphere. Create methods and tests: calculate the surface area of the sphere, the volume of the Sphere, the ratio of the volumes obtained as a result of cutting the Sphere by the coordinate plane; Is the object a ball? Do the Sphere touch any of the coordinate planes?
5. **Cube**. Create the classes Point and Cube. Create methods and tests: calculate the surface area of a cube, the volume of a cube; the ratio of the volumes obtained as a result of the dissection of the cube by the coordinate plane, Is the object a cube? Is the base of the cube on one of the coordinate planes?
6. **Tetrahedron**. Create the classes Point and Tetrahedron. Create methods and tests: calculate the surface area of a figure and its volume, and also the ratio of volumes obtained as a result of cutting a figure by a coordinate plane; Is the object a given shape? Is the base of the figure on one of the coordinate planes?
7. **Pyramid**. Create the classes Point and Pyramid. Create methods and tests: calculate the surface area of a figure and its volume, and also the ratio of volumes obtained as a result of cutting a figure by a coordinate plane; Is the object a specified figure? Do the base of the figure lie on one of the coordinate planes?
8. **Cone**. Create the classes Point and Cone. Create methods and tests: calculate the surface area of a figure and its volume, and the ratio of volumes obtained as a result of cutting a figure by a coordinate plane; Is the object a specified figure? Do the base of the figure lie on one of the coordinate planes?

####  Template repo: 

https://github.com/filippstankevich/geometry
