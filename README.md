# Finance Dashboard Backend

## Project Description

This is a Spring Boot backend application for managing financial records and generating dashboard insights. The system allows users to store income and expense data and provides summary information such as total income, total expenses, and net balance.

## Features

* Add financial records
* View all records
* Calculate total income
* Calculate total expenses
* Get net balance
* Category-wise summary
* View recent transactions

## Technology Stack

* Java
* Spring Boot
* Spring Data JPA
* MySQL
* Maven

## Project Structure

The project follows a layered architecture:

* Controller: Handles HTTP requests and responses
* Service: Contains business logic
* Repository: Handles database operations
* Entity: Represents database tables
* DTO: Used for data transfer between layers

## API Endpoints

GET /api/dashboard/summary
Returns total income, total expenses, and net balance

GET /api/dashboard/category
Returns category-wise totals

GET /api/dashboard/recent
Returns recent financial records

POST /api/records
Add a new financial record

GET /api/records
Get all financial records

## Database Design

The main entity used is FinancialRecord with the following fields:

* id
* amount
* category
* type (INCOME or EXPENSE)
* date

## Validation and Error Handling

* Validates input fields such as amount and type
* Handles invalid data and missing records
* Returns appropriate error messages

  
## API Documentation

The API documentation is available using Swagger UI.

Swagger URL:
http://localhost:8080/swagger-ui/index.html

To access the API documentation:

1. Run the Spring Boot application using:
   mvn spring-boot:run

2. Open the above URL in a web browser

3. Use the Swagger interface to test available APIs

Note:
The Swagger UI works only when the application is running locally.

## How to Run the Project

1. Clone the repository
   git clone https://github.com/your-username/FinanceDashboard.git

2. Navigate to the project folder
   cd FinanceDashboard

3. Configure database in application.properties

4. Run the application
   mvn spring-boot:run

## Future Improvements

* Add user authentication and authorization
* Add frontend user interface
* Add pagination and filtering
* Improve error handling

## Author

Rohan Hanmante
