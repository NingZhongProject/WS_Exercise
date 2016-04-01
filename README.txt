0. Introduction

This project implements a RESTful web service to accept a number as input and returns the first n Fibonacci numbers.
It is developed using Java and Spring framework.  Maven was used for build and deployment purpose.

1) Environment

   Java version 1.8
   Apache Maven 3.3.9
   
2) Program directory structure 

   Here is a summary of the main program file or directories (assuming they are under {path_to}/WS_TestProject)
   
   * WS_TestProject/pom.xml	
   
     This is the maven build file.
   
   * WS_TestProject/src/main/java/com/exercise
     
     The Spring Boot appliction class and an application exception class are put here.
   
   * WS_TestProject/src/main/java/com/exercise/controllers
   
     The controller classes are defined and put in this directory. The Restful service endpoints are defined in these classes.

   * WS_TestProject/src/main/java/com/exercise/services
    
     The classes that implement service logics are collected in this directory.
     
   * WS_TestProject/src/test/java/com/exercise/test
   
     The unit test and web layer test classes are put here. Six test cases are defined. 
   
   * WS_TestProject/target	
   
     The war file is generated and put here.
   

3) Build, Deploy, Run with Spring boot

	   cd {path_to}/WS_TestProject

	   mvn clean 

	   mvn install

	   mvn test
   
   The above steps build a war file "WS_TestProject-1.1.war" under the target directory. This file is executable. The following 
   command can be used to launch the application, which run on top of the embedded tomcat servlet container.
   
	   java -jar target/WS_TestProject-1.1.war
   
4) Deploy to Tomcat

   The same war file "WS_TestProject-1.1.war" can be deployed to a standalone tomcat server. The tomcat server I used here is tomcat-8.0.33.
   
   Please note that the URL context is different from that from Spring boot version, if the war file is deployed to the webapp directory without 
   further tomcat server configuration. For example,
   
   http://localhost:8080/WS_TestProject-1.1/fabonacci/20

5) Usage

   The following are a few examples to use the service through a browser. The response is in JSON format. In successful scenario, the returned Fibonacci numbers can be 
   found in the JSON field "fibNumbers". In cases where invalid inputs are given, the response JSON messages include attributes to indicate error codes and reasons.  
   
   http://localhost:8080/fabonacci/20
   
   {"note":"Numbers obtained.","serviceTimeStamp":"Thu Mar 31 11:07:29 EDT 2016","fibNumbers":[0,1,1,2,3,5,8,13,21,34,55,89,144,233,377,610,987,1597,2584,4181]}
   
   http://localhost:8080/fabonacci/1
   
   {"note":"Numbers obtained.","serviceTimeStamp":"Thu Mar 31 11:12:07 EDT 2016","fibNumbers":[0]}
   
   http://localhost:8080/fabonacci/-1
   
   {"timestamp":145943744363 6,"status":400,"error":"Bad Request","exception":"com.exercise.InvalidRequestParameterException","message":"Input Number cannot be negative","path":"/fabonacci/-1"}
   
   http://localhost:8080/fabonacci/abcd
   
   {"timestamp":1459437531123,"status":500,"error":"Internal Server Error","exception":"java.lang.NumberFormatException","message":"For input string: \"abcd\"","path":"/fabonacci/abcd"}