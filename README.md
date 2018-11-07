
# Notes
A Spring+Hibernate project

# Instructions on how to build project
Make sure MySQL is installed and running and a database called 'test' exists and can be accessed.
(There is a string property under /resources/properties/database.properties,  jdbc.url=jdbc:mysql://localhost:3306/test?useSSL=false .
Changed the port and name of the database 'test' if needed.

Login name and password for now : 
- Tor : password
- Foo : password

## Windows
1. Download or clone https://github.com/torgammelgard/notes.git
2. Import the project in your favorite IDE, OR - build the project from the command line using gradle - In Notes folder, run command : gradlew build
3. After building the project you will find a war-file (/build/libs/notes.war). Deploy this to your application server. I used Tomcat 7

## Mac
1. Download or clone https://github.com/torgammelgard/notes.git
2. Import the project in your favorite IDE, OR - build the project from the command line using gradle - In Notes folder, run command : ./gradlew build
3. After building the project you will find a war-file (/build/libs/notes.war). Deploy this to your application server. I used Tomcat 7

# Description
The Notes webapp aims to 
- store information about each user
- let the user create persistence notes
- offer a RESTful api

# Technologies used
It uses Spring MVC, Hibernate, MySQL, Spring ORM, JSPs, Servlets, JSTL and Gradle...

# Resources
- [Tutorialspoint](http://www.tutorialspoint.com/spring/)
- [Java EE 6 Tutorial](http://docs.oracle.com/javaee/6/tutorial/doc/gexaf.html)
- [Udemy - Spring and Hibernate Tutorial](https://www.udemy.com/spring-hibernate-tutorial/learn/v4/overview)
- [Udemy - JSP and Servlets](https://www.udemy.com/jsp-tutorial/learn/v4/overview)
- [Udemy - The Java Spring Turorial](https://www.udemy.com/javaspring/learn/v4/overview)
