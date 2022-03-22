# 5. Criteria Api
## Materials
* 5.1. JPA Query API
* 5.2. Hibernate Query Language (HQL)
* 5.3. Criteria API. Restrictions with like
* 5.4. Criteria API. Restrictions with between
* 5.5. Criteria API. Sorting
* 5.6. Criteria API. Pagination
* 5.7. Criteria API. Join


The JPA Query Language (JPQL) can be considered as an object-oriented version of SQL. Users familiar with SQL should 
find JPQL very easy to learn and use. </br>
The **JPA Criteria API** provides an alternative way for building dynamic queries,  based on Java objects that represent
query elements (replacing string based JPQL).</br>
JPA also provides a way for building static queries, as **named queries**, using the **@NamedQuery** and
**@NamedQueries** annotations. It is considered to be a good practice in JPA to prefer named queries over
dynamic queries when possible.

### 5.1. Criteria Api
Criteria queries offer a type-safe alternative to HQL, JPQL and native SQL queries. Hibernate offers an older, 
legacy _org.hibernate.Criteria_ API which should be considered deprecated. No feature development will target those APIs.
Eventually, Hibernate-specific criteria features will be ported as extensions to the JPA 
_javax.persistence.criteria.CriteriaQuery_.</br>
This chapter will focus on the JPA APIs for declaring type-safe criteria queries.
### 5.2. Steps to create Criteria Query
1) Create an object of **CriteriaBuilder** interface by invoking **getCriteriaBuilder()** method on the instance of
**EntityManager** interface.</br>

    
    EntityManager entityManager = entityManager.createEntityManager();
    CriteriaBuilder cb = entityManager.getCriteriaBuilder();
2) build an instance of CriteriaQuery interface to create a query object.

   
    CriteriaQuery<Customer> cq=cq.createQuery(Customer.class);  
3) Call from method on CriteriaQuery object to set the query root.

    
    Root<Customer> customer=cq.from(Customer.class);
4) Call the select method of CriteriaQuery Object to specify type of query result.

   
    CriteriaQuery<Customer> select = cq.select(customer); 
5) CriteriaQuery<StudentEntity> select = cq.select(stud);  

    
    Query q = entityManager.createQuery(select);  
6) Calling the methods of Query Interface


    List<Customer> list = q.getResultList();  
### 5.3. Criteria API. Restrictions with like

    EntityManager entityManager = entityManager.createEntityManager();
    CriteriaBuilder cb = entityManager.getCriteriaBuilder();
    CriteriaQuery<Customer> cq=cg.createQuery(Customer.class);  
    Root<Customer> customer=cq.from(Customer.class);
    cq.select(customer).where(cq.like(customer.get("name"), "%Iva%"));
    List<Customer> customers = entityManager.createQuery(cq).getResultList();
### 5.4. Criteria API. Restrictions with between

    EntityManager entityManager = entityManager.createEntityManager();
    CriteriaBuilder cb = entityManager.getCriteriaBuilder();
    CriteriaQuery<Customer> cq=cb.createQuery(Customer.class);
    Root<Customer> customer=cq.from(Customer.class);
    cq.select(emp).where(cb.between(emp.get("age"), 35, 50));
    List<Employee> employees = em.createQuery(cq).getResultList();
### 5.5. Criteria API. Sorting 

    EntityManager entityManager = entityManager.createEntityManager();
    CriteriaBuilder cb = entityManager.getCriteriaBuilder();
    CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);
    Root<Customer> customer=cq.from(Customer.class);
    cq.select(customer).orderBy(
    cb.desc(customer.get("id")),
    cb.asc(customer.get("name"))
    );
    List<Customer> customers = entityManager.createQuery(cq).getResultList();
### 5.6. Criteria API. Pagination

    EntityManager entityManager = entityManager.createEntityManager();
    int pageNumber = 1;
    int pageSize = 2;
    CriteriaBuilder cb = entityManager.getCriteriaBuilder();
    CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);
    cq.from(Customer.class);
    List<Customer> customers = entityManager.createQuery(cq)
    .setFirstResult(pageSize * (pageNumber-1))
    .setMaxResults(pageSize)
    .getResultList();

### 5.7. Criteria API. Join

    EntityManager em = entityManager.createEntityManager();
    CriteriaBuilder cb = entityManager.getCriteriaBuilder();
    CriteriaQuery<Customer> criteria = cb.createQuery(Customer.class);
    Root<Customer> customer = criteria.from(Customer.class);
    Join<Customer, Address> customerJoin = customer.join("address", JoinType.INNER);
    criteria.where(cb.equal(customerJoin.get("name"), "Ivan"));
    List <Address> address = entityManager.createQuery(criteria).getResultList();
