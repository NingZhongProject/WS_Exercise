0. Introduction

This project implements a RESTful web service to accept a number as input and returns the first n Fibonacci numbers.
It is developed using Java and Spring framework.  Maven was used for build and deployment purpose.

1) Environment

   Java version 1.8
   Apache Maven 3.3.9
   
2) Program directory structure 

   Here is a summary of the main program file or directories (assuming they are under {path_to}/WS_Exercise-master)
   
   * WS_Exercise-master/pom.xml	
   
     This is the maven build file.
   
   * WS_Exercise-master/src/main/java/com/exercise
     
     The Spring Boot appliction class and an application exception class are put here.
   
   * WS_Exercise-master/src/main/java/com/exercise/controllers
   
     The controller classes are defined and put in this directory. The Restful service endpoints are defined in these classes.

   * WS_Exercise-master/src/main/java/com/exercise/services
    
     The classes that implement service logics are collected in this directory.
     
   * WS_Exercise-master/src/test/java/com/exercise/test
   
     The unit test and web layer test classes are put here. Six test cases are defined. 
   
   * WS_Exercise-master/target	
   
     The war file is generated and put here.
   

3) Build, Deploy, Run with Spring boot

   Uncompress the ZIP file to a working directory (For example, WS_Exercise-master). Then execute the following commands.

	   cd {path_to}/WS_Exercise-master

	   mvn clean 

	   mvn install
   
   The above steps build a war file "WS_TestProject-1.1.war" under the "target" directory. This file is executable. The following 
   command can be used to launch the web service, which runs on top of the embedded tomcat servlet container in Spring Boot.
   
	   java -jar target/WS_TestProject-1.1.war
	   
   Once the embedded tomcat server is up and running, we can use a browser (or curl command) to the Restful web service.
   
   Another way to launch the service is to deploy it to a tomcat server, which is described in section 5).
   
4) Usage

   The following are a few examples to test the service through a browser. The response is in JSON format. In successful scenario, the returned Fibonacci numbers can be 
   found in the JSON field "fibNumbers". In cases where invalid inputs are given, the response JSON messages include attributes to indicate error codes and reasons.  
   
   http://localhost:8080/fabonacci/20
   
   {"note":"Numbers obtained.","serviceTimeStamp":"Thu Mar 31 11:07:29 EDT 2016","fibNumbers":[0,1,1,2,3,5,8,13,21,34,55,89,144,233,377,610,987,1597,2584,4181]}
   
   http://localhost:8080/fabonacci/1
   
   {"note":"Numbers obtained.","serviceTimeStamp":"Thu Mar 31 11:12:07 EDT 2016","fibNumbers":[0]}
   
   http://localhost:8080/fabonacci/-1
   
   {"timestamp":145943744363 6,"status":400,"error":"Bad Request","exception":"com.exercise.InvalidRequestParameterException","message":"Input Number cannot be negative","path":"/fabonacci/-1"}
   
   http://localhost:8080/fabonacci/abcd
   
   {"timestamp":1459437531123,"status":500,"error":"Internal Server Error","exception":"java.lang.NumberFormatException","message":"For input string: \"abcd\"","path":"/fabonacci/abcd"}
   
 5) Deploy to Tomcat
 
    Alternatively, the war file "WS_TestProject-1.1.war" can be deployed to a standalone tomcat server. The tomcat server I used here is tomcat-8.0.33.
    
    We can deploy the war file by simply copying it into the "webapps" directory of the tomcat server.
    In this case, the web context root is different from that from Spring boot version. Here is an example:
    
    http://localhost:8080/WS_TestProject-1.1/fabonacci/20
    
    In the future, we may config Maven to deploy the war file to tomcat automatically.
    
 6) Unit and functional tests
 
    The following commands may be used to run unit tests.
    
           cd {path_to}/WS_Exercise-master
    
    	   mvn clean 
    
	   mvn test