# Aggregate Functions
Aggregate functions are the functions provided in sql to perform calculations. 
As usual, it is used with **GROUP BY**, **HAVING** clauses in **SELECT** statements. 
There are different types of aggregate functions which are widely used.
Most popular aggregate functions are: **Count(), Sum(), Avg(), Min(), Max()**

## Syntax

    #Count all students
    SELECT count(*) FROM Student;
    #Find max mark for specific student
    SELECT max(Mark) FROM Mark WHERE StudentId = 1;
    #Calculate average mark for specific student
    SELECT avg(Mark) FROM Mark WHERE StudentId = 1;
    ...

## Tasks:
1) Select the youngest student's birthday; 
2) Find the earliest made payment's date; 
3) Find average mark by Math; 
4) Find min amount of payment for payment type “Weekly”. 

## Materials: 
- https://www.geeksforgeeks.org/aggregate-functions-in-sql/ 

- https://www.sqlservertutorial.net/sql-server-aggregate-functions/ 

- https://www.sqltutorial.org/sql-aggregate-functions/ 

## Questions
1. What kinds of aggregate functions do you know?
2. In what cases it is necessary to use AVG() function?
3. Describe two aggregate functions you worked with.