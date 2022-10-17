# GROUP BY and HAVING

**GROUP BY** statement groups rows by columns. It is to be used with aggregate functions.    
**HAVING** is like **WHERE**, but to be used with aggregate functions.  

## Syntax

    #Counts, how many of each marks a student with id 1 has
    SELECT count(Mark), Mark FROM Mark WHERE StudentId = 1 GROUP BY Mark;
    #Finds students with average mark higher than 4
    SELECT avg(Mark), StudentId FROM Mark GROUP BY StudentId HAVING avg(Mark) > 4;

## Tasks:

1)	Select all Students from Table Students having average mark more than 8
2)	Select students (id and name) who have minimum mark more than 7 
3)	Select all students(id and name) who paid more than 2 times during 2019 

##	Materials 
-	https://www.w3schools.com/sql/sql_groupby.asp
-	https://www.w3schools.com/sql/sql_having.asp
-	https://www.dofactory.com/sql/having
-	https://www.guru99.com/group-by.html
-	https://www.datacamp.com/community/tutorials/group-by-having-clause-sql

## Questions
1. What is GROUP BY used for? Describe syntax.
2. What is HAVING used for? Describe syntax.
3. Provide an example of usage both GROUP BY and HAVING.  