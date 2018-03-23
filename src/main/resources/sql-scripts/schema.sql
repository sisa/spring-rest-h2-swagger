CREATE TABLE city (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  city_code INT NOT NULL,
  city_name varchar(255) DEFAULT NULL,
  country varchar(100) DEFAULT NULL,
  PRIMARY KEY (id)
);
