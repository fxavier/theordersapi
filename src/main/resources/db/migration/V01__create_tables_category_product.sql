CREATE TABLE category(
category_id BIGSERIAL,
category_name VARCHAR(250) NOT NULL,
PRIMARY KEY(category_id)
);

CREATE TABLE product(
product_id BIGSERIAL,
product_name VARCHAR(200) NOT NULL,
description TEXT,
quantity INTEGER,
old_price NUMERIC(10, 2) NOT NULL,
descount NUMERIC(10, 2) NOT NULL,
new_price NUMERIC(10, 2) NOT NULL,
category_id BIGINT,
PRIMARY KEY(product_id),
CONSTRAINT fk_product_category
  FOREIGN KEY(category_id) REFERENCES category(category_id)
);


CREATE TABLE country(
country_id SERIAL,
country_name VARCHAR(100) NOT NULL,
PRIMARY KEY(country_id)
);

CREATE TABLE city(
city_id SERIAL,
city_name VARCHAR(100) NOT NULL,
country_id INTEGER NOT NULL,
PRIMARY KEY(city_id),
CONSTRAINT fk_country_city
  FOREIGN KEY(country_id) REFERENCES country(country_id)
);

CREATE TABLE village(
village_id BIGSERIAL,
village_name VARCHAR(100) NOT NULL,
city_id INTEGER NOT NULL,
PRIMARY KEY(village_id),
CONSTRAINT fk_village_city
  FOREIGN KEY(city_id) REFERENCES city(city_id)
);

