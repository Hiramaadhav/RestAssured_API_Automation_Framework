RestAssured API Automation Framework (Restful-Booker)

This repository contains a Hybrid API Automation Framework for testing the Restful-Booker API using RestAssured. The framework supports full CRUD operations (Create, Read, Update, Partial Update, Delete) with a scalable and maintainable architecture, built following Test-Driven Development (TDD) practices. The framework is designed to be robust, reliable, and integrates seamlessly with CI/CD pipelines.

🚀 Project Overview
This project automates the validation of the Restful-Booker API to ensure the accuracy and functionality of all its endpoints. The framework supports BDD-style test cases, token-based authentication, and integrates multiple reporting tools to provide comprehensive test execution insights.

Key Features
Full CRUD Operations: Comprehensive API testing for Create, Read, Update, Partial Update, and Delete operations.

BDD-style Scenarios: Written using TestNG with a business-readable approach to align with agile practices.

Token-based Authentication: Secure API interactions with automatic token generation and renewal.

Modular Architecture: Clean separation of concerns with dedicated classes for requests, responses, utilities, and configuration.

Comprehensive Reporting: Multiple reporting tools to generate:

HTML Reports

Emailable Reports

Extent Reports with detailed logs and screenshots

Allure Reports with rich annotations like @Epic, @Feature, @Severity, and @Description

CI/CD Integration: Jenkins integration using Maven for continuous integration and automated test execution.

🛠 Tools & Technologies Used
Java – Programming Language

RestAssured – For API Testing

TestNG – Testing Framework for BDD-style scenarios

Maven – Build and Dependency Management

Jenkins – Continuous Integration/Continuous Delivery

Log4j2 – For Logging and Debugging

Allure Reports – For Test Reporting

Extent Reports – For Detailed Test Execution Insights

JSON – For Request/Response Handling

Postman – For Initial API Testing (manual testing)

Git/GitHub – Version Control and Collaboration

⚙️ Framework Architecture
The framework follows a modular and scalable architecture. The key components include:

1. Request Classes:
Responsible for creating and handling API requests (GET, POST, PUT, DELETE, etc.).

2. POJO Classes:
These classes map the API request/response data in a structured way using Java objects for easier manipulation.

3. Utility Classes:
Contains reusable methods and logic to handle common functionalities such as response validation, token generation, and API request setup.

4. TestBase Class:
Contains the centralized configuration for setting up test environments, including @BeforeSuite setup and global configurations.

📊 Reporting & Logging
1. Test Reports
HTML Report: Summary of the overall test execution, including passed/failed tests.

Emailable Report: A detailed report that can be emailed after each test run.

Extent Reports: Rich, interactive reports with step-by-step execution logs, screenshots (if applicable), and detailed test information.

Allure Reports: A powerful and visually rich reporting tool that gives detailed insights into test execution with annotations like @Epic, @Feature, @Severity, and @Description.

2. Logging with Log4j2
Provides detailed logging of the test execution process to assist with debugging and traceability.

🚀 CI/CD Integration
The framework is integrated with Jenkins and Maven for seamless CI/CD pipelines. Tests are automatically executed upon code commits or on a scheduled basis, ensuring continuous testing of the API.

🤝 Contributing
Feel free to fork this repository, submit issues, and contribute to the project. If you have any questions or suggestions, feel free to open an issue or pull request.
