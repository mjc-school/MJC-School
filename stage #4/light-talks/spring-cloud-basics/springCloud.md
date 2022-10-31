1. To talk about Spring Cloud libraries, we should discuss MSA first
    1. Monolith - old approach, one big application
    2. MSA - splitted into many apps, usually vertical slices
    3. Pros and cons of MSA
2. Spring Cloud - bunch of libraries, that help facilitate microservice architecture. Most popular libs are for external configuration, service discovery and request routing
3. Lets build our app with the use of Spring Cloud. At the very beginning, we'll have a simple http server, that returns a list of available hotels
    1. We have only two hotels, each of them is enabled by property
    2. Launch the app, show that one hotel is returned, another is not
    3. If we remove one property, application doesn't start
4. Config server - externalized configuration, both client and server. By default loads config from git, but can load from other sources
    1. Show basic schema how config server works
    2. It also supports refreshing beans - when a specific actuator endpoint is called, server may fetch properties from config server again and re-initialize it's beans
    3. Demo
        1. Launch config server, show it's configuration
        2. Enabled config server client in hotel service, launch it
        3. Show that properties are loaded from the config server, application works even if application.properties is empty
        4. Change the property in `hotel-service-dev.properties`, call `/refresh` on hotel service
        5. Show that the result changed, show the log from the HotelService constructor
5. Eureka
    1. Definition of service discovery
    2. Schema how eureka works in the distributed environment
    3. Demo
        1. Introduce discount service
        2. Launch eureka server
        3. Show Feign client in hotels service, describe how it works
        4. Enable eureka client in both hotels and discount services, launch them
        5. Show Eureka UI
        5. Make a request to hotels service
6. Gateway
    1. Short description
    2. Schema
    3. Pros and cons of gateway
    4. Demo
        1. Show gateway config, launch it
        2. Make requests to hotels and discounts through gateway
