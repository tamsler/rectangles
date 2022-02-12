Local Development Dependencies
------------------------------

# Java 8+
# Maven

Execution & Testing
-------------------

# To run program
mvn exec:java

# To run tests
mvn test

# Run individual test file e.g.
mvn -Dtest=TestRectangle test

# To run tests and run program
mvn test exec:java

# Test coverage results
./target/site/jacoco/index.html