CREATE TABLE orders(
order_id BIGSERIAL,
order_date DATE NOT NULL,
customer_id BIGINT NOT NULL,
address_id BIGINT NOT NULL,
PRIMARY KEY(order_id),
CONSTRAINT fk_order_customer
  FOREIGN KEY(customer_id) REFERENCES customer(customer_id),
CONSTRAINT fk_order_address
  FOREIGN KEY(address_id) REFERENCES shipping_address(address_id)
);

CREATE TABLE payment(
order_id BIGINT NOT NULL,
payment_status VARCHAR(20) NOT NULL,
PRIMARY KEY(order_id),
CONSTRAINT fk_payment_order
  FOREIGN KEY(order_id) REFERENCES orders(order_id)
);

CREATE TABLE payment_bank_slip(
expire_date DATE NOT NULL,
payment_date DATE NOT NULL,
order_id BIGINT NOT NULL,
CONSTRAINT fk_order_bankSlip
  FOREIGN KEY(order_id) REFERENCES orders(order_id)
);

CREATE TABLE payment_card(
number_of_portions INTEGER NOT NULL,
order_id BIGINT NOT NULL,
CONSTRAINT fk_order_card
  FOREIGN KEY(order_id) REFERENCES orders(order_id)
);