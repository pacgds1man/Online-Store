# Online store
[![Java](https://img.shields.io/badge/Java-17-blue)](https://www.oracle.com/java/technologies/downloads/#java17)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.1.0-brightgreen)](https://spring.io/projects/spring-boot)
[![Maven](https://img.shields.io/badge/Maven-indigo)](https://maven.apache.org/)
[![Swagger](https://img.shields.io/badge/Swagger-blue)](https://your-swagger-url.com/)
[![H2 Database](https://img.shields.io/badge/H2%20Database-orange)](https://www.h2database.com/html/main.html)
[![Docker](https://img.shields.io/badge/Docker-blue)](https://www.docker.com/)

### This is a RESTfull project - an online store that contains the entities of the customer, order and delivery. It is connected to In Memory database, implemented basic authentication using different roles to access resources
![Schema](schema.png)


- REST API
    - [OpenAPI Spec](http://localhost:8083/swagger-ui/index.html)

## Requirements
* Java 17
* Maven 3.9.1 or above

## Getting started

Clone repository

```shell
https://github.com/pacgds1man/Online-Store
```

## Run the application with the command:

Maven:
```shell
mvn clean install
```


Create image for Docker
```shell
docker build -t online-store:0.0.1 .
```
Run the container
```shell
docker run -d -p 8083:8083 -t online-store:0.0.1
```
The application is running on port 8083.


## Basic auth credentials:
User
- username: user
- password: user

Admin
- username: admin
- password: admin