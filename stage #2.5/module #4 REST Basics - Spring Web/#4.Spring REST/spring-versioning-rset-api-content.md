## Versioning a REST API

There are some ways of versioning REST API. Let's consider the high level approaches to versioning the REST API:
- **URI Versioning** – version the URI space using version indicators.
- **Versioning using Accept Header** – version REST API using Media Type.
- **Versioning using Custom Header** - version REST API using custom http header.
- **Versioning using URI parameter** - version REST API using URI query parameter.

## 1. URI Versioning

**When we introduce the version in the URI space, the Representations of Resources are considered immutable.**<BR>
So when changes need to be introduced in the API, a new URI space needs to be created.
For example, say an API publishes the following resources – users and privileges:
```
http://host/v1/users
http://host/v1.0/books
```
If you make a breaking changes in the users and book API requires introducing a second version like this:
```
http://host/v2/users
http://host/v2/privileges
```

## 2. Versioning using Accept Header
Content negotiation using **HTTP Accept header** can be used for the REST API versioning. To handle versioning,
REST API would use MIME type to determine the API versioning.
```
Accept: application/vnd.javadevjournal.v2+json
Accept: application/vnd.javadevjournal+json;version=1.0
```
it is important to understand here is that the client makes no assumptions about the structure of the response
beyond what it define in the media type.
The response:
```
############## GET Request for Products ##############
GET /products/228781 HTTP/1.1
Accept: application/vnd.javadevjournal.v1+json

############## Response ##############
HTTP/1.1 200 OK
Content-Type: application/vnd.javadevjournal.v1+json
{
"product": {
"code": "228781",
"name": "Running shoes",
"description": "one of the best running shoes"
}
}
```

## 3. Versioning using Custom Header
You can use a custom header for handling API versioning.
The example:
```
Accept-version: v1
Accept-version: v2
```

## 4. Versioning using URI parameter
This is the least used method to version your REST API. Append version as a query parameter.
The example:
```
http://host/shopping?version=2.0
http://host/catalog/titles/series/70023522?v=1.5
```

If REST API client tries to use old API, the system should return **HTTP 410 status code**.
**HTTP 410 Gone status code** indicates that access to the target resource is no longer available at the origin server and that this condition is likely to be permanent.


