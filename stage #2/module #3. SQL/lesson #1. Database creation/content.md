# Database creation 
In this module we have to learn how to create the database and its tables. 

## Materials
https://www.tutorialspoint.com/sql/sql-create-database.htm 

https://www.w3schools.com/sql/sql_create_db.asp 

https://www.w3schools.com/sql/sql_create_table.asp 

https://www.sqlservertutorial.net/sql-server-basics/sql-server-create-table/ 

## Tasks:
1)Create database University; 

2)Create Tables: 

        Student: 

        Id bigint (Primary key); 

        Name varchar; 

        Birthday datetime; 

        Group int. 

        Subject 

        Id bigint(Primary key); 

        Name varchar; 

        Description varchar; 

        Grade int. 

        PaymentType 

        Id bigint(Primary key); 

        Name varchar. 

        Payment 

        Id bigint(Primary key); 

        TypeId bigint(FOREIGN KEY to PaymentType); 

        Amount decimal; 

        StudentId bigint(FOREIGN KEY to Student); 

        Date datetime. 

        Mark 

        Id bigint(Primary key); 

        StudentId bigint(FOREIGN KEY to Student); 

        SubjectId bigint(FOREIGN KEY to Subject); 

        Mark int. 
        
## Questions
1. What script creates database?
2. What script creates tables?
3. What types of data exist?
4. What is Primary key?
5. What is Foreign key?
6. How can we create Foreign key the way it is not necessary to insert it manually? 
