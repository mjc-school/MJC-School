# Rest API Basics

The goal of this task is to build simple REST service. 

You will learn modern web applications architecture and technologies used to develop them.

## Sub-module #1

Sub-module description

### Task #1

#### Business requirements

General model requirements:
* At least two entities.
* Entities are in many-to-many relationship.
* **Main entity** has at least 6 meaningful fields.

Suggested model:

* Gift Certificate:
  * name
  * description
  * price
  * date of creation
  * date of modification
  * duration in days *(expiration period)*
* Tag

The system should expose REST API to perform the following operations:

* CRUD operations for **main entity**.
  * If <ins>new secondary objects</ins> are passed during creation/modification of main entity –they should be persisted in DB.
* CRD operations for **secondary entity**.
* Filter **main entity objects** (all params are *optional* and ***can be used in conjunction***).
  * <ins>*by*</ins> **secondary entity field**.
  * <ins>*search*</ins> by part of **text field**(*should be implemented using DB function call*).
  * <ins>*sort*</ins> by **date field/text field**.
  
#### Technical requirements

##### General requirements

1. Code should be clean and should not contain any “developer-purpose” constructions.
2. App should be designed and written with respect to OOD and SOLID principles.
3. Other best practices such as YAGNI, DRY, etc.should be considered too.
4. Code should contain valuable comments where appropriate.
5. Public APIs should be documented(Javadoc).
6. Clear layered structure should be used with responsibilities of each application layer defined.
7. JSON should be used as a format of client-server communication messages.
8. Convenient error/exception handling mechanism should be implemented: <ins>all errors should be meaningful</ins>.

##### App requirements

1. JDK version: 8 - use *Streams, java.time.\*, etc.* where it is possible.
2. Application packages root is *com.epam.esm*.
3. Any widely usedconnection pool could be used.
4. *JDBC / Spring JDBC Template* should be used for data access.
5. Java Code Convention is mandatory (exception: margin size –120 chars).
6. *Build tool*: Apache Maven 3.5+. **Multi-module project**.
7. *Web server*: Apache Tomcat.
8. *Application container*: Spring IoC. Spring Framework4.+.
9. *Database*: PostgreSQL 9.+ or 10.+.
10. *Testing*: JUnit 4.+ or 5.+, Mockito.
11. Service layer should be covered with unit tests not less than 80%.
12. Repository layer should be tested using integration tests (create test database on your local machine).
13. APIs should be demonstrated using Postman tool. **Prepare for demo Postman collections with APIs**.

Please note that only GA versions of tools/frameworks/libs are allowed.

##### App restrictions

It is forbidden to use:
1. Spring Boot.
2. Spring Data Repositories.
3. JPA.
4. Powermock (your application should be testable).

Mentee can use lombok when agreed with mentor.
  
### Materials (Videos & Links)

* Some video link
* Some other video link
* Some link to external training
* Some link to resource
