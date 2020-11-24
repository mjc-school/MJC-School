# Authentication & Spring Security

## Materials

1. [Spring Security Architecture](https://spring.io/guides/topicals/spring-security-architecture)
2. [Securing a Web Application](https://spring.io/guides/gs/securing-web/)
3. [Иллюстрированное руководство по OAuth и OpenID Connect](https://habr.com/ru/company/flant/blog/475942/)
4. [Spring Boot and OAuth2](https://spring.io/guides/tutorials/spring-boot-oauth2/)
5. [Introduction to JSON Web Tokens](https://jwt.io/introduction/)
6. [Tutorial: Create and Verify JWTs in Java](https://developer.okta.com/blog/2018/10/31/jwts-with-java)
7. [Simple Token Authentication for Java Apps](https://developer.okta.com/blog/2018/10/16/token-auth-for-java)

## Practice

#### Recommended Timeline
The recommended timeline for the whole module is 2 weeks.

### Task

This module is an extension of REST API Advanced module and covers following topics:

1. Spring Security framework
2. Oauth2 and OpenId Connect
3. JWT token

Spring Security is a powerful and highly customizable authentication and access-control framework. It is the de-facto standard for securing Spring-based applications. OAuth 2.0 is a security standard where you give one application permission to access your data in another application. The steps to grant permission, or consent, are often referred to as authorization or even delegated authorization. You authorize one application to access your data, or use features in another application on your behalf, without giving them your password. OpenID Connect (OIDC) is a thin layer that sits on top of OAuth 2.0 that adds login and profile information about the person who is logged in. JSON Web Tokens are JSON objects used to send information between parties in a compact and secure manner.

#### Application requirements

1. Spring Security should be used as a security framework.
2. Application should support only stateless user authentication and verify integrity of JWT token.
3. Users should be stored in a database with some basic information and a password.

User Permissions:

     - Guest:
        * Read operations for main entity.
        * Signup.
        * Login.
     - User:
        * Make an order on main entity.
        * All read operations.
     - Administrator (can be added only via database call):
        * All operations, including addition and modification of entities.

4. Get acquainted with the concepts Oauth2 and OpenId Connect
5. (Optional task) Use Oauth2 as an authorization protocol.
    a. OAuth2 scopes should be used to restrict data.
    b. Implicit grant and Resource owner credentials grant should be implemented.
6. (Optional task) It's allowed to use Spring Data. Requirement for this task - all repository (and existing ones) should be migrated to Spring Data.

## Demo
### Practical part

1. Generate for demo at least 
    a. 1000 users
    b. 1000 tags
    c. 10’000 gift certificates (should be linked with tags and users)
All values should look like more -or-less meaningful: random words, but not random letters 
2. Demonstrate API using Postman tool (prepare for demo Postman collection with APIs)  
3. (Optional) Build & run application using command line

### Theoretical part

Mentee should be able to answer questions during demo session.