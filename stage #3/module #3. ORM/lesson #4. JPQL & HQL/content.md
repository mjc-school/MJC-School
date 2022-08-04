# JPQL & HQL

## Materials
+ Overview
+ JPA Query API
+ Hibernate Query Language (HQL)

## Overview
The JPA Query Language (JPQL) can be considered as an object oriented version of SQL. Users familiar with SQL should 
find JPQL very easy to learn and use. </br>
The **JPA Criteria API** provides an alternative way for building dynamic queries,  based on Java objects that represent
query elements (replacing string based JPQL).</br>
JPA also provides a way for building static queries, as **named queries**, using the @NamedQuery and
@NamedQueries annotations. It is considered to be a good practice in JPA to prefer named queries over
dynamic queries when possible.

The Hibernate Query Language (HQL) and Java Persistence Query Language (JPQL) are both object model focused query 
languages similar in nature to SQL. JPQL is a heavily-inspired-by subset of HQL. A JPQL query is always a valid HQL 
query, the reverse is not true, however.

## JPA Query API
In JPA the query is represented by _javax.persistence.Query_ or _javax.persistence.TypedQuery_ as obtained from 
the EntityManager. The create an inline Query or TypedQuery, you need to use the EntityManager#createQuery method:
```java
Query query = entityManager.createQuery(
"select c from Customer c where p.name like :name");

TypedQuery<Person> typedQuery = entityManager.createQuery(
"select c from Customer c where c.name like :name", Customer.class);
```

### Query Parameters in JPA
There are two types query parameters in JPA:

* **Named parameters(:name)**

The following method retrieves a Customer object from the database by its name:
```java
String customerName = "Ivan";
Query query = entityManager.createQuery("select c from Customer c where c.name like :name ");
query.setParameter("name", pattern +"%");
```

The WHERE clause reduces the query results to Customer objects whose name field value is equal to :name, which is a
parameter that serves as a placeholder for a real value. Before the query can be executed a parameter value has to be
set using the setParameter() method.
Queries can include multiple parameters, and each parameter can occur multiple times in the query string. A query can
be run only after setting values for all its parameters (no matter in which order).

* **Positional parameters (?index)**

In addition to named parameters, whose form is :name, JPQL also supports positional parameters, whose form is ?index.
The following method is equivalent to the method above, except that an ordinal parameter replaces the named parameter:</br>
_Example_:</br>
```java
String customerName = "Ivan";
Query query = entityManager.createQuery("SELECT FROM Customer c where c.name = ?1 ");
query.setParameter(1, customerName);
```

### Running JPA Queries
In terms of execution, the Query interface defines two methods for running SELECT queries:
* Query.getSingleResult  - for use when exactly one result object is expected.</br>
    ```java
    long count = (Long) entityManager.createQuery("select count() from Customer");
    ```

* Query.getResultList - for general use in any other case.</br>
    ```java
    List<Customer> = entityManager.createQuery("select from Customer").getResultList();
    ```

Similarly, the TypedQuery interface defines the following methods:
* TypedQuery.getSingleResult - for use when exactly one result object is expected.
* TypedQuery.getResultList - for general use in any other case.

### JPQL Statement types
JPQL allow SELECT, UPDATE and DELETE statements to be performed.

The simplest possible HQL SELECT statement is of the form:
```java
List<Customer> customers = session.createQuery("select * from Customer" ).list();
```

The UPDATE statements is the same in HQL and JPQL:
```java
String jpqlUpdate = "update Customer c set c.name = :newName where c.name = :oldName";
int updatedEntities = entityManager.createQuery(jpqlUpdate)
        .setString( "newName", newName )
        .setString( "oldName", oldName )
        .executeUpdate();
```

The DELETE statements is the same in HQL and JPQL:
```java
entityManager.createQuery("delete from Customer where name = :name")  
        .setParameter( name, "Ivan" )
        .executeUpdate();  
```

## Hibernate Query Language (HQL)

Hibernate Query Language (HQL) is same as SQL (Structured Query Language) but it doesn't depends on the table of the 
database. Instead of table name, we use class name in HQL. So it is database independent query language.

Advantage of HQL:
* database independent
* supports polymorphic queries
* easy to learn for Java Programmer

In Hibernate, the HQL query is represented as _org.hibernate.query.Query_ which is obtained from a _Session_. 
If the HQL is a named query, _Session#getNamedQuery_ would be used; otherwise _Session#createQuery_ is needed.
```java
org.hibernate.query.Query query = session.createQuery(
        "select c from Customer c where c.name like :name");
```
or 
```java
org.hibernate.query.Query query = session.createQuery(
        "from Customer c where c.name like :name");
```

### Query Parameters in HQL
There are also two types query parameters in JPA:
* **Named parameters(:name)**</br>
The following method retrieves a Customer object from the database by its name:
    ```java
    String customerName = "Ivan";
    org.hibernate.query.Query query = session.createQuery("select c from Customer c where c.name like :name ");
    query.setParameter("name", pattern +"%");
    ```

* **Positional parameters (?index)**</br>
HQL-style positional parameters follow JDBC positional parameter syntax. They are declared using ? without a following 
ordinal. There is no way to relate two such positional parameters as being "the same" aside from binding the same value 
to each:
    ```java
    String customerName = "Ivan";
    org.hibernate.query.Query query = session.createQuery("select c from Customer c where c.name = ?");
    query.setParameter(0, customerName);
    ```
### Running HQL Queries
In terms of execution, Hibernate offers 4 different methods. The 2 most commonly used are
* Query.list() - executes the select query and returns back the list of results.
* Query.uniqueResult() - executes the select query and returns the single result. If there were more than one result an exception is thrown.
    ```java
    List<Customer> customers = session.createQuery("select c from Customer c where c.name like :name" )
            .setParameter( "name", "Iv%" )
            .list();
    ```
It is also possible to extract a single result from a Query.
```java
Customer customer = (Customer) session.createQuery("select c from Customer c where c.name like :name" )
        .setParameter( "name", "Iv%" )
        .uniqueResult();
```

### HQL Statement types
HQL as JPQL allow SELECT, UPDATE and DELETE statements to be performed. HQL additionally allows INSERT statements, 
in a form similar to a SQL INSERT FROM SELECT.

The simplest possible HQL SELECT statement is of the form:
```java
List<Customer> customers = session.createQuery("from Customer").list();
```

The UPDATE statements is the same in HQL and JPQL:
```java
int updatedEntities = session.createQuery("update Customer set name = :newName where name = :oldName" )
        .setParameter( "oldName", oldName )
        .setParameter( "newName", newName )
        .executeUpdate();
```
The DELETE statements is the same in HQL and JPQL:
```java
session.createQuery("delete from Customer where name = :name");  
        .setParameter( name, "Ivan" )
        .executeUpdate(); 
```

A DELETE statement is also executed using the executeUpdate() method of either org.hibernate.query.Query.

HQL adds the ability to define INSERT statements as well.There is no JPQL equivalent to this.

The HQL INSERT statement is:
```roomsql
insert_statement ::=
insert_clause select_statement

insert_clause ::=
INSERT INTO entity_name (attribute_list)

attribute_list ::=
state_field[, state_field ]*
```















