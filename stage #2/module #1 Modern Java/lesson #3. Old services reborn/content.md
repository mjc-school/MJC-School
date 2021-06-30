# Old services reborn

## Materials
- Date and Time API
- HTTP Client

## Date and Time API

Java 8 introduced new classes for date and time to resolve the long-standing issues of existing APIs: java.util.Date and Java.util.Calendar. These newly introduced immutable-value classes are easy-to-use, well-documented, and thread-safe.

In this chapter, we will look at all Java 8 new date and time APIs in detail with examples. 
Let start with the issues in the existing Date and Calendar classes and how the newly introduced classes addressed these shortcomings.

<b>Why Java 8 new Date & Time API?</b>

Date and time API was specifically launched to address the following issues with the current date and time API:

+ <b>*Thread-Safety*</b> - both java.util.Date and java.util.Calendar classes are not thread-safe. Therefore, developers have to deal with concurrency issues by writing additional codes. The new date and time APIs are immutable and thread-safe.


+ <b>*Easier to Use & Understand*</b> - The old APIs are poorly designed with little to no direct methods for common date operations. The new date and time APIs provide a consistent and easier-to-user interface for dealing with dates, times, durations, and periods. There are a lot of utility methods included in the new API for common date and time tasks.


+ <b>*Better Time Zone Handling*</b> - Old APIs do not provide any direct way to handle different timezones. Developers were forced to write additional logic to deal with timezone issues. New date and time API separated both local and zoned date times handling into two different categories. Thus, making it easier to handle different timezones without writing extra codes.

Here is a short summary of the new date and time APIs we will cover:

- <b>Local Date & Time API:</b> Local date and time API is intended to use for local date and time operations when you no longer required the timezone information. LocalDate, LocalTime, and LocalDateTime classes are a part of the local API. 
- <b>Zoned Date & Time API:</b> Java 8 introduced ZonedDateTime and OffsetDateTime classes along with ZoneId and ZonedOffset identifiers for handling date and time with timezone information. 
- <b>Instant API:</b> The instant class is added to Java 8 new date and time API to represent a specific moment on the timeline. 
- <b>Period & Duration API:</b> To work with date and time differences, Java 8 new date and time API introduced Period and Duration classes. These classes can be used to represent an amount of time in terms of different units like days, months, years, hours, minutes, etc. 
- <b>Chrono Units Enum:</b> The ChronoUnit enum replaced the legacy integer values that were in old API to represent different date and time units. 
- <b>Temporal Adjusters:</b> Temporal adjusters are another useful feature to perform date and time calculations in Java 8 and higher. 
- <b>Date and Time Formatting:</b> To format the date and time output, Java 8 new date and time API introduced format() method. 
- <b>Backward Compatibility:</b> To keep the new date and time API backward compatible, Java 8 has added toInstant() method to existing Date and Calendar classes.

Let stars with *LocalDate*, *LocalTime*, and *LocalDateTime* classes. As their names suggest, these classes are intended to use for local date and time operations without timezones. You should use them when timezones are no longer required.

<b>LocalDate Class</b>

The LocalDate class represents a date without time in the ISO-8601 format (yyyy-MM-dd). This class does not store or represent a time or time-zone. Instead, it is a description of the date, as used for birthdays and anniversaries.

To create an instance of current local date* from the system clock, you can use LocalDate.now() static method:

    LocalDate now = LocalDate.now();

To create an instance for a specific day, month, and year, you can use LocalDate.of() method:

    LocalDate localDate = LocalDate.of(2019, 12, 20);

To convert a string representation of ISO-8601 format to date, you can use LocalDate.parse() method:

    LocalDate localDate = LocalDate.parse("2019-12-20");

The LocalDate class offers various <b>*utility methods*</b> that can be used to access different types of information. For example, the following code snippet shows how you can get the current local date and then add or subtract days:

    LocalDate tomorrow = LocalDate.now().plusDays(1);
    LocalDate yesterday = LocalDate.now().minusDays(1);

Just like days, you can also add or minus months and years:

    LocalDate lastMonth = LocalDate.now().minusMonths(1);
    // OR        
    LocalDate lastMonth = LocalDate.now().minus(1, ChronoUnit.MINUTES);

Here is an example that shows how you can obtain the day of the week and the day of the month from an instance of LocalDate:

    // get day of week
    DayOfWeek day = LocalDate.now().getDayOfWeek();
    
    // get day of month
    int month = LocalDate.parse("2020-01-12").getDayOfMonth();

To check if the current year is leap year, you can do the following:

    boolean isLeap = LocalDate.now().isLeapYear();

You can also compare two local dates by using isBefore() and isAfter() methods as shown below:

    // create local dates
    LocalDate date1 = LocalDate.parse("2019-08-02");
    LocalDate date2 = LocalDate.parse("2018-01-45");

    // check if `date1` is before `date2`
    boolean isBefore = date1.isBefore(date2);

    // check if `date1` is after `date2`
    boolean isAfter = date1.isAfter(date2);

You can use LocalDate to obtain different date boundaries such as the first day of the month, the start of the day (returns a LocalDateTime instance), and more. Here is an example:

    // get start of the day
    LocalDateTime startOfDay = LocalDate.now().atStartOfDay();
    
    // get first day of the month
    LocalDate firstDayOfMonth = LocalDate.parse("2019-12-18")
    .with(TemporalAdjusters.firstDayOfMonth());

<b>LocalTime Class</b>

The LocalTime class represents a time without any date or timezone information in the ISO-8601 calendar system. This class does not store or represent a date or time-zone. Instead, it is a description of the local time as seen on a wall clock.

Just like LocalDate, you can use create an instance of LocalTime from the system clock, parse a string, or specify time units manually:

    // use system clock
    LocalTime now = LocalTime.now();
    
    // parse a string
    LocalTime parseTime = LocalTime.parse("02:08");
    
    // specify hour-minute-second - 08:45:20 AM
    LocalTime specificTime = LocalTime.of(8, 45, 20);

Similarly, you can use also add or minus hours, minutes, seconds, or even nanoseconds:

    // past hour
    LocalTime pastHour = LocalTime.now().minusHours(1);
    
    // add minutes - can be replaced with `plusMinutes()`
    LocalTime addMinutes = LocalTime.now().plus(15, ChronoUnit.MINUTES);

The LocalTime class provides various <b>*utility methods*</b>:

    // get different units of the time
    int hour = LocalTime.now().getHour();
    int minutes = LocalTime.now().getMinute();
    int seconds = LocalTime.now().getSecond();
    int nanoseconds = LocalTime.now().getNano();
    
    // compare two local times
    LocalTime time1 = LocalTime.parse("05:15");
    LocalTime time2 = LocalTime.parse("21:00");
    boolean isBefore = time1.isBefore(time2); // is `time1` before `time2`?

LocalTime also provides various constants to get maximum, minimum, or noon time of a day as shown below:

    // get max time (23:59:59.999999999)
    LocalTime max = LocalTime.MAX;
    
    // get min time (00:00)
    LocalTime min = LocalTime.MIN;
    
    // the time of noon (12:00)
    LocalTime noon = LocalTime.NOON;
    
    // time of midnight (00:00)
    LocalTime midnight = LocalTime.MIDNIGHT;

<b>LocalDateTime Class</b>

LocalDateTime is the most commonly used class of Java 8 new data and time API for handling both date and time together. This class provides a range of utility methods for various date and time operations.

To create a new instance of LocalDateTime, you can either use the system clock, parse a string, or manually define date and time units as shown below:

    // use system clock
    LocalDateTime now = LocalDateTime.now();
    
    // parse a string
    LocalDateTime parseDT = LocalDateTime.parse("2019-08-02T15:20");
    
    // specify data and time units
    LocalDateTime specificDT = LocalDateTime.of(2019, Month.AUGUST, 2, 15, 20);

Just like in *LocalDate* and *LocalTime*, you can add or subtract different date and time units from LocalDateTime as shown below:

    // yesterday
    LocalDateTime yesterday = LocalDateTime.now().minusDays(1);
    
    // subtract one year from a specific date and time
    LocalDateTime lastYear = LocalDateTime.parse("2019-08-02T15:20")
    .minus(1, ChronoUnit.YEARS);
    
    // add 4 hours to the current date and time
    LocalDateTime nextHour = LocalDateTime.now().plusHours(4);

Also LocalDateTime also provides getter and compare methods:

    // get month, hour
    Month month = LocalDateTime.now().getMonth();
    int hour = LocalDateTime.now().getHour();
    
    // compare
    LocalDateTime dt1 = LocalDateTime.parse("2019-08-08T05:10");
    LocalDateTime dt2 = LocalDateTime.parse("2019-10-29T23:45");
    boolean isAfter = dt1.isAfter(dt2); // check if `dt1` is after `dt2`

<b>Zoned Date & Time API</b>

The *ZonedDateTime* and *ZoneId* classed were added new date and time API to deal with situations where you can need the timezone information.

The *ZoneId* is an identifier that is used to identity different timezones. There are around 40 different timezones provided by ZoneId.

    ZoneId paris = ZoneId.of("Europe/Paris");
    ZoneId karachi = ZoneId.of("Asia/Karachi");
    
    // get all available zones
    Set<String> zones = ZoneId.getAvailableZoneIds();

The *ZonedDateTime* class represents a date-time with a timezone in the ISO-8601 format (e.g. 2019-12-20T10:15:30+05:00 Asia/Karachi)

Obtain the current date-time from the system clock:

    ZonedDateTime now = ZonedDateTime.now();

An instance of LocalDateTime can also be converted to a specific zone to create a new ZonedDateTime:

    ZonedDateTime zonedDT = ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("Europe/Paris"));

ZonedDateTime has some methods which we covered in local date & time API:

    // create a zoned date and time instance of a string
    ZonedDateTime zonedDT = ZonedDateTime.parse("2019-12-20T10:15:30+05:00[Asia/Karachi]");
    
    // add 2 months to a specific zoned date and time
    ZonedDateTime addMonths = ZonedDateTime.parse("2019-12-20T10:15:30+05:00[Asia/Karachi]")
    .plusMonths(2);
    
    // subtract one year from now
    ZonedDateTime lastYear = ZonedDateTime.now().minus(1, ChronoUnit.YEARS);
    
    // getters
    Month month = ZonedDateTime.now().getMonth();
    int year = ZonedDateTime.now().getYear();
    
    // compare two ZonedDateTime instances
    ZonedDateTime dt1 = ZonedDateTime.parse("2019-12-20T10:15:30+01:00[Europe/Paris]");
    ZonedDateTime dt2 = ZonedDateTime.parse("2017-03-05T02:45:15+00:00[Europe/London]");
    boolean isAfter = dt1.isAfter(dt2); // check if `dt1` is after `dt2`

Another way to deal with zoned date and time is by using the *ZoneOffset* and *OffsetDateTime* classes.

*ZonedOffset* is an extension of ZoneId that stores the amount of time that a timezone differs from Greenwich/UTC.
This is usually a fixed number of hours and minutes.

    ZoneOffset offset = ZoneOffset.of("+04:00");

The *OffsetDateTime* class represents a date and time with an offset from UTC/Greenwich in the ISO-8601 calendar system such as 2019-12-03T10:15:30+01:00. 

This class stores all date and time fields, to a precision of nanoseconds, as well as the offset from UTC/Greenwich.

To create a new instance of OffsetDateTime, you can either use the system clock, parse a string, or convert local data time to zoned date time with ZonedOffset:
    
    // use system clock
    OffsetDateTime now = OffsetDateTime.now();

    // use local date and time with `ZonedOffset`
    ZoneOffset offset = ZoneOffset.of("+04:00");
    LocalDateTime localDateTime = LocalDateTime.of(2019, Month.JULY, 17, 11, 30);
    
    OffsetDateTime offsetDT = OffsetDateTime.of(localDateTime, offset);
    
    // parse a string
    OffsetDateTime parseOffsetDT = OffsetDateTime.parse("2019-12-03T10:15:30+01:00");

Just like ZonedDateTime, you can use utility methods from OffsetDateTime to get different units, add or subtract date and time units, and to perform a comparison between two instances.

<b>Instant API</b>

The *Instant* class is used to represents a specific moment on the time line (1970-01-01 00:00:00).

To create an instance of Instant API, you can either use the system clock or parse UNIX timestamp or a date string:

    // use system clock
    Instant now = Instant.now();
    
    // parse ISO 8601 string
    Instant parseISO = Instant.parse("2019-08-08T12:58:00Z");
    
    // parse UNIX timestamp - 2019-09-04T01:54:18Z
    Instant parseUnix = Instant.ofEpochSecond(1567562058);
    
    // same time in milliseconds
    Instant parseMillis = Instant.ofEpochMilli(1567562058000L);

The Instant class also provides several utility methods to make calculations relative to an Instant:

    // add 10 seconds
    Instant addSeconds = Instant.now().plusSeconds(10);
    
    // minus milliseconds
    Instant minusMillis = Instant.now().minus(500, ChronoUnit.MILLIS);

<b>Period and Duration API </b>

New date and time API introduced two classes (Period and Duration) to work with the date and time differences.

The *Period* class represents an amount of time in terms of years, months, and days. It is commonly used to modify an existing date object values as well as to get the difference between two dates.

    // future local date
    LocalDate futureDate = LocalDate.now().plus(Period.ofDays(5));
    
    // past local date
    LocalDate pastDate = LocalDate.now().minus(Period.ofWeeks(1));
    
    // period of specific months and days
    LocalDate specificDate = LocalDate.now().plus(Period.ofMonths(2).plusDays(15));

Similarly, you can also use the Period class to get the difference between two dates:

    LocalDate firstDate = LocalDate.of(2020, Month.JULY, 5); // 2020-07-05
    LocalDate secondDate = LocalDate.of(2021, Month.DECEMBER, 20); // 2021-12-20
    
    // difference between two dates
    Period period = Period.between(firstDate, secondDate);
    
    int days = period.getDays(); // 15
    int months = period.getMonths(); // 5
    int years = period.getYears(); // 1
    boolean isNegative = period.isNegative(); // false
    boolean isZero = period.isZero(); // false

Alternatively, you can use the *ChronoUnit* class to obtain the period between two dates in a specific unit such as days or month or years:

    long days = ChronoUnit.DAYS.between(firstDate, secondDate); // 533
    long months = ChronoUnit.MONTHS.between(firstDate, secondDate); // 17
    long years = ChronoUnit.YEARS.between(firstDate, secondDate); // 1

The *Duration* class represents an amount of time in terms of days, hours, seconds, milliseconds, and nanoseconds. It can be used to modify existing time values as well as to get the difference between two times.

    // future local time
    LocalTime futureTime = LocalTime.now().plus(Duration.ofHours(5));
    
    // past local time
    LocalTime pastTime = LocalTime.now().minus(Duration.ofDays(1));
    
    // duration of specific days and hours
    LocalTime specificTime = LocalTime.now().plus(Duration.ofDays(7).plusHours(3));

The Duration between two times can be obtained either as an instance of Duration or as a specific unit (ChronoUnit):

    LocalTime firstTime = LocalTime.of(11, 30); // 11:30
    LocalTime secondTime = LocalTime.of(22, 35); // 22:35
    
    // Duration
    // get difference between times
    Duration duration = Duration.between(firstTime, secondTime);
    long millis = duration.toMillis(); // 39900000
    long seconds = duration.getSeconds(); // 39900
    long minutes = duration.toMinutes(); // 665
    long hours = duration.toHours(); // 11

    // ChronoUnit
    long seconds = ChronoUnit.SECONDS.between(firstTime, secondTime); // 39900
    long minutes = ChronoUnit.MINUTES.between(firstTime, secondTime); // 665
    long hours = ChronoUnit.HOURS.between(firstTime, secondTime); // 11

<b>Chrono Units Enum</b>

The *ChronoUnit* enum represents individual date and time units such as day, month, year, week, hour, minutes, and more. It replaces the integer values used in the old API to represent these units.

Here is an example that demonstrates how you can use ChronoUnit for different tasks:

    // the current date
    LocalDate today = LocalDate.now();
    System.out.println("Current Date: " + today);
    
    // next week
    LocalDate nextWeek = today.plus(1, ChronoUnit.WEEKS);
    System.out.println("Next Week: " + nextWeek);
    
    // next century
    LocalDate nextCentury = today.plus(1, ChronoUnit.CENTURIES);
    System.out.println("Next Century: " + nextCentury);

The above code will produce the following output:

    Current Date: 2021-06-29
    Next Week: 2019-07-06
    Next Century: 2121-06-29

<b>Temporal Adjusters</b>

Temporal adjusters are highly useful for performing different calculations on date and time. You can use them to modify temporal objects and answer questions like find the next Friday, find the second Tuesday of the month, etc.

Here is how you can use it:

    // the current date
    LocalDate today = LocalDate.now();
    
    // first day of month
    LocalDate firstDay = today.with(TemporalAdjusters.firstDayOfMonth());
    
    // next Tuesday
    LocalDate nextTuesday = today.with(TemporalAdjusters.next(DayOfWeek.TUESDAY));
    
    // last day of year
    LocalDate lastDayofYear = today.with(TemporalAdjusters.lastDayOfYear());
    
    // last Friday of month
    LocalDate lastFridayOfMonth = today.with(TemporalAdjusters.lastInMonth(DayOfWeek.FRIDAY));

<b>Date and Time Formatting</b>

Just like the parse() method to convert a string to an instance of date and time, Java 8 new date and time API also provides the format() method for formatting the output.

The below example shows how you can format an instance of LocalDateTime in ISO formats:

    LocalDateTime date = LocalDateTime.of(2021, Month.DECEMBER, 18, 9, 45);
    
    // ISO date format (yyyy-MM-dd) - 2021-12-18
    String isoDate = date.format(DateTimeFormatter.ISO_DATE);
    
    // ISO date and time format - 2019-12-18T09:45:00
    String isoDateTime = date.format(DateTimeFormatter.ISO_DATE_TIME);

Custom formatting patterns can also be provided to format() method as shown below:

    // custom format pattern (MM/dd/yyyy HH:mm a) - 12/18/2019 09:45 AM
    String customFormat = date.format(DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm a"));

We can also pass in the formatting style like SHORT, MEDIUM or LONG as part of the formatting pattern as shown below:

    // formatting style MEDIUM - Dec 18, 2019 9:45:00 AM
    String customFormat = date.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)
    .withLocale(Locale.US));

<b>Backward Compatibility</b>

Java 8 has added toInstant() method to the legacy Date and Calendar classes. It can be used to convert a Date or Calendar instance to a new date and time API instance.

The following example shows how you can use ofInstant() to convert a legacy Date object to a LocalDateTime and ZonedDateTime objects:

    // current date and time
    Date date = new Date();
    
    // get the Instant of current date (in millis)
    Instant now = date.toInstant();
    
    // convert instant to local date/time
    LocalDateTime localDT = LocalDateTime.ofInstant(now, ZoneId.systemDefault());
    
    // convert instant to zoned date/time
    ZonedDateTime zonedDT = ZonedDateTime.ofInstant(now, ZoneId.systemDefault());

In this in-depth chapter, we looked at Java 8 new date and time API in detail with examples. Java 8 new date and time APIs are not only thread-safe but also developer-friendly with easier-to-use utility methods and far better zoned date-time handling.

## HTTP Client

In this chapter, we'll explore Java 9's new incubating HttpClient.

Until very recently, Java provided only the HttpURLConnection API – which is low-level and isn't known for being feature-rich and user-friendly.

Before delving into HttpClient let's remind what HTTP is.

> The Hypertext Transfer Protocol (HTTP) is an application protocol for distributed, collaborative, hypermedia information systems. HTTP is the foundation of data communication for the World Wide Web.

The Java HTTP Client supports both HTTP/1.1 and HTTP/2. By default, the client will send requests using HTTP/2. Requests sent to servers that do not yet support HTTP/2 will automatically be downgraded to HTTP/1.1.

The API consists of 3 core classes:

+ HttpRequest – represents the request to be sent via the HttpClient 
+ HttpClient – behaves as a container for configuration information common to multiple requests
+ HttpResponse – represents the result of an HttpRequest call

First, let's focus on a request.

<b>HttpRequest</b>

HttpRequest, as the name suggests, is an object which represents request we want to send. New instances can be created using *HttpRequest.Builder*.

We can get it by calling HttpRequest.newBuilder(). Builder class provides a bunch of methods which we can use to configure our request.

*Setting URI*

The first thing we have to do when creating a request is to provide the URL.

We can do that in two ways – by using the constructor for Builder with URI parameter or by calling method uri(URI) on the Builder instance:

    HttpRequest.newBuilder(new URI("https://postman-echo.com/get"))
    
    HttpRequest.newBuilder()
    .uri(new URI("https://postman-echo.com/get"))

*Specifying the HTTP Method*

We can define the HTTP method which our request will use by calling one of the methods from Builder:

+ GET()
+ POST(BodyProcessor body)
+ PUT(BodyProcessor body)
+ DELETE(BodyProcessor body)

We'll cover BodyProcessor later. Now, let's just create a very simple GET request example:

    HttpRequest request = HttpRequest.newBuilder()
    .uri(new URI("https://postman-echo.com/get"))
    .GET()
    .build();

*Setting HTTP Protocol Version*

The API fully leverages the HTTP/2 protocol and uses it by default but we can define which version of the protocol we want to use.

    HttpRequest request = HttpRequest.newBuilder()
    .uri(new URI("https://postman-echo.com/get"))
    .version(HttpClient.Version.HTTP_2)
    .GET()
    .build();

*Setting Headers*

In case we want to add additional headers to our request, we can use the provided builder methods.

We can do that in one of two ways:

+ passing all headers as key-value pairs to the headers() method or by 
+ using header() method for the single key-value header:


    HttpRequest request = HttpRequest.newBuilder()
    .uri(new URI("https://postman-echo.com/get"))
    .headers("key1", "value1", "key2", "value2")
    .GET()
    .build();
    
    HttpRequest request2 = HttpRequest.newBuilder()
    .uri(new URI("https://postman-echo.com/get"))
    .header("key1", "value1")
    .header("key2", "value2")
    .GET()
    .build();

*Setting a Timeout*

Let's now define the amount of time we want to wait for a response.

If the set time expires, a HttpTimeoutException will be thrown; the default timeout is set to infinity.

The timeout can be set with the Duration object – by calling method timeout() on the builder instance:

    HttpRequest request = HttpRequest.newBuilder()
    .uri(new URI("https://postman-echo.com/get"))
    .timeout(Duration.of(10, SECONDS))
    .GET()
    .build();

*Setting a Request Body*

We can add a body to a request by using the request builder methods: POST(BodyProcessor body), PUT(BodyProcessor body) and DELETE(BodyProcessor body).

The new API provides a number of BodyProcessor implementations out-of-the-box which simplify passing the request body:

+ StringProcessor - reads body from a String, created with HttpRequest.BodyProcessor.fromString()
+ InputStreamProcessor - reads body from an InputStream, created with HttpRequest.BodyProcessor.fromInputStream()
+ ByteArrayProcessor - reads body from a byte array, created with HttpRequest.BodyProcessor.fromByteArray()
+ FileProcessor - reads body from a file at the given path, created with HttpRequest.BodyProcessor.fromFile()

In case we don't need a body, we can simply pass in an HttpRequest.noBody():

    HttpRequest request = HttpRequest.newBuilder()
    .uri(new URI("https://postman-echo.com/post"))
    .POST(HttpRequest.noBody())
    .build();

Setting a request body with any BodyProcessor implementation is very simple and intuitive.

For example, if we want to pass a simple String as a body, we can use StringBodyProcessor.

As we already mentioned, this object can be created with a factory method fromString(); it takes just a String object as an argument and creates a body from it:

    HttpRequest request = HttpRequest.newBuilder()
    .uri(new URI("https://postman-echo.com/post"))
    .headers("Content-Type", "text/plain;charset=UTF-8")
    .POST(HttpRequest.BodyProcessor.fromString("Sample request body"))
    .build();

Here examples with other processors:

    // InputStreamBodyProcessor
    byte[] sampleData = "Sample request body".getBytes();
    ...
    .POST(HttpRequest.BodyProcessor.fromInputStream(
                () -> new ByteArrayInputStream(sampleData)))

    // ByteArrayProcessor
    .POST(HttpRequest.BodyProcessor.fromByteArray(sampleData))

    // FileProcessor
    .POST(HttpRequest.BodyProcessor.fromFile(
            Paths.get("src/test/resources/sample.txt")))

<b>HttpClient</b>

All requests are sent using HttpClient which can be instantiated using the HttpClient.newBuilder() method or by calling HttpClient.newHttpClient().

It provides a lot of useful and self-describing methods we can use to handle our request/response.

*Setting a Proxy*

We can define a proxy for the connection. Just merely call proxy() method on a Builder instance:

    HttpResponse<String> response = HttpClient
    .newBuilder()
    .proxy(ProxySelector.getDefault())
    .build()
    .send(request, HttpResponse.BodyHandler.asString());

*Setting the Redirect Policy*

Sometimes the page we want to access has moved to a different address.

In that case, we'll receive HTTP status code 3xx, usually with the information about new URI. <b>*HttpClient can redirect the request to the new URI automatically if we set the appropriate redirect policy.*</b>

    HttpResponse<String> response = HttpClient.newBuilder()
    .followRedirects(HttpClient.Redirect.ALWAYS)
    .build()
    .send(request, HttpResponse.BodyHandler.asString());

All policies are defined and described in enum HttpClient.Redirect.

*Setting Authenticator for a Connection*

An Authenticator is an object which negotiates credentials (HTTP authentication) for a connection. It provides different authentication schemes (like e.g., basic or digest authentication).

Example of using PasswordAuthentication class :

    HttpResponse<String> response = HttpClient.newBuilder()
        .authenticator(new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(
                    "username",
                    "password".toCharArray());
            }
        }).build()

*Send Requests – Sync vs. Async*

New HttpClient provides two possibilities for sending a request to a server:

+ send(…) – synchronously (blocks until the response comes)
+ sendAsync(…) – asynchronously (doesn't wait for the response, non-blocking)

Up until now, the send(...) method naturally waits for a response:

    HttpResponse<String> response = HttpClient.newBuilder()
    .build()
    .send(request, HttpResponse.BodyHandler.asString());

This call returns an HttpResponse object, and we're sure that the next instruction from our application flow will be executed only when the response is already here.

sendAsync(...) method – which returns *CompletableFeature<HttpResponse>* – to process a request asynchronously:

*Setting Executor for Asynchronous Calls*

We can also define an Executor which provides threads to be used by asynchronous calls.

This way we can, for example, limit the number of threads used for processing requests:

    ExecutorService executorService = Executors.newFixedThreadPool(2);
    
    CompletableFuture<HttpResponse<String>> response1 = HttpClient.newBuilder()
    .executor(executorService)
    .build()
    .sendAsync(request, HttpResponse.BodyHandler.asString());
    
    CompletableFuture<HttpResponse<String>> response2 = HttpClient.newBuilder()
    .executor(executorService)
    .build()
    .sendAsync(request, HttpResponse.BodyHandler.asString());

<b>*By default, the HttpClient uses executor java.util.concurrent.Executors.newCachedThreadPool().*</b>

<b>HttpResponse</b>

The HttpResponse class represents the response from the server. It provides a number of useful methods – but two the most important are:

+ statusCode() – returns status code (type int) for a response (HttpURLConnection class contains possible values)
+ body() – returns a body for a response (return type depends on the response BodyHandler parameter passed to the send() method)

The response object has other useful get method like uri(), headers(), trailers() and version().

*Get Trailers from Response*

The HTTP response may contain additional headers which are included after the response content. These headers are called trailer headers.
    
    HttpResponse<String> response = HttpClient.newHttpClient()
    .send(request, HttpResponse.BodyHandler.asString());
    CompletableFuture<HttpHeaders> trailers = response.trailers();

<b>Java 11 Http Client</b>

The major change in Java 11 was the standardization of HTTP client API that implements HTTP/2 and Web Socket. It aims to replace the legacy HttpUrlConnection class which has been present in the JDK since the very early years of Java.

The main changes:

+ The newer version of the HTTP protocol is designed to improve the overall performance of sending requests by a client and receiving responses from the server. This is achieved by introducing a number of changes such as stream multiplexing, header compression and push promises.
+ As of Java 11, <b>*the API is now fully asynchronous (the previous HTTP/1.1 implementation was blocking)*</b>. Asynchronous calls are implemented using  CompletableFuture. The CompletableFuture implementation takes care of applying each stage once the previous one has finished, so this whole flow is asynchronous.
+ The new APIs provide native support for HTTP 1.1/2 WebSocket. The core classes and interface providing the core functionality include:
  + java.net.http.HttpClient
  + java.net.http.HttpRequest
  + java.net.http.HttpResponse
  + java.net.http.WebSocket

*Introduction of Static Factory Classes*

New static factory classes BodyPublishers, BodySubscribers, and BodyHandlers are introduced that include existing implementations of BodyPublisher, BodySubscriber and BodyHandler.

These are used to perform useful common tasks, such as handling the response body as a String or streaming the body to a File.

For e.g. in Pre Java 11 we had to do something like this:

    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandler.asString());

Which we can now simplify as:

    HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

*Handling Push Promises in HTTP/2*

New Http client supports push promises through PushPromiseHandler interface.

<b>*It allows the server to “push” content to the client additional resources while requesting the primary resource, saving more roundtrip and as a result, improves performance in page rendering.*</b>

It is really the multiplexing feature of HTTP/2 that allows us to forget about resource bundling. For each resource, the server sends a special request, known as a push promise to the client.

Push promises received, if any, are handled by the given PushPromiseHandler. A null valued PushPromiseHandler rejects any push promises.

The HttpClient has an overloaded sendAsync method that allows us to handle such promises, as shown in the below example.

Let's first create a PushPromiseHandler:

    private static PushPromiseHandler<String> pushPromiseHandler() {
        return (HttpRequest initiatingRequest,
        HttpRequest pushPromiseRequest,
        Function<HttpResponse.BodyHandler<String>,
        CompletableFuture<HttpResponse<String>>> acceptor) -> {
            acceptor.apply(BodyHandlers.ofString())
                .thenAccept(resp -> {
                    System.out.println(" Pushed response: " + resp.uri() + ", headers: " + resp.headers());
                });
            System.out.println("Promise request: " + pushPromiseRequest.uri());
            System.out.println("Promise request: " + pushPromiseRequest.headers());
        };
    }

Next, let's use sendAsync method to handle this push promise:

    httpClient.sendAsync(pageRequest, BodyHandlers.ofString(), pushPromiseHandler())
        .thenAccept(pageResponse -> {
            System.out.println("Page response status code: " + pageResponse.statusCode());
            System.out.println("Page response headers: " + pageResponse.headers());
            String responseBody = pageResponse.body();
            System.out.println(responseBody);
        })
        .join();


Thus, In this chapter we explored Java 9's HttpClient API which provides a lot of flexibility and powerful features.
We also explored the new changes in HttpClient provided by JDK 11, that standardized the incubating HttpClient introduced in Java 9 with more powerful changes.
