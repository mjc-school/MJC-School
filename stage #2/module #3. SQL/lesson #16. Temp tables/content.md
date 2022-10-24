# Temp tables

A temporary table in SQL is a database table that exists temporarily on the database server. A temporary table stores a
subset of data from a normal table for a certain period of time.
As its name indicates, temporary tables are used to store data temporarily and they can perform CRUD (Create, Read,
Update, and Delete), join, and some other operations like the persistent database tables. Temporary tables are dropped
when the session that creates the table has closed, or can also be explicitly dropped by users. At the same time,
temporary tables can act like physical tables in many ways, which gives us more flexibility. Such as, we can create
constraints, indexes, or statistics in these tables.  
SQL Server provides two types of temporary tables according to
their scope:
- Local Temporary Table
- Global Temporary Table

## Materials

- https://codingsight.com/introduction-to-temporary-tables-in-sql-server/
- https://www.sqlshack.com/overview-and-performance-tips-of-temp-tables-in-sql-server/
- https://stackoverflow.com/questions/11491240/how-to-create-temp-table-with-select-into-temptable-from-cte-query

## Questions

1. What is a temporary table?
2. What are temporary tables used for?
3. Describe syntax of temporary table creation.

