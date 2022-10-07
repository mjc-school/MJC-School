# Insert Into Query

The SQL INSERT INTO Statement is used to add new rows of data to a table in the database.
There are two basic syntaxes of the INSERT INTO statement which are shown below.

```text
INSERT INTO TABLE_NAME (column1, column2, column3,...columnN)  
VALUES (value1, value2, value3,...valueN);
```

Here, column1, column2, column3,...columnN are the names of the columns in the table into which you want to insert the
data.
You may not need to specify the column(s) name in the SQL query if you are adding values for all the columns of the
table. But make sure the order of the values is in the same order as the columns in the table.  
The SQL INSERT INTO syntax will be as follows:

```text
INSERT INTO TABLE_NAME VALUES (value1,value2,value3,...valueN);
```

You can populate the data into a table through the select statement over another table; provided the other table has a
set of fields, which are required to populate the first table.
```text
INSERT INTO first_table_name [(column1, column2, ... columnN)] 
   SELECT column1, column2, ...columnN 
   FROM second_table_name
   [WHERE condition];
```

## Tasks:

1) Insert new Students with names “John”, “Chris”, “Carl” for grade “1”, then with names “Oliver”, “James”, “Lucas” and
   “Henry” for grade “2” and with names “Jacob” and “Logan” for grade “3”. Insert more students for 4 and 5 grade.

2) Insert new Subjects:

Art and music for 1 grade;

Geography and history for 2 grade;

PE and math for 3 grade;

Science and IT for 4 grade.

Insert 2 subjects for 5 grade.

3) Insert “DAILY”, “WEEKLY”, ”MONTHLY” Payment Types.

4) Insert 4 Payments:

Payment is referenced to student with name “John” and “Weekly” payment type;

Payment is referenced to student with name “Oliver” and “Monthly” payment type;

Payment is referenced to student with name “Henry” and “Weekly” payment type

Payment is referenced to student with name “James” and “Daily” payment type.

Insert more payments for students.

5) Insert 5 Marks:

8 for Chris by Art;

5 for Oliver by History;

9 for James by Geography;

4 for Jacob by Math;

9 for Logan by PE.

Insert more Masks for students.

## Materials

https://www.w3schools.com/sql/sql_insert.asp

https://www.w3schools.com/sql/sql_insert_into_select.asp

https://www.tutorialspoint.com/sql/sql-insert-query.htm

##Questions

1. What script inserts data into the table?
2. Is it possible to copy the values from one table and insert into another one? if yes, how?
