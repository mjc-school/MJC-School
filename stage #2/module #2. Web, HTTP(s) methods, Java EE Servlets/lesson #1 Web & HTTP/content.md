# Web & HTTP(S)

## Materials
+ Introduction in Web
+ Web and HTTP interrelation
+ HTTP Request structure
+ HTTP Response structure
+ HTTP Methods
+ HTTP Response codes
+ HTTPS

## Introduction in Web
### Clients and servers
Web is basically a system of Internet servers that supports formatted documents. The documents are formatted using a markup language called HTML (HyperText Markup Language) that supports links to other documents, like graphics, audio, or video files.

Computers connected to the web are divided into clients and servers. Web consists of billions of clients and servers connected through wires and wireless networks. A simplified diagram of how they interact might look like this:

![сlient-server interaction](media/сlient_server_interaction.png)

- Clients are the typical web user's internet-connected devices (for example, your computer or your phone connected to your Wi-Fi) and web-accessing software available on those devices (usually a web browser like Firefox or Chrome).
- Servers are computers that store webpages, sites, or apps. When a client device wants to access a webpage, a copy of the webpage is downloaded from the server onto the client machine to be displayed in the user's web browser.

### Other parts of the toolbox
A client and a server we've described above don't tell the whole story. There are many other parts involved, and we'll describe them below.

For now, let's imagine that the web is a road. On one end of the road is the client, which is like your house. On the other end of the road is the server, which is a shop you want to buy something from.

![Road](media/road.jpeg)

In addition to the client and the server, we also need to know:

+ **Internet connection**. Allows you to send and receive data on the web. It's basically like the street between your house and the shop.
+ **TCP/IP**. Transmission Control Protocol and Internet Protocol are communication protocols that define how data should travel across the internet. In our example, this is like transport mechanisms that help you get to your destination.
+ **DNS**: Domain Name Servers are like an address book for websites. When you type a web address in your browser, the browser looks at the DNS to find the website's real IP address before it can retrieve the website. The browser needs to find out which server that website lives on, so it can send HTTP messages to the right place. This is like looking up the address of the shop so you can access it.
+ **HTTP**: Hypertext Transfer Protocol is an application protocol that defines a language in which clients and servers can communicate. This is like the language you use to order your goods.
+ **Component files**: A website is made up of many different files, which are like the different parts of the goods you buy from the shop. 
  
    These files come in two main types:
    + Code files: Primarily, HTML, CSS, and JavaScript.
    + Assets: This is a collective name for all the other stuff that makes up a website, such as images, music, video, Word documents, and PDFs.

### "How it works" or HTTP Request lifecycle 
When you type a web address into your browser *(for our analogy that's like walking to the shop)*:

1. The browser goes to the DNS server, and finds the real IP address of the server that the website lives on *(you find the address of the shop)*.
2. The browser sends an HTTP request message to the server, asking it to send a copy of the website to the client *(you go to the shop and order your goods)*. This message, as well as other data sent between the client and the server, are sent across your internet connection using TCP/IP and HTTP.
3. If the server approves the client's request, the server sends the client a "200 OK" message, which means "Of course you can look at that website! Here it is", and then starts sending the website's files to the browser as a series of small chunks called data packets *(the shop gives you your goods, and you bring them back to your house)*.
4. The browser assembles the small chunks into a complete web page and displays it to you *(the goods arrive at your door)*.

## Web and HTTP interrelation
HTTP (Hypertext Transfer Protocol)
- HTTP is a protocol that clients and servers on the web use to communicate. 
- It is similar to other internet protocols such as SMTP (Simple Mail Transfer Protocol) and FTP (File Transfer Protocol).
- HTTP is a stateless protocol i.e. it supports only one request per connection (although since HTTP/1.1 "keep-alive" connections allow you to send several HTTP requests over one TCP connection). This means that with HTTP the clients connect to the server to send one request and then disconnect. This mechanism allows more users to connect to a given server over a period of time.
- The client sends an HTTP request and the server answers with an HTTP response containing an HTML page, JSON data or something else requested.

In an extremely simplified form, the HTTP architecture can be represented as follows:

![http architecture](media/http_architecture.png)

HTTP messages are composed of textual information encoded in ASCII, and span over multiple lines.
Web developers rarely craft these textual HTTP messages themselves: software, web browsers, proxy, or web servers perform this action. 

## HTTP Request structure

The start-line of HTTP request contains three elements:
1. An HTTP method, a verb that describes the action to be performed (like `GET`, `POST`). We'll discuss HTTP methods later.
2. The request target, usually a URL, or the absolute path of the protocol, port, and domain, that are usually characterized by the request context.
3. The protocol version, which defines the structure of the remaining message, acting as an indicator of the expected version to use for the response.

HTTP headers from a request follow the same basic structure of an HTTP header: a case-insensitive string followed by a colon (':') and a value. The whole header, including the value, consist of one single line, which can be quite long.

Many different headers can appear in requests. They can be divided in several groups:
+ **General headers**, like `Connection`. They apply to the message as a whole.
+ **Request headers**, like `Accept` or `Accept-Language`. They modify the request or conditionally restrict it.
+ **Representation headers**, like `Content-Type`. They describe the original format of the message data and any encoding applied.

![http request structure](media/http_request_headers.png)

The final part of the request is its body. Not all requests have one:  `GET`, `HEAD`, `DELETE`, or `OPTIONS` requests usually don't need one.

## HTTP Response structure

The start line of an HTTP response, called the status line, contains the following information:
1. Protocol version, usually HTTP/1.1.
2. Status code, indicating success or failure of the request. 
3. Status text. A brief, purely informational, textual description of the status code to help a human understand the HTTP message.

A typical status line looks like this: 
        
    HTTP/1.1 404 Not Found.

HTTP headers from a response follow the same basic structure of an HTTP header: a case-insensitive string followed by a colon (':') and a value. The whole header, including the value, consist of one single line, which can be quite long.

Many different headers can appear in responses. These can be divided into several groups:

+ **General headers**, like `Transfer-Encoding`. They apply to the whole message.
+ **Response headers**, like `Server`, `Set-Cookie`. They give additional information about the server which doesn't fit in the status line.
+ **Representation headers** like `Content-Type`. They describe the original format of the message data and any encoding applied.

![http response structure](media/http_response_headers.png)

The last part of a response is the body. Not all responses have one: responses with a status code that sufficiently answers the request without the need for corresponding payload (like `201 Created` or `204 No Content`) usually don't.

## HTTP methods
There are eight methods in HTTP:

+ **HEAD** 
  
    Used to get the status line and title from the server by URI. Doesn't change data. 

+ **GET**
  
    Used to receive data from the server at the specified URI. Doesn't change data.
    
+ **POST**
    
    Used to send data to the server (such as developer information, etc.) inside the body.
    
+ **PUT**
  
    Replaces all previous data on the resource specified by the URI with the new loaded data from body.
    
+ **DELETE**
    
    Removes all current data on the resource specified by the URI.
    
+ **CONNECT**
    
    Establishes a tunnel connection to the server at the specified URI.
    
+ **OPTIONS**
  
    Describes the connection properties for the specified resource.
    
+ **TRACE**
    Provides a message containing a reverse trace of the location of the specified resource URI.

An HTTP request can be made using a variety of methods, but the ones which we use widely are  **GET** and **POST**. The method name itself tells the server the kind of request that is being made, and how the rest of the message will be formatted.

Now, with the help of the table below, let’s understand the difference between Get and Post methods of HTTP.

| GET                                          | POST                                       |
| :-------------------------------------------:|:------------------------------------------:|
| No data is sent                              | Data is sent in the request body           |
| Restricted to limited data transfer          | Supports a large amount of data transfer   |
| It is not secured                            | It is completely secured                   |
| It can be bookmarked                         | It cannot be bookmarked                    |

###  Idempotent Methods

The term idempotent is used to describe an operation that will produce the same results if executed multiple times.

Idempotence is a handy property in many situations, as it means that an operation can be repeated or retried as often as necessary without causing unintended effects.

With non-idempotent operations, the algorithm may have to keep track of whether the operation was already performed or not.

In HTTP specification, methods **GET**, **HEAD**, **PUT** and **DELETE** are declared idempotent methods.

Methods **OPTIONS** and **TRACE** SHOULD NOT have side effects, so both are also inherently idempotent.

### Safe methods

An HTTP method is safe if it doesn't alter the state of the server. In other words, a method is safe if it leads to a read-only operation. All safe methods are idempotent, but not the other way round.

In HTTP specification, methods **GET**, **HEAD** and **OPTIONS** are declared safe.

## HTTP Response codes

There are five types of Response codes:

![http response structure](media/http_status_codes.png)

Some of the important response codes are given below:

*Information responses*

`100 Continue` - This interim response indicates that everything so far is OK and that the client should continue the request, or ignore the response if the request is already finished.

`102 Processing` - This code indicates that the server has received and is processing the request, but no response is available yet.

*Successful responses*

`200 Ok` - The request has succeeded.

`201 Created` - The request has succeeded and a new resource has been created.

`204 No content` - There is no content to send for this request, but the headers may be useful.

*Redirecting messages*

`301 Moved Permanently` - The URL of the requested resource has been changed permanently. The new URL is given in the response.

`302 Found` - This response code means that the URI of requested resource has been changed temporarily.

`307 Temporary Redirect` - The server sends this response to direct the client to get the requested resource at another URI with same method that was used in the prior request. This has the same semantics as the 302 Found HTTP response code, with the exception that the user agent must not change the HTTP method used: If a POST was used in the first request, a POST must be used in the second request.

`308 Permanent Redirect` - This means that the resource is now permanently located at another URI, specified by the Location HTTP Response header. The user agent must not change the HTTP method used.

*Client Error responses*

`400 Bad Request` - The server could not understand the request due to invalid syntax.

`401 Unauthorized` - The client must authenticate itself to get the requested response.

`403 Forbidden` - The client does not have access rights to the content;

`404 Not Found` - The server can not find the requested resource.

`409 Conflict` - This response is sent when a request conflicts with the current state of the server.

*Server Error responses*

`500 Internal Server Error` - The server has encountered a situation it doesn’t know how to handle.

`501 Not Implemented` - The request method is not supported by the server and cannot be handled.

`502 Bad Gateway` - This error response means that the server, while working as a gateway to get a response needed to handle the request, got an invalid response.

`503 Server Unavailable` - The server is not ready to handle the request. Common causes are a server that is down for maintenance or that is overloaded.

### Summary of HTTP Methods and Response codes

| HTTP Method  | CRUD           | Collection Resource (e.g. /users)                                                                      | Single Resource (e.g. /users/123)                                                |
| -------------|:--------------:| -------------------------------------------------------------------------------------------------------|:--------------------------------------------------------------------------------:|
| **POST**  | Create         | 201 (Created), ‘Location’ header with link to /users/{id} containing new ID                            | 405 (Method not allowed), avoid using POST with single resources                                            |
| **GET**   | Read           | 200 (OK), list of users. Use pagination, sorting, and filtering to navigate big lists                  | 200 (OK), single user. 404 (Not Found), if ID not found or invalid               |
| **PUT**   | Update/Replace | 405 (Method not allowed), unless you want to update every resource in the entire collection of resource| 200 (OK). Use 404 (Not Found), if ID is not found or invalid |
| **DELETE**| Delete         | 405 (Method not allowed), unless you want to delete the whole collection — use with caution            | 204 (No content). 404 (Not Found), if ID not found or invalid                            |

## HTTPS

While being a great means of communication in general, HTTP messages are not encrypted, which leads to a whole list of possible attacks. HTTPS fixes it by using plain old HTTP, but over an encrypted SSL/TSL connection. HTTPS encrypts the whole message including headers.

HTTPS is based on using TSL certificates as a proof of authenticity. Such sertificates are issued and validated by CA (certificate authorities). 

Web nowadays is slowly moving towards forcing websites into using HTTPS instead of HTTP, protecting user's data.