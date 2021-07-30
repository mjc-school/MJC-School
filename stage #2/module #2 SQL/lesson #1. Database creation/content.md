# Database creation 

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
## Materials
https://www.tutorialspoint.com/sql/sql-create-database.htm 

https://www.w3schools.com/sql/sql_create_db.asp 

https://www.w3schools.com/sql/sql_create_table.asp 

https://www.sqlservertutorial.net/sql-server-basics/sql-server-create-table/ 
