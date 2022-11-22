# N+1 problem in Hibernate

## Materials
+ Overview
+ FetchType.LAZY as a solution
+ Solution 
+ Why you should avoid N+1 problems?

## Overview

N+1 problem is a performance issue in Object Relational Mapping that fires multiple select queries (N+1 to be exact,
where N = number of records in table) in database for a single select query at application layer. 
Hibernate & Spring Data JPA provides multiple ways to catch and address this performance problem.

Let's look at an example for tables Customer and Order:
```java
 @Entity
 @Table(name="CUSTOMER")
 public class Customer {
     @Id
     @GeneratedValue
     private Long id;
     
     private String name;
     
     @OneToMany(mappedBy = "order")
     private List<Order> orders = new ArrayList<>();
     // ...
 }

 @Entity
 @Table(name="ORDER")
 public class Order {
     @Id
     private Long id;
     
     private Date date;
     
     Decimal amount;
     
     @ManyToOne 
     @JoinColumn(name="CUSTOMER_ID")
     private Customer customer;
     // ...
 }
```

Stored in the Session's cache is an object graph associated with each other. By default, when Hibernate loads the 
Customer object from the database, it will load all associated Orders objects at the same time. Take the Customer and
Order classes as an example, assuming that the CUSTOMER_ID foreign key of the ORDERS table is allowed to be null.

The following find() method of the Session is used to retrieve all Customer objects from the database:
```java
List customerLists=session.find("from Customer as c");
```

When running the above find() method, Hibernate will first query all the records in the CUSTOMERS table, and then query
the records with reference relationship in the ORDERS table according to the ID of each record. Hibernate will execute 
the following select statements in turn:

```roomsql
select * from CUSTOMERS;
select * from ORDERS where CUSTOMER_ID=1;
select * from ORDERS where CUSTOMER_ID=2;
select * from ORDERS where CUSTOMER_ID=3;
select * from ORDERS where CUSTOMER_ID=4;
```

Through the above five select statements, Hibernate finally loads 4 Customer objects and 5 Order objects, 
forming an associated object graph in memory.

Hibernate uses the default immediate retrieval strategy when retrieving the Order object associated with Customer.
There are two major deficiencies in this search strategy:

1) The number of select statements is too large, requiring frequent access to the database, which will affect the 
retrieval performance. If you need to query n Customer objects, you must execute n+1 select query statements. This is
the classic n+1 select query problem. This retrieval strategy does not utilize the SQL connection query function. 
For example, the above five select statements can be completely completed by the following one select statement:

   ```roomsql
   select * from CUSTOMERS left outer join ORDERS
   on CUSTOMERS.ID=ORDERS.CUSTOMER_ID
   ```
The above select statement uses SQL's left outer join query function, which can query all the records of the CUSTOMERS 
table and the records of the matched ORDERS table in a select statement.

2) When the application logic only needs to access the Customer object without accessing the Order object,
loading the Order object is completely redundant operation. These redundant Order objects waste a lot of memory space.

## FetchType.LAZY as a solution
At initial thought, you can lazy load the child. So to do this set the annotation as @ManyToOne(fetch = FetchType.LAZY).
Under the hood, lazy loading creates proxy objects for child objects. As and when we access the child objects, hibernate
will fire the queries and load them. With that being said, this may look like a good idea, but lazy loading is not 
the perfect solution.
```java
@Entity
public class Order {
    @Id
    private Long id;
    
    private Date date;
    
    Decimal amount;
    
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name="CUSTOMER_ID")
    private Customer customer;
    // ...
}
```

This is due to the underlying logic behind lazy loading. When lazy loading is enabled, hibernate will create proxies
for the orders fields. When the order field is accessed, hibernate will fill the proxy with values from the 
database. Yes, a query will still happen for each Customer object.

## Solution
So how do we solve the N+1 problem? For this, we need to get back to some basics of SQL. When we have to load data from
two separate tables, we can use joins. So instead of using multiple queries, we can write a single query like below.
```roomsql
select * from CUSTOMERS left outer join ORDERS
on CUSTOMERS.ID=ORDERS.CUSTOMER_ID
```
## Why you should avoid N+1 problems?
The reasons:

1) N+1 problems create more queries to database. This means database will be overloaded.
2) More queries to the database impacts the performance of the database as well as the application server. 
Each query and processing the response requires more CPU cycles.
3) Each extra query would increase the over all processing time. As each query need to send and receive query and 
results, the processing time increases proportionately.
4) Longer processing time means more open connections from connection pools. This impacts other requests as they have 
 to wait longer to get connections.