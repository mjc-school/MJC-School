## Authentication & Spring Security

This module is an extension of REST API Advanced module and covers following topics:
1. Spring Security framework
2. Oauth2 and OpenId Connect
3. JWT token

Spring Security is a powerful and highly customizable authentication and access-control framework.
It is the de-facto standard for securing Spring-based applications.

OAuth 2.0 is a security standard where you give one application permission to access your data in another application.
The steps to grant permission, or consent, are often referred to as authorization or even delegated authorization.
You authorize one application to access your data, or use features in another application on your behalf, without giving them your password.

OpenID Connect (OIDC) is a thin layer that sits on top of OAuth 2.0 that adds login and profile information about the person who is logged in.

JSON Web Tokens are JSON objects used to send information between parties in a compact and secure manner.

### Task #1
1.Spring Security should be used as a security framework.

2.Application should support only stateless user authentication and verify integrity of JWT token.
Users should be stored in a database with some basic information and a password.

User Permissions:

2.1. Guest:
   * Read operations for main entity.
   * Signup.
   * Login.
   
2.2. User:
   * Make an order on main entity.
   * All read operations.

2.3. Administrator (can be added only via database call):
   * All operations, including addition and modification of entities.

3.Get acquainted with the concepts Oauth2 and OpenId Connect

### Optional Task
1. Use Oauth2 as an authorization protocol.
    * OAuth2 scopes should be used to restrict data.
    * Implicit grant and Resource owner credentials grant should be implemented.

### Materials (Videos & Links)

* [Spring Security Architecture](https://spring.io/guides/topicals/spring-security-architecture)
* [Securing a Web Application](https://spring.io/guides/gs/securing-web/)
* [Иллюстрированное руководство по OAuth и OpenID Connect](https://habr.com/ru/company/flant/blog/475942/)
* [Spring Boot and OAuth2](https://spring.io/guides/tutorials/spring-boot-oauth2/)
* [Introduction to JSON Web Tokens](https://jwt.io/introduction/)
* [Tutorial: Create and Verify JWTs in Java](https://developer.okta.com/blog/2018/10/31/jwts-with-java)
* [Simple Token Authentication for Java Apps](https://developer.okta.com/blog/2018/10/16/token-auth-for-java)

### Questions

 1. What is Spring Security?
 2. What does Authentication mean?
 3. What does Authorization mean?
 4. What is Oauth2?
 5. What is OpenId Connect?
 6. What is a Security context?
 7. What is Security principal?
 8. What is JWT? Describe JWT structure
 9. Why should you use JWT?