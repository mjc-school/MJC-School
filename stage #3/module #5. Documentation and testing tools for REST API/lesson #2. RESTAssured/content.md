# REST Assured

This is a series of Rest Assured Tutorial which is one of the most used library for REST API Automation Testing. Rest-Assured is a Java-based library that is used to test RESTful Web Services. This library behaves like a headless Client to access REST web services. You can create highly customize-able HTTP Requests to send to the Restful server. This enables you to test a wide variety of Request combinations and in turn test different combinations of core business logic.

Rest-Assured library also provides the ability to validate the HTTP Responses received from the server. You can verify the Status code, Status message, Headers and even the Body of the response. This makes Rest-Assured a very flexible library that can be used for testing.

## How to write REST API test using Rest Assured?

REST Assured is widely used to test JSON and XML-based web applications. In addition, it fully supports all REST methods like the GET, PUT, POST, PATCH, and DELETE.

In order to test REST API using REST Assured you should follow the steps:

Use the RestAssured class to generate a RequestSpecification for the URL: e.g. http://news.mjc/api/v1/news
1. Specify the HTTP Method type (any of HTTP methods).
2. Send the Request to the server.
3. Get the Response back from the server.
4. Check the status code of returned response and response’s body.

Below given is the complete code for the above steps:

```Java
public class RestAssuredAPITest {

    private final String SECURITY_TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6InRlc3RpbmcxMjMiLCJwYXNzd29yZCI6IlBhc3N3b3JkQDEiLCJpYXQiOjE2Mjg1NjQyMjF9.lW8JJvJF7jKebbqPiHOBGtCAus8D9Nv1BK6IoIIMJQ4";
    private final String BASE_URI = "http://localhost:8080";
    private final String REQUEST_MAPPING_URI = "/api/v1/news";
    private final int EXPECTED_NEWS_CONTENT = "Financial News";
    private final ObjectMapper mapper = new ObjectMapper();

    private int newsID;
    
    @Injected
    private final NewsService newsService;

    @BeforeEach
    void setUp() {
        //Create a piece of news for the testing purpose.
        News news = new News(EXPECTED_NEWS_CONTENT);
        News createdNews = newsService.create(news);
        newsID = createdNews.getId();
    }

    @AfterEach
    void tearDown() {
        //Delete a piece of news for executing a test.
        newsService.delete(news);
    }
 
    @Test
    public void GetAllNewsTest() { 
        private final int EXPECTED_STATUS_CODE = 200;
        
        // Specify the base URL to the RESTful service
        RestAssured.baseURI = BASE_URI + REQUEST_MAPPING_URI; 
	
        // Get the RequestSpecification of the request to be sent to the server. 
        RequestSpecification httpRequest = RestAssured.given().header("Authorization", "Bearer " + SECURITY_TOKEN)
            .header("Content-Type", "application/json");
	
        // Specify the method type (GET) and the parameters if any. 
        //In this case the request does not take any parameters 
        Response response = httpRequest.request(Method.GET, "");

        //Converting the response body to string
        String responseBodyAsString = response.asString();
	
        // Verify the status and body of the response received from the server
        assertEquals(EXPECTED_STATUS_CODE, response.getStatusCode());
        assertNotNull(responseBodyAsString);     
    }

    @Test 
    public void GetNewsByIdTest() {
        private final int EXPECTED_STATUS_CODE = 200;
       
        // Specify the base URL to the RESTful service 
        RestAssured.baseURI = BASE_URI;

        // Get the RequestSpecification of the request to be sent to the server. 
        RequestSpecification httpRequest = RestAssured.given().header("Authorization", "Bearer " + SECURITY_TOKEN)
                .header("Content-Type", "application/json");

        // Specify the method type (GET) and the parameters if any. 
        //In this case the request does not take any parameters 
        Response response = httpRequest.get(REQUEST_MAPPING_URI + "/" + newsID);

        //Converting the response body to string
        String responseBodyAsString = response.asString();

        //Deserializing JSON response body to News object
        News news = mapper.readValue(responseBodyAsString, News.class);

        // Verify the status and body of the response received from the server
        assertEquals(EXPECTED_STATUS_CODE, response.getStatusCode());
        assertEquals(newsID, news.getId());
        assertEquals(EXPECTED_NEWS_CONTENT, news.getContent());
    }

    @Test
    public void CreateNewsTest() {
        private final int EXPECTED_STATUS_CODE = 201;
        private final int EXPECTED_CONTENT_OF_NEWLY_CREATED_NEWS = "Political News";

        // Specify the base URL to the RESTful service 
        RestAssured.baseURI = BASE_URI;

        // Get the RequestSpecification of the request to be sent to the server. 
        RequestSpecification httpRequest = RestAssured.given().header("Authorization", "Bearer " + SECURITY_TOKEN)
                .header("Content-Type", "application/json");

        //Create a piece of news object.
        News news = new News(EXPECTED_CONTENT_OF_NEWLY_CREATED_NEWS);

        //Serialize a piece of news object to json string.
        String news = mapper.writeValueAsString(news);

        // Send the put request to update a piece of news.
        Response response = httpRequest.body(news).post(REQUEST_MAPPING_URI);

        //Converting the response body to string
        String responseBodyAsString = response.asString();

        //Deserializing JSON response body to News object
        News createdNews = mapper.readValue(responseBodyAsString, News.class);

        // Verify the status and body of the response received from the server
        assertEquals(EXPECTED_STATUS_CODE, response.getStatusCode());
        assertEquals(newsID, createdNews.getId());
        assertEquals(EXPECTED_CONTENT_OF_NEWLY_CREATED_NEWS, createdNews.getContent());
        
        //Delete the created news for cleaning testing database after the test.
        newsService.delete(createdNews.getId());
    }


    @Test
    public void UpdateNewsTest() {
        private final int EXPECTED_STATUS_CODE = 200;
        private final int EXPECTED_NEWS_CONTENT_AFTER_UPDATE = "Updated Financial News";

        // Specify the base URL to the RESTful service 
        RestAssured.baseURI = BASE_URI;

        // Get the RequestSpecification of the request to be sent to the server. 
        RequestSpecification httpRequest = RestAssured.given().header("Authorization", "Bearer " + SECURITY_TOKEN)
                .header("Content-Type", "application/json");

        //Create a piece of news object with new content.
        News newsWithNewContent = new News(newsID, EXPECTED_NEWS_CONTENT_AFTER_UPDATE);
        
        //Serialize a piece of news object with new content to json string.
        String newsWithNewContentAsJson = mapper.writeValueAsString(news);
        
        // Send the put request to update a piece of news.
        Response response = httpRequest.body(newsWithNewContentAsJson).put(REQUEST_MAPPING_URI + "/" + newsID);

        //Converting the response body to string
        String responseBodyAsString = response.asString();

        //Deserializing JSON response body to News object
        News updatedNews = mapper.readValue(responseBodyAsString, News.class);

        // Verify the status and body of the response received from the server
        assertEquals(EXPECTED_STATUS_CODE, response.getStatusCode());
        assertEquals(newsID, updatedNews.getId());
        assertEquals(EXPECTED_NEWS_CONTENT_AFTER_UPDATE, updatedNews.getContent());
    }

    @Test
    public void DeleteNewsTest() {
        private final int EXPECTED_STATUS_CODE = 204;
     
        // Specify the base URL to the RESTful service
        RestAssured.baseURI = BASE_URI;

        // Get the RequestSpecification of the request to be sent to the server. 
        RequestSpecification httpRequest = RestAssured.given().header("Authorization", "Bearer " + SECURITY_TOKEN);

        // Send the request to delete resource. 
        Response response = httpRequest.delete(REQUEST_MAPPING_URI + "/" + newsID);

        // Verify the status and body of the response received from the server
        assertEquals(EXPECTED_STATUS_CODE, response.getStatusCode());
    }
}
```

More information here https://www.toolsqa.com/rest-assured/rest-assured-library/.