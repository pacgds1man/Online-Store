# Online store
[![Java](https://img.shields.io/badge/Java-17-blue)](https://www.oracle.com/java/technologies/downloads/#java17)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.1.0-brightgreen)](https://spring.io/projects/spring-boot)
[![Maven](https://img.shields.io/badge/Maven-indigo)](https://maven.apache.org/)
[![Swagger](https://img.shields.io/badge/Swagger-blue)](https://your-swagger-url.com/)
[![H2 Database](https://img.shields.io/badge/H2%20Database-orange)](https://www.h2database.com/html/main.html)
[![Docker](https://img.shields.io/badge/Docker-blue)](https://www.docker.com/)

Online Store - this is RESTful application which is based on Spring Boot, and it processes the entities of the customer, order and shipping. It is connected to H2 In Memory database, implemented basic authentication and authorization with using different roles to access resources.
Swagger is used for describing application API
![Schema](schema.png)

- REST API
    - [OpenAPI Spec](http://localhost:8083/swagger-ui/index.html)

## Requirements
* Java 17
* Maven 3.9.1 or above

## Technology list

1. **Spring Boot**
2. **Spring Web MVC**
3. **Spring Data JPA**
4. **Spring Security**
5. **Maven**
6. **H2 database**
7. **Docker**
8. **Swagger**
9. **Lombok**

## Getting started

```shell
#clone repository
https://github.com/pacgds1man/Online-Store.git
```

Run the application with the command:

```shell
# Create executable jar file:
mvn clean install
```

```shell
#create docker image
docker build -t online-store:0.0.1 .
```

```shell
#run the docker container
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