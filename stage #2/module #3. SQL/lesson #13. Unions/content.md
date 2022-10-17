# Unions


The SQL UNION clause/operator is used to combine the results of two or more SELECT statements without returning any duplicate rows.

To use this UNION clause, each SELECT statement must have

- The same number of columns selected
- The same number of column expressions
- The same data type and
- Have them in the same order
 
-
But they don't have to be the same length.

Syntax:
````
SELECT column1 [, column2 ]
FROM table1 [, table2 ]
[WHERE condition]

UNION

SELECT column1 [, column2 ]
FROM table1 [, table2 ]
[WHERE condition]
````

Let's look at how to use the SQL UNION operator that returns one field. In this simple example, the field in both SELECT statements will have the same name and data type.

````
SELECT supplier_id FROM suppliers
    UNION
SELECT supplier_id FROM orders
ORDER BY supplier_id;

````
In this SQL UNION operator example, if a supplier_id appeared in both the suppliers and orders table, it would appear once in your result set. The UNION operator removes duplicates. If you do not wish to remove duplicates, try using the UNION ALL operator.
## Materials
- https://www.w3schools.com/sql/sql_union.asp
- http://www.sql-tutorial.ru/ru/book_union.html
- https://metanit.com/sql/mysql/5.4.php

## Questions
1. What is UNION used for? 
2. Describe syntax of UNION.
3. What are the rules of using UNION?
