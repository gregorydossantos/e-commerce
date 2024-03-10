# E-Commerce API
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/gregorydossantos/projeto-sds3/blob/main/LICENSE)
<br/>This is a project from my graduate studies in architecture and Java software development at FIAP.

## About E-Commerce
This project consists of creating a microservice with 4 modules. All will be built on the Rest API standard and also the
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
![Web 1](https://github.com/gregorydossantos/e-commerce/blob/develop/assets/databse-model.png)
<br />
#### Sequence Diagram - API Client
#### Sequence Diagram - API Item-Manager
#### Sequence Diagram - API Shop-Cart
#### Sequence Diagram - API Payment
#### Notes:
To create the database and upload it locally, first confirm that you have docker installed on your machine, after that 
follow these steps:
<br/> - cd e-commerce/docker
<br/> - sudo docker-compose up -d (to start container with database)
<br/> - sudo docker-compose down -d (to stop container)

### Documentation (Swagger - Endpoints):
After running the project, we can access the API documentation through Swagger: <br/>
Link: http://localhost:8080/swagger-ui/index.html#/