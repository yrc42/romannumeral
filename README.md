# Number to Roman Numeral Converter API
This API provides functionality to convert numbers to Roman numerals.

## Building and Running the Project

1. Clone the repository.
3. Open a terminal or command prompt and navigate to the project's root directory.
4. Install Java, Maven and configure JAVA_HOME variables
5. Build the project Maven:mvn clean install
5. Run the project mvn spring-boot:run

The API will start running on http://localhost:8080.

## Engineering and Testing Methodology
This project follows a Spring Boot architecture.

Controller Layer: Handles incoming HTTP requests, performs input validation, and calls the conversion service.
Service Layer: Implements the logic for converting numbers to Roman numerals.

## Packaging Layout
The main code is located under src/main/java/com.example.AdobeTakehomeAPI.

Test code is located under src/test/java/com.example.AdobeTakehomeAPI.

The pom.xml file contains the project configuration and dependencies.

## Dependency Attribution
This project relies on the following dependencies:
* Spring Boot
* Spring Web
* JUnit
* Spring Test
* log4j