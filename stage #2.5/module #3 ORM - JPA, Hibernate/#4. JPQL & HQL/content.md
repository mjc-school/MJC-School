JPQL & HQL
## Materials
* 4.1. JPQL & HQL
* 4.2. JPA Query API
  * 4.2.1. Query Parameters in JPA
  * 4.2.2. Running JPA Queries
  * 4.2.3. JPQL Statement types
    * 4.2.3.1. JPQL Select statements
    * 4.2.3.2. JPQL Update statements
    * 4.2.3.3. JPQL Delete statements
* 4.3. Hibernate Query Language (HQL)
  * 4.3.1. HQL. Advantages
  * 4.3.2. Hibernate Query API
  * 4.3.3. Query Parameters in HQL
  * 4.3.4. Running HQL Queries
  * 4.3.5. HQL Statement types
    * 4.3.5.1. HQL Select statements
    * 4.3.5.2. HQL Update statements
    * 4.3.5.3. HQL Delete statements
    * 4.3.5.4. HQL Insert statements

The JPA Query Language (JPQL) can be considered as an object oriented version of SQL. Users familiar with SQL should 
find JPQL very easy to learn and use. </br>
The **JPA Criteria API** provides an alternative way for building dynamic queries,  based on Java objects that represent
query elements (replacing string based JPQL).</br>
JPA also provides a way for building static queries, as **named queries**, using the **@NamedQuery** and
**@NamedQueries** annotations. It is considered to be a good practice in JPA to prefer named queries over
dynamic queries when possible.

### 4.1. JPQL & HQL
The Hibernate Query Language (HQL) and Java Persistence Query Language (JPQL) are both object model focused query 
languages similar in nature to SQL. JPQL is a heavily-inspired-by subset of HQL. A JPQL query is always a valid HQL 
query, the reverse is not true, however.
### 4.2. JPA Query API
In JPA the query is represented by _**javax.persistence.Query**_ or _**javax.persistence.TypedQuery**_ as obtained from 
the **EntityManager**. The create an inline Query or TypedQuery, you need to use the EntityManager#createQuery method

    Query query = entityManager.createQuery(
    "select c from Customer c where p.name like :name");

    TypedQuery<Person> typedQuery = entityManager.createQuery(
    "select c from Customer c where c.name like :name", Customer.class);

### 4.2.1. Query Parameters in JPA
There are two types query parameters in JPA:
* named parameters (:name);
* positional parameters(?index)
####  Named parameters(:name)
The following method retrieves a Customer object from the database by its name:

    String customerName = "Ivan";
    Query query = entityManager.createQuery("select c from Customer c where c.name like :name ");
    query.setParameter("name", pattern +"%");
The WHERE clause reduces the query results to Customer objects whose name field value is equal to :name, which is a
parameter that serves as a placeholder for a real value. Before the query can be executed a parameter value has to be
set using the **setParameter** method.
Queries can include multiple parameters, and each parameter can occur multiple times in the query string. A query can
be run only after setting values for all its parameters (no matter in which order).
#### Positional parameters (?index)
In addition to named parameters, whose form is :name, JPQL also supports positional parameters, whose form is ?index.
The following method is equivalent to the method above, except that an ordinal parameter replaces the named parameter:</br>
_Example_:</br>

    String customerName = "Ivan";
    Query query = entityManager.createQuery("SELECT FROM Customer c where c.name = ?1 ");
    query.setParameter(1, customerName);

### 4.2.2. Running JPA Queries
In terms of execution, the Query interface defines two methods for running **SELECT** queries:
* **Query.getSingleResult**  - for use when exactly one result object is expected.</br>


    
    long count =(Long) entityManager.createQuery("select count() from Customer");`
* **Query.getResultList** - for general use in any other case.</br>

    
    List<Customer> = entityManager.createQuery("select from Customer").getResultList();`
 
Similarly, the TypedQuery interface defines the following methods:
* **TypedQuery.getSingleResult** - for use when exactly one result object is expected.
* **TypedQuery.getResultList** - for general use in any other case.

## 4.2.3. JPQL Statement types
JPQL allow SELECT, UPDATE and DELETE statements to be performed.

#### 4.2.3.1. JPQL Select statements
The simplest possible HQL SELECT statement is of the form:

    List<Customer> customers = session.createQuery(
    "select * from Customer" )
    .list();
#### 4.2.3.2. JPQL Update statements
The UPDATE statements is the same in HQL and JPQL:
       
    String jpqlUpdate =
    "update Customer c " +
    "set c.name = :newName " +
    "where c.name = :oldName";
    int updatedEntities = entityManager.createQuery( jpqlUpdate )
    .setString( "newName", newName )
    .setString( "oldName", oldName )
    .executeUpdate();

#### 4.2.3.3.JPQL Delete statements
The DELETE statements is the same in HQL and JPQL:

    entityManager.createQuery(
    "delete from Customer" +
    "where name = :name");  
    .setParameter( name, "Ivan" )
    .executeUpdate();  

## 4.3. Hibernate Query Language (HQL)
### 4.3.1. HQL. Advantages

Hibernate Query Language (HQL) is same as SQL (Structured Query Language) but it doesn't depends on the table of the 
database. Instead of table name, we use class name in HQL. So it is database independent query language.

Advantage of HQL
* database independent
* supports polymorphic queries
* easy to learn for Java Programmer

### 4.3.2. Hibernate Query API

In Hibernate, the HQL query is represented as **_org.hibernate.query.Query_** which is obtained from a **_Session_**. 
If the HQL is a named query, _**Session#getNamedQuery**_ would be used; otherwise _**Session#createQuery is needed**_.

    org.hibernate.query.Query query = session.createQuery(
    "select c from Customer c where c.name like :name");

    or 

    org.hibernate.query.Query query = session.createQuery(
    "from Customer c where c.name like :name");

### 4.3.3. Query Parameters in HQL
There are two types query parameters in JPA:
* named parameters (:name);
* positional parameters(?index)
####  Named parameters(:name)
The following method retrieves a Customer object from the database by its name:

    String customerName = "Ivan";
    org.hibernate.query.Query query = session.createQuery("select c from Customer c where c.name like :name ");
    query.setParameter("name", pattern +"%");
#### Positional parameters (?)
HQL-style positional parameters follow JDBC positional parameter syntax. They are declared using ? without a following 
ordinal. There is no way to relate two such positional parameters as being "the same" aside from binding the same value 
to each:

    String customerName = "Ivan";
    org.hibernate.query.Query query = session.createQuery("select c from Customer c where c.name = ?");
    query.setParameter(0, customerName);
### 4.3.4. Running HQL Queries
In terms of execution, Hibernate offers 4 different methods. The 2 most commonly used are
* **Query.list()** - executes the select query and returns back the list of results.
* **Query.uniqueResult()** - executes the select query and returns the single result. If there were more than one result an exception is thrown.


        List<Customer> customers = session.createQuery(
        "select c from Customer c where c.name like :name" )
        .setParameter( "name", "Iv%" )
        .list();
It is also possible to extract a single result from a Query.
    
    Customer customer = (Customer) session.createQuery(
    "select c from Customer c where c.name like :name" )
    .setParameter( "name", "Iv%" )
    .uniqueResult();

### 4.3.5. HQL Statement types
HQL as JPQL allow SELECT, UPDATE and DELETE statements to be performed. HQL additionally allows INSERT statements, 
in a form similar to a SQL INSERT FROM SELECT.
#### 4.3.5.1. HQL Select statements
The simplest possible HQL SELECT statement is of the form:

    List<Customer> customers = session.createQuery(
    "from Customer" )
    .list();
#### 4.3.5.2. HQL Update statements
The UPDATE statements is the same in HQL and JPQL:

    int updatedEntities = session.createQuery(
    "update Customer " +
    "set name = :newName " +
    "where name = :oldName" )
    .setParameter( "oldName", oldName )
    .setParameter( "newName", newName )
    .executeUpdate();
#### 4.3.5.3. HQL Delete statements
The DELETE statements is the same in HQL and JPQL:

    session.createQuery(
    "delete from Customer" +
    "where name = :name");  
    .setParameter( name, "Ivan" )
    .executeUpdate();  
A DELETE statement is also executed using the executeUpdate() method of either org.hibernate.query.Query.
#### 4.3.5.4. HQL Insert statements
HQL adds the ability to define INSERT statements as well.There is no JPQL equivalent to this.

The HQL INSERT statement is:
    
    insert_statement ::=
    insert_clause select_statement
    
    insert_clause ::=
    INSERT INTO entity_name (attribute_list)
    
    attribute_list ::=
    state_field[, state_field ]*















