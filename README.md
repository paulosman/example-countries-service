# countries-service

This is an example Java Spring Boot application that uses JAX-RS as an HTTP client.

It's very simple, it has two endpoints, and reads data from JSON files in a publicly accessible S3 bucket.

## Build

To build, we use gradle:

    gradle build
    java -jar build/libs/countries-service-1.0-SNAPSHOT.jar

## Test

Now you can use curl to access the service:

    curl -D - http://localhost:9999/countries
    
    HTTP/1.1 200
    Content-Type: application/json
    Transfer-Encoding: chunked
    Date: Tue, 09 Feb 2021 23:01:28 GMT

    [{"id":1,"name":"Canada"},{"id":2,"name":"United States"}]
    
Or:

    curl -D - http://localhost:9999/countries/1
    
    HTTP/1.1 200
    Content-Type: application/json
    Transfer-Encoding: chunked
    Date: Tue, 09 Feb 2021 23:02:30 GMT

    {"id":1,"name":"Canada"}
    
Yes, there are more than 2 countries, but I'm doing this to test something out :)