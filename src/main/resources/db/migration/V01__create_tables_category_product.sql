CREATE TABLE category(
category_id BIGSERIAL,
category_name VARCHAR(250) NOT NULL,
PRIMARY KEY(category_id)
);

CREATE TABLE product(
product_id BIGSERIAL,
product_name VARCHAR(200) NOT NULL,
description TEXT,
old_price NUMERIC(10, 2) NOT NULL,
descount NUMERIC(10, 2) NOT NULL,
new_price NUMERIC(10, 2) NOT NULL,
PRIMARY KEY(product_id)
);

CREATE TABLE product_category(
category_id BIGINT NOT NULL,
product_id BIGINT NOT NULL,
PRIMARY KEY(category_id,product_id),
CONSTRAINT fk_product_category
  FOREIGN KEY(category_id) REFERENCES category(category_id),
CONSTRAINT fk_category_product
  FOREIGN KEY(product_id) REFERENCES product(product_id)
);