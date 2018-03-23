# Swagger ile Spring Rest API Dökümanı Hazırlama

> *Copyright 2018 [isa öztürk](http://sisa.github.io)*

   Swagger ile Spring Rest API Dökümanı Hazırlama
   
   [![Build Status](https://travis-ci.org/sisa/spring-rest-h2-swagger.svg?branch=master)](https://travis-ci.org/sisa) 
      [![Codecov branch](https://codecov.io/gh/sisa/spring-rest-h2-swagger/branch/master/graphs/badge.svg)](https://codecov.io/gh/sisa/spring-rest-h2-swagger)
   

## Gereksinimler    

   + Maven 3 
   + JDK 1.8    
   
## Uygulama Nasıl Derlenir    
  
  Öncelikle klasör yapısı oluşturulmalı(``` mkdir -p src/main/java/io/sisa/demo ```). 
   
  ```
  └── src
      └── main
          └── java
              └── io
                  └── sisa
                      └── demo
  ```
  **pom.xml**
  
  ```xml
   <?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>

	<groupId>io.sisa</groupId>
	<artifactId>spring-security-with-jwt</artifactId>
	<version>1.0.0</version>
	<packaging>jar</packaging>

	<name>spring-security-with-jwt</name>
	<description>spring security with jwt sample</description>

	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.0.0.RELEASE</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>

	<properties>
  		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
  		<project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
  		<java.version>1.8</java.version>
  		<maven.compiler.source>1.8</maven.compiler.source>
  		<maven.compiler.target>1.8</maven.compiler.target>
  	</properties>
  
  	<dependencies>
  		<dependency>
  			<groupId>org.springframework.boot</groupId>
  			<artifactId>spring-boot-starter-data-jpa</artifactId>
  		</dependency>
  		<dependency>
  			<groupId>org.springframework.boot</groupId>
  			<artifactId>spring-boot-starter-data-rest</artifactId>
  		</dependency>
          <dependency>
              <groupId>org.springframework.boot</groupId>
              <artifactId>spring-boot-configuration-processor</artifactId>
              <optional>true</optional>
          </dependency>
  		<dependency>
  			<groupId>io.springfox</groupId>
  			<artifactId>springfox-swagger2</artifactId>
  			<version>2.7.0</version>
  			<scope>compile</scope>
  		</dependency>
  		<dependency>
  			<groupId>io.springfox</groupId>
  			<artifactId>springfox-swagger-ui</artifactId>
  			<version>2.7.0</version>
  			<scope>compile</scope>
  		</dependency>
  		<dependency>
  			<groupId>com.h2database</groupId>
  			<artifactId>h2</artifactId>
  			<scope>runtime</scope>
  		</dependency>
  		<dependency>
  			<groupId>org.projectlombok</groupId>
  			<artifactId>lombok</artifactId>
  			<optional>true</optional>
  		</dependency>
  		<dependency>
  			<groupId>org.springframework.boot</groupId>
  			<artifactId>spring-boot-starter-test</artifactId>
  			<scope>test</scope>
  		</dependency>
  		<dependency>
  			<groupId>junit</groupId>
  			<artifactId>junit</artifactId>
  			<version>4.12</version>
  			<scope>test</scope>
  		</dependency>
	</dependencies>
	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
			<plugin>
				<groupId>org.codehaus.mojo</groupId>
				<artifactId>cobertura-maven-plugin</artifactId>
				<version>2.7</version>
				<configuration>
					<formats>
						<format>html</format>
						<format>xml</format>
					</formats>
					<check />
				</configuration>
			</plugin>
		</plugins>
	</build>
</project> 
  ```
  derlemek için ./mvnw clean package. 
  Sonrasında jar dosyayısını çalıştırmak için ;
   
   ```
   java -jar target/demo-rest-1.0.0.jar
   ```  
   
   docker build:
   
   ```
   docker build -t spring-swagger 
   ```
   
   docker run:
   
   ```
   docker run -p 4000:8080 spring-swagger
   ```
   
   
## Creator

**İsa Öztürk**

* <https://github.com/sisa>
