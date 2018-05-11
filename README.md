# MTool

**MTool** is a Personal Task Management Tool, developed as an example which has the following functionality:
 - Personal task management tool (task name, description, status, time added, time finished)
 - Adding/changing/deleting tasks
 - Mark tasks done

## Technology stack:
 - Maven [3+](https://maven.apache.org/)
 - Spring Boot [2.0.2](https://docs.spring.io/spring-boot/docs/2.0.2.RELEASE/reference/htmlsingle/)
 - Java [1.8+](http://www.oracle.com/technetwork/java/javase/overview/index.html)
 - JPA/Hibernate
 - ThymeLeaf [latest](https://www.thymeleaf.org)
 - H2 Database [latest](http://www.h2database.com)
 
## Build an executable JAR
**STEP 1**
Run the application using
 > ./mvnw spring-boot:run


**STEP 2**
Build the JAR file
 > ./mvnw clean package
Run the JAR file
 > java -jar target/mtool-1.0.jar
 
###### Launch up H2 DB Console at 
http://localhost:8080/h2
```
JDBC URL: jdbc:h2:~/mtool
User Name: sa
Password:
```

###### MTool web url
http://localhost:8080