StoryStream – Spring Boot Blogging Platform

#Table of Contents
Overview
Features
Technologies Used
Project Structure
Getting Started
Contributions and Version Control
License


#Overview

StoryStream is a personal blogging platform built with Java Spring Boot that allows users to create, edit, view, and delete blog posts through both a user-friendly web interface and a RESTful API. The project follows a clean, modular architecture with separate layers for entities, services, repositories, and controllers, ensuring maintainability and scalability.


#Features

Full CRUD functionality for blog posts.
User interface built with Thymeleaf templates for dynamic HTML rendering.
REST API endpoints for programmatic access and integration.
Data persistence with SQLite using Spring Data JPA and Hibernate ORM.
Input validation using Bean Validation annotations.
Live reload capabilities during development through Spring Boot DevTools.
Responsive, modern UI design with CSS and background image support.


#Technologies Used

Java 21
Spring Boot 3.5.x
Spring MVC and Thymeleaf
Spring Data JPA with Hibernate ORM
Hibernate Community Dialects for SQLite
SQLite as embedded database
Bean Validation (Jakarta Validation)
Lombok for boilerplate code reduction
Maven for build and dependency management
CSS3 for styling and responsive design


#Project Structure

src/main/java/com/storystream/StoryStream/
Contains all Java source files organized by responsibility (controller, service, repository, entity, config).
src/main/resources/templates/
Thymeleaf HTML templates for the web UI.
src/main/resources/static/css/
CSS stylesheets defining the look and feel.
src/main/resources/application.properties
Configuration for database and Spring Boot settings.
pom.xml
Maven configuration with dependencies and build plugins.


#Getting Started

Clone the repository (bash):
git clone <repository-url>
cd StoryStream


Build and run the application (bash):
mvn spring-boot:run

Access the application:
Open a browser and navigate to http://localhost:8080/posts to use the blogging platform UI.
Use the REST API:
API endpoints are available under /api/posts for JSON-based create, read, update, and delete operations.


#Contributions and Version Control
The project is developed using Git and hosted on GitHub for version control and deployment, following agile best practices to ensure continuous integration and delivery.

Thank you for exploring StoryStream! Contributions and feedback are welcome.
