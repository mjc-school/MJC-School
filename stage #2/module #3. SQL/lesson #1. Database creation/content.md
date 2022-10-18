# Database creation 
In this module we are going to learn how to create the database and its tables using **CREATE DATABASE** and **CREATE TABLE** statements. 

## Syntax
**CREATE DATABASE** is used to create databases on SQL server

        CREATE DATABASE DatabaseName;

**USE** is used to select a database

        USE DatabaseName;

**CREATE TABLE** is used to create tables inside a selected database

        CREATE TABLE table_name(
        column1 datatype,
        column2 datatype,
        column3 datatype,
        .....
        columnN datatype,
        PRIMARY KEY( one or more columns )
        );

## Tasks:

1. Create database University; 

2. Create Tables: 
   1. Student: 
      - Id bigint (Primary key)

      - Name varchar

      - Birthday datetime

      - Group int

    2. Subject: 

         - Id bigint(Primary key)

         - Name varchar

         - Description varchar

         - Grade int

   3. PaymentType:

      - Id bigint(Primary key)

      - Name varchar

   4. Payment: 

      - Id bigint(Primary key)

      - TypeId bigint(FOREIGN KEY to PaymentType)

      - Amount decimal

      - StudentId bigint(FOREIGN KEY to Student)

      - Date datetime

   5. Mark 

      - Id bigint(Primary key)

      - StudentId bigint(FOREIGN KEY to Student)

      - SubjectId bigint(FOREIGN KEY to Subject)

      - Mark int

## Materials
- https://www.tutorialspoint.com/sql/sql-create-database.htm 
- https://www.w3schools.com/sql/sql_create_db.asp 
- https://www.w3schools.com/sql/sql_create_table.asp 
- https://www.sqlservertutorial.net/sql-server-basics/sql-server-create-table/ 

## Questions
1. What script creates database?
2. What script creates tables?
3. What types of data exist?
4. What is Primary key?
5. What is Foreign key?
6. How can we create Foreign key the way it is not necessary to insert it manually?