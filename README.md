[![Java CI with Maven](https://github.com/tamsler/rectangles/actions/workflows/maven.yml/badge.svg)](https://github.com/tamsler/rectangles/actions/workflows/maven.yml)

## Local Development Dependencies

- Java 8+
- Maven

## Execution & Testing
### To run program
- mvn compile exec:java

### To run tests
- mvn test

### Run individual test file
- mvn -Dtest=TestRectangle test

### Test coverage results
- ./target/site/jacoco/index.html

### Javadocs
- mvn javadoc:javadoc
- ./target/site/apidocs/index.html 
