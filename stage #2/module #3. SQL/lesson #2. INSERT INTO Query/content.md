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

## Materials

https://www.w3schools.com/sql/sql_insert.asp

https://www.w3schools.com/sql/sql_insert_into_select.asp

https://www.tutorialspoint.com/sql/sql-insert-query.htm

##Questions

1. What script inserts data into the table?
2. Is it possible to copy the values from one table and insert into another one? if yes, how?
