# REST Basics - Spring Web

## Materials
+ Basics of RESTful APIs
+ Richardson REST API Maturity Model
+ Some definitions related to REST API
+ REST architectural constraints
+ Basic principals of designing REST APIs

## Basics of RESTful APIs
_**REST is an API architecture style.**_ It stands for Representational State Transfer (REST). 
REST is an architectural style that defines a set of constraints to be used for creating web services. 
REST API is a way of accessing web services in a simple and flexible way without having any processing.
REST technology is generally preferred to the more robust Simple Object Access Protocol (SOAP) technology because REST uses less bandwidth, 
simple and flexible making it more suitable for internet usage. It’s used to fetch or give some information from a web service. 
All communication done via REST API uses only HTTP protocol.

## Richardson REST API Maturity Model
The Richardson Maturity Model grades RESTful API by their maturity. The REST Maturity Model is a way to grade your API according to the constraints of REST.
It describes four different levels of REST (starting from 0 to 3 level). A REST API that supports hypermedia controls is classified as Level 3 in this maturity model.
- **Level 0 - a single URI and use a single HTTP method (typically POST)** <br> These services have a single URI and use a single HTTP method (typically POST). This is the most primitive way of building SOA applications with a single POST method and using XML to communicate between services. Level zero of maturity does not make use of any of URI, HTTP Methods, and HATEOAS capabilities.

- **Level 1 - different URIs for different resources but use a single HTTP method (typically POST)** <br> API design at Level 1 is all about using different URIs to interact with the different resources in your application but only a single HTTP verb – generally HTTP POST. These services will give each resource, available in the application, a unique URI. A unique URI separately identifies one unique resource – and that makes these REST API better than level zero.

- **Level 2 - different URIs and HTTP Verbs for manipulating resources** <br>
REST API of Level 2 uses different URIs and HTTP Methods, but does not use the HATEOAS. Such REST API supports several of the HTTP verbs on each exposed resource – Create, Read, Update and Delete (CRUD) operations. Here the state of resources, typically representing business entities, can be manipulated over the network.Maturity level 2 is the most popular usecase of REST principles, which advocate using different verbs based on the HTTP request methods, while the system can have multiple resources.

- **Level 3 - different URIs and HTTP Verbs and HATEOAS** <br>
REST API of Level 3 is the most mature level of Richardson’s model, which encourages easy discoverability. This level makes it easy for the responses to be self-descriptive by using HATEOAS. Level 3 leads the service consumers through a trail of resources, causing application state transitions as a result.

## Some definitions related to REST API

- _**Resource**_ <br> The key abstraction of information in REST is a resource. Any information that can be named can be a resource: a document or image, a temporal service (e.g. "today's weather in Los Angeles"), a collection of other resources, a non-virtual object (e.g. a person), and so on. In other words, any concept that might be identified by a URI provided by the server can be called a resource. A resource is an object with a type, associated data, relationships to other resources, and a set of methods that operate on it. It is similar to an object instance in an object-oriented programming, with the important difference that only a few standard methods are defined for the resource (corresponding to the standard HTTP GET, POST, PUT and DELETE methods), while an object instance typically has many methods. Resources can be singleton or grouped into collections. <br>
_**1.Singleton and Collection Resources**_<br>
For example, _“customers”_ is a collection resource and _“customer”_ is a singleton resource (in a banking domain).We can identify _“customers”_ collection resource using the URI **“/customers“**.  We can identify a single _“customer”_ resource using the URI **“/customers/{customerId}“**.<br>
_**2.Collection and Sub-collection Resources**_<br>
A resource may contain sub-collection resources also. For example, sub-collection resource _“accounts”_ of a particular _“customer”_ can be identified using the URN **“/customers/{customerId}/accounts”** (in a banking domain). Similarly, a singleton resource _“account”_ inside the sub-collection resource _“accounts”_ can be identified as follows: **“/customers/{customerId}/accounts/{accountId}“**.

- _**Resource state**_ <br> Resource state is the current state of a resource on a server at any point in time – and it has nothing to do with the interaction between client and server. It is what we get as a response from the server as the API response. We refer to it as resource representation.

- _**Resource representations**_ <br> A server can provide different representations for the same resource. A resource state can be represented in multiple formats, such as JSON, XML, YAML, etc. A client can use _**content negotiation (Accept ot Content-Type)**_ to request different representations of the same resource.

- _**Resource identifiers**_ <br> REST APIs use _**Uniform Resource Identifiers (URIs)**_ to address resources. REST API designers should create URIs that convey a REST API’s resource model to the potential clients of the API. When resources are named well, an API is intuitive and easy to use. If done poorly, that same API can be challenging to use and understand. Creating URIs for resources you should follow the principale (the best practice) described lower in this document.

- _**Application state**_<br>
Application state is server-side data that servers store to identify incoming client requests, their previous interaction details, and current context information.
It is important to understand the difference between the application state and the resource state. Both are completely different things.

- _**Stateless**_<br> Statelessness means that every HTTP request happens in complete isolation. When the client makes an HTTP request, it includes all information necessary for the server to fulfill the request. The server never relies on information from previous requests from the client and doesn't store state about the client session on the server-side. If any such information is important then the client will send that as part of the current request. REST statelessness means being free from the application state.

- _**REST API endpoint**_<br> An endpoint is one end of a communication channel. When an API interacts with another system, the touchpoints of this communication are considered endpoints. For APIs, an endpoint can include a URI of a server or service. Each endpoint is the location from which APIs can access the resources they need to carry out their function.
APIs work using ‘requests’ and ‘responses.’ When an API requests information from a web application or web server, it will receive a response. The place that APIs send requests and where the resource lives, is called an endpoint.

- _**Idempotence**_<br> An idempotent method is a method that can be called many times without different outcomes. 
It would not matter if the method is called only once, or ten times over. 
NOTE: POST is neither safe nor idempotent.
<br>Example:<br>
    
    ```java
    a = 5; // It is Idempotence, as final value(a = 5) would not change after executing it multiple times.
     
    a++; // It is not Idempotence because the final value will depend upon the number of times the statement is executed.
    
    ```

- _**Safety**_<br> The concepts of _**‘idempotent methods’**_ and _**‘safe methods’**_ are often confused. 
A safe method does not change the value that is returned, it reads – but it never writes. Safe methods are HTTP methods that do not modify resources. 
For instance, using GET or HEAD on a resource URI, should NEVER change the resource.
<br>Example:<br>

    ```java
    x + 0; //it is idempotent and also safe, as final value x would not change after executing it multiple times.
    
    x = 5; //it is idempotent but is not safe, as original value x could be changed to 5
    
    ```
    
    The first of these, adding zero, will return the same value every time (it is idempotent), and adding zero will have no effect on that value (it is also safe). 
    The second example will return the same value every time (it is idempotent) but is not safe (if x is anything other than 5 before the operation runs, it changes x).
    Therefore, all safe methods are idempotent, but not all idempotent methods are safe.

- _**HTTP PUT vs HTTP PATCH**_<br> The HTTP PATCH request method applies partial modifications to a resource.
A PATCH request is considered a set of instructions on how to modify a resource. Contrast this with PUT; which is a complete representation of a resource.
A PATCH is not necessarily idempotent, although it can be. Contrast this with PUT; which is always idempotent. 
The word "idempotent" means that any number of repeated, identical requests will leave the resource in the same state. 
For example if an auto-incrementing counter field is an integral part of the resource, then a PUT will naturally overwrite it (since it overwrites everything), 
but not necessarily so for PATCH. The PATCH body should not just be a modified part of the resource, but in some kind of patch language like _**JSON Patch**_ or _**XML Patch**_.
PATCH (like POST) may have side-effects on other resources so it is not safe.

- _**HATEOAS (Hypermedia as the Engine of Application State)**_<br> HATEOAS is a constraint of the REST application architecture. HATEOAS keeps the REST style architecture unique from most other network application architectures.
The term “hypermedia” refers to any content that contains links to other forms of media such as images, movies, and text.
REST architectural style let us use the hypermedia links in the API response contents. It allows the client to dynamically navigate to the appropriate resources by traversing the hypermedia links.
Navigating hypermedia links is conceptually the same as browsing through web pages by clicking the relevant hyperlinks to achieve a final goal.
For example, the given below JSON response may be from an API like HTTP GET _http://api.domain.com/management/departments/10_

    ```json
    {
        "departmentId": 10,
        "departmentName": "Administration",
        "locationId": 1700,
        "managerId": 200,
        "links": [
            {
                "href": "10/employees",
                "rel": "employees",
                "action":"GET",
                "types":["text/xml","application/json"]
            }
        ]
    }
    ```
    In the example above, the response returned by the server contains hypermedia links to employee resources _10/employees_ which can be traversed by the client to read employees belonging to the department.
    The advantage of the above approach is that hypermedia links returned from the server drive the application’s state and not the other way around.
    JSON does not have any universally accepted format for representing links between two resources. We may choose to send in the response body or decide to send links in HTTP response headers.

## REST architectural constraints

### 1. Client-Server
REST application should have a client-server architecture. This constraint essentially means that client applications and server applications MUST be able to evolve separately without any dependency on each other. A client should know only resource URIs, and that’s all. A Client requests resources and is not concerned with data storage, which remains internal to each server, and server holds the resources and is not concerned with the user interface or user state. They can evolve independently. Client doesn’t need to know anything about business logic and server doesn’t need to know anything about frontend UI.

### 2. Uniform Interface
It is a key constraint that differentiate between a REST API and Non-REST API. It suggests that there should be an uniform way of interacting with a given server irrespective of device or type of application (website, mobile app).
There are four guidelines principle of Uniform Interface are:
- _**Resource-Based:**_ Individual resources are identified in requests. For example: API/users.<br>
- _**Manipulation of Resources Through Representations:**_ Client has representation of resource and it contains enough information to modify or delete the resource on the server, provided it has permission to do so. Example: Usually user get a user id when user request for a list of users and then use that id to delete or modify that particular user.
- _**Self-descriptive Messages:**_ Each message includes enough information to describe how to process the message so that server can easily analyses the request.
- _**Hypermedia as the Engine of Application State (HATEOAS):**_ It need to include links for each response so that client can discover other resources easily.

### 3. Stateless
The restriction is called _**Statelessness**_ if the server does not store any data about the client session on the server-side.  It means that the necessary data\state to handle the request is contained within the request itself and server would not store anything related to the client session. The server will not store anything about the latest HTTP request the client made. It will treat every request as new. _**No client context shall be stored on the server between requests. No session, no history. The client is responsible for managing the state of the application**_. In REST, the client must include all information for the server to fulfill the request whether as a part of query params, headers or URI. For making REST API stateless, Even authentication/authorization details of the client should not be stored on the server side. Provide authentication credentials with each request. Statelessness enables greater availability since the server does not have to maintain, update or communicate that client session state. There is a drawback when the client need to send too much data to the server so it reduces the scope of network optimization and requires more bandwidth.

### 4. Cacheable
In order to provide a better performance, the applications are often made cacheable. Every response should include whether the response is cacheable or not and for how much duration responses can be cached at the client side. Client will return the data from its cache for any subsequent request and there would be no need to send the request again to the server. A well-managed caching partially or completely eliminates some client–server interactions, further improving availability and performance. But sometime there are chances that user may receive stale data To prevent it, the cached data needs to be updated each time the data is getting updated server side.

### 5. Layered System
This constraint tells that the architecture of the application can be layered, without letting the client know about it.
An application architecture needs to be composed of multiple layers. Each layer doesn’t know any thing about any layer other than that of immediate layer and 
there can be lot of intermediate servers(layers) between client and the end server. 
Intermediary servers may improve system availability by enabling load-balancing and by providing shared caches.

### 6. Code on demand (optional)
It is an optional feature. According to this, servers can also provide executable code to the client. The examples of code on demand may include a UI widget rendering code or client-side scripts such as JavaScript/Python.

## Basic principals of designing REST APIs

### 1. Use nouns to represent resources
RESTful URI should refer to a resource that is a thing (noun) instead of referring to an action (verb) because nouns have properties that verbs do not have – similarly, resources have attributes. Some examples of a resource are:
- Users of the system
- User Accounts
- Network Devices etc.
and their resource URIs can be designed as below:
```
http://api.example.com/device-management/managed-devices 
http://api.example.com/device-management/managed-devices/{device-id} 
http://api.example.com/user-management/users
http://api.example.com/user-management/users/{id}
```
Resources can be divided by the **resource archetypes** into four categories **(document, collection, store, and controller)**. Then it would be best if you always targeted to put a resource into one archetype and then use its naming convention consistently.

- ### document
    A document resource is a singular concept that is akin to an object instance or database record.
    In REST, you can view it as a single resource inside resource collection. A document’s state representation typically includes both fields with values and links to other related resources.
    Use “singular” name to denote document resource archetype.
    ```
    http://api.example.com/device-management/managed-devices/{device-id}
    http://api.example.com/user-management/users/{id}
    http://api.example.com/user-management/users/admin
    ```
- ### collection
    A collection resource is a server-managed directory of resources.
    Clients may propose new resources to be added to a collection. However, it is up to the collection resource to choose to create a new resource or not.
    A collection resource chooses what it wants to contain and also decides the URIs of each contained resource.
    Use the “plural” name to denote the collection resource archetype.
    ```
    http://api.example.com/device-management/managed-devices
    http://api.example.com/user-management/users
    http://api.example.com/user-management/users/{id}/accounts
    ```
- ### store
    A store is a client-managed resource repository. A store resource lets an API client put resources in, get them back out, and decide when to delete them.
    A store never generates new URIs. Instead, each stored resource has a URI. The URI was chosen by a client when the resource initially put it into the store.
    Use “plural” name to denote store resource archetype.
    ```
    http://api.example.com/song-management/users/{id}/playlists
    ```
- ### controller
    A controller resource models a procedural concept. Controller resources are like executable functions, with parameters and return values, inputs, and outputs.
    _**A REST API relies on controller resources to perform application specific actions that cannot be logically mapped to one of the standard methods (create, retrieve, update and delete).**_
    Use “verb” to denote controller archetype. Controller  “verb” typically appear as the last segment in a URI path, with no child resources to follow them in the hierarchy. 
    ```
    http://api.example.com/cart-management/users/{id}/cart/checkout 
    http://api.example.com/song-management/users/{id}/playlist/play
    ```
    The example above shows a controller resource that allows a client to checkout his cart or start to play client's playlist.

### 2. Use consistent resource naming conventions and URI formatting
Using consistent resource naming conventions and URI formatting allows you to minimize ambiguity and maximize readability and maintainability. Below some design hints to achieve consistency:
- **Use forward slash (/) to indicate hierarchical relationships**<br>
The forward-slash (/) character is used in the path portion of the URI to indicate a hierarchical relationship between resources. e.g.
    ```
    http://api.example.com/device-management
    http://api.example.com/device-management/managed-devices
    http://api.example.com/device-management/managed-devices/{id}
    http://api.example.com/device-management/managed-devices/{id}/scripts
    http://api.example.com/device-management/managed-devices/{id}/scripts/{id}
    ```
- **Do not use trailing forward slash (/) in URIs**<br>
    As the last character within a URI’s path, a forward slash (/) adds no semantic value and may confuse. It’s better to drop it from the URI.<br> Examples:<br>
    ```
    http://api.example.com/device-management/managed-devices/ 
    http://api.example.com/device-management/managed-devices  /*This is much better version*/
    ```
- **Use hyphens (-) to improve the readability of URIs**<br>
    To make your URIs easy for people to scan and interpret, use the hyphen (-) character to improve the readability of names in long path segments.<br> Examples:<br>
    ```
    http://api.example.com/devicemanagement/manageddevices/
    http://api.example.com/device-management/managed-devices  /*This is much better version*/
    ```
- **Do not use underscores ( _ )**<br>
    It’s possible to use an underscore in place of a hyphen to be used as a separator – But depending on the application’s font, it is possible that _the underscore (_)_ _character can either get partially obscured or completely hidden in some browsers or screens._
    To avoid this confusion, use hyphens (-) instead of underscores ( _ <br> Examples:<br>
    ```
    http://api.example.com/inventory-management/managed-entities/{id}/install-script-location  //More readable
    http://api.example.com/inventory_management/managed-entities/{id}/install_script_location  //(_) may be obscured or hidden in some browsers or screens
    http://api.example.com/inventory-management/managedEntities/{id}/installScriptLocation     //Less readable
    ```
- **Use lowercase letters in URIs**<br>
    When convenient, lowercase letters should be consistently preferred in URI paths.<br> Examples:<br>
    ```
    http://api.example.org/my-folder/my-doc     //1
    HTTP://API.EXAMPLE.ORG/my-folder/my-doc     //2
    http://api.example.org/My-Folder/my-doc     //3
    ```
    In the above examples, 1 and 2 are the same but 3 is not as it uses My-Folder in capital letters.

- **Do not use file extensions**<br>
   File extensions look bad and do not add any advantage. Removing them decreases the length of URIs as well. No reason to keep them.
   Apart from the above reason, if you want to highlight the media type of API using file extension, then you should rely on the media type, as communicated through the Content-Type header, to determine how to process the body’s content.<br> Examples:<br>
    ```
    http://api.example.com/device-management/managed-devices.xml  /*Do not use xml in the URI*/
    http://api.example.com/device-management/managed-devices 	    /*This is correct URI*/
    ```
- **Never use CRUD function names in**<br>
    We should not use URIs to indicate a CRUD function. URIs should only be used to uniquely identify the resources and not any action upon them.
    We should use HTTP request methods to indicate which CRUD function is performed.<br> Examples:<br>
    ```
    HTTP GET http://api.example.com/device-management/managed-devices           //Get all devices
    HTTP POST http://api.example.com/device-management/managed-devices          //Create new Device
    HTTP GET http://api.example.com/device-management/managed-devices/{id}      //Get device for given Id
    HTTP PUT http://api.example.com/device-management/managed-devices/{id}      //Update device for given Id
    HTTP DELETE http://api.example.com/device-management/managed-devices/{id}   //Delete device for given Id
    ```
- **Use query component to filter URI collection**<br>
    Often, you will encounter requirements where you will need a collection of resources sorted, filtered, or limited based on some specific resource attribute.
    For this requirement, do not create new APIs – instead, enable sorting, filtering, and pagination capabilities in resource collection API and pass the input parameters as query parameters.<br> Examples:<br>
    ```
    http://api.example.com/device-management/managed-devices
    http://api.example.com/device-management/managed-devices?region=USA
    http://api.example.com/device-management/managed-devices?region=USA&brand=XYZ
    http://api.example.com/device-management/managed-devices?region=USA&brand=XYZ&sort=installation-date
    ```
- **Consistent subdomain names should be used for your APIs**<br>
    The top-level domain and first subdomain names (e.g., soccer.restapi.org) of an API should identify its service owner. The full domain name of an API should add a subdomain named api.<br>
    For example:
    ```
    http://api.soccer.restapi.org
    ```
- **Consistent subdomain names should be used for your client developer portal**<br>
    Many REST APIs have an associated website, known as a developer portal.<br>
    For example:
    ```
    http://developer.soccer.restapi.org
    ```

### 3. Define API operations in terms of HTTP methods and HTTP response status codes
HTTP has defined few sets of methods which indicates the type of action to be performed on the resources.
_The URI is a sentence, where resources are nouns and HTTP methods are verbs._
The below table summarises the use of mostly-used HTTP methods and HTTP response status codes.

| HTTP Method  | CRUD           | Collection Resource (e.g. /users)                                                                      | Single Resource (e.g. /users/123)                                                |
| -------------|:--------------:| -------------------------------------------------------------------------------------------------------|:--------------------------------------------------------------------------------:|
| <b>POST</b>  | Create         | **201 (Created)**, ‘Location’ header with link to /users/{id} containing new ID; <p>**400 (Bad Request)**, if the server fails to parse the request body (the reason of development errors); <p>**409 (Conflict)**, if a request conflict with current state of the target resource; <p>**422 (Unprocessable Entity)**, if the server can't proccess request data due to validation errors caused by end client because of sending invalid fields.                            | Avoid using POST on a single resource                                            |
| <b>GET</b>   | Read           | **200 (OK)**, list of users. Use pagination, sorting, and filtering to navigate big lists;<br> <p>**403 (Forbidden)**, if user is authenticated, but it’s not allowed to access a resource; <p>**404 (Not Found)** if resources not found.                 | **200 (OK)**, single user.<br> <p>**404 (Not Found)** if resource not found or invalid ID               |
| <b>PUT</b>   | Update/Replace | **405 (Method not allowed)**, unless you want to update every resource in the entire collection of resource| **200 (OK)** if the response includes an updated entity;<br> <p>**400 (Bad Request)**, if the server fails to parse the request body (the reason of development errors); <p>**403 (Forbidden)**, if user is authenticated, but it’s not allowed to access a resource;<br> <p>**404 (Not Found)** if resource not found or invalid ID;<br> <p>**409 (Conflict)**, if there is a request conflict with current state of the target resource; |           **200 (OK)** if the response includes an entity describing the status; <p>**422 (Unprocessable Entity)**, if the server can't proccess request data due to validation errors caused by end client because of sending invalid fields.           
| <b>DELETE</b>| Delete         | **405 (Method not allowed)**, unless you want to delete the whole collection — use with caution            | **200 (OK)**, if the response includes an entity describing the status; <p>**202 (Accepted)**, if the action has been queued; <p>**204 (No Content)**, if the action has been performed but the response does not include an entity; <p>**404 (Not Found)**, if resource not found or invalid ID. <p>_Repeatedly calling DELETE API on that resource will not change the outcome – however, calling DELETE on a resource a second time will return a **404 (NOT FOUND)** since it was already removed._                            |

### 4. Allow filtering, sorting, pagination and searching
Complex result filters, sorting requirements, data pagination and advanced searching (when restricted to a single type of resource) can all be easily implemented as query parameters on top of the base URI.
- **Filtering:** Use a unique query parameter for each field that implements filtering. For example, when requesting a list of tickets from the **/tickets** endpoint, you may want to limit these to only those in the open state. This could be accomplished with a request like
    ```
    GET /tickets?state=open
    ```
    Where, **state** is a query parameter that implements a filter.
 
- **Sorting:** Similar to filtering, a generic parameter sort can be used to describe sorting rules. Accommodate complex sorting requirements by letting the sort parameter take in list of comma separated fields, each with a possible unary negative to imply descending sort order. Let's look at some examples:
    ```
    GET /tickets?sort=-priority  //retrieves a list of tickets in descending order of priority
    GET /tickets?sort=-priority,createdAt  //retrieves a list of tickets in descending order of priority. 
                                           //within a specific priority, older tickets are ordered first
    GET /users?sort=email&order=asc //sort by email in asc order
    GET /users?sort=email.asc //sort by email in asc order
    ```
- **Pagination:** When the dataset is too large, we divide the data set into smaller chunks, which helps in improving the performance and is easier to handle the response. 
Using Limit/Offset is the simplest form of paging. Limit/Offset became popular with apps using SQL databases which already have LIMIT and OFFSET as part of the SQL SELECT Syntax. <br> Example:
     ```
     GET /companies?limit=20 //get the list of first 20 companies
     GET /companies?limit=20&offset=20 //get next 20 companies
     GET /companies?limit=20&after_id=20 //get 20 companies after the id of ‘20’
     GET /companies?limit=20&after_id=20&sort_by=name //get 20 companies after the id of ‘20’ sorting by company name
     GET /companies?page=23 //get the list of companies on 23rd page.
     ```
- **Searching:** Sometimes basic filters aren't enough and you need the power of full text search. Perhaps you're already using ElasticSearch or another Lucene based search technology. When full text search is used as a mechanism of retrieving resource instances for a specific type of resource, it can be exposed on the API as a query parameter on the resource's endpoint. Let's say, Search queries should be passed straight to the search engine and API output should be in the same format as a normal list result.
Combining these together, we can build queries like:
    ```
    GET /tickets?sort=-updatedAt  //Retrieve recently updated tickets
    GET /tickets?state=closed&sort=-updatedAt  //Retrieve recently closed tickets
    GET /tickets?q=return&state=open&sort=-priority,createdAt  //Retrieve the highest priority open tickets 
                                                               //mentioning the word 'return'
     ```
     You can use more complex query for searching resources e.g. adding a range, conditional expressions for searching like:
     ```
     GET /items?price[gte]=10&price[lte]=100 //find all the items where the price is 
                                             //greater than or equal to 10, but less than or equal to 100.
     ```
    We can have as many operators as needed such as **[lte], [gte], [exists], [regex], [before], and [after]**. Brackets are a little harder to parse on server side, but provides greater flexibility in what the filter value is for clients. No need to handle special characters differently.
    Similar to the bracket approach, you can design an API to take the operator using colon symbol **:**.<br>
    For example:
    ```
    GET /items?price=gte:10&price=lte:100 //find all the items where the price is greater than 
                                          //or equal to 10, but less than or equal to 100.
    ```
    You can combine the two approaches (using bracket and colon symbol) to search for a resources.<br>
    Example:
    ```
    GET /items?q=title:red chair AND price:[10 TO 100] //search items for those that contain the terms red chair   
                                                       //and the price is greater than or equal to 10 and  less than or equal to 100
    ```
     If adding many query params in GET methods makes the URI too long, the server may respond with 414 URI Too long HTTP status. To avoid the issues you can store commonly - used queries on the server side and pass only the query alias as parameter or a part of path.
     
- **Use aliases for common queries:** To make the API experience more pleasant for the average consumer, consider packaging up sets of conditions into easily accessible RESTful paths. For example, the recently closed tickets query above could be packaged up as 
    ```
    GET /tickets/recently_closed //query alias in the path
    GET /tickets/?queryAlias=recently_closed //query alias as a parameter 
    ```
   Where recently_closed is the alias for a set of query parameters stored at the server side.
 
- **Limiting which fields are returned by the API:** The API consumer doesn't always need the full representation of a resource. The ability to select and chose returned fields goes a long way in letting the API consumer minimize network traffic and speed up their own usage of the API.
Use a fields query parameter that takes a comma separated list of fields to include. For example, the following request would retrieve just enough information to display a sorted listing of open tickets:
   ```
   GET /tickets?fields=id,subject,updated_at&state=open&sort=-updated_at
   ```
   **Note:** This approach can also be combined with with autoloading of related resources see below:
   ```
   GET /tickets?embed=customer&fields=id,customer.id,customer.name
   ```
- **Autoloading related resource representations:** There are many cases where an API consumer needs to load data related to (or referenced from) the resource being requested. Rather than requiring the consumer to hit the API repeatedly for this information, there would be a significant efficiency gain from allowing related data to be returned and loaded alongside the original resource on demand.
However, as this goes against some RESTful principles, You can minimize this deviation by only doing so based on an embed (or expand) query parameter.
In this case, embed would be a comma separated list of fields to be embedded. Dot-notation could be used to refer to sub-fields.<br>For example:
    ```
    GET /tickets/12?embed=customer.name,assigned_user
    ```
    This would return a ticket with additional details embedded, like:
    ```json
    {
      "id" : 12,
      "subject" : "I have a question!",
      "summary" : "Hi, ....",
      "customer" : {
        "name" : "Bob"
      },
      "assigned_user": {
       "id" : 42,
       "name" : "Jim"
      }
    }
    ```
    Of course, ability to implement something like this really depends on internal complexity. This kind of embedding can easily result in an **N+1 select issue**.

### 5. Handle errors gracefully and return standard error codes
To eliminate confusion for API users when an error occurs, we should handle errors gracefully and return HTTP response codes that indicate what kind of error occurred. This gives maintainers of the API enough information to understand the problem that’s occurred. We don’t want errors to bring down our system, so we can leave them unhandled, which means that the API consumer has to handle them. The API should always return sensible HTTP status codes. API errors typically break down into 2 types: **400 series status codes for client issues** & **500 series status codes for server issues**.<br>
Common error HTTP status codes include:
- **400 Bad Request** – This means that server fails to parse the request body (the reason of development errors). For example:Sending invalid JSON will result in a 400 Bad  Request response.Sending the wrong type of JSON values will result in a 400 Bad Request response. 
- **401 Unauthorized** – This means the user isn’t not authorized to access a resource. It usually returns when the user isn’t authenticated.
- **403 Forbidden** – This means the user is authenticated, but it’s not allowed to access a resource.
- **404 Not Found** – This indicates that a resource is not found.
- **406 Not Acceptable** – This indicates that the server cannot produce a response matching the list of acceptable values defined in the request's proactive content negotiation
                           headers, and that the server is unwilling to supply a default representation.
- **409 Conflict** – This indicates a request conflict with current state of the target resource. Conflicts are most likely to occur in response to a PUT or POST request when violating the resource constrains.
 - **422 Unprocessable Entity** – This indicates that the server understands the content type of the request entity, and the syntax of the request entity is correct, 
but it was unable to process the contained instructions.The Status code is used quite often to signify validation errors (end client errors).For example:Sending invalid fields will result in a 422 Unprocessable Entity response.
- **500 Internal server error** – This is a generic server error. It probably shouldn’t be thrown explicitly.
- **502 Bad Gateway** – This indicates an invalid response from an upstream server.
- **503 Service Unavailable** – This indicates that something unexpected happened on server side. It can be anything like server overload, some parts of the system failed.<br>

 We should be throwing errors that correspond to the problem that our app has encountered. Error codes need to have messages accompanied with them so that the maintainers have enough information to troubleshoot the issue.
 A response error body should provide a few things for the developer - a useful error message, a unique error code (that can be looked up for more details in the docs) and possibly a detailed description. Some examples:
```json
{
  "code" : 1234,
  "message" : "Something bad happened :(",
  "description" : "More details about the error here"
}
 ```
Validation errors for **PUT, PATCH and POST** requests will _**need a field breakdown**_. This is best modeled by using a fixed top-level error code for validation failures and providing the detailed errors in an additional errors field, like so:
```json
{
  "code" : 1024,
  "message" : "Validation Failed",
  "errors" : [
    {
      "code" : 5432,
      "field" : "first_name",
      "message" : "First name cannot have fancy characters"
    },
    {
       "code" : 5622,
       "field" : "password",
       "message" : "Password cannot be blank"
    }
  ]
}
```
Whenever our API does not successfully complete, we should fail gracefully by sending an error with information to help users make corrective action.

### 6. Secure REST APIs and maintain good security practices
Below given points may serve as a checklist for designing the security mechanism for REST APIs.

- **Keep it Simple**<br>
Secure an API/System – just how secure it needs to be. Every time you make the solution more complex “unnecessarily,” you are also likely to leave a hole.

- **Always Use HTTPS**<br>
Using SSL, the authentication credentials can be simplified to a randomly generated access token. The token is delivered in the username field of HTTP Basic Auth. 
It’s relatively simple to use, and you get a lot of security features for free.

- **Use Password Hash**<br>
Passwords must always be hashed to protect the system (or minimize the damage) even if it is compromised in some hacking attempts. There are many such hashing algorithms that can prove really effective for password security e.g. PBKDF2, bcrypt, and scrypt algorithms.

- **Never expose information on URIs**<br>
Usernames, passwords, session tokens, and API keys should not appear in the URI, as this can be captured in web server logs, which makes them easily exploitable.
    ```
    https://api.domain.com/user-management/users/{id}/someAction?apiKey=abcd123456789  //Very BAD !!
    ```
    The above URI exposes the API key. So, never use this form of security.

- **Consider OAuth:**<br>
Though basic auth is good enough for most of the APIs and if implemented correctly, it’s secure as well – yet you may want to consider OAuth as well.
The OAuth 2.0 authorization framework enables a third-party application to obtain limited access to an HTTP service, either on behalf of a resource owner by orchestrating an approval interaction between the resource owner and the HTTP service, or by allowing the third-party application to obtain access on its behalf.

- **Consider Adding Timestamp in Request:**<br>
Along with other request parameters, you may add a request timestamp as an HTTP custom header in API requests.
The server will compare the current timestamp to the request timestamp and only accepts the request if it is after a reasonable timeframe (30 seconds, perhaps).
This will prevent very basic replay attacks from people who are trying to brute force your system without changing this timestamp.

- **Input Parameter Validation:**<br>
Validate request parameters on the very first step, before it reaches application logic. Put strong validation checks and reject the request immediately if validation fails.
In API response, send relevant error messages and examples of correct input format to improve user experience.

### 7. Cache data to improve performance
Being cacheable is one of the architectural constraints of REST.

- **GET** requests should be cachable by default – until a special condition arises. Usually, browsers treat all GET requests as cacheable.
- **POST** requests are not cacheable by default but can be made cacheable if either an Expires header or a Cache-Control header with a directive, to explicitly allows caching, is added to the response.
- Responses to **PUT and DELETE** requests are not cacheable at all.<br>

Below given are main HTTP response headers that we can use to control caching behavior:
- **Expires**<br>
The Expires HTTP header specifies an absolute expiry time for a cached representation. Beyond that time, a cached representation is considered stale and must be re-validated with the origin server.
To indicate that a representation never expires, a service can include a time up to one year in the future.
    ```
    Expires: Fri, 20 May 2016 19:20:49 GMT
    ```
- **Cache-Control**<br>
The header value comprises one or more comma-separated directives. These directives determine whether a response is cacheable, and if so, by whom, and for how long e.g. max-age or s-maxage directives.
    ```
    Cache-Control: max-age=3600
    ```
Cacheable responses (whether to a GET or to a POST request) should also include a validator — either an ETag or a Last-Modified header.

- **ETag**<br>
An ETag value is an opaque string token that a server associates with a resource to uniquely identify the state of the resource over its lifetime.
When the resource changes, the ETag changes accordingly.
    ```
    ETag: "abcd1234567n34jv"
    ```
- **Last-Modified**<br>
Whereas a response’s Date header indicates when the response was generated, the Last-Modified header indicates when the associated resource last changed.
The Last-Modified value cannot be less than Date value.
    ```
    Last-Modified: Fri, 10 May 2016 09:17:49 GMT
    ```

### 8. Use HATEOAS to enable navigation to related resources
The single most important reason for HATEOAS is **loose coupling**. If a consumer of a REST service needs to hard-code all the resource URIs, then it is tightly coupled with your service implementation. Instead, if you return the URIs, it could use for the actions, then it is loosely coupled. There is no tight dependency on the URI structure, as it is specified and used from the response. When you design a RESTful service, there is a need to specify how to return data and links corresponding to a request. HATEOAS is a simple way that gives an easy, consistent way to hyperlink between resources in your REST API.