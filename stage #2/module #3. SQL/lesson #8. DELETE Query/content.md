# DELETE Query
Delete statement is used to delete data from the database.
It is highly important to know how to perform such operations and don't loose valuable data at the same time.
As usual, in production, data is not deleted from the database. 
Delete actions are performed the way that the field that is supposed to be deleted is labeled as deleted. 
But no matter what, we will learn how to run delete scripts. 

## Tasks
1) Delete all students with grade more than 4 and all relationships with this student; 

2) Delete students who have at least one mark less than 4; 

3) Delete “Daily” payment type and all relationships with this type. 

4) Delete All marks less than 4 

## Materials
- https://www.w3schools.com/sql/sql_delete.asp 

- https://www.tutorialspoint.com/sql/sql-delete-query.htm 

- https://www.mysqltutorial.org/mysql-on-delete-cascade/

## Questions
1. What is the purpose of DELETE statement? Describe its syntax.
2. Is it possible to delete all the rows in the table at once?
3. What are the ways to perform DELETE operation in case we have relations in other tables? 
4. What is CASCADE delete? How can we use it? How can we specify that CASCADE delete is required?
5. What if we haven't specified that CASCADE delete is needed for certain fields, what can we do?
