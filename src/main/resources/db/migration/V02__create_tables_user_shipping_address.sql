
CREATE TABLE user_account(
user_id BIGSERIAL,
email VARCHAR(100) NOT NULL,
password VARCHAR(500) NOT NULL,
first_name VARCHAR(50) NOT NULL,
last_name VARCHAR(50) NOT NULL,
phone VARCHAR(50),
PRIMARY KEY(user_id)
);

CREATE TABLE shipping_address(
address_id BIGSERIAL,
village VARCHAR(100) NOT NULL,
street VARCHAR(200) NOT NULL,
number VARCHAR(20),
city VARCHAR(50) NOT NULL,
user_id BIGINT NOT NULL,
PRIMARY KEY(address_id),
CONSTRAINT fk_address_customer
  FOREIGN KEY(user_id) REFERENCES user_account(user_id)
);
