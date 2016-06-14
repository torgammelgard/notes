
# Notes
A Spring+Hibernate project

# Instructions on how to build project
Make sure there MySQL is installed and a database called 'test' exists and can be accessed.
(There is a string property under /resources/properties/database.properties,  jdbc.url=jdbc:mysql://localhost:3306/test?useSSL=false .
Changed the port and name of the database 'test' if needed.

## Windows
1. Download or clone https://github.com/torgammelgard/Notes.git
2. In Notes folder, run command : gradlew build
3. Deploy /build/libs/notes.war to your server or import it to your IDE and run it though the application server.

## Mac
1. Download or clone https://github.com/torgammelgard/Notes.git
2. In Notes folder, run command : bash ./gradlew build
3. Deploy /build/libs/notes.war to your server or import it to your IDE and run it though the application server.

# Description
The Notes webapp aims to 
- store information about each user
- let the user create persistence notes
- offer a RESTful api

# Technologies used
It uses Spring MVC, Hibernate, MySQL, Spring ORM, JSPs, Servlets, JSTL...
