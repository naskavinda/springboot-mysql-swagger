# <b>Spring Boot Project with mysql db, JPA and swagger</b>

## What's included
This project is based on the Spring Boot

* Maven
* Swagger 
* Spring web
* Spring Core - Lombok
* Spring Data - Hibernate & MySQL

## Configuration 
Create a MySQL database with the name `library`. MySQL database configuration is controlled by adding external configuration properties. These properties are already added, but you have to change the username and password of /resources/application.properties.  
(full path :- springboot-mysql-swagger/src/main/resources/application.properties). 

`spring.jpa.hibernate.ddl-auto=update'
 spring.datasource.url=jdbc:mysql://localhost:3307/library'      
 spring.datasource.username=root'      
 spring.datasource.password=1234`  
