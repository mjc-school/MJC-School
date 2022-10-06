# SUBQUERY
SUBQUERY is a query that is nested inside select, insert, update, delete operations or inside another subquery. 

What is subquery in SQL?
A subquery is a SQL query nested inside a larger query.

A subquery may occur in :
- A SELECT clause
- A FROM clause
- A WHERE clause
 
The subquery can be nested inside a SELECT, INSERT, UPDATE, or DELETE statement or inside another subquery.
  A subquery is usually added within the WHERE Clause of another SQL SELECT statement.
  You can use the comparison operators, such as >, <, or =. 

The comparison operator can also be a multiple-row operator, such as IN, ANY, or ALL.
  A subquery is also called an inner query or inner select, while the statement containing a subquery is also called an outer query or outer select.
  The inner query executes first before its parent query so that the results of an inner query can be passed to the outer query.
  You can use a subquery in a SELECT, INSERT, DELETE, or UPDATE statement to perform the following tasks:

Compare an expression to the result of the query.
Determine if an expression is included in the results of the query.
Check whether the query selects any rows.

Subqueries can be used in several places within a query, but it's easiest to start with the FROM statement.

The basic syntax is as follows:
````
SELECT column_name [, column_name ]
FROM   table1 [, table2 ]
WHERE  column_name OPERATOR
   (SELECT column_name [, column_name ]
   FROM table1 [, table2 ]
   [WHERE])
````
Here's an example of a basic subquery:
````
SELECT sub.*
    FROM (
        SELECT *
        FROM tutorial.sf_crime_incidents_2014_01
        WHERE day_of_week = 'Friday'
    ) sub
WHERE sub.resolution = 'NONE'
````

Subqueries are required to have names, which are added after parentheses the same way you would add an alias to a normal table. In this case, we've used the name "sub."

## Tasks
1) Select all columns from Subject where average mark for that subject is more than average mark for all subjects
2) Select all students who paid for school less than average paid amount for all students

## Materials
- https://docs.microsoft.com/en-us/sql/relational-databases/performance/subqueries?view=sql-server-ver15
- https://www.w3resource.com/sql/subqueries/understanding-sql-subqueries.php
- https://www.tutorialspoint.com/sql/sql-sub-queries.htm

##Questions
1. What is Subquery used for? Describe its syntax.
2. In which statements can Subquery be used?
3. In which parts of script can subquery be used?
