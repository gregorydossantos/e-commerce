# E-Commerce Project
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/gregorydossantos/projeto-sds3/blob/main/LICENSE)
<br/>This is a project from my graduate studies in Architecture and Software Development at FIAP.

## About E-Commerce
This project consists of creating a microservice with 4 modules independent of each other. All will be built on the Rest API standard and also the
main libraries used on the market today.

The core of the project will be creating users, managing access, managing items, shopping carts and making payments.

## Technologies and Libraries:
- Java 17
- Spring-boot 3.2.2
- Spring Security
- Database H2
- Postgres
- Docker
- Lombok
- JUnit
- Mockito
- Jacoco Report 0.8.8 
- Mapstruct 1.5.5.Final
- OpenAPI 2.0.4

### API Documentation
#### Project Architecture
![Web 1](https://github.com/gregorydossantos/e-commerce/blob/develop/assets/project-architecture.png)
<br />
#### Database Model
![Web 1](https://github.com/gregorydossantos/e-commerce/blob/develop/assets/database-model.png)
<br />
#### Sequence Diagram - API Client
![Web 1](https://github.com/gregorydossantos/e-commerce/blob/develop/assets/client-sequence.png)
<br />
#### Sequence Diagram - API Item-Manager
#### Sequence Diagram - API Shop-Cart
#### Sequence Diagram - API Payment
#### Notes:
To create the database and upload it locally, first confirm that you have docker installed on your machine, after that 
follow these steps:
<br/> - cd e-commerce/docker
<br/> - sudo docker-compose up -d (to start container with database)
<br/> - sudo docker-compose down -d (to stop container)
<br/> I also included a directory containing the endpoint call collections in the postman-collections folder

### Documentation (Swagger - Endpoints):
After running the project, we can access the API documentation through Swagger: <br/>
#### Client Module
Link: http://localhost:8081/swagger-ui/index.html#/
#### Item-Manager Module
Link: http://localhost:8082/swagger-ui/index.html#/
#### Shop-Cart Module
Link: http://localhost:8083/swagger-ui/index.html#/
#### Payment Module
Link: http://localhost:8084/swagger-ui/index.html#/