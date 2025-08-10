# spring-microservice-communication-demo

This project demonstrates communication between microsrvices using:
1. RestTemplate (legacy/simple)
2. WebClient (Reactive and modern alternative to RestTemplate)
3. Fiegn Client (Declarative Rest Client)

# Structure
spring-microservice-communication-demo/
├── common-service/         # Common DTOs shared between services
├── user-service/           # Provides user data (like a database service)
├── caller-service/         # Calls user-service using Feign, RestTemplate, and WebClient
└── pom.xml                 # Parent pom

# How It Works (In Simple Words)
1. user-service has a simple REST API that gives user data.
2. caller-service tries to get that user data using three different clients:
  => RestTemplate (traditional synchronous HTTP client)
  => WebClient (modern reactive/non-blocking client)
  => Feign (declarative REST client — just write interface, Spring handles the rest)

# Modules Explained
## common-service
  Contains the User.java DTO (Data Transfer Object).
  Shared by both caller-service and user-service.
  No business logic or controllers.
## user-service
  Simulates a real backend service that exposes user-related endpoints.

Provides a dummy user for any given ID.
Sample Endpoint:
GET http://localhost:8080/user/{id}

## caller-service
  Calls the user-service using:
    1. RestTemplateUserClient
    2. WebClientUserClient
    3. FeignUserClient
Sample Feign Endpoint (exposed by caller-service):
  GET http://localhost:8081/feign-client/user/1
# How to Run
1. start user-service
     1. cd user-service
     2. mvn spring-boot run
        it runs on port#8080
2. start caller-service
    1. cd caller-service
    2. mvn spring-boot run
       it runs on port#8081
# Test the API
## Using Feign Client
  GET http://localhost:8081/feign-client/user/1
## Using WebClient
  GET http://localhost:8081/web-client/user/1
## Using RestTemplate
  GET http://localhost:8081/rest-template/user/1
Each of these calls will return a user fetched from user-service.

## Sample User Response
{
  "id": 1,
  "name": "John Doe",
  "email": "john@example.com"
}
