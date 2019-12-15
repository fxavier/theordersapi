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
PRIMARY KEY(product_id)
);
