# REST API Basics

## READING

1. [Getting started with Spring Core. Reading (30 mins)](https://www.manning.com/books/spring-in-action-fourth-edition) 
2. [Getting started with Spring Core. Reading (25 mins)](https://www.tutorialspoint.com/spring/spring_beans_autowiring.htm) 
3. [Getting started with Spring MVC. Reading (30 mins)](https://www.manning.com/books/spring-in-action-fourth-edition) 
4. [Best practices for REST API design. Reading (10 mins)](https://hackernoon.com/restful-api-designing-guidelines-the-best-practices-60e1d954e7c9) 
5. [Spring Web Application Structure. Reading (20 mins)](https://www.petrikainulainen.net/software-development/design/understanding-spring-web-application-architecture-the-classic-way/) 
6. [Create REST API with Spring MVC. Reading (30 mins)](https://livebook.manning.com/#!/book/spring-in-action-fourth-edition/chapter-16)
7. [A Simple Guide to Connection Pooling in Java (10 mins)](https://www.baeldung.com/java-connection-pooling)
8. [JDBC Connection Pooling Tutorial (10 mins)](https://www.progress.com/tutorials/jdbc/jdbc-jdbc-connection-pooling)
9. [Modern Best Practices for Testing in Java (20 mins)](https://phauer.com/2019/modern-best-practices-testing-java/) 
10. [JUnit (overview guid)](https://junit.org/junit5/docs/current/user-guide/)

## Practice

### Task

#### Recommended Timeline
The recommended timeline for the whole module is 2 weeks.

#### Business requirements
1. Develop web service for Gift Certificates system with the following entities (many-to-many):
![](media/model.png)\
    - *CreateDate*, *LastUpdateDate* - format *ISO 8601* (https://en.wikipedia.org/wiki/ISO_8601). Example: 2018-08-29T06:12:15.156. More discussion here: https://stackoverflow.com/questions/3914404/how-to-get-current-moment-in-iso-8601-format-with-date-hour-and-minute 
    - *Duration* - in days (expiration period)
2. The system should expose REST APIs to perform the following operations:
    - CRUD operations for GiftCertificate. If new tags are passed during creation/modification – they should be created in the DB. For update operation - update only fields, that pass in request, others should not be updated. Batch insert is out of scope.
    - CRD operations for Tag.
    - Get certificates with tags (all params are optional and can be used in conjunction):
        - by tag name (ONE tag)
        - search by part of name/description (can be implemented, using DB function call)
        - sort by date or by name ASC/DESC (extra task: implement ability to apply both sort type at the same time).

#### Application requirements

1. JDK version: 8 – use Streams, java.time.*, etc. where it is possible. (the JDK version can be increased in agreement with the mentor/group coordinator/run coordinator) 
2. Application packages root: com.epam.esm
3. Any widely-used connection pool could be used. 
4. JDBC / Spring JDBC Template should be used for data access. 
5. Use transactions where it’s necessary. 
6. Java Code Convention is mandatory (exception: margin size – 120 chars). 
7. Build tool: Maven/Gradle, latest version. Multi-module project. 
8. Web server: Apache Tomcat/Jetty. 
9. Application container: Spring IoC. Spring Framework, the latest version. 
10. Database: PostgreSQL/MySQL, latest version.
11. Testing: JUnit 5.+, Mockito. 
12. Service layer should be covered with unit tests not less than 80%. 
13. Repository layer should be tested using integration tests with an in-memory embedded database (all operations with certificates).    

#### General requirements

1. Code should be clean and should not contain any “developer-purpose” constructions.  
2. App should be designed and written with respect to OOD and SOLID principles. 
3. Code should contain valuable comments where appropriate. 
4. Public APIs should be documented (Javadoc). 
5. Clear layered structure should be used with responsibilities of each application layer defined.  
6. JSON should be used as a format of client-server communication messages.  
7. Convenient error/exception handling mechanism should be implemented: all errors should be meaningful and localized on backend side. Example: handle 404 error: 

        • HTTP Status: 404
        • response body    
        • {
        • “errorMessage”: “Requested resource not found (id = 55)”,
        • “errorCode”: 40401
        • }
         
    where *errorCode” is your custom code (it can be based on http status and requested resource - certificate or tag) 
8. Abstraction should be used everywhere to avoid code duplication. 
9. Several configurations should be implemented (at least two - dev and prod).

#### Application restrictions

It is forbidden to use:
1. Spring Boot.
2. Spring Data Repositories.
3. JPA.
4. Powermock (your application should be testable).

Mentee can use lombok when agreed with mentor.

## Demo
### Practical part

1. Demonstrate API using Postman tool (prepare for demo Postman collection with APIs) 
2. (Optional) Build & run application using command line

### Theoretical part

Mentee should be able to answer questions during demo session.

## Extra Materials

1. **Java**
   * **Functional Interfaces**
     *	http://tutorials.jenkov.com/java-functional-programming/index.html - Java Functional Programming from Chapter 1 to 4 (Java Functional Programming, Java Higher Order Functions, Java Functional Interfaces, Java Functional Composition)
   * **Lambdas, Method references**
     *	https://docs.oracle.com/javase/specs/ - The Java Language Specification, Java SE 8 Edition, Chapter 15.27 “Lambda Expressions” (page 601)
   * **1.3.Stream API**
     *	http://tutorials.jenkov.com/java-functional-programming/streams.html - Chapter 5 (Java Stream API)
    * **Optional**
      * https://www.baeldung.com/java-optional
      * https://www.tutorialspoint.com/java8/java8_optional_class.htm#:~:text=Optional%20is%20a%20container%20object,instead%20of%20checking%20null%20values.
    * **Date/Time API, TemporalAdjuster**
      *	https://www.baeldung.com/java-8-date-time-intro
2. **Coding best practices**
    * **Overview**
      *	https://www.baeldung.com/java-clean-code
      *	https://www.scaler.com/topics/java/java-clean-code/
    * **Java Code Convention**
      *	https://www.oracle.com/technetwork/java/codeconventions-150003.pdf
      *	https://medium.com/@thusharaj/java-code-convention-simplified-f476bd8aa719
    * **OOD, SOLID, YAGNI, DRY principles**
      * https://www.baeldung.com/solid-principles - SOLID Principles
      * https://youtu.be/rtmFCcjEgEw - lection by Katerina Trajchevska
             Transcription:
               1) Single Responsibility Principle: 7:04 
               2) Open/Closed Principle: 13:53
               3) Liskov Substitution Principle: 20:42
               4) Interface Segregation Principle: 27:18
               5) Dependency Inversion Principle: 31:21
    * **Comments best practice**
      *	https://dzone.com/articles/5-best-practices-commenting
      *	https://javarevisited.blogspot.com/2011/08/code-comments-java-best-practices.html
3. **Exception handling**
   * **Overview**
     * https://www.javatpoint.com/exception-handling-in-java#:~:text=What%20is%20Exception%20in%20Java,which%20is%20thrown%20at%20runtime.
     * https://www.geeksforgeeks.org/exceptions-in-java/
     * https://www.tutorialspoint.com/java/java_exceptions.htm
   * **Checked vs. Runtime (Unchecked) Exceptions**
     * https://www.geeksforgeeks.org/checked-vs-unchecked-exceptions-in-java/
     * https://howtodoinjava.com/java/exception-handling/checked-vs-unchecked-exceptions-in-java/
   * **Exception handling best practices**
     *	https://stackabuse.com/exception-handling-in-java-a-complete-guide-with-best-and-worst-practices/
     *	https://dzone.com/articles/9-best-practices-to-handle-exceptions-in-java
     *	https://howtodoinjava.com/best-practices/java-exception-handling-best-practices/
4. **Layered Architecture**
     * https://medium.com/java-vault/layered-architecture-b2f4ebe8d587#:~:text=In%20a%20layered%20architecture%2C%20layers,is%20a%203%2DLayered%20Architecture.
5. **Spring Framework**
   * **Overview:**
     *	https://docs.spring.io/spring-framework/docs/5.0.0.RC2/spring-framework-reference/overview.html#:~:text=The%20Spring%20Framework%20consists%20of,shown%20in%20the%20following%20diagram.
   * **Spring Core: Wiring beans**
     *	https://www.manning.com/books/spring-in-action-fourth-edition
   * **Core concepts – Chapter 2: Wiring beans;**
     * https://www.tutorialspoint.com/spring/spring_beans_autowiring.htm
   * **Building Spring web applications: Spring MVC**
     *	https://www.manning.com/books/spring-in-action-fourth-edition
          MVC –  Chapter 5: Building Spring web applications
          MVC – Chapter 7: Advanced Spring MVC
6. **REST API Fundamentals**
   * **Overview:**
     * https://bookauthority.org/books/best-rest-api-books - list of books for additional learning
   * **RESTful Architecture**
     * https://www.vinaysahni.com/best-practices-for-a-pragmatic-restful-api
     * https://dzone.com/refcardz/rest-foundations-restful?chapter=1
   * **REST APIs with Spring**
     * https://www.manning.com/books/spring-in-action-fourth-edition
7. **Maven**
    * https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html
    * https://www.baeldung.com/maven
8. **Testing**
    * **Well-known approaches**
      * https://martinfowler.com/articles/practical-test-pyramid.html
      * https://www.petrikainulainen.net/programming/spring-framework/unit-testing-of-spring-mvc-controllers-rest-api/
    * **Junit**
      * https://www.tutorialspoint.com/junit/index.htm
      * https://junit.org/junit4/
    * **Mockito**
      * https://www.journaldev.com/21816/mockito-tutorial
      * https://www.baeldung.com/mockito-series
      * https://site.mockito.org/
      * https://www.petrikainulainen.net/programming/spring-framework/unit-testing-of-spring-mvc-controllers-configuration/
9. **Postman**
    * https://learning.postman.com/docs/getting-started/introduction/