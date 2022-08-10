# Curl for testing REST API

## Materials
+ Overview
+ Command-line options
+ Verbose mode
+ Output
+ Methods

## Overview
Сurl is a cross-platform command-line utility that allows you to interact with various servers using a variety of different protocols with URL syntax. cURL can automate file transfers or a sequence of such operations. For example, it is a good tool for modeling client actions with an API.

Curl is a command-line tool for transferring data and supports about 22 protocols, including HTTP. This combination makes it a very good special tool for testing almost any REST service.

## Command-line options
Curl supports over 200 command-line options. You can run a REST request either without parameters or with one or more parameters to accompany the URL request in the command. Let's look at two simple parameters that would facilitate the testing process.

## Verbose mode
When testing more complex queries, you should set the verbose mode to -v:

> **curl -v http://example.com/**
> 
> Trying 93.184.216.34...
> 
> TCP_NODELAY set
> 
> Connected to example.com (93.184.216.34) port 80 (#0)
> 
> GET / HTTP/1.1
> 
> Host: example.com
> 
> User-Agent: curl/7.54.0
> 
> Accept: */*
>
> < HTTP/1.1 200 OK
> 
> … (HTML)...

As a result, Here you can see useful information, such as the IP address, the port to which you are connecting, and headers.

## Output
By default, curl prints the response body to standard output. If necessary, you can provide an output option to save to a file:

> curl -o out.json http://www.example.com/index.html

This is especially helpful when the response size from the REST request is large enough. You can examine in detail all the necessary data from the server response.

Each HTTP request contains a request method. The most commonly used methods are GET, POST, PUT and DELETE.

## Methods
### GET method
This is the default method when making HTTP calls using curl. In fact, the previously shown examples were simple GET calls. When starting a local service instance on port 8080, you can use this command to call GET:

> curl -v http://localhost:8082/

### POST method
This method is used to send data to the received service. And for this, you use the data option. The easiest way to do this is by putting data in a command:

> curl -d 'id=1&name=create' http://localhost:8080/new

or you can transfer the file containing the request body to the data option as follows:

> curl -d @request.json -H "Content-Type: application/json" http://localhost:8080/new

### PUT Method
This method is very similar to POST. But it is used when you need to send a new version of an existing resource. To do this, use the -X option. Without any mention of the type of the request method, curl uses GET by default. Therefore, we explicitly mention the type of method in the case of PUT:

> curl -d @request.json -H 'Content-Type: application/json' -X PUT http://localhost:8080/update

### DELETE Method
Use DELETE with the -X option:

> curl -X DELETE http://localhost:8082/

The main disadvantage and at the same time the main advantage of curl is the lack of a GUI.

More information here https://www.baeldung.com/curl-rest.