
CREATE TABLE customer(
customer_id BIGSERIAL,
customer_type VARCHAR(20) NOT NULL,
first_name VARCHAR(50) NOT NULL,
last_name VARCHAR(50) NOT NULL,
email VARCHAR(200) NOT NULL,
PRIMARY KEY(customer_id)
);

CREATE TABLE shipping_address(
address_id BIGSERIAL,
village VARCHAR(100) NOT NULL,
street VARCHAR(200) NOT NULL,
number VARCHAR(20),
city VARCHAR(50) NOT NULL,
customer_id BIGINT NOT NULL,
PRIMARY KEY(address_id),
CONSTRAINT fk_address_customer
  FOREIGN KEY(customer_id) REFERENCES customer(customer_id)
);
