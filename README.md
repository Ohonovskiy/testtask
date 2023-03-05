
# Person API
This is a REST API built with Java and Spring that provides an endpoint for retrieving a person's information by their ID from a database.

## Usage
To use this API, you can send a GET request to the /people/{id} endpoint, where {id} is the ID of the person you want to retrieve. The API will return a JSON object with the person's first name, last name, and age.

## Dependencies
This project requires the following dependencies:

Java 8 or higher,
Spring Framework,
PostgreSQL

## Getting started
To run this project, you'll need to first set up a PostgreSQL database and configure the application to connect to it. You can do this by updating the application.properties file with your database connection details.

Once you've set up your database, you can run the application using the following command:

### Copy code
mvn spring-boot:run
