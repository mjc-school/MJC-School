# Procedures and Functions
A stored procedure is a prepared SQL code that you can save, so the code can be reused over and over again.
###Function

Function, in computer programming language context, a set of instructions which takes some input and performs certain tasks. In SQL, a function returns a value.

###Procedure

Procedure, as well, is a set of instructions which takes input and performs certain task. In SQL, procedure does not return a value. In java, procedure and functions are same and also called sub-routines.
A procedure  is a named PL/SQL block which performs one or more specific task. This is similar to a procedure in other programming languages. A procedure has a header and a body.
The header consists of the name of the procedure and the parameters or variables passed to the procedure.
The body consists of declaration section, execution section and exception section similar to a general PL/SQL Block. A procedure is similar to an anonymous PL/SQL Block but it is named for repeated usage.
We can pass parameters to procedures in three ways :

| Parameters | Description  |
| :--------|--------------|
| IN type|These types of parameters are used to send values to stored procedures.|
|OUT type|These types of parameters are used to get values from stored procedures. This is similar to a return type in functions.|
|IN OUT type|These types of parameters are used to send values and get values from stored procedures.|

Syntax:

````
CREATE [OR REPLACE] PROCEDURE procedure_name (<Argument> {IN, OUT, IN OUT}    <Datatype>,…)  
IS 
  Declaration section<variable, constant> ; 
BEGIN 
  Execution section 
EXCEPTION 
  Exception section  
END
````

__How to execute a Procedure?__

There are two ways to execute a procedure :
- From the SQL prompt : EXECUTE [or EXEC] procedure_name;
- Within another procedure – simply use the procedure name : procedure_name;
 
Example:<br>
(create table named emp have two column id and salary with number datatype.)
```` 
 CREATE OR REPLACE PROCEDURE p1(id IN NUMBER, sal IN NUMBER)
  AS
  BEGIN   
  INSERT INTO emp VALUES(id, sal);
  DBMD_OUTPUT.PUT_LINE('VALUE INSERTED.');
  END;
 ````

## Tasks
1) Create a procedure “OLDEST_STUDENT” which select student's birthday with the earliest birthday; 

2) Create a procedure “REMOVE_DEBTOR” which removes all students who have at least 1 mark by Math less than 4; 

3) Create a procedure “PUT_NEW_MARK” which will have 3 arguments: 

    Id of student; 

    Id of subject; 

    Mark; 

    And will insert new mark into table Mark. 

4) Create a function which find surname of student with min average mark. 

## Materials
- https://www.w3schools.com/sql/sql_stored_procedures.asp 

- https://www.mysqltutorial.org/getting-started-with-mysql-stored-procedures.aspx 

- https://www.geeksforgeeks.org/different-types-of-procedures-in-mysql/ 

- https://www.sqlservertutorial.net/sql-server-user-defined-functions/sql-server-scalar-functions/ 

## Questions
1. What is a stored procedure?
2. What is stored procedure used for?
3. Describe syntax of stored procedure.
4. How to execute stored procedure?
