# Views

In SQL, a view is a virtual table based on the result-set of an SQL statement.
Database views are created using the **CREATE VIEW** statement. Views can be created from a single table, multiple
tables or another view.
To create a view, a user must have the appropriate system privilege according to the specific implementation.
The basic **CREATE VIEW** syntax is as follows :
```text
CREATE VIEW view_name AS
SELECT column1, column2.....
FROM table_name
WHERE [condition];
```

## Tasks

Create views which store:

1) Surname, name, mark, subject name of students;

2) Surname, name, payment type name and amount;

3) Average mark by all subjects;

4) Payment type name, max amount of payment and student surname/name for all students.

## Materials

- https://www.w3schools.com/sql/sql_view.asp

- https://www.geeksforgeeks.org/sql-views/

- https://www.tutorialspoint.com/sql/sql-using-views.htm

##Questions

1. What is a View in Sql?
2. What are Views used for?
3. How can you create a view?
4. How can you update the view?
