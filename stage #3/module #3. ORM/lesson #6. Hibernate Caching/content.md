# Hibernate Caching

## Materials
+ Overview
+ First Level Cache
+ Second Level Cache
+ Query Level Cache

## Overview

Caching is a feature that is being used in applications to improve the performance. Cache is positioned between the
database and the application and usually the data of database queries gets cached (local copy) in disk or memory so that
subsequent calls for the same data can be served by cache only. Caching is important to Hibernate as well. 
It utilizes a multilevel caching scheme as explained below.
<br>![](../%236.%20Hibernate%20Caching/media/hibernate_cache.jpg)</br>
Hibernate cache is 3 levels of caching:
* Cache of the first level (First-level cache)
* Second-level cache (Second-level cache)
* Query cache

## First Level Cache
Hibernate first level cache is associated with the **Session object**. Hibernate first level cache is enabled by default
and there is no way to disable it. However hibernate provides methods through which we can delete selected objects from
the cache or clear the cache completely.
Any object cached in a session will not be visible to other sessions and when the session is closed, all the cached 
objects will also be lost.

## Second Level Cache
Second level cache can be enabled for a process or cluster scope. In this cache the state of a persistent object is 
stored (in a disassembled) form and not as a complete instance. Second level cache is optional and can be configured
to cache at a class, collection level.
It is very important to know that second  level cache is at a **SessionFactory level**, which means all sessions of same
session factory will share the cache data.</br>

Hibernate does not provide any default implementation for the second-level cache. It gives **CacheProvider** interface 
(org.hibernate.cache.CacheProvider interface).So any third party Cache which implements **CacheProvider interface** can
be hooked as Second level cache:
* EHCache
* OSCache
* SwarmCache
* JBoss TreeCache

Concurrency Strategies:
The main responsibility of Concurrency Strategy is to store and retrieve data from the cache. There are four in-built concurrency strategies:

* **Read Only** – as its name suggests, it is appropriate for the data which is never changed like reference data (like month in a year)
* **Non Strict Read Write** – high possibility that we can read stale data and inconsistency between the database and a cache. Should be used when data hardly changes.
* **Read-Write** - this strategy maintains read-committed isolation level (read a committed data) and is not available in clustered environments.
* **Transactional** - it prevents stale data, so should be used when stale data is not acceptable at all.

 </br>
  It needs to tell hibernate itself what exactly to cache. Luckily, this can be done very easily with
annotations, like so:

```java
@Entity
@Table(name = "customer")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Customer {
    @Id
    @GeneratedValue
    private Long id;
    
    private String name;
    
    @OneToMany(mappedBy = "order")
    private List<Order> orders = new ArrayList<>();
    // ...
}
```

The class dependencies aren't catch by default. For example, if we consider the class above - Customer, then when 
fetching, the orders' collection will be taken from the database, and not from the second-level cache. If you want to
cache dependencies as well, then the class should look like this:

```java
@Entity
@Table(name = "customer")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Customer {
    @Id
    @GeneratedValue
    private Long id;
    
    private String name;
    
    @OneToMany(mappedBy = "order")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    private List<Order> orders = new ArrayList<>();
    // ...
}
```

**How it works**: When hibernate session try to load an entity, it will first find into the first-level cache,
if it does not found then it will look into the second-level cache and return the response (if available), but before
returning the response it will store that object/data into first-level also so next time no need to come at the 
session-level. When data is not found in the second level then it will go to the database to fetch data. Before 
returning a response to the user it will store that object/data into both levels of cache so next time it will be 
available at cache stages only.

## Query Level Cache
By default, the data of  HQL queries are not cached. If application fires HQL statement in the same or different session,
multiple times, then data of the query can be cached.

To do so we need to enable, we need to first set **_hibernate.cache.use_query_cache="true"_** in _**hibernate.cfg.xml file**_ .
Setting up this property will create additional two required cache regions. One to store the data and one to hold the 
last updated timestamps.

```xml    
<property name="hibernate.cache.use_query_cache" value="true"/>
```

Once done, we need to explicitly call **_setCacheable(true)_** on Query object before execution:

```java
Query query = session.createQuery("select c from Customer c where c.name = ?");
query.setCacheable(true);
```

The query cache is similar to the second level cache. But unlike it, the key to the cache data is not the object 
identifier, but the set of query parameters. And the data itself is the identifiers of the objects that match the query 
criteria. Thus, it is rational to use this cache with the second-level cache.

