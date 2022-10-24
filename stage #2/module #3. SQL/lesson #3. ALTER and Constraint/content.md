# ALTER and Constraint

The SQL **ALTER TABLE** command is used to add, delete or modify columns in an existing table. 

## Syntax
```
ALTER TABLE table_name ADD column_name datatype;
```
```
ALTER TABLE table_name DROP COLUMN column_name;
```
```
ALTER TABLE table_name MODIFY COLUMN column_name datatype;
```

We are able to specify not only the type of the filed in the table, but also the rules according to which the data will be checked while performing different kinds of actions. We can add this rules using SQL **constraints**.

Constraints can be specified when the table is created with the CREATE TABLE statement, or after the table is created with the ALTER TABLE statement.

## Syntax: 
```
CREATE TABLE table_name (
    column1 datatype constraint,
    column2 datatype constraint,
    column3 datatype constraint,
    ....
);
```
```
ALTER TABLE table_name 
ADD CONSTRAINT constraint_name constraint (columns/condition);
```

The following constraints are commonly used in SQL:

| Constraint                                      | Description                                |
| ------------------------------------------------|:------------------------------------------:|
| NOT NULL                                        | Values cannot be null                      |
| UNIQUE                                          | Values cannot match any older value        |
| PRIMARY KEY                                     | Used to uniquely identify a row            |
| FOREIGN KEY                                     |	References a row in another table          |
| CHECK                                           | Validates condition for new value          |
| DEFAULT                                         | Set default value if not passed            |
| CREATE INDEX                                    | Used to speedup the read process           |

## Materials
-	https://www.w3schools.com/sql/sql_constraints.asp
-	https://www.w3schools.com/sql/sql_notnull.asp
-	https://www.w3schools.com/sql/sql_unique.asp
-	https://www.w3schools.com/sql/sql_primarykey.asp
-	https://www.w3schools.com/sql/sql_foreignkey.asp
-	https://www.w3schools.com/sql/sql_check.asp
-	https://www.w3schools.com/sql/sql_default.asp
-	https://www.w3schools.com/sql/sql_create_index.asp
-	https://www.w3schools.com/sql/sql_autoincrement.asp
-	https://www.tutorialspoint.com/sql/sql-alter-command.htm
-	https://postgrespro.ru/docs/postgresql/9.5/sql-altertable
-	https://www.w3schools.com/sql/sql_ref_alter.asp

## Questions
1. What constraints do you know?
2. What script modifies the table?
3. Which way can we specify that the data of Filed 'Amount' should be from 1 to 1000?
4. Which way can we specify that the field cannot be empty(without data)?
5. Which way can we delete/add the column in the table?
