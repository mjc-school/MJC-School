### Spring MVC
https://www.javatpoint.com/spring-mvc-tutorial
https://terasolunaorg.github.io/guideline/5.0.1.RELEASE/en/Overview/SpringMVCOverview.html
https://docs.spring.io/spring-framework/docs/3.1.x/spring-framework-reference/html/mvc.html


A **Spring MVC** is a Java framework which is used to build web applications. It follows the Model-View-Controller design pattern.
It implements all the basic features of a core spring framework like Inversion of Control, Dependency Injection.
A Spring MVC provides an elegant solution to use MVC in spring framework by the help of **DispatcherServlet**. that is completely 
integrated with the Spring IoC container <br>
**DispatcherServlet** is a class that receives the incoming request and maps it to the right resource such as controllers, models, and views.

## Understanding Spring Web Model-View-Controller

spring-web-model-view-controller.png

Model - A model contains the data of the application. A data can be a single object or a collection of objects.
Controller - A controller contains the business logic of an application. Here, the @Controller annotation is used to mark the class as the controller.
View - A view represents the provided information in a particular format. Generally, JSP+JSTL is used to create a view page. Although spring also supports other view technologies such as Apache Velocity, Thymeleaf and FreeMarker.
Front Controller - In Spring Web MVC, the DispatcherServlet class works as the front controller. It is responsible to manage the flow of the Spring MVC application.


## Understanding the flow of Spring Web MVC

RequestLifecycle.png

DispatcherServlet receives the request.
DispatcherServlet dispatches the task of selecting an appropriate controller to HandlerMapping. HandlerMapping selects the controller which is mapped to the incoming request URL and returns the (selected Handler) and Controller to DispatcherServlet.
DispatcherServlet dispatches the task of executing of business logic of Controller to HandlerAdapter.
HandlerAdapter calls the business logic process of Controller.
Controller executes the business logic, sets the processing result in Model and returns the logical name of view to HandlerAdapter.
DispatcherServlet dispatches the task of resolving the View corresponding to the View name to ViewResolver. ViewResolver returns the View mapped to View name.
DispatcherServlet dispatches the rendering process to returned View.
View renders Model data and returns the response.