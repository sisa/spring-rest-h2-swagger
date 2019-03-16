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
