# Selenium WebDriver Test Suite

This repository contains automated test scenarios for a web application using Selenium WebDriver, TestNG, and a POM (Project Object Model) file for dependency management. The tests are developed using Java and can be executed in IntelliJ IDEA.

## Prerequisites

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html) installed.
- [IntelliJ IDEA](https://www.jetbrains.com/idea/download/) installed.
- WebDriver executables (e.g., ChromeDriver, msedgedriver) downloaded and available in your system path.
- [Maven](https://maven.apache.org/download.cgi) installed (for dependency management).

## Project Structure

- `src/test/java`: Contains the test automation code.
- `src/main/java`: Contains application-specific code and page objects (if using POM).
- `src/test/resources`: Contains TestNG XML configuration files.
- `pom.xml`: POM file for managing dependencies.

## Test Scenarios

### Scenario 1: Verify User Cannot Log in with Valid but Unregistered Email

1. Ensure you have the necessary test data (valid but unregistered email) in your project.
2. Open the project in IntelliJ IDEA.
3. Navigate to the `src/test/resources` folder and open `testing.xml`.
4. Right-click on the `testing.xml` file and choose "Run" to execute the `Scenario1Test` class.
5. The test will run, and the result will be displayed in the TestNG Results window.

### Scenario 2: Verify Item is Added to Cart Correctly

1. Ensure you have the necessary test data (item details) in your project.
2. Open the project in IntelliJ IDEA.
3. Navigate to the `src/test/resources` folder and open `testing.xml`.
4. Right-click on the `testing.xml` file and choose "Run" to execute the `Scenario2Test` class.
5. The test will run, and the result will be displayed in the TestNG Results window.

### Scenario 3: Verify User Cannot Access "Your Orders" and "Your Addresses" Pages

1. Ensure you have the necessary test data (user credentials) in your project.
2. Open the project in IntelliJ IDEA.
3. Navigate to the `src/test/resources` folder and open `testing.xml`.
4. Right-click on the `testing.xml` file and choose "Run" to execute the `Scenario3Test` class.
5. The test will run, and the result will be displayed in the TestNG Results window.

### Scenario 4
1. Ensure that screenshot will be taken when test result failed due to scnario 1
2. find in Screenshots directory

## Running All Test Scenarios

1. Ensure you have all the necessary test data.
2. Open the project in IntelliJ IDEA.
3. Navigate to the `src/test/resources` folder and open `testing.xml`.
4. Right-click on the `testing.xml` file and choose "Run" to execute all test scenarios.
5. The test suite will run, and the results will be displayed in the TestNG Results window for Report generation.

## Contributors

- [Mohamed Ahmed Abdelsalam] - [Mohamedabdelsalam30398@gmail.com] - [https://github.com/Abdelsalaam10]





