
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
1. Download or clone https://github.com/torgammelgard/Notes.git
2. Import the project in your favorite IDE, OR - build the project from the command line using gradle - In Notes folder, run command : gradlew build
3. After building the project you will find a war-file (/build/libs/notes.war). Depoy this to your application server. I used Tomcat 7

## Mac
1. Download or clone https://github.com/torgammelgard/Notes.git
2. Import the project in your favorite IDE, OR - build the project from the command line using gradle - In Notes folder, run command : gradlew build
3. After building the project you will find a war-file (/build/libs/notes.war). Depoy this to your application server. I used Tomcat 7

# Description
The Notes webapp aims to 
- store information about each user
- let the user create persistence notes
- offer a RESTful api

# Technologies used
It uses Spring MVC, Hibernate, MySQL, Spring ORM, JSPs, Servlets, JSTL and Gradle...
