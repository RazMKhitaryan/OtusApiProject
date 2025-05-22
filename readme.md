# OtusLesson Project

This project demonstrates a Maven-based Java application with a focus on **Rest Assured** API automation, **TestNG**
## Prerequisites

Before running the project, ensure you have the following installed:

- **Java 21** or higher (check by running `java -v`)
- **Maven 3.6+** (check by running `mvn -v`)

## Clone the Repository

To clone the repository, run the following command:

```bash
  git clone https://github.com/RazMKhitaryan/OtusApiProject.git
```

## Code Quality Checks

`mvn checkstyle:check`
`mvn spotbugs:check`

## Run the tests with command from terminal

`mvn clean test -Dbase.uri=https://petstore.swagger.io/v2`
