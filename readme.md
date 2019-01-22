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
   	<artifactId>spring-rest-h2-swagger</artifactId>
   	<version>0.0.1</version>
   	<packaging>jar</packaging>
   
   	<name>spring-rest-h2-swagger</name>
   	<description>Demo project for Spring Boot</description>
   
   	<parent>
   		<groupId>org.springframework.boot</groupId>
   		<artifactId>spring-boot-starter-parent</artifactId>
   		<version>2.1.2.RELEASE</version>
   		<relativePath/>
   	</parent>
   
   	<properties>
   		<docker.image.prefix>sisa</docker.image.prefix>
   
   		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
           <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
           <encoding>UTF-8</encoding>
   
           <java.version>1.8</java.version>
   
           <maven.compiler.target>1.8</maven.compiler.target>
           <maven.compiler.source>1.8</maven.compiler.source>
           <maven-compiler-plugin.version>3.5.1</maven-compiler-plugin.version>
   
   		<spring-boot.version>2.1.2.RELEASE</spring-boot.version>
   		<spring.cloud.version>Greenwich.RC2</spring.cloud.version>
   
   		<org.mapstruct.version>1.2.0.Final</org.mapstruct.version>
   		<lombok.version>1.16.20</lombok.version>
   	</properties>
   
   	<dependencyManagement>
   		<dependencies>
   			<dependency>
   				<groupId>org.springframework.cloud</groupId>
   				<artifactId>spring-cloud-dependencies</artifactId>
   				<version>${spring.cloud.version}</version>
   				<type>pom</type>
   				<scope>import</scope>
   			</dependency>
   		</dependencies>
   	</dependencyManagement>
   
   	<dependencies>
           <dependency>
               <groupId>org.springframework.boot</groupId>
               <artifactId>spring-boot-starter-actuator</artifactId>
           </dependency>
   		<dependency>
   			<groupId>org.springframework.boot</groupId>
   			<artifactId>spring-boot-starter-data-jpa</artifactId>
   		</dependency>
   		<dependency>
   			<groupId>org.springframework.boot</groupId>
   			<artifactId>spring-boot-starter-data-rest</artifactId>
   			 <exclusions>
                   <exclusion>
                       <groupId>org.hibernate</groupId>
                       <artifactId>hibernate-core</artifactId>
                   </exclusion>
                </exclusions>
   		</dependency>
   		 <dependency>
               <groupId>com.fasterxml.jackson.datatype</groupId>
               <artifactId>jackson-datatype-jsr310</artifactId>
           </dependency>
   		<dependency>
   			<groupId>org.springframework.boot</groupId>
   			<artifactId>spring-boot-configuration-processor</artifactId>
   			<optional>true</optional>
   		</dependency>
   		 <dependency>
               <groupId>org.hibernate</groupId>
               <artifactId>hibernate-core</artifactId>
               <version>5.2.12.Final</version>
           </dependency>
   		<dependency>
   			<groupId>io.springfox</groupId>
   			<artifactId>springfox-swagger2</artifactId>
   			<version>2.9.2</version>
   			<scope>compile</scope>
   		</dependency>
   		<dependency>
   			<groupId>io.springfox</groupId>
   			<artifactId>springfox-swagger-ui</artifactId>
   			<version>2.9.2</version>
   			<scope>compile</scope>
   		</dependency>
   		<dependency>
   			<groupId>org.springframework.cloud</groupId>
   			<artifactId>spring-cloud-starter-zipkin</artifactId>
   		</dependency>
   		<dependency>
   			<groupId>org.springframework.cloud</groupId>
   			<artifactId>spring-cloud-starter-sleuth</artifactId>
   		</dependency>
   		<dependency>
   			<groupId>com.h2database</groupId>
   			<artifactId>h2</artifactId>
   			<scope>runtime</scope>
   		</dependency>
   	  <dependency>
                   <groupId>org.projectlombok</groupId>
                   <artifactId>lombok</artifactId>
                   <version>${lombok.version}</version>
                   <optional>true</optional>
               </dependency>
   
           <dependency>
                   <groupId>org.mapstruct</groupId>
                   <artifactId>mapstruct</artifactId> <!-- use mapstruct-jdk8 for Java 8 or higher -->
                   <version>${org.mapstruct.version}</version>
               </dependency>
   
               <dependency>
                   <groupId>org.mapstruct</groupId>
                   <artifactId>mapstruct-jdk8</artifactId>
                   <version>${org.mapstruct.version}</version>
               </dependency>
   
           <dependency>
              <groupId>de.codecentric</groupId>
              <artifactId>spring-boot-admin-starter-client</artifactId>
              <version>2.1.1</version>
           </dependency>
   
           <dependency>
               <groupId>org.springframework.boot</groupId>
               <artifactId>spring-boot-starter-security</artifactId>
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
   
   	<repositories>
   		<repository>
   			<id>spring-milestones</id>
   			<name>Spring Milestones</name>
   			<url>https://repo.spring.io/libs-milestone</url>
   			<snapshots>
   				<enabled>false</enabled>
   			</snapshots>
   		</repository>
   		 <repository>
                 <id>jcenter-snapshots</id>
                 <name>jcenter</name>
                 <url>https://jcenter.bintray.com/</url>
               </repository>
   	</repositories>
   
   	<build>
   	    <finalName>${project.artifactId}</finalName>
   		<plugins>
   			<plugin>
   				<groupId>org.springframework.boot</groupId>
   				<artifactId>spring-boot-maven-plugin</artifactId>
   				<executions>
   					<execution>
   						<goals>
   							<goal>repackage</goal>
   						</goals>
   					</execution>
   				</executions>
   			</plugin>
   			<plugin>
                               <artifactId>maven-compiler-plugin</artifactId>
                               <version>${maven-compiler-plugin.version}</version>
                               <configuration>
                                   <source>${maven.compiler.source}</source>
                                   <target>${maven.compiler.target}</target>
                                   <encoding>${project.build.sourceEncoding}</encoding>
                                   <annotationProcessorPaths>
                                       <path>
                                           <groupId>org.projectlombok</groupId>
                                           <artifactId>lombok</artifactId>
                                           <version>${lombok.version}</version>
                                       </path>
                                       <path>
                                           <groupId>org.mapstruct</groupId>
                                           <artifactId>mapstruct-processor</artifactId>
                                           <version>${org.mapstruct.version}</version>
                                       </path>
                                   </annotationProcessorPaths>
                                   <compilerArgs>
                                       <arg>-Amapstruct.suppressGeneratorTimestamp=true</arg>
                                       <arg>-Amapstruct.defaultComponentModel=spring</arg>
                                   </compilerArgs>
                               </configuration>
                           </plugin>
   			<plugin>
   				<groupId>com.spotify</groupId>
   				<artifactId>dockerfile-maven-plugin</artifactId>
   				<version>1.3.6</version>
   				<configuration>
   					<repository>${docker.image.prefix}/${project.artifactId}</repository>
   					<buildArgs>
   						<JAR_FILE>target/${project.build.finalName}.jar</JAR_FILE>
   					</buildArgs>
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
