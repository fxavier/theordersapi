
CREATE TABLE customer(
customer_id BIGSERIAL,
first_name VARCHAR(50) NOT NULL,
last_name VARCHAR(50) NOT NULL,
email VARCHAR(200) NOT NULL,

)

CREATE TABLE shipping_address(
address_id BIGSERIAL,
village VARCHAR(100) NOT NULL,
street VARCHAR(200) NOT NULL,
number VARCHAR(20),
city VARCHAR(50) NOT NULL,
PRIMARY KEY(address_id)
);
