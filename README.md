# weather
To insert, update, delete and fetch Weather Details Using Restful WebServices.
## Clone the Repository
		git clone git@github.com:rajesh612/weather.git
## Tools and Softwares Required
###### Spring Tool Suite 3.7.3.RELEASE
###### jdk 1.8
###### postman 
###### MySQL WorkBench 6.3 CE
## Maven Dependencies for pom.xml
###### jersey-media-moxy
###### spring-boot-starter-web
###### spring-boot-starter-test
###### spring-boot-starter-data-jpa
###### spring-boot-starter-aop
###### mysql-connector-java
###### spring-boot-starter-data-rest
###### scala-library
## Required MySQL DB Tables
	Create a schema using MYSQL WorkBench.
	Create a Table weather with Columns 
	id int(11) AI,PK
	cityname varchar(45)
	state varchar(45)
	zipcode int(11)

## Application
#### WeatherApplication is a Spring Boot Application represented by @SpringBootApplication annotation. It is used to run the weather application.

## Controller 
###### WeatherController is represented by @RestController Annotation. It will use service methods to insert, update, delete and fetch weather details. Service Objects are used as Dependency Injection with @Autowired annotation.Controller will return data to client(postman).

## Service
###### WeatherService is represented by @Service annotation. Service will invoke Weather Repository methods and return the data to Controller. DAO objects are used as Dependency Injection with @Autowired annotation.

## Repository
###### DAO is recognized using @Repository annotation. DAO class will use EntityManager methods and WeatherModel Objects to perform various CRUD operations.
 

