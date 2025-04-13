RestAssured API Automation Framework (Restful-Booker)
This repository contains the implementation of a Hybrid API Automation Framework designed using RestAssured for testing the Restful-Booker API. The framework supports full CRUD operations (Create, Read, Update, Partial Update, Delete) with a scalable and maintainable architecture, following Test-Driven Development (TDD) practices.

Project Overview
The goal of this project is to efficiently validate RESTful services of the Restful-Booker API, providing comprehensive automated test scenarios that ensure the functionality and reliability of the API endpoints.

Key Features:
Full CRUD Operations: Tests for Create, Read, Update, Partial Update, and Delete API methods.

BDD-style Test Scenarios: Developed using TestNG with a business-readable approach.

Token-Based Authentication: Secured API interactions with automated token generation and renewal.

Maven-based Framework: Simplified build management, dependency handling, and plugin configuration.

Comprehensive Reporting: Integrated HTML, Emailable Reports, Extent Reports, and Allure Reports for detailed test execution analysis.

Logging with Log4j2: Logs and evidence to aid debugging and traceability.

Tools & Technologies
Java - Programming Language

RestAssured - For REST API Testing

TestNG - Testing Framework

Maven - Build and Dependency Management

Jenkins - CI/CD Integration

Log4j2 - Logging

Allure Reports - Test Reporting

Extent Reports - Enhanced Test Reporting with Screenshots and Logs

JSON - For Request/Response handling

Postman - API Testing (Manual/Initial Testing)

Git/GitHub - Version Control and Collaboration

Framework Structure
The framework is designed with a clean architecture following SOLID principles. It includes:

1. Request Classes:
Handles the creation and configuration of API requests.

2. POJO Classes:
Used for request/response mapping to facilitate easy data handling.

3. Utility Classes:
Contains common methods and reusable logic to reduce redundancy.

4. TestBase Class:
Centralized configuration and setup, initialized with the @BeforeSuite annotation.

Features & Enhancements
BDD Syntax: Test cases are written in a behavior-driven style, making them easier to understand for both developers and non-developers (aligned with agile practices).

Token-Based Authentication: Automated token generation and renewal logic ensure the tests run smoothly with secure access to the API.

Comprehensive Reporting: Multiple reporting tools integrated to generate various reports like HTML, Allure, and Extent, along with detailed logs to track execution progress and failures.

CI/CD Integration
This framework is integrated with Jenkins using Maven for seamless CI/CD integration, enabling automated execution on every code commit or scheduled build.

Getting Started
Prerequisites:
Java (preferably JDK 8 or above)

Maven (for build and dependency management)

Git (for version control)

Jenkins (optional for CI/CD)

Postman (for initial testing)

Allure (for test reporting)

