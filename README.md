# Task Management REST API

A simple Task Management REST API built using **Java, Spring Boot, Spring Data JPA, Hibernate, and MySQL**.

This project provides RESTful APIs to create, retrieve, update, complete, and delete tasks. It follows a layered backend architecture using **Controller → Service → Repository**.

# Features

* Create a new task
* Retrieve all tasks
* Retrieve a task by ID
* Update task details
* Mark a task as completed
* Delete a task
* MySQL database persistence
* RESTful API architecture
* Spring Data JPA for database operations

# Technologies Used

* Java 21
* Spring Boot
* Spring Web
* Spring Data JPA
* Hibernate
* MySQL
* Maven
* Lombok
* Git

# Project Architecture

Client
  │
  ▼
REST Controller
  │
  ▼
Service Layer
  │
  ▼
Repository Layer
  │
  ▼
MySQL Database


# Layer Responsibilities

# Controller

Handles HTTP requests and responses.

# Service

Contains the application's business logic.

# Repository

Handles database operations using Spring Data JPA.

# Entity

Represents the `Task` table in the database.

# Project Structure

src/
└── main/
    ├── java/
    │   └── com/example/ToDoList/
    │       ├── controller/
    │       │   └── TaskController.java
    │       │
    │       ├── model/
    │       │   └── Task.java
    │       │
    │       ├── repository/
    │       │   └── ITaskRepository.java
    │       │
    │       ├── service/
    │       │   └── TaskService.java
    │       │
    │       └── App.java
    │
    └── resources/


# Database Configuration

Create a MySQL database:

CREATE DATABASE todolist;


Configure the database connection in:

src/main/resources/application.properties


Example:

properties

spring.datasource.url=jdbc:mysql://localhost:3306/todolist
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true


> Do not commit real database passwords or credentials to GitHub.

# Running the Application

# 1. Clone the repository

git clone <your-repository-url>
cd ToDoList


# 2. Configure MySQL

Make sure MySQL is running and create the `todolist` database.

# 3. Update database credentials

Update `application.properties` with your MySQL username and password.

# 4. Run the application

Using Maven:

./mvnw spring-boot:run

Or:

mvn spring-boot:run

The application will start on:

http://localhost:8080


# API Endpoints

# Create Task
POST /api/v1/todolist/create/newtask


Request body:
{
  "title": "Learn Spring Boot",
  "description": "Study Spring Boot REST APIs",
  "completed": false
}


Response:


Task Created!


# Get All Tasks
GET /api/v1/todolist/getAllTasks


Example response:

[
  {
    "id": 1,
    "title": "Learn Spring Boot",
    "description": "Study Spring Boot REST APIs",
    "completed": false
  }
]


# Update Task Title

PUT /api/v1/todolist/changeTitle


Request:

json
{
  "id": 1,
  "title": "Learn Advanced Spring Boot"
}


# Update Task Description

PUT /api/v1/todolist/change-description


Request:
{
  "id": 1,
  "description": "Learn Spring Boot, JPA and REST APIs"
}


# Mark Task as Completed

PUT /api/v1/todolist/markTaskcompleted/{id}


Example:

PUT /api/v1/todolist/markTaskcompleted/1

# Delete Task

DELETE /api/v1/todolist/deleteTaskByID/{id}

Example:
DELETE /api/v1/todolist/deleteTaskByID/1

# API Testing

You can test the APIs using:

* Postman
* cURL
* IntelliJ HTTP Client

Example using cURL:

bash
curl -X GET http://localhost:8080/api/v1/todolist/getAllTasks

# Future Improvements

The project can be extended with:

* DTOs for request and response objects
* Global exception handling
* Input validation
* Proper HTTP status codes
* Pagination and sorting
* Search and filtering
* Task priority
* Due dates
* User authentication and authorization
* Spring Security + JWT
* Unit and integration testing
* Docker support
* Swagger/OpenAPI documentation
* CI/CD pipeline

🎯 Learning Objectives

This project was built to practice:

* Building REST APIs with Spring Boot
* Dependency Injection
* Layered architecture
* Spring Data JPA
* Hibernate ORM
* CRUD database operations
* MySQL integration
* REST API design
* Backend application development

 👨‍💻 Author

Poovarasan M

Java Full Stack Developer

Core Technologies

Java | Spring Boot | REST API | JPA | Hibernate | MySQL | Git 

