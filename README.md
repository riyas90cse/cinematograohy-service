# cinematography-service

POC Application for Cinematorgraphy 

# Tools & Technology Used

Java 11, Spring Boot, Apache Maven 3, GIT, Junit 5, Mockito, Rest API, Lombok, Ehcache, Swagger2, Docker, Docker Compose


# Deployment Instructions

Please go throught the read me file from the devops folder for deployment instruction


# Application Overview

This is a SpringBoot Web Application that downloads all the items in https://mgtechtest.blob.core.windows.net/files/showcase.json and cache images within each asset. In this application there is 4 Rest API to perform the below operations

1. Load the Json Data from the http url and store it in cache
2. Load the data by using filters (gener, director, rating, year) if the data is available from cache otherwise it will load from http call
3. Get Detail of an Object from the loaded the data
4. Clear the cached data

# API Specification

BASE_URI : http://localhost:9000

# Load Data API
```
Request 

End Point: GET - /data/load 

[return all the data from the Url and load it in cache when hit next time if cache exists it will load from the cache and return the list]

Response - 
- List of JsonData 
```

# Load Data API With Filters

```
Request

End Point: GET - /data/filter?

QueryParams = gener, directors, rating, year this can be either one or multiple based on that the data will return the response

Response
- List of JsonData 
```

# Details API for Loaded Data by Id

```
Request

End Point: GET - /data/{id}

Pathvariable: Id based on the Id passed in reequest path vairable the object will load and return as response 

Response
- JsonData Object 
```

# Clear Cache

```
Request

End Point: GET - /cache/clear

Response
- String Message is Body 
```

# Cache Images

```
Request

End Point: GET - /images/{id}

Response
- Cached Image 
```

# Compile, Build and Run Application
- Go to Root Foler cinematography-service to compile & build use below command
- ./mvnw clean install

- if u want to skip test and compile use below command 
- ./mvnw clean install -DskipTests=true

- Once Application Successfully compiled to run application use below command  
- ./mvnw spring-boot:run 
- once it runs successfuly application will run on below uri where you can see the Swagger UI for better understanding
http://localhost:9000/swagger-ui/

