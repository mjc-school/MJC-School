# Servlets

## Materials
+ Introduction to Servlets
+ Servlet lifecycle
+ Servlet architecture
+ Servlet interfaces
+ Request Dispatcher

## Introduction to Servlets

Servlets are Java programs that run on the server and handle requests coming from an HTTP client.

A Servlet is a class that handles requests, processes them, and sends back a response.

For example, we may use a Servlet to gather user input via an HTML form, query records from a database, and dynamically build web pages.

Benefits of servlets:
+ **Efficient, platform independent**

    By definition, the Java Servlet responds to the client’s request in real-time. It may also be portable and perform in any environment, regardless of the operating system platform.

+ **Scalable**

    Java Servlets are highly scalable. Servlets employ lightweight threads for their processes and may handle many client requests simultaneously by creating several threads.

+ **Robust**

    Java Servlets are best recognized for their dependable operation methods. The servlets enhance Java’s functionality, which includes exception handling, security management and garbage collection.

Servlets are managed by another Java program known as a **Servlet Container**. When an application, which is running in a web server, receives a request, the Server forwards it to the Servlet Container, which, in turn, passes it to the target Servlet.

The most common servlet container implementations are Apache Tomcat, GlassFish, Jetty, JBoss, IBM WebSphere and Oracle Weblogic.

***The servlet container loads the servlet on the first client request.*** In some cases, if the servlet is bulky, you need to load it directly at the start of the application in order to reduce the processing time of the request. To do this, use the `<load-on-startup>` tag in the web.xml application descriptor, which determines whether the servlet should be loaded at startup.

    <servlet>
        <servlet-name>servlet_name</servlet-name>
        <servlet-class>common.servlets.ServletName</servlet-class>
        <load-on-startup>3</load-on-startup>
    </servlet>

## Servlet lifecycle

Let's go through the set of methods which define the lifecycle of a Servlet.

**1. init()**

The `init()` method is designed to be called only once. If an instance of the servlet does not exist, the web container:
1. loads the servlet class
2. creates an instance of the servlet class
3. initializes it by calling the `init()` method 
   
Before the Servlet can receive requests, the `init()` method must be successfully completed. If the `init()` method throws a `ServletException` or does not return inside the time limit specified by the Web server, the servlet container cannot put the Servlet into service.

    public void init() throws ServletException { // ... }

**2. service()**

Container invokes the `service()` method to handle client requests. Container determines the HTTP method (POST, GET, PUT, etc.) and invokes the `doGet()`, `doPost()` `doPut()`, `doDelete()`, and so on.

    public void service(ServletRequest request, ServletResponse response)
        throws ServletException, IOException { // ... }

**3. destroy()**

The Servlet Container invokes this method to remove the Servlet from service. This method is only executed when all Servlet's service method threads have left or a timeout period has expired. The Container will not call the service method on the Servlet again after calling this method.

    public void destroy() { // ... }

## Servlet architecture

 Architecture shows the communication interface, protocol used, requirements of client and server, the programming with the languages and software involved. Basically, it performs the below-mentioned tasks.

+ First, it reads the explicit data sent by the clients (browsers). This data can include an HTML form on a Web page, an applet or a custom HTTP client program. It also reads implicit HTTP request data sent by the clients (browsers). This can include cookies, media types and compression schemes the browser understands, and so forth.
+ After that, the servlet processes data and generates results. This process may require interacting with a database, executing an RMI, invoking a Web service, or computing the response directly.
+ After processing, it sends explicit data to the clients (browsers). This document can be sent in a variety of formats, including text (HTML or XML) or binary formats(GIF images).
+ Finally, it also sends implicit HTTP response to the clients (browsers). This includes telling the browsers or other clients what type of document is being returned.

![servlet architecture](media/servlet_architecture.png)

## Servlet interfaces

Sun defines two java packages that contain all the interfaces and classes required by Servlet API. These packages are:

1. **`javax.servlet`** – This package contains generic classes and interfaces (protocol less). 

2. **`javax.servlet.http`** - As package name suggest , this package contains all classes and interfaces related to HTTP protocol.

The main interface in the Servlet API is the `Servlet` interface. All servlets implement this interface, either directly or indirectly.

By indirectly we mean, instead of implementing `Servlet` interface, custom servlets can extend one of the two available abstract classes which are `GenericServlet` and `HttpServlet`.

The inheritance hierarchy looks as follows.

![servlet hierarchy](media/servlet_hierarchy.png)

`Servlet` is displayed in a different color because it is an interface while `GenericServlet` and `HttpServlet` are abstract classes.

`GenericServlet` implements `Servlet` interface whereas `HttpServlet` extends `GenericServlet`.

### Servlet Config

([Oracle Docs: ServletConfig](https://docs.oracle.com/javaee/7/api/javax/servlet/ServletConfig.html))

Servlet Container creates `ServletConfig` object for each Servlet during initialization, to pass information to the Servlet. 

This object can be used to get configuration information such as parameter names and values from deployment descriptor file (web.xml).

A servlet is initialized by passing an object of `ServiceConfig` to its `init()` method by the Servlet Container. The `ServletConfig` object contains initialization information and provides access to the `ServletContext` object.

The following example shows a servlet's `init()` method that prints the name and surname parameters to the console.

    public void init (ServletConfig config) throws ServletException  
    {  
        System.out.println ("name = " + config.getInitParameter("name") +
        "surname = " + config.getInitParameter("surname"));
    }

To get the Servlet Config object in a servlet, we just need to call `getServletConfig()` method.

### Servlet Context

([Oracle Docs: ServletContext](https://docs.oracle.com/javaee/7/api/javax/servlet/ServletContext.html))

The main difference between `ServletConfig` and `ServletContext` is that unlike `ServletConfig`, the `ServletContext` is being created once per web application, i.e. `ServletContext` object is common to all the servlets in web application.

`ServletContext` allows you to access the parameters of the web application defined in the web.xml descriptor by the `<context-param>` tag:

    <context-param>
        <param-name>email</param-name>
        <param-value>admin@email.com</param-value>
    </context-param>

The `ServletContext` object can be obtained using the `getServletContext()` method of the `ServletConfig` interface.

    public void init (ServletConfig config) throws ServletException  
    {  
        ServletContext sc = config.getServletContext();  
        System.out.println ("Email = " + sc.getInitParameter("email"));
    }

Once we have the `ServletContext` object, we can set the attributes of the `ServletContext` object by using the `setAttribute()` method. Other servlets can retrieve the attribute from the `ServletContext` object by using the `getAttribute()` method.
The purpose of these methods is to transfer different objects between unrelated servlets.

### Servlet requests and responses

When a client sends a request to the web server, the servlet container creates `HttpServletRequest` and `HttpServletResponse` objects and passes them as arguments to the servlet’s `service()` method.

`HttpServletRequest` and `HttpServletResponse` are extended from `ServletRequest` and `ServletResponse` respectively and allow you to get additional information about the servlet and the details of the HTTP request protocol.

#### Servlet Request
([Oracle Docs: ServletRequest](https://docs.oracle.com/javaee/7/api/javax/servlet/ServletRequest.html))

The request object provides access to the request information such as headers and body information of the request data.

Following, various segments of a request received by the Servlet:

- HTTP Request Headers
- HTTP Request Parameters 
- HTTP Request InputStream
- HTTP Request Context
- HTTP Request Session

#### Servlet Response

([Oracle Docs: ServletResponse](https://docs.oracle.com/javaee/7/api/javax/servlet/ServletResponse.html))

The response object allows you to format and send the response back to the client. 

Various components of a response in Servlets:

- HTTP Response Headers
- HTTP Response Content-Type
- HTTP Response Content-Length
- HTTP Response Write HTML 
- HTTP Response Redirection

## Request Dispatcher

([Oracle Docs: RequestDispatcher](https://docs.oracle.com/javaee/7/api/javax/servlet/RequestDispatcher.html))

`RequestDispatcher` is used to work with additional resources such as another servlet, a JSP page, or an HTML document. Typically, this interface is used for internal communication between servlets in the same context. `RequestDispatcher` can be accessed using the `getRequestDispatcher(String url)` method of the `ServletContext` interface. 

`RequestDispatcher` implements two methods:

    //Transfers request to another resource on the server
    void forward(ServletRequest request, ServletResponse response)   

    //Includes the content of an additional resource in the response
    void **include**(ServletRequest request, ServletResponse response)

### forward() vs sendRedirect()
| forward()       | sendRedirect()   | 
| :------------:|:--------------:|
| Executed on the server side | Executed on the client side |
| The request is redirected to another resource within the same server | A 302 (redirect) response is returned to the client and the request can be redirected to another server |
| Does not depend on the client's request protocol, as provided by the servlet container | Can only be used with HTTP clients |
| Cannot be used to inject a servlet into another context | Can be used to inject a servlet into another context |
| Client is unaware of the actual resource being processed and the URL in the string remains the same  | The URL is changed to the address of the new resource |
| Faster than `sendRedirect()` method  | Slower than `forward()` because requires the creation of a new request |
| All request data stays intact | A new request is created, all parameters from the previous request are lost |
| Defined in the `RequestDispatcher` interface  | Defined in the `HttpServletResponse` interface |
