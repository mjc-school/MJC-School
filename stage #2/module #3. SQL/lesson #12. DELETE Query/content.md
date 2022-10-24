# DELETE Query

Delete statement is used to delete data from the database.
It is highly important to know how to perform such operations and don't lose valuable data at the same time.
As usual, in production, data is not deleted from the database.
Delete actions are performed the way that the field that is supposed to be deleted is labeled as deleted.
But no matter what, we will learn how to run delete scripts.

```text
DELETE FROM table_name
WHERE [condition];
```

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
